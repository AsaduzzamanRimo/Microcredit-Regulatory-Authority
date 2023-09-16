package com.doer.mraims.core.util.service;

import com.doer.mraims.core.util.*;
import com.google.gson.GsonBuilder;
import lombok.Synchronized;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UtilService {

	public static String generateOid() {
		return getRandomNumberString() + System.currentTimeMillis();
	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

	public static String applicationId() {
		StringBuffer stringBuffer = new StringBuffer();
		Date now = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssZ");
		simpleDateFormat.format(now, stringBuffer, new FieldPosition(0));
		// this will convert any number sequence into 6 character.
		return stringBuffer.toString() + getRandomNumberString();
	}

	@Synchronized
	public static String print(Object object) {
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(BigDecimal.class, new GsonBigDecimalUtil())
				.registerTypeAdapter(DateTime.class, new GsonDateTimeUtil());
		builder.excludeFieldsWithoutExposeAnnotation();
		builder.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE, Modifier.FINAL);
		if (Constant.PREETY_JSON) {
			builder.setPrettyPrinting();
		}
		return builder.create().toJson(object);
	}

//	@Synchronized
//	public static String generateOid(int count) {
//		Date today = new Date();
//		Random rnd = new Random();
//		int number = rnd.nextInt(99999999);
//		return String.format("%08d", count);
//	}

	@Synchronized
	public static String generatePeopleId(int count, String gender) {
		String peopleId = "P-";
		String pattern = "yyyyMM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		peopleId += date;
		if (gender.equals("Male")) {
			peopleId += "M";
		} else if (gender.equals("Female")) {
			peopleId += "F";
		} else {
			peopleId += "O";
		}
		peopleId += String.format("%04d", count + 1);
		return peopleId;
	}
	
	@Synchronized
	public static String getSchemaByInstituteOid(String instituteOd) {
//	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT db_schema_name as dbSchema FROM " + DatabaseSchema.MRAIMS_DB + Table.INSTITUTE
				+ " WHERE oid = ?";

		String dbSchema = (String) new JdbcTemplate().queryForObject(sql, String.class, instituteOd);

		return dbSchema + ".";
	}
	
	@Synchronized
	public static String getSchemaNameByInstituteOid(String instituteOid, DataSource dataSource) {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT db_schema_name as dbSchema FROM " + DatabaseSchema.MRAIMS_DB + Table.INSTITUTE
				+ " WHERE oid = ?";

		String dbSchema = (String) jdbcTemplate.queryForObject(sql, String.class, instituteOid);

		return dbSchema + ".";
	}
	@Synchronized
	public static String formatIdsForInOperator(List<String> ids) {
		String s = "'";
		for (int i = 0; i < ids.size(); i++) {
			if (i != ids.size() - 1) {
				s += "" + ids.get(i) + "','";
			} else if (i == ids.size() - 1) {
				s += "" + ids.get(i) + "'";
			}
		}
		return s;
	}
}
