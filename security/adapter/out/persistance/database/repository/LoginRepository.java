package com.doer.mraims.security.adapter.out.persistance.database.repository;


import com.doer.mraims.security.adapter.out.persistance.database.entity.LoginEntity;

import java.util.List;
import java.util.Map;


public interface LoginRepository {

    int countBranch(String schema);

    int countTotalBranchForPagination(Map<String, String> params);

    List<LoginEntity> findAllBranch(Map<String, String> params);

    LoginEntity findByBranchId(String branchId, Map<String, String> params);

    LoginEntity findByOid(String oid, Map<String, String> params);

    int countLoginId(Map<String, String> params);

    LoginEntity getUserInfo(Map<String, String> params);

    LoginEntity checkLoginId(Map<String, String> params);


    int saveWithSchema(LoginEntity entity, Map<String, String> params);

    int updateWithSchema(LoginEntity entity, Map<String, String> params);


}
