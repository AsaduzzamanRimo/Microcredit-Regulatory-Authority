package com.doer.mraims.security.adapter.out.persistance.database.repository;


import com.doer.mraims.core.util.Table;
import com.doer.mraims.security.adapter.out.persistance.database.entity.LoginEntity;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private final JdbcTemplate jdbcTemplate;

//    @Override
//    public int countLoginId(Map<String, String> params) {
//        String sql ="select count(l.login_id) "
//                + " from " + Table.LOGIN +" l "
//                + " where 1 = 1 and l.login_id = '" + params.get("loginId") + "'";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }

    @Override
    public int countTotalBranchForPagination(Map<String, String> params) {
        String sql ="select count(*) "
                + " from " + params.get("schemaName") +  Table.BRANCH +" br "
                + " left join " + Table.BRANCH_TYPE + " brt on brt.oid = br.branch_type_oid"
                + " left join " + Table.DISTRICT + " dist on dist.oid = br.district_oid"
                + " where 1 = 1 ";

        if(StringUtils.isNotBlank(params.get("branchTypeOid"))){
            sql += " and br.branch_type_oid  =  '" + params.get("branchTypeOid") + "' ";
        }

        if(StringUtils.isNotBlank(params.get("districtOid"))){
            sql += " and br.district_oid  =  '" + params.get("districtOid") + "' ";
        }

        if(StringUtils.isNotBlank(params.get("status"))){
            sql += " and br.status  =  '" + params.get("status") + "' ";
        }

        if (StringUtils.isNotBlank(params.get("searchText"))) {
            sql += " and (br.name_en ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.name_bn ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.branch_id ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.email ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.contact_no ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.branch_type_oid ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.district_oid ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.status ilike '%" + params.get("searchText").trim() +  "%')";
        }

        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public List<LoginEntity> findAllBranch(Map<String, String> params) {
        List<LoginEntity> dataList = new ArrayList<>();

        String sql = "SELECT br.oid, br.branch_id, br.com_branch_id, br.name_en, br.name_bn, br.email, br.contact_no,"
                + " br.address_en, br.address_bn, br.status, br.branch_type_oid, brt.name_en as branch_type_name_en, brt.name_bn as branch_type_name_bn, "
                + " br.district_oid, dist.name_en as district_name_en, dist.name_bn as district_name_bn"
                + " from " + params.get("schemaName") +  Table.BRANCH +" br "
                + " left join " + Table.BRANCH_TYPE + " brt on brt.oid = br.branch_type_oid"
                + " left join " +  Table.DISTRICT + " dist on dist.oid = br.district_oid"
                + " where 1 = 1 ";

        if(StringUtils.isNotBlank(params.get("branchTypeOid"))){
            sql += " and br.branch_type_oid  =  '" + params.get("branchTypeOid") + "' ";
        }

        if(StringUtils.isNotBlank(params.get("districtOid"))){
            sql += " and br.district_oid  =  '" + params.get("districtOid") + "' ";
        }

        if(StringUtils.isNotBlank(params.get("status"))){
            sql += " and br.status  =  '" + params.get("status") + "' ";
        }
        if (StringUtils.isNotBlank(params.get("searchText"))) {
            sql += " and (br.name_en ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.name_bn ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.branch_id ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.email ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.contact_no ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.branch_type_oid ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.district_oid ilike '%" + params.get("searchText").trim() + "%'"
                    + " or br.status ilike '%" + params.get("searchText").trim() +  "%')";
        }

        if (StringUtils.isNotBlank(params.get("sortColId")) && StringUtils.isNotBlank(params.get("sortOrder"))) {
            sql += " order by br." + params.get("sortColId") +" "+ params.get("sortOrder");
        } else {
            sql += " order by br.created_on asc";
        }
        if (Integer.valueOf(params.get("offset"))>=0) {
            sql += " offset "+params.get("offset");
        }
        if (Integer.valueOf(params.get("limit"))>=0) {
            sql += " limit "+params.get("limit");
        }

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map<String, Object> row:rows){
            LoginEntity data = new LoginEntity();
            data.setOid((String) row.get("oid"));
            /*
            data.setBranchId((String) row.get("branch_id"));
            data.setComBranchId((String) row.get("com_branch_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setEmail((String) row.get("email"));
            data.setContactNo((String) row.get("contact_no"));
            data.setAddressEn((String) row.get("address_en"));
            data.setAddressBn((String) row.get("address_bn"));

            data.setDistrictOid((String) row.get("district_oid"));
            data.setDistrictNameEn((String) row.get("district_name_en"));
            data.setDistrictNameBn((String) row.get("district_name_bn"));

            data.setBranchTypeOid((String) row.get("branch_type_oid"));
            data.setBranchTypeNameEn((String) row.get("branch_type_name_en"));
            data.setBranchTypeNameBn((String) row.get("branch_type_name_bn"));

            data.setStatus((String) row.get("status"));
            data.setCreatedBy((String) row.get("created_by"));
            data.setCreatedOn((Date) row.get("created_on"));
            data.setUpdatedBy((String) row.get("updated_by"));
            data.setUpdatedOn((Date) row.get("updated_on"));

             */
            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public LoginEntity findByBranchId(String branchId, Map<String, String> params){

    LoginEntity data = new LoginEntity();

    try {
        String sql = "SELECT br.oid, br.branch_id, br.com_branch_id, br.name_en, br.name_bn, br.email, br.contact_no,"
                + " br.address_en, br.address_bn, br.status, br.branch_type_oid, brt.name_en as branch_type_name_en, brt.name_bn as branch_type_name_bn, "
                + " br.district_oid,dist.name_en as district_name_en, dist.name_bn as district_name_bn"
                + " from " + params.get("schemaName") +  Table.BRANCH +" br "
                + " left join " + Table.BRANCH_TYPE + " brt on brt.oid = br.branch_type_oid"
                + " left join " + Table.DISTRICT + " dist on dist.oid = br.district_oid"
                + " where 1 = 1 and  br.branch_id = '" + branchId + "'";

        List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            data.setOid((String) row.get("oid"));
            /*
            data.setBranchId((String) row.get("branch_id"));
            data.setComBranchId((String) row.get("com_branch_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setEmail((String) row.get("email"));
            data.setContactNo((String) row.get("contact_no"));
            data.setAddressEn((String) row.get("address_en"));
            data.setAddressBn((String) row.get("address_bn"));

            data.setDistrictOid((String) row.get("district_oid"));
            data.setDistrictNameEn((String) row.get("district_name_en"));
            data.setDistrictNameBn((String) row.get("district_name_bn"));

            data.setBranchTypeOid((String) row.get("branch_type_oid"));
            data.setBranchTypeNameEn((String) row.get("branch_type_name_en"));
            data.setBranchTypeNameBn((String) row.get("branch_type_name_bn"));

            data.setStatus((String) row.get("status"));
            data.setCreatedBy((String) row.get("created_by"));
            data.setCreatedOn((Date) row.get("created_on"));
            data.setUpdatedBy((String) row.get("updated_by"));
            data.setUpdatedOn((Date) row.get("updated_on"));
            */
            break;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return data;
};

    @Override
    public LoginEntity findByOid(String oid, Map<String, String> params){
    LoginEntity data = new LoginEntity();

    try {
        String sql = "SELECT br.oid, br.branch_id, br.com_branch_id, br.name_en, br.name_bn, br.email, br.contact_no,"
                + " br.address_en, br.address_bn, br.status, br.created_by, br.created_on, br.updated_by, br.updated_on, br.branch_type_oid, brt.name_en as branch_type_name_en, brt.name_bn as branch_type_name_bn, "
                + " br.district_oid,dist.name_en as district_name_en, dist.name_bn as district_name_bn"
                + " from " + params.get("schemaName") +  Table.BRANCH +" br "
                + " left join " + Table.BRANCH_TYPE + " brt on brt.oid = br.branch_type_oid"
                + " left join " + Table.DISTRICT + " dist on dist.oid = br.district_oid"
                + " where 1 = 1 and  br.oid = '" + oid + "'";

        List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            data.setOid((String) row.get("oid"));
            /*
            data.setBranchId((String) row.get("branch_id"));
            data.setComBranchId((String) row.get("com_branch_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setEmail((String) row.get("email"));
            data.setContactNo((String) row.get("contact_no"));
            data.setAddressEn((String) row.get("address_en"));
            data.setAddressBn((String) row.get("address_bn"));

            data.setDistrictOid((String) row.get("district_oid"));
            data.setDistrictNameEn((String) row.get("district_name_en"));
            data.setDistrictNameBn((String) row.get("district_name_bn"));

            data.setBranchTypeOid((String) row.get("branch_type_oid"));
            data.setBranchTypeNameEn((String) row.get("branch_type_name_en"));
            data.setBranchTypeNameBn((String) row.get("branch_type_name_bn"));

            data.setStatus((String) row.get("status"));
            data.setCreatedBy((String) row.get("created_by"));
            data.setCreatedOn((Date) row.get("created_on"));
            data.setUpdatedBy((String) row.get("updated_by"));
            data.setUpdatedOn((Date) row.get("updated_on"));

             */
            break;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return data;
}

    @Override
    public int countLoginId(Map<String, String> params) {
        String sql ="select count(l.login_id) "
                + " from " + Table.LOGIN +" l "
                + " where 1 = 1 and l.login_id = '" + params.get("loginId") + "'";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public LoginEntity getUserInfo(Map<String, String> params) {
        LoginEntity data = new LoginEntity();

        try {
            String sql = "SELECT l.login_id, l.password  "
                    + " from " + Table.LOGIN +" l "
                    + " where 1 = 1 and l.login_id = '" + params.get("loginId") + "'";

            List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);

            for (Map<String, Object> row : rows) {
                data.setOid((String) row.get("oid"));
                data.setLoginId((String) row.get("login_id"));
                data.setPassword((String) row.get("password"));
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public LoginEntity checkLoginId(Map<String, String> params) {
        LoginEntity data = new LoginEntity();

        try {
            String sql = "SELECT l.oid, l.login_id, l.name_en, l.name_bn  "
                    + " from " + Table.LOGIN +" l "
                    + " where 1 = 1 and l.login_id = '" + params.get("loginId") + "'";

            List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);

            for (Map<String, Object> row : rows) {
                data.setOid((String) row.get("oid"));
                data.setLoginId((String) row.get("login_id"));
                data.setNameEn((String) row.get("name_en"));
                data.setNameBn((String) row.get("name_bn"));
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    ;

    @Override
    public int countBranch(String schema) {
        String sql = "Select count(*) from " + schema + "branch";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int saveWithSchema(LoginEntity entity, Map<String, String> params){
    String sql = "INSERT INTO " + params.get("schemaName") + Table.BRANCH + "(" +
            "oid, branch_id, com_branch_id, name_en, name_bn, email, " +
            "contact_no, address_en, address_bn, district_oid, branch_type_oid, status, created_by" +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    return jdbcTemplate.update(sql, entity.getOid(),
            /*
            entity.getBranchId(), entity.getComBranchId(),
            entity.getNameEn(), entity.getNameBn(), entity.getEmail(), entity.getContactNo(), entity.getAddressEn(),
            entity.getAddressBn(), entity.getStatus(), entity.getDistrictOid(), entity.getBranchTypeOid(),
            */
            entity.getCreatedBy());
};

    @Override
    public int updateWithSchema(LoginEntity entity, Map<String, String> params) {
        try {
            String sql = "update " + params.get("schemaName") +  Table.BRANCH
                    + " set branch_type_oid = ?, name_en = ?, name_bn = ?,"
                    + " email = ?, contact_no = ?, address_en = ?, address_bn = ?, district_oid = ?,"
                    + " status = ?, updated_by = ?, updated_on = current_timestamp  where oid = ?";
            return jdbcTemplate.update(sql,
                    /*
                    entity.getBranchTypeOid(), entity.getNameEn(),
                    entity.getNameBn(), entity.getEmail(), entity.getContactNo(), entity.getAddressEn(),
                    entity.getAddressBn(), entity.getDistrictOid(), entity.getStatus(), entity.getUpdatedBy(),

                     */
                    entity.getOid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
