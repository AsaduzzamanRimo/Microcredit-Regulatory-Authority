package com.doer.mraims.user.application.port.out;

import com.doer.mraims.user.domain.User;
import com.doer.mraims.core.util.exception.ExceptionHandlerUtil;

import java.util.List;
import java.util.Map;

public interface UserPersistencePort {

    int countUser(String schema);

    int countTotalUserForPagination(Map<String, String> params) throws ExceptionHandlerUtil;

    List<User> findAllUser(Map<String, String> params) throws ExceptionHandlerUtil;

    User findUserInfoByLoginId(Map<String, String> params) throws ExceptionHandlerUtil;

    User findUserByOid(String oid, Map<String, String> params) throws ExceptionHandlerUtil;

    User saveUser(User branch, Map<String, String> params) throws ExceptionHandlerUtil;

    User updateUser(User branch, Map<String, String> params) throws ExceptionHandlerUtil;

}
