package com.doer.mraims.user.adapter.out.persistance;

import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;
import com.doer.mraims.user.adapter.out.persistance.database.repository.UnAuthUserRepository;
import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;
import com.doer.mraims.user.application.port.out.UnAuthUserPersistencePort;
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

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UnAuthUserPersistenceAdapter implements UnAuthUserPersistencePort {
    @Autowired
    IdGenerator idGenerator;
    private final ModelMapper modelMapper;
    private final UtilRepository utilRepository;
    private final UnAuthUserRepository unauthUserRepository;
    private final UserModelMapper userModelMapper;

    @Override
    public List<User> findAllUnAuthUser(Map<String, String> params) throws ExceptionHandlerUtil {
        //String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        //params.put("schemaName", schemaName);
        List<UserEntity> entityList = unauthUserRepository.findAllUnAuthUser(params);
        return entityList.size() > 0 ? entityList.stream().map(entity -> modelMapper.map(entity, User.class)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public User findByBranchId(String branchId, Map<String, String> params) throws ExceptionHandlerUtil {
        return null;
    }

    public User findByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil {
        System.out.println(oid);
        //String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        //params.put("schemaName", schemaName);
        UserEntity entity = unauthUserRepository.findByOid(oid, params);
        if (entity == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return modelMapper.map(entity, User.class);
    }

    public List<User> findByOidIn(List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil {
        System.out.println(oidList);
        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        params.put("schemaName", schemaName);
        List<UserEntity> entityList = unauthUserRepository.findByOidIn(params, oidList);
        if (entityList == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList());
    }

    @Override
    public List<User> findOidsByOidListExceptUnAuthOids(List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil {
        System.out.println(oidList);
        //String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        //params.put("schemaName", schemaName);
        List<UserEntity> entityList = unauthUserRepository.findOidsByOidListExceptUnAuthOids(params, oidList);
        if (entityList == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList());
    }

    @Override
    public List<User> findUnlockLoginListByOids(List<String> oidList, Map<String, String> params, String loginId) throws ExceptionHandlerUtil {
//        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
//        params.put("schemaName", schemaName);
        List<UserEntity> entityList = unauthUserRepository.findUnlockUserListByOids(params, oidList, loginId);
        if (entityList == null) throw new ExceptionHandlerUtil(HttpStatus.NOT_FOUND, "Data not found");
        return entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList());
    }


    @Override
    public int countTotalUnAuthUserForPagination(Map<String, String> params) throws ExceptionHandlerUtil {
        return unauthUserRepository.countTotalUnAuthUserForPagination(params);
    }

    @Override
    public int countUnAuthUser(String schema) {
        return unauthUserRepository.countUser(schema);
    }


    @Override
    public User save(User user, Map<String, String> params) throws ExceptionHandlerUtil {
//        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
//        params.put("schemaName", schemaName);
//        UserEntity entity = modelMapper.map(user, UserEntity.class);
        Provider<UserEntity> branchEntityProvider = provider -> new UserEntity();
        UserEntity entity = userModelMapper.mapToJpaEntity(branchEntityProvider, user);
        entity.setOid(idGenerator.generateOid());
        int saveCount = unauthUserRepository.saveUnAuthLogin(entity, params);
        return saveCount > 0 ? modelMapper.map(entity, User.class) : null;
    }

    @Override
    public int[] batchSaveUnAuthUser(List<User> userList, Map<String, String> params, String loginId) throws ExceptionHandlerUtil {
        //String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        //params.put("schemaName", schemaName);
        List<UserEntity> entityList = userList.stream().map(branch -> modelMapper.map(branch, UserEntity.class)).collect(Collectors.toList());
        int[] saveCount = unauthUserRepository.batchSaveUnAuthUserEntity(entityList, params, loginId);
        return saveCount.length > 0 ? saveCount: null;
    }

    @Override
    public User updateState(User user, Map<String, String> params) throws ExceptionHandlerUtil {
        Provider<UserEntity> branchEntityProvider = provider -> unauthUserRepository.findByOid(user.getOid(), params);
        UserEntity entity = userModelMapper.mapToJpaEntity(branchEntityProvider, user);
        int updateCount = unauthUserRepository.updateUnAuthLogin(entity, params);
        return updateCount > 0 ? modelMapper.map(entity, User.class) : null;
    }

    @Override
    public User updateUser(String loginId, String oid, Map<String, String> params) throws ExceptionHandlerUtil {
//        Provider<UserEntity> branchEntityProvider = provider -> unauthUserRepository.findByOid(oid, params);
        UserEntity entity = unauthUserRepository.findByOid(oid, params);
        System.out.println(entity);
//        UserEntity entity = userModelMapper.mapToJpaEntity(branchEntityProvider, branch);
        int updateCount = unauthUserRepository.updateLockLiveSchema(entity, loginId, oid, params);
        System.out.println(updateCount);
        return updateCount > 0 ? modelMapper.map(entity, User.class) : null;
    }

    @Override
    public List<User> updateLockStatusUnAuthUser(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil {
        List<UserEntity> entityList = unauthUserRepository.findLiveUserByOidIn(params, oidList);
        List<String> filteredOidList = entityList.stream().map(UserEntity::getOid).collect(Collectors.toList());
        int updateCount = unauthUserRepository.updateUserByLockStatusAndOidInAndLockedBy(loginId, filteredOidList, params);
        System.out.println(updateCount);
        return updateCount > 0 ? entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList()) : new ArrayList<>();
    }


    @Override
    public List<User> updateUnlockStatusUnAuthUser(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil {
        List<UserEntity> entityList = unauthUserRepository.findByOidIn(params, oidList);
        int updateCount = unauthUserRepository.updateUserByUnlockStatusAndOidInAndLockedBy(loginId, oidList, params);
        int deleteCount = unauthUserRepository.deleteUserByOidInAndLockedBy(loginId, oidList, params);
        System.out.println(updateCount);
        return updateCount  > 0 && deleteCount > 0 ? entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public List<User> updateLockStatusUnAuthUserForApprover(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil {
//        List<UserEntity> entityList = unauthUserRepository.findLiveBranchByOidIn(params, oidList);
//        List<String> filteredOidList = entityList.stream().map(UserEntity::getOid).collect(Collectors.toList());
//        int updateCount = unauthUserRepository.updateBranchByLockStatusAndOidInAndLockedByForApprover(loginId, filteredOidList, params);
//        return updateCount > 0 ? entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList()) : new ArrayList<>();

        int updateCount = unauthUserRepository.updateUserByLockStatusAndOidInAndLockedByForApprover(loginId, oidList, params);
        return updateCount > 0 ? oidList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList()) : new ArrayList<>();
    }


    @Override
    public List<User> updateUnlockStatusUnAuthUserForApprover(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil {
        List<UserEntity> entityList = unauthUserRepository.findByOidIn(params, oidList);
        int updateCount = unauthUserRepository.updateUserByUnlockStatusAndOidInAndLockedByForApprover(loginId, oidList, params);
        System.out.println(updateCount);
        return updateCount  > 0 ? entityList.stream().map(entity-> modelMapper.map(entity, User.class)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public User getDataFromLiveUserAndSave(String oid, Map<String, String> params) throws ExceptionHandlerUtil {

        return null;
    }

    @Override
    public User approvalUser(ApprovalUserRequest request, Map<String, String> params) {
        String schemaName = utilRepository.findSchemaNameByInstituteOid(params.get("instituteOid"));
        params.put("schemaName", schemaName);
        params.put("approverRemarks", request.getApproverRemarks());
        params.put("isApproverRemarks", request.getIsApproverRemarks());
        unauthUserRepository.updateApprovedStatusUnAuthBranchByOid(request.getLoginId(), request.getOid(), params);

        if(unauthUserRepository.countUserByOid(schemaName, request.getOid()) > 0){
            int saveCount = unauthUserRepository.saveUserHistory(request, params);
            int updateCount = unauthUserRepository.updateUserByUnAuthOid(request, params);
            int deleteCount = unauthUserRepository.deleteUnauthUserByOid(request.getOid(), params);
            return saveCount > 0 && updateCount > 0 && deleteCount > 0 ? modelMapper.map(request, User.class) : null;
        } else {
            int saveCount = unauthUserRepository.saveUserFromUnAuthUser(request, params);
            int deleteCount = unauthUserRepository.deleteUnauthUserByOid(request.getOid(), params);
            return saveCount  > 0 && deleteCount > 0 ? modelMapper.map(request, User.class) : null;
        }
    }

}
