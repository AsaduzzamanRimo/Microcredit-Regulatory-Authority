package com.doer.mraims.security.application.port.in;


import com.doer.mraims.security.application.port.in.dto.request.LoginRequest;
import com.doer.mraims.core.util.response.CommonListResponseBody;
import com.doer.mraims.core.util.response.CommonObjectResponseBody;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;

import java.util.Map;

public interface LoginFeatureUseCase {

    CommonObjectResponseBody userLogin(Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody checkLoginId(Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody saveLogin(LoginRequest saveRequest, Map<String, String> params) throws ExceptionHandlerUtil;

    CommonObjectResponseBody updateLogin(LoginRequest updateRequest, String oid, Map<String, String> params) throws ExceptionHandlerUtil;

}
