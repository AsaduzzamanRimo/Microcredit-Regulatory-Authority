package com.doer.mraims.user.application.port.in;


import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;
import com.doer.mraims.user.application.port.in.dto.request.UserSaveRequest;
import com.doer.mraims.user.application.port.in.dto.request.LockUnlockUserRequest;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;

import java.util.Map;

public interface UnAuthBranchFeatureUseCase {

    CommonObjectResponseBody saveUnAuthUser(UserSaveRequest saveRequest, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonListResponseBody<Object> findAllUnAuthUser(Map<String, String> params) throws ExceptionHandlerUtil;
    CommonObjectResponseBody findUnAuthUserByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonObjectResponseBody updateUnAuthUser(UserSaveRequest saveRequest, String oid, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonListResponseBody<Object> lockUnAuthUser(LockUnlockUserRequest lockUnlockUserRequest, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonListResponseBody<Object> unlockUnAuthUser(LockUnlockUserRequest unlockBranchRequest, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonListResponseBody<Object> lockApprovalUnAuthUser(LockUnlockUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonListResponseBody<Object> unlockApprovalUnAuthUser(LockUnlockUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil;
    CommonListResponseBody<Object> findAllPendingApprovalUnAuthUser(Map<String, String> params) throws ExceptionHandlerUtil;
    CommonObjectResponseBody approvalUnAuthUser(ApprovalUserRequest request, Map<String, String> params) throws ExceptionHandlerUtil;

}
