package com.doer.mraims.user.application.port.out;

import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;
import com.doer.mraims.user.domain.User;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;

import java.util.List;
import java.util.Map;

public interface UnAuthUserPersistencePort {

    int countUnAuthUser(String schema);

    int countTotalUnAuthUserForPagination(Map<String, String> params) throws ExceptionHandlerUtil;

    List<User> findAllUnAuthUser(Map<String, String> params) throws ExceptionHandlerUtil;

    User findByBranchId(String branchId, Map<String, String> params) throws ExceptionHandlerUtil;

    User findByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil;

    List<User> findByOidIn(List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil;

    List<User> findOidsByOidListExceptUnAuthOids(List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil;

    List<User> findUnlockLoginListByOids(List<String> oidList, Map<String, String> params, String loginId) throws ExceptionHandlerUtil;


    User save (User user, Map<String, String> params) throws ExceptionHandlerUtil;

    int[] batchSaveUnAuthUser(List<User> userList, Map<String, String> params, String loginId) throws ExceptionHandlerUtil;

    User updateState(User user, Map<String, String> params) throws ExceptionHandlerUtil;

    User updateUser(String loginId, String oid, Map<String, String> params) throws ExceptionHandlerUtil;

    List<User> updateLockStatusUnAuthUser(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil;


    List<User> updateUnlockStatusUnAuthUser(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil;

    // Approval lock Unlock
    List<User> updateLockStatusUnAuthUserForApprover(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil;


    List<User> updateUnlockStatusUnAuthUserForApprover(String loginId, List<String> oidList, Map<String, String> params) throws ExceptionHandlerUtil;

    User getDataFromLiveUserAndSave(String oid, Map<String, String> params) throws ExceptionHandlerUtil;

    User approvalUser(ApprovalUserRequest request, Map<String, String> params);

}
