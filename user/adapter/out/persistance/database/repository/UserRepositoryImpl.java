package com.doer.mraims.user.adapter.out.persistance.database.repository;


import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;
import com.doer.mraims.core.util.Table;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalUserForPaginationSql(Map<String, String> params) {
        String sql ="select count(l.oid) "
                + " from " + Table.LOGIN +" l "
                + " where 1 = 1 ";

        if(StringUtils.isNotBlank(params.get("instituteOid"))){
            sql += " and l.institute_oid  =  '" + params.get("instituteOid") + "' ";
        }

        if(StringUtils.isNotBlank(params.get("status"))){
            sql += " and l.status  =  '" + params.get("status") + "' ";
        }

        if (StringUtils.isNotBlank(params.get("searchText"))) {
            sql += " and (l.name_en ilike '%" + params.get("searchText").trim() + "%'"
                    + " or l.name_bn ilike '%" + params.get("searchText").trim() + "%'"
                    + " or l.login_id ilike '%" + params.get("searchText").trim() + "%'"
                    + " or l.status ilike '%" + params.get("searchText").trim() +  "%')";
        }

        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public List<UserEntity> findAllUserSql(Map<String, String> params) {
        List<UserEntity> dataList = new ArrayList<>();

        String sql = "SELECT l.oid, l.login_id, l.name_en, l.name_bn, l.role_oid, l.institute_oid, l.status, "
                + " r.role_id, r.role_description, r.role_name_en, r.role_name_bn "
                + " from " + Table.LOGIN +" l "
                + " left join " + Table.ROLE + " r on r.oid = l.role_oid "
                + " where 1 = 1 ";

        if(StringUtils.isNotBlank(params.get("instituteOid"))){
            sql += " and l.institute_oid  =  '" + params.get("instituteOid") + "' ";
        }

        if(StringUtils.isNotBlank(params.get("status"))){
            sql += " and l.status  =  '" + params.get("status") + "' ";
        }
        if (StringUtils.isNotBlank(params.get("searchText"))) {
            sql += " and (l.name_en ilike '%" + params.get("searchText").trim() + "%'"
                    + " or l.name_bn ilike '%" + params.get("searchText").trim() + "%'"
                    + " or l.login_id ilike '%" + params.get("searchText").trim() + "%'"
                    + " or l.status ilike '%" + params.get("searchText").trim() +  "%')";
        }

        if (StringUtils.isNotBlank(params.get("sortColId")) && StringUtils.isNotBlank(params.get("sortOrder"))) {
            sql += " order by l." + params.get("sortColId") +" "+ params.get("sortOrder");
        } else {
            sql += " order l br.created_on asc";
        }
        if (Integer.valueOf(params.get("offset"))>=0) {
            sql += " offset "+params.get("offset");
        }
        if (Integer.valueOf(params.get("limit"))>=0) {
            sql += " limit "+params.get("limit");
        }
    // l.oid, l.login_id, l.name_en, l.name_bn, l.institute_oid, l.status,
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map<String, Object> row:rows){
            UserEntity data = new UserEntity();
            data.setOid((String) row.get("oid"));
            data.setLoginId((String) row.get("login_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setInstituteOid((String) row.get("institute_oid"));
            data.setStatus((String) row.get("status"));
            data.setRoleOid((String) row.get("role_oid"));
            data.setRoleId((String) row.get("role_id"));
            data.setRoleDescription((String) row.get("role_description"));
            data.setRoleNameEn((String) row.get("role_name_en"));
            data.setRoleNameBn((String) row.get("role_name_bn"));
//            data.setCreatedBy((String) row.get("created_by"));
//            data.setCreatedOn((Date) row.get("created_on"));
//            data.setUpdatedBy((String) row.get("updated_by"));
//            data.setUpdatedOn((Date) row.get("updated_on"));
            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public UserEntity findUserInfoByLoginIdSql(Map<String, String> params){

    UserEntity data = new UserEntity();

    try {
        String sql = "SELECT l.oid, l.oid as login_oid, l.login_id, l.name_en, l.name_bn, l.status as login_status, l.institute_oid, "
                + " CASE WHEN char_length(l.password)>0 THEN 'true' ELSE 'false' end as is_exist_password, "
                + " r.role_id, r.role_description, r.role_name_en, r.role_name_bn, r.menu_json, r.api_json, "
                + " i.institute_type, i.name_en as institute_name_en, i.name_bn as institute_name_bn, i.logo_url "
                + " from " + Table.LOGIN +" l "
                + " left join " + Table.ROLE + " r on r.oid = l.role_oid "
                + " left join " + Table.INSTITUTE + " i on i.oid = l.institute_oid "
                + " where 1 = 1 and  l.login_id = '" + params.get("loginId") + "'";

        List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            data.setOid((String) row.get("oid"));
            data.setLoginId((String) row.get("login_oid"));
            data.setLoginId((String) row.get("login_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setLoginStatus((String) row.get("login_status"));
            data.setInstituteOid((String) row.get("institute_oid"));
            //data.setIsExistPassword((Boolean) row.get("is_exist_password"));
            data.setRoleId((String) row.get("role_id"));
            data.setRoleDescription((String) row.get("role_description"));
            data.setRoleNameEn((String) row.get("role_name_en"));
            data.setRoleNameBn((String) row.get("role_name_bn"));
            data.setMenuJson((String) row.get("menu_json"));
            data.setApiJson((String) row.get("api_json"));
            data.setInstituteType((String) row.get("institute_type"));
            data.setInstituteNameEn((String) row.get("institute_name_en"));
            data.setInstituteNameBn((String) row.get("institute_name_bn"));
            data.setLogoUrl((String) row.get("logo_url"));
            break;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return data;
};

    @Override
    public UserEntity findUserByOidSql(String oid, Map<String, String> params){
    UserEntity data = new UserEntity();

    try {

        String sql = "SELECT l.oid, l.login_id, l.name_en, l.name_bn, l.role_oid, l.institute_oid, l.status, "
                + " r.role_id, r.role_description, r.role_name_en, r.role_name_bn "
                + " from " + Table.LOGIN +" l "
                + " left join " + Table.ROLE + " r on r.oid = l.role_oid "
                + " where 1 = 1 and  l.oid = '" + oid + "'";

        List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            data.setOid((String) row.get("oid"));
            data.setLoginId((String) row.get("login_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setInstituteOid((String) row.get("institute_oid"));
            data.setStatus((String) row.get("status"));
            data.setRoleOid((String) row.get("role_oid"));
            data.setRoleId((String) row.get("role_id"));
            data.setRoleDescription((String) row.get("role_description"));
            data.setRoleNameEn((String) row.get("role_name_en"));
            data.setRoleNameBn((String) row.get("role_name_bn"));
//
//            data.setStatus((String) row.get("status"));
//            data.setCreatedBy((String) row.get("created_by"));
//            data.setCreatedOn((Date) row.get("created_on"));
//            data.setUpdatedBy((String) row.get("updated_by"));
//            data.setUpdatedOn((Date) row.get("updated_on"));
            break;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return data;
};

    @Override
    public int countUserSql(String schema) {
        String sql = "Select count(*) from " + schema + "branch";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int saveUserSql(UserEntity entity, Map<String, String> params){
//    String sql = "INSERT INTO " + params.get("schemaName") + Table.BRANCH + "(" +
//            "oid, branch_id, com_branch_id, name_en, name_bn, email, " +
//            "contact_no, address_en, address_bn, district_oid, branch_type_oid, status, created_by" +
//            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    return jdbcTemplate.update(sql, entity.getOid(), entity.getBranchId(), entity.getComBranchId(),
//            entity.getNameEn(), entity.getNameBn(), entity.getEmail(), entity.getContactNo(), entity.getAddressEn(),
//            entity.getAddressBn(), entity.getStatus(), entity.getDistrictOid(), entity.getBranchTypeOid(), entity.getCreatedBy());

        return 0;
    };

    @Override
    public int updateUserSql(UserEntity entity, Map<String, String> params) {
        try {
//            String sql = "update " + params.get("schemaName") +  Table.BRANCH
//                    + " set branch_type_oid = ?, name_en = ?, name_bn = ?,"
//                    + " email = ?, contact_no = ?, address_en = ?, address_bn = ?, district_oid = ?,"
//                    + " status = ?, updated_by = ?, updated_on = current_timestamp  where oid = ?";
//            return jdbcTemplate.update(sql, entity.getBranchTypeOid(), entity.getNameEn(),
//                    entity.getNameBn(), entity.getEmail(), entity.getContactNo(), entity.getAddressEn(),
//                    entity.getAddressBn(), entity.getDistrictOid(), entity.getStatus(), entity.getUpdatedBy(),
//                    entity.getOid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
