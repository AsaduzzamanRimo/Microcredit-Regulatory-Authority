package com.doer.mraims.user.adapter.out.persistance.database.repository;

import com.doer.mraims.user.adapter.out.persistance.database.entity.UserEntity;
import com.doer.mraims.user.application.port.in.dto.request.ApprovalUserRequest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import java.sql.PreparedStatement;

import com.doer.mraims.core.util.Constant;
import com.doer.mraims.core.util.Table;
import com.doer.mraims.core.util.service.UtilService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Repository
public class UnAuthUserRepositoryImpl implements UnAuthUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalUnAuthUserForPagination(Map<String, String> params) {
        String sql = "SELECT COUNT(*)" +
                " from " + Table.UNAUTH_LOGIN + " ul " +
                " where 1 = 1 ";

        if (StringUtils.isNotBlank(params.get("instituteOid"))) {
            sql += " and ul.institute_oid  =  '" + params.get("instituteOid") + "' ";
        }

        if (StringUtils.isNotBlank(params.get("status"))) {
            sql += " and ul.status  =  '" + params.get("status") + "' ";
        }

        if (StringUtils.isNotBlank(params.get("searchText"))) {
            sql += " and (ul.name_en ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.name_bn ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.email ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.contact_no ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.status ilike '%" + params.get("searchText").trim() + "%')";
        }

        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public List<UserEntity> findAllUnAuthUser(Map<String, String> params) {
        List<UserEntity> dataList = new ArrayList<>();

        String sql = "SELECT ul.oid, ul.login_id, ul.password, ul.name_en, ul.name_bn, ul.email, ul.contact_no, ul.photo_path, ul.photo_url, " +
                " ul.current_version, ul.is_new_record, ul.locked_by, ul.locked_on, ul.approved_by, ul.approved_on, ul.remarked_by, " +
                " ul.remarked_on, ul.is_approver_remarks, ul.approver_remarks, ul.edit_commit, ul.role_oid, ul.institute_oid, ul.status, " +
                " r.role_id, r.role_name_en, r.role_name_bn " +
                " from " + Table.UNAUTH_LOGIN + " ul " +
                " left join " + Table.ROLE + " r on r.oid = ul.role_oid" +
                " where 1 = 1 ";

        if (StringUtils.isNotBlank(params.get("editCommit"))) {
            sql += " and ul.edit_commit  =  '" + params.get("editCommit") + "' ";
        }

        if (StringUtils.isNotBlank(params.get("instituteOid"))) {
            sql += " and ul.institute_oid  =  '" + params.get("instituteOid") + "' ";
        }

        if (StringUtils.isNotBlank(params.get("status"))) {
            sql += " and ul.status  =  '" + params.get("status") + "' ";
        }
        if (StringUtils.isNotBlank(params.get("searchText"))) {
            sql += " and (ul.name_en ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.name_bn ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.email ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.contact_no ilike '%" + params.get("searchText").trim() + "%'"
                    + " or ul.status ilike '%" + params.get("searchText").trim() + "%')";
        }

        if (StringUtils.isNotBlank(params.get("sortColId")) && StringUtils.isNotBlank(params.get("sortOrder"))) {
            sql += " order by ul." + params.get("sortColId") + " " + params.get("sortOrder");
        } else {
            sql += " order by ul.created_on asc";
        }
        if (Integer.valueOf(params.get("offset")) >= 0) {
            sql += " offset " + params.get("offset");
        }
        if (Integer.valueOf(params.get("limit")) >= 0) {
            sql += " limit " + params.get("limit");
        }

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            UserEntity data = new UserEntity();

            data.setOid((String) row.get("oid"));
            data.setLoginId((String) row.get("login_id"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setEmail((String) row.get("email"));
            data.setContactNo((String) row.get("contact_no"));
            data.setPhotoPath((String) row.get("photo_path"));
            data.setPhotoUrl((String) row.get("photo_url"));
            data.setCurrentVersion((String) row.get("current_version"));
            data.setIsNewRecord((String) row.get("is_new_record"));
            data.setLockedBy((String) row.get("locked_by"));

            data.setLockedOn((Date) row.get("locked_on"));
            data.setApprovedBy((String) row.get("approved_by"));
            data.setApprovedOn((Date) row.get("approved_on"));
            data.setRemarkedBy((String) row.get("remarked_by"));
            data.setRemarkedOn((Date) row.get("remarked_on"));
            data.setIsApproverRemarks((String) row.get("is_approver_remarks"));

            data.setApproverRemarks((String) row.get("approver_remarks"));
            data.setEditCommit((String) row.get("edit_commit"));
            data.setRoleId((String) row.get("role_oid"));
            data.setInstituteOid((String) row.get("institute_oid"));
            data.setStatus((String) row.get("status"));
            data.setRoleId((String) row.get("role_id"));
            data.setRoleNameEn((String) row.get("role_name_en"));
            data.setRoleNameBn((String) row.get("role_name_bn"));
            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public UserEntity findByUserId(String branchId, Map<String, String> params) {
        return null;
    }

    @Override
    public UserEntity findByOid(String oid, Map<String, String> params) {
        UserEntity data = new UserEntity();

        try {
            String sql = "SELECT ul.oid, ul.login_id, ul.password, ul.name_en, ul.name_bn, ul.email, ul.contact_no, ul.photo_path, ul.photo_url, " +
                    " ul.current_version, ul.is_new_record, ul.locked_by, ul.locked_on, ul.approved_by, ul.approved_on, ul.remarked_by, " +
                    " ul.remarked_on, ul.is_approver_remarks, ul.approver_remarks, ul.edit_commit, ul.role_oid, ul.institute_oid, ul.status,  " +
                    " r.role_id, r.role_name_en, r.role_name_bn, r.menu_json, r.api_json " +
                    " from " + Table.UNAUTH_LOGIN + " ul " +
                    " left join " + Table.ROLE + " r on r.oid = ul.role_oid" +
                    " where 1 = 1  and  ul.oid = '" + oid + "'";

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            for (Map<String, Object> row : rows) {
                data.setOid((String) row.get("oid"));
                data.setLoginId((String) row.get("login_id"));
                data.setNameEn((String) row.get("name_en"));
                data.setNameBn((String) row.get("name_bn"));
                data.setEmail((String) row.get("email"));
                data.setContactNo((String) row.get("contact_no"));
                data.setPhotoPath((String) row.get("photo_path"));
                data.setPhotoUrl((String) row.get("photo_url"));
                data.setCurrentVersion((String) row.get("current_version"));
                data.setIsNewRecord((String) row.get("is_new_record"));
                data.setLockedBy((String) row.get("locked_by"));
                data.setLockedOn((Date) row.get("locked_on"));
                data.setApprovedBy((String) row.get("approved_by"));
                data.setApprovedOn((Date) row.get("approved_on"));
                data.setRemarkedBy((String) row.get("remarked_by"));
                data.setRemarkedOn((Date) row.get("remarked_on"));
                data.setIsApproverRemarks((String) row.get("is_approver_remarks"));
                data.setApproverRemarks((String) row.get("approver_remarks"));
                data.setEditCommit((String) row.get("edit_commit"));
                data.setRoleId((String) row.get("role_oid"));
                data.setInstituteOid((String) row.get("institute_oid"));
                data.setStatus((String) row.get("status"));
                data.setRoleId((String) row.get("role_id"));
                data.setRoleNameEn((String) row.get("role_name_en"));
                data.setRoleNameBn((String) row.get("role_name_bn"));
                data.setMenuJson((String) row.get("menu_json"));
                data.setApiJson((String) row.get("api_json"));
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<UserEntity> findByOidIn(Map<String, String> params, List<String> oidList) {
        List<UserEntity> dataList = new ArrayList<>();

        String sql = "SELECT ul.oid, ul.login_id, ul.password, ul.name_en, ul.name_bn, ul.email, ul.contact_no, ul.photo_path, ul.photo_url, " +
                " ul.current_version, ul.is_new_record, ul.locked_by, ul.locked_on, ul.approved_by, ul.approved_on, ul.remarked_by, " +
                " ul.remarked_on, ul.is_approver_remarks, ul.approver_remarks, ul.edit_commit, ul.role_oid, ul.institute_oid, ul.status " +
                " from " + Table.UNAUTH_LOGIN + " ul " +
                " where 1 = 1 and ul.oid in (" + UtilService.formatIdsForInOperator(oidList) + ")";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            UserEntity data = new UserEntity();

                data.setOid((String) row.get("oid"));
                data.setLoginId((String) row.get("login_id"));
                data.setNameEn((String) row.get("name_en"));
                data.setNameBn((String) row.get("name_bn"));
                data.setEmail((String) row.get("email"));
                data.setContactNo((String) row.get("contact_no"));
                data.setPhotoPath((String) row.get("photo_path"));
                data.setPhotoUrl((String) row.get("photo_url"));
                data.setCurrentVersion((String) row.get("current_version"));
                data.setIsNewRecord((String) row.get("is_new_record"));
                data.setLockedBy((String) row.get("locked_by"));
                data.setLockedOn((Date) row.get("locked_on"));
                data.setApprovedBy((String) row.get("approved_by"));
                data.setApprovedOn((Date) row.get("approved_on"));
                data.setRemarkedBy((String) row.get("remarked_by"));
                data.setRemarkedOn((Date) row.get("remarked_on"));
                data.setIsApproverRemarks((String) row.get("is_approver_remarks"));
                data.setApproverRemarks((String) row.get("approver_remarks"));
                data.setEditCommit((String) row.get("edit_commit"));
                data.setRoleId((String) row.get("role_oid"));
                data.setInstituteOid((String) row.get("institute_oid"));
                data.setStatus((String) row.get("status"));
            dataList.add(data);
        }

        return dataList;
    }


    @Override
    public List<UserEntity> findLiveUserByOidIn(Map<String, String> params, List<String> oidList) {
        List<UserEntity> dataList = new ArrayList<>();

        String sql = "SELECT l.oid, l.login_id, l.password, l.name_en, l.name_bn, l.email, l.contact_no, l.photo_path, l.photo_url, " +
                " l.current_version, l.is_new_record, l.locked_by, l.locked_on, l.approved_by, l.approved_on, l.remarked_by, l.remarked_on, " +
                " l.is_approver_remarks, l.approver_remarks, l.role_oid, l.institute_oid, l.status " +
                " FROM " + Table.LOGIN + " l " +
                " WHERE 1 = 1 AND l.oid in (" + UtilService.formatIdsForInOperator(oidList) + ")";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            UserEntity data = new UserEntity();
            data.setOid((String) row.get("oid"));
            data.setLoginId((String) row.get("login_id"));
            data.setPassword((String) row.get("password"));
            data.setNameEn((String) row.get("name_en"));
            data.setNameBn((String) row.get("name_bn"));
            data.setEmail((String) row.get("email"));
            data.setContactNo((String) row.get("contact_no"));
            data.setPhotoPath((String) row.get("photo_path"));
            data.setPhotoUrl((String) row.get("photo_url"));
            data.setCurrentVersion((String) row.get("current_version"));
            data.setIsNewRecord((String) row.get("is_new_record"));
            data.setLockedBy((String) row.get("locked_by"));
            data.setLockedOn((Date) row.get("locked_on"));
            data.setApprovedBy((String) row.get("approved_by"));
            data.setApprovedOn((Date) row.get("approved_on"));
            data.setRemarkedBy((String) row.get("remarked_by"));
            data.setRemarkedOn((Date) row.get("remarked_on"));
            data.setIsApproverRemarks((String) row.get("is_approver_remarks"));
            data.setApproverRemarks((String) row.get("approver_remarks"));
            data.setRoleId((String) row.get("role_oid"));
            data.setInstituteOid((String) row.get("institute_oid"));
            data.setStatus((String) row.get("status"));
            dataList.add(data);
        }

        return dataList;
    }


    @Override
    public List<UserEntity> findOidsByOidListExceptUnAuthOids(Map<String, String> params, List<String> oidList) {
        List<UserEntity> dataList = new ArrayList<>();
        String sql = "select l.oid " +
                " from " + Table.LOGIN + " l " +
                " where 1 = 1 and l.oid in (" + UtilService.formatIdsForInOperator(oidList) + ")" +
                " EXCEPT " +
                " (select ul.oid " +" from " + Table.UNAUTH_LOGIN + " ul " +
                " where 1 = 1 and ul.oid in (" + UtilService.formatIdsForInOperator(oidList) + ")" + ")";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            UserEntity data = new UserEntity();
            data.setOid((String) row.get("oid"));
            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public List<UserEntity> findUnlockUserListByOids(Map<String, String> params, List<String> oidList, String loginId) {
        List<UserEntity> dataList = new ArrayList<>();
        String sql = "select l.oid " +
                " from " + Table.LOGIN + " l " +
                " where 1 = 1 and l.oid in (" + UtilService.formatIdsForInOperator(oidList) + ") and l.locked_by = ?"  ;

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, loginId);
        for (Map<String, Object> row : rows) {
            UserEntity data = new UserEntity();
            data.setOid((String) row.get("oid"));
            dataList.add(data);
        }
        return dataList;
    }

    @Override
    public int countUser(String schema) {
        String sql = "Select count(*) from " + schema + Table.LOGIN;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    @Override
    public int countUserByOid(String schema, String oid) {
        String sql = "Select count(*) from " + schema + Table.LOGIN + " where oid = '"+oid+"'";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int saveUnAuthLogin(UserEntity entity, Map<String, String> params) {
        String sql = "INSERT INTO " + Table.UNAUTH_LOGIN + "(" +
                " oid, login_id, password, name_en, name_bn, email, contact_no, photo_path, photo_url, current_version, is_new_record, " +
                " edit_commit, role_oid, institute_oid, status, created_by " +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, entity.getOid(),
                entity.getLoginId(), entity.getPassword(), entity.getNameEn(), entity.getNameBn(), entity.getEmail(), entity.getContactNo(),
                entity.getPhotoPath(), entity.getPhotoUrl(), entity.getCurrentVersion(), entity.getIsNewRecord(),
                entity.getEditCommit(), entity.getRoleOid(), entity.getInstituteOid(),
                entity.getStatus(), entity.getCreatedBy());
    }

    @Override
    public int[] batchSaveUnAuthUserEntity(List<UserEntity> entityList, Map<String, String> params, String loginId) {


        String sql = "INSERT INTO " + Table.UNAUTH_LOGIN + "(" +
                " oid, login_id, password, name_en, name_bn, email, contact_no, photo_path, photo_url, current_version, is_new_record, " +
                " edit_commit, role_oid, institute_oid, status, created_by" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                ps.setString(1, entityList.get(i).getOid());
                ps.setString(2, entityList.get(i).getLoginId());
                ps.setString(3, entityList.get(i).getPassword());
                ps.setString(4, entityList.get(i).getNameEn());
                ps.setString(5, entityList.get(i).getNameBn());
                ps.setString(6, entityList.get(i).getEmail());
                ps.setString(7, entityList.get(i).getContactNo());
                ps.setString(8, entityList.get(i).getPhotoPath());
                ps.setString(9, entityList.get(i).getPhotoUrl());
                ps.setString(10, entityList.get(i).getCurrentVersion());
                ps.setString(11, Constant.YES);
                ps.setString(12, Constant.NO);
                ps.setString(13, entityList.get(i).getRoleOid());
                ps.setString(14, entityList.get(i).getInstituteOid());
                ps.setString(15, entityList.get(i).getStatus());
                ps.setString(16, loginId);

            }

            public int getBatchSize() {
                return entityList.size();
            }

        });
    }


    @Override
    public int updateUnAuthLogin(UserEntity entity, Map<String, String> params) {
        try {
            String sql = "update " + Table.UNAUTH_LOGIN +
                    " set login_id = ?, password = ?, name_en = ?, name_bn = ?, email = ?, contact_no = ?, photo_path = ?, photo_url = ?, " +
                    " is_new_record = ?, edit_commit = ?, role_oid = ?, institute_oid = ?, status = ?, " +
                    " updated_by = ?, updated_on = current_timestamp  " +
                    " where oid = ?";

            return jdbcTemplate.update(sql, entity.getLoginId(), entity.getPassword(), entity.getNameEn(),
                    entity.getNameBn(), entity.getEmail(), entity.getContactNo(), entity.getPhotoPath(), entity.getPhotoUrl(),
                    entity.getIsNewRecord(), entity.getEditCommit(), entity.getRoleOid(), entity.getInstituteOid(),
                    entity.getStatus(), entity.getUpdatedBy(), entity.getOid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int updateLockLiveSchema(UserEntity entity, String loginId, String oid, Map<String, String> params) {
        try {
            String sql = "update " + params.get("schemaName") + Table.UNAUTH_BRANCH +
                    " set locked_by = ?, locked_on = current_timestamp " +
                    " where oid = ?";

            return jdbcTemplate.update(sql,
                    loginId, oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int updateUserByLockStatusAndOidInAndLockedBy(String loginId, List<String> oidList, Map<String, String> params) {
        try {
            String sql = "UPDATE " + Table.LOGIN +
                    " SET locked_by = ?, locked_on = current_timestamp, updated_by = ?, updated_on = current_timestamp " +
                    " WHERE oid IN (" + UtilService.formatIdsForInOperator(oidList) + ")";
//            in (" + utilService.formatIdsForInOperator(oidList) + ")";
            return jdbcTemplate.update(sql, loginId,  loginId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUserByUnlockStatusAndOidInAndLockedBy(String loginId, List<String> oidList, Map<String, String> params) {
        try {
            String sql = "UPDATE " + params.get("schemaName") + Table.BRANCH +
                    " SET locked_by = ?, locked_on = ?,  updated_by = ?, updated_on = current_timestamp  " +
                    " WHERE oid IN (" + UtilService.formatIdsForInOperator(oidList) + ")";

            return jdbcTemplate.update(sql, null, null, loginId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUserByOidInAndLockedBy(String loginId, List<String> oidList, Map<String, String> params) {
        try {
            String sql = "delete from " + params.get("schemaName")
                    + Table.UNAUTH_BRANCH + " ub where " +
                    " ub.oid in (" + UtilService.formatIdsForInOperator(oidList) + ")";

            return jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Approval lock unlock
    @Override
    public int updateUserByLockStatusAndOidInAndLockedByForApprover(String loginId, List<String> oidList, Map<String, String> params) {
        try {
            String sql = "UPDATE " + params.get("schemaName") + Table.UNAUTH_BRANCH +
                    " SET locked_by = ?, locked_on = current_timestamp, updated_by = ?, updated_on = current_timestamp " +
                    " WHERE oid IN (" + UtilService.formatIdsForInOperator(oidList) + ") and locked_by is null";
            return jdbcTemplate.update(sql, loginId,  loginId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int updateUserByUnlockStatusAndOidInAndLockedByForApprover(String loginId, List<String> oidList, Map<String, String> params) {
        try {
            String sql = "UPDATE " + params.get("schemaName") + Table.UNAUTH_BRANCH +
                    " SET locked_by = ?, locked_on = ?,  updated_by = ?, updated_on = current_timestamp  " +
                    " WHERE oid IN (" + UtilService.formatIdsForInOperator(oidList) + ") and locked_by = ?";
            return jdbcTemplate.update(sql, null, null, loginId, loginId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public int updateApprovedStatusUnAuthBranchByOid(String loginId, String oid, Map<String, String> params) {
        try {
            String sql = "UPDATE " + params.get("schemaName") + Table.UNAUTH_BRANCH +
                    " SET approved_by = ?, approved_on = current_timestamp, is_approver_remarks = ?, approver_remarks = ?, updated_by = ?, updated_on = current_timestamp " +
                    " WHERE oid = ? and approved_by is null";
            return jdbcTemplate.update(sql, loginId, params.get("isApproverRemarks"), params.get("approverRemarks"), loginId, oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateApprovedStatusUserByOid(String loginId, String oid, Map<String, String> params) {
        try {
            String sql = "UPDATE " + params.get("schemaName") + Table.BRANCH +
                    " SET approved_by = ?, approved_on = current_timestamp, updated_by = ?, updated_on = current_timestamp " +
                    " WHERE oid = ?";
            return jdbcTemplate.update(sql, loginId,  loginId, oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int saveUserHistory(ApprovalUserRequest request, Map<String, String> params) {

        String sql = "INSERT INTO " + params.get("schemaName") + Table.BRANCH_HISTORY + "(" +
                " oid, branch_id, com_branch_id, name_en, name_bn, email, contact_no, address_en, address_bn, " +
                " district_oid, branch_type_oid, version, is_new_record, locked_by, locked_on, " +
                " approved_by, approved_on, remarked_by, remarked_on, is_approver_remarks, approver_remarks, status, created_by " +
                ") SELECT b.oid||'-'||b.current_version, b.branch_id, b.com_branch_id, b.name_en, b.name_bn, email, b.contact_no, " +
                " b.address_en, b.address_bn, " +
                " b.district_oid, b.branch_type_oid, b.current_version, b.is_new_record, b.locked_by, b.locked_on, b.approved_by, b.approved_on, " +
                " b.remarked_by, b.remarked_on, b.is_approver_remarks, b.approver_remarks, b.status, '" +request.getLoginId()+"' "+
                " FROM " +  params.get("schemaName") + Table.BRANCH + " b where b.oid = '"+request.getOid()+"'";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int saveUserFromUnAuthUser(ApprovalUserRequest request, Map<String, String> params) {

        String sql = "INSERT INTO " + params.get("schemaName") + Table.BRANCH + "(" +
                " oid, branch_id, com_branch_id, name_en, name_bn, email, contact_no, address_en, address_bn, " +
                " district_oid, branch_type_oid, current_version, is_new_record, " +
                " approved_by, approved_on, remarked_by, remarked_on, is_approver_remarks, approver_remarks, status, created_by " +
                ") SELECT b.oid, b.branch_id, b.com_branch_id, b.name_en, b.name_bn, email, b.contact_no, " +
                " b.address_en, b.address_bn, " +
                " b.district_oid, b.branch_type_oid, b.current_version, b.is_new_record, b.approved_by, b.approved_on, " +
                " b.remarked_by, b.remarked_on, b.is_approver_remarks, b.approver_remarks, b.status, '" +request.getLoginId()+"' "+
                " FROM " +  params.get("schemaName") + Table.UNAUTH_BRANCH + " b where b.oid = '"+request.getOid()+"'";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateUserByUnAuthOid(ApprovalUserRequest request, Map<String, String> params) {

        String sql = "UPDATE " + params.get("schemaName") + Table.BRANCH + " b " +
            " SET (branch_id, com_branch_id, name_en, name_bn, email, contact_no, address_en, address_bn, district_oid, branch_type_oid, current_version, " +
            " is_new_record, locked_by, locked_on, approved_by, approved_on, remarked_by, remarked_on, is_approver_remarks, approver_remarks, " +
            " status, updated_by) = (ub.branch_id, ub.com_branch_id, ub.name_en, ub.name_bn, ub.email, ub.contact_no, ub.address_en, " +
            " ub.address_bn, ub.district_oid, ub.branch_type_oid, (ub.current_version::int + 1)::text, ub.is_new_record, null, null, ub.approved_by, " +
            " ub.approved_on, ub.remarked_by, ub.remarked_on, ub.is_approver_remarks, " +
            " ub.approver_remarks, ub.status, '"+request.getLoginId()+"') FROM   " + params.get("schemaName") + Table.UNAUTH_BRANCH +" ub  " +
            " WHERE  b.oid = '"+request.getOid()+"' AND    ub.oid = b.oid";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int deleteUnauthUserByOid(String oid, Map<String, String> params) {
        try {
            String sql = "delete from " + Table.UNAUTH_LOGIN + " ul where " +
                    " ul.oid = '"+oid+"'";

            return jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
