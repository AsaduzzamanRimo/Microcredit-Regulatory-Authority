package com.doer.mraims.user.adapter.out.persistance.database.repository;


import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;
import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;

import java.util.List;
import java.util.Map;


public interface UnAuthUserRepository {

    List<UserEntity> findByOidIn(Map<String, String> params, List<String> oidList);

    List<UserEntity> findLiveUserByOidIn(Map<String, String> params, List<String> oidList);

    List<UserEntity> findOidsByOidListExceptUnAuthOids(Map<String, String> params, List<String> oidList);

    List<UserEntity> findUnlockUserListByOids(Map<String, String> params, List<String> oidList, String loginId);

    int countUser(String schema);
    int countUserByOid(String schema, String oid);

    int countTotalUnAuthUserForPagination(Map<String, String> params);

    List<UserEntity> findAllUnAuthUser(Map<String, String> params);

    UserEntity findByUserId(String branchId, Map<String, String> params);

    UserEntity findByOid(String oid, Map<String, String> params);

    int saveUnAuthLogin(UserEntity entity, Map<String, String> params);

    int[] batchSaveUnAuthUserEntity(List<UserEntity> entityList, Map<String, String> params, String loginId);

    int deleteUserByOidInAndLockedBy(String loginId, List<String> oidList, Map<String, String> params);

    int updateUnAuthLogin(UserEntity entity, Map<String, String> params);
    int updateLockLiveSchema(UserEntity entity, String loginId, String oid, Map<String, String> params);

    int updateUserByLockStatusAndOidInAndLockedBy(String loginId, List<String> oidList, Map<String, String> params);

    int updateUserByUnlockStatusAndOidInAndLockedBy(String loginId, List<String> oidList, Map<String, String> params);

    // Approval lock unlock
    int updateUserByLockStatusAndOidInAndLockedByForApprover(String loginId, List<String> oidList, Map<String, String> params);

    int updateUserByUnlockStatusAndOidInAndLockedByForApprover(String loginId, List<String> oidList, Map<String, String> params);

    int updateApprovedStatusUnAuthBranchByOid(String loginId, String oid, Map<String, String> params);

    int updateApprovedStatusUserByOid(String loginId, String oid, Map<String, String> params);

    int saveUserHistory(ApprovalUserRequest request, Map<String, String> params);
    int saveUserFromUnAuthUser(ApprovalUserRequest request, Map<String, String> params);
    int updateUserByUnAuthOid(ApprovalUserRequest request, Map<String, String> params);

    int deleteUnauthUserByOid(String oid, Map<String, String> params);


}
