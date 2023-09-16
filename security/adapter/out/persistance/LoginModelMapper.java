package com.doer.mraims.security.adapter.out.persistance;

import com.doer.mraims.security.adapter.out.persistance.database.entity.LoginEntity;
import com.doer.mraims.security.domain.Login;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class LoginModelMapper {

    //    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public LoginModelMapper(
//            ObjectMapper objectMapper,
            ModelMapper modelMapper) {
//        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    public Login mapToDomainEntity(LoginEntity loginEntity, Class<Login> branchClass) throws ExceptionHandlerUtil {
        /*modelMapper.typeMap(LoginEntity.class, Login.class)
                .addMappings(mapper -> mapper.map(LoginEntity::getBranchId, Login::setBranchId));
        modelMapper.typeMap(LoginEntity.class, Login.class)
                .addMappings(mapper -> mapper.map(LoginEntity::getOid, Login::setOid));*/
        Login branch = modelMapper.map(loginEntity, Login.class);

//        try {
//            branch.setStatus(objectMapper.readValue(loginEntity.getStatus(), String.class));
//        } catch (JsonProcessingException e) {
//            log.error("Error occurred during converting intermediate status to domain object", e);
//            throw new ExceptionHandlerUtil(HttpStatus.BAD_REQUEST, "Something went wrong");
//        }
        return branch;
    }

    public LoginEntity mapToJpaEntity(Provider<LoginEntity> branchEntityProvider, Login branch) throws ExceptionHandlerUtil {
//        modelMapper.typeMap(LoginEntity.class, LoginEntity.class).setProvider(branchEntityProvider);
        LoginEntity loginEntity = modelMapper.map(branch, LoginEntity.class);
        return loginEntity;
    }

    List<Login> mapJpaListToDomainEntityList(List<LoginEntity> loginEntityList) throws ExceptionHandlerUtil {
        List<Login> branchList = new ArrayList<Login>();
        for (LoginEntity loginEntity : loginEntityList) {
            Login branch = new Login();
            BeanUtils.copyProperties(loginEntity, branch);
//            try {
            branch = modelMapper.map(loginEntity, Login.class);
//            } catch (JsonProcessingException e) {
//                log.error("Error occurred during converting intermediate status to domain object", e);
//                throw new ExceptionHandlerUtil(HttpStatus.BAD_REQUEST, "Something went wrong");
//            }
            branchList.add(branch);
        }
        return branchList;
    }

}
