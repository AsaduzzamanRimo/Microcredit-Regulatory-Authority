package com.doer.mraims.user.adapter.out.persistance.database.repository;


import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;

import java.util.List;
import java.util.Map;


public interface UserRepository {

    int countUserSql(String schema);

    int countTotalUserForPaginationSql(Map<String, String> params);

    List<UserEntity> findAllUserSql(Map<String, String> params);

    UserEntity findUserInfoByLoginIdSql(Map<String, String> params);

    UserEntity findUserByOidSql(String oid, Map<String, String> params);

    int saveUserSql(UserEntity entity, Map<String, String> params);

    int updateUserSql(UserEntity entity, Map<String, String> params);


}
