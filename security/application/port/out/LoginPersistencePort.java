package com.doer.mraims.security.application.port.out;

import com.doer.mraims.security.domain.Login;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;

import java.util.List;
import java.util.Map;

public interface LoginPersistencePort {

    int countBranch(String schema);

    Login userLogin(Map<String, String> params) throws ExceptionHandlerUtil;

    Login findLoginId(Map<String, String> params) throws ExceptionHandlerUtil;

    Login findByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil;

    Login save (Login branch, Map<String, String> params) throws ExceptionHandlerUtil;

    Login updateState(Login branch, Map<String, String> params) throws ExceptionHandlerUtil;

}
