package com.doer.mraims.core.util.repository;


import com.doer.mraims.core.util.DatabaseSchema;
import com.doer.mraims.core.util.Table;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UtilRepositoryImpl implements UtilRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate parameterJdbcTemplate;
    public String findSchemaByInstituteOid(String instituteOid) {
        String sql = "SELECT db_schema_name as dbSchema FROM " + DatabaseSchema.MRAIMS_DB + Table.INSTITUTE
                + " WHERE oid = ?";
        String dbSchema = jdbcTemplate.queryForObject(sql, String.class, instituteOid);
        return dbSchema;
    }

    public String findSchemaNameByInstituteOid(String instituteOid) {
        return findSchemaByInstituteOid(instituteOid).concat(".");
    }

}
