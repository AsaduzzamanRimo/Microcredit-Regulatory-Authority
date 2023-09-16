package com.doer.mraims.core.util;

import lombok.Synchronized;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component("idGenerator")
public class IdGenerator {

	private final int NUM_CHARS = 15;
	private String chars = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private String passwordChars = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ123456789";

	private static Random r = new Random();
	private SimpleDateFormat generalFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
	private SimpleDateFormat fetchIdFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	private final int TRACE_NUM_CHARS = 6;
	private String traceChars = "ABCDEFGHJKLMNPQRSTUVWXYZ";
	private SimpleDateFormat traceDateFormat = new SimpleDateFormat("yyMMdd");

	private String instituteCode = "001";
	
	private static final int OTP_NUM_CHARS = 6;
	private static String otpChars = "0123456789";
	//private static Random r = new Random();

	@Synchronized
	public String generateOTP() {
		 String Otp = generateRandormNumber(OTP_NUM_CHARS);
		 return Otp;
	}

	@Synchronized
	public String generateSamityId(int count) {
		String samityId = Constant.REQEUST_PREFIX_MRAIMS.concat(Constant.PREFIX_SAMITY_ID + String.format("%08d", count));
		return samityId;
	}

	@Synchronized
	public String generateBranchId(int count) {
		String branchId = Constant.PREFIX_BRANCH_ID + String.format("%04d", (count + 1));
		return branchId;
	}
	@Synchronized
	public String generateComBranchId(int count) {
		String comBranchId = Constant.PREFIX_COM_BRANCH_ID + String.format("%03d", (count + 1));
		return comBranchId;
	}


	@Synchronized
	public String generateRoleId(int count) {
		return Constant.REQEUST_PREFIX_MRAIMS.concat("R-" + String.format("%08d", count));
	}
	
	@Synchronized
	public String generateRepayScheduleId(int count) {
		return Constant.REQEUST_PREFIX_MRAIMS.concat("LRS-" + String.format("%08d", count));
	}
	
	@Synchronized
	public String getStudentCode(int studentSerial) {
		final AtomicInteger incrementedstudentSerial = new AtomicInteger( studentSerial ) ;
		incrementedstudentSerial.incrementAndGet();
		String code = instituteCode + "-" + String.valueOf(incrementedstudentSerial);
		return code;
	}
	
	
	@Synchronized
	public String generateRandomPassword(int characterLength) {
		char[] buf = new char[characterLength];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = passwordChars.charAt(r.nextInt(passwordChars.length()));
		}
		return new String(buf);
	}

	@Synchronized
	public String generateOid() {
		Date today = new Date();
		String todayAsString = generalFormat.format(today);
		return todayAsString + "-" + getRandomWord();
	}

	@Synchronized
	public String generateId() {
		Date today = new Date();
		String todayAsString = generalFormat.format(today);
		return Constant.REQEUST_PREFIX_DRWS.concat(todayAsString + "-" + getRandomWord());
	}

	@Synchronized
	public String generateTraceId() {
		Date today = new Date();
		String todayAsString = traceDateFormat.format(today);
		return todayAsString + getTraceRandomWord();
	}

	@Synchronized
	public String generateFetchId() {
		Date today = new Date();
		String todayAsString = fetchIdFormat.format(today);
		return todayAsString + getTraceRandomWord();
	}

	@Synchronized
	private String getRandomWord() {
		char[] buf = new char[NUM_CHARS];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = chars.charAt(r.nextInt(chars.length()));
		}
		return new String(buf);
	}

	@Synchronized
	private String getTraceRandomWord() {
		char[] buf = new char[TRACE_NUM_CHARS];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = traceChars.charAt(r.nextInt(traceChars.length()));
		}
		return new String(buf);
	}

	public static synchronized String generateRandormNumber(int length) {
		char[] buf = new char[length];

		for (int i = 0; i < buf.length; i++) {

			buf[i] = otpChars.charAt(r.nextInt(otpChars.length()));

		}
		return new String(buf);
	}

	@Synchronized
	public String generateAdmissionId() {
		String admissionId = generateRandormNumber(8);
		return Constant.PREFIX_MRA_IMS + "-" + admissionId;
	}
	@Synchronized
	public String generateStudentPromotionId() {
		String admissionId = generateRandormNumber(8);
		return Constant.PREFIX_STUDENT_PROMOTION_ID + "-" + admissionId;
	}

	@Synchronized
	public String generateStudentId(String id) {
		return Constant.PREFIX_STUDENT_ID + "-" + id;
	}

	@Synchronized
	public String generateGuardianFatherId(String id) {
		return Constant.PREFIX_GUARDIAN_FATHER_ID + "-" + id;
	}

	@Synchronized
	public String generateGuardianMotherId(String id) {
		return Constant.PREFIX_GUARDIAN_MOTHER_ID + "-" + id;
	}

	@Synchronized
	public String generateFeesCollectionId() {
		String feesCollectionId = generateRandormNumber(8);
		return Constant.PREFIX_FESS_COLLECTION_ID + "-" + feesCollectionId;
	}

	@Synchronized
	public String generateTeacherId() {
		String teacherId = generateRandormNumber(8);
		return Constant.PREFIX_TEACHER_ID + "-" + teacherId;
	}
	

	@Synchronized
	public String generatePaymentId() {
		String paymentId = generateRandormNumber(8);
		return Constant.PREFIX_PAYMENT_ID + "-" + paymentId;
	}

	@Synchronized
	public String generateAssetIncomeId() {
		String assetIncomeId = generateRandormNumber(8);
		return Constant.PREFIX_ASSET_INCOME_ID + "-" + assetIncomeId;
	}
	
	@Synchronized
	public String generateKeyMappingCode() {
		String keyCodeRandom = generateRandormNumber(8);
		return Constant.PREFIX_FEE_MAPPING_KEY_ID + "-" + keyCodeRandom;
	}

	@Synchronized
	public String generateLoginId(String id) {
		return Constant.PREFIX_LOGIN_ID + "_" + id;
	}

	@Synchronized
	public String generateVoucherNo() {
		String voucherNo = generateRandormNumber(8);
		return Constant.PREFIX_VOUCHER_NO + "-" + voucherNo;
	}

	@Synchronized
	public String generatePassword() {
		char[] buf = new char[8];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = chars.charAt(r.nextInt(chars.length()));
		}
		return new String(buf);
	}
	
	@Synchronized
	public String generateIncomeCollectionId() {
		char[] buf = new char[8];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = chars.charAt(r.nextInt(chars.length()));
		}
		return new String(buf);
	}
	
	
	
	@Synchronized
	public String generateBankId() {
		String bankId = generateRandormNumber(8);
		return Constant.PREFIX_BANK_ID + "-" + bankId;
	}
	
	
	
	@Synchronized
	public String generateBankBranchId() {
		String bankBranchId = generateRandormNumber(8);
		return Constant.PREFIX_BANK_BRANCH_ID + "-" + bankBranchId;
	}
	
	@Synchronized
	public String generateEmployeeId() {
		String employeeId = generateRandormNumber(8);
		return Constant.PREFIX_EMPLOYEE_ID + "-" + employeeId;
	}

}
