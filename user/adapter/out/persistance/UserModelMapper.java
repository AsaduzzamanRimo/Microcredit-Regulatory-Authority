package com.doer.mraims.user.adapter.out.persistance;

import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;
import com.doer.mraims.user.domain.User;
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
public class UserModelMapper {

    //    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public UserModelMapper(
//            ObjectMapper objectMapper,
            ModelMapper modelMapper) {
//        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    public User mapToDomainEntity(UserEntity userEntity, Class<User> branchClass) throws ExceptionHandlerUtil {
        /*modelMapper.typeMap(UserEntity.class, User.class)
                .addMappings(mapper -> mapper.map(UserEntity::getBranchId, User::setBranchId));
        modelMapper.typeMap(UserEntity.class, User.class)
                .addMappings(mapper -> mapper.map(UserEntity::getOid, User::setOid));*/
        User branch = modelMapper.map(userEntity, User.class);

//        try {
//            branch.setStatus(objectMapper.readValue(userEntity.getStatus(), String.class));
//        } catch (JsonProcessingException e) {
//            log.error("Error occurred during converting intermediate status to domain object", e);
//            throw new ExceptionHandlerUtil(HttpStatus.BAD_REQUEST, "Something went wrong");
//        }
        return branch;
    }

    public UserEntity mapToJpaEntity(Provider<UserEntity> branchEntityProvider, User branch) throws ExceptionHandlerUtil {
//        modelMapper.typeMap(UserEntity.class, UserEntity.class).setProvider(branchEntityProvider);
        UserEntity userEntity = modelMapper.map(branch, UserEntity.class);
        return userEntity;
    }

    List<User> mapJpaListToDomainEntityList(List<UserEntity> userEntityList) throws ExceptionHandlerUtil {
        List<User> branchList = new ArrayList<User>();
        for (UserEntity userEntity : userEntityList) {
            User branch = new User();
            BeanUtils.copyProperties(userEntity, branch);
//            try {
            branch = modelMapper.map(userEntity, User.class);
//            } catch (JsonProcessingException e) {
//                log.error("Error occurred during converting intermediate status to domain object", e);
//                throw new ExceptionHandlerUtil(HttpStatus.BAD_REQUEST, "Something went wrong");
//            }
            branchList.add(branch);
        }
        return branchList;
    }

}
