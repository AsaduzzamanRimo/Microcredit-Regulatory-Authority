package com.doer.mraims.security.adapter.out.persistance;

import com.doer.mraims.core.util.IdGenerator;
import com.doer.mraims.security.adapter.out.persistance.database.entity.LoginEntity;
import com.doer.mraims.security.adapter.out.persistance.database.repository.LoginRepository;
import com.doer.mraims.security.application.port.out.LoginPersistencePort;
import com.doer.mraims.security.domain.Login;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.repository.UtilRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class LoginPersistenceAdapter implements LoginPersistencePort {
    @Autowired
    IdGenerator idGenerator;
    private final ModelMapper modelMapper;
    private final UtilRepository utilRepository;
    private final LoginRepository loginRepository;
    private final LoginModelMapper loginModelMapper;

    public Login findByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        params.put("schemaName", schemaName);
        LoginEntity entity = loginRepository.findByOid(oid, params);
        if (entity == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return modelMapper.map(entity, Login.class);
    }

    @Override
    public Login userLogin(Map<String, String> params) throws ExceptionHandlerUtil {
        LoginEntity entity = loginRepository.getUserInfo(params);
        if (entity == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return modelMapper.map(entity, Login.class);
    }

    @Override
    public Login findLoginId(Map<String, String> params) throws ExceptionHandlerUtil {
        LoginEntity entity = loginRepository.checkLoginId(params);
        if (entity == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return modelMapper.map(entity, Login.class);
    }

    @Override
    public int countBranch(String schema) {
        return loginRepository.countBranch(schema);
    }

    @Override
    public Login save(Login branch, Map<String, String> params) throws ExceptionHandlerUtil {
        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        params.put("schemaName", schemaName);
        Provider<LoginEntity> branchEntityProvider = provider -> new LoginEntity();
        LoginEntity entity = loginModelMapper.mapToJpaEntity(branchEntityProvider, branch);
        entity.setOid(idGenerator.generateOid());
        int saveCount = loginRepository.saveWithSchema(entity, params);
        return saveCount > 0 ? modelMapper.map(entity, Login.class) : null;
    }

    @Override
    public Login updateState(Login branch, Map<String, String> params) throws ExceptionHandlerUtil {
        Provider<LoginEntity> branchEntityProvider = provider -> loginRepository.findByOid(branch.getOid(), params);
        LoginEntity entity = loginModelMapper.mapToJpaEntity(branchEntityProvider, branch);
        int updateCount = loginRepository.updateWithSchema(entity, params);
        return updateCount > 0 ? modelMapper.map(entity, Login.class) : null;
    }

}
