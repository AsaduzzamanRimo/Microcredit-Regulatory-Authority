package com.doer.mraims.user.adapter.out.persistance;

import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;
import com.doer.mraims.user.adapter.out.persistance.database.repository.UserRepository;
import com.doer.mraims.user.application.port.out.UserPersistencePort;
import com.doer.mraims.user.domain.User;
import com.doer.mraims.core.util.IdGenerator;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.repository.UtilRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    @Autowired
    IdGenerator idGenerator;
    private final ModelMapper modelMapper;
    private final UtilRepository utilRepository;
    private final UserRepository userRepository;
    private final UserModelMapper userModelMapper;

    @Override
    public List<User> findAllUser(Map<String, String> params) throws ExceptionHandlerUtil {
        //String schemaName = utilRepository.findSchemaNameByMfiOid(params.get("instituteOid"));
        //params.put("schemaName", schemaName);
        List<UserEntity> entityList = userRepository.findAllUserSql(params);
        return entityList.size()>0 ? entityList.stream().map(entity->
                modelMapper.map(entity, User.class)).collect(Collectors.toList()):new ArrayList<>();
    }

    public User findUserByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil {
//        String schemaName = utilRepository.findSchemaNameByMfiOid(params.get("instituteOid"));
//        params.put("schemaName", schemaName);
        UserEntity entity = userRepository.findUserByOidSql(oid, params);
        if (entity == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return modelMapper.map(entity, User.class);
    }

    @Override
    public User findUserInfoByLoginId(Map<String, String> params) throws ExceptionHandlerUtil {
        UserEntity entity = userRepository.findUserInfoByLoginIdSql(params);
        if (entity == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return modelMapper.map(entity, User.class);
    }

    @Override
    public int countTotalUserForPagination(Map<String, String> params) throws ExceptionHandlerUtil {
        return userRepository.countTotalUserForPaginationSql(params);
    }

    @Override
    public int countUser(String schema) {
        return userRepository.countUserSql(schema);
    }

    @Override
    public User saveUser(User branch, Map<String, String> params) throws ExceptionHandlerUtil {
        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        params.put("schemaName", schemaName);
        Provider<UserEntity> branchEntityProvider = provider -> new UserEntity();
        UserEntity entity = userModelMapper.mapToJpaEntity(branchEntityProvider, branch);
        entity.setOid(idGenerator.generateOid());
        int saveCount = userRepository.saveUserSql(entity, params);
        return saveCount > 0 ? modelMapper.map(entity, User.class) : null;
    }

    @Override
    public User updateUser(User branch, Map<String, String> params) throws ExceptionHandlerUtil {
        Provider<UserEntity> branchEntityProvider = provider -> userRepository.findUserByOidSql(branch.getOid(), params);
        UserEntity entity = userModelMapper.mapToJpaEntity(branchEntityProvider, branch);
        int updateCount = userRepository.updateUserSql(entity, params);
        return updateCount > 0 ? modelMapper.map(entity, User.class) : null;
    }

}
