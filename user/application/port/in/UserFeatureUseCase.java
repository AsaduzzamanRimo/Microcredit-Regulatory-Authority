package com.doer.mraims.user.application.port.in;


import com.doer.mraims.user.application.port.in.dto.request.UserSaveRequest;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;

import java.util.Map;

public interface UserFeatureUseCase {

    CommonListResponseBody<Object> findAllUser(Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody findUserByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody findUserInfoByLoginId(Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody saveUser(UserSaveRequest request, Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody updateUser(UserSaveRequest request, String oid, Map<String, String> params) throws ExceptionHandlerUtil;

}
