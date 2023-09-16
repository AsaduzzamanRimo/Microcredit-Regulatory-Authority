package com.doer.mraims.core.util;

import com.google.gson.GsonBuilder;
import lombok.Synchronized;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Modifier;
import java.math.BigDecimal;


public final class Constant {
    public static String REQEUST_PREFIX_DOER = "DOER-";
    public static String REQEUST_PRODUCT_SHIPMENT = "SHIPMENT-";

    // //Liton
    // public static final String PDF_REPORT_PATH =  "/home/liton/User/Project/mra-ims/mra-ims-common-api/service/java/jasperreports/";

    // //Kamal Parvez
    public static final String PDF_REPORT_PATH = "/home/doer/DOER/mra-ims/mra-ims-common-api/service/java/jasperreports/";

    public static final String CLASS_PATH = "classpath:";
    public static final String JASPER_REPORT_PATH = "jasperreports/";
    public static final String METHOD_POST = "POST";
    public static final String REQUEST_VERSION__DEFAULT = "1.0";
    public static final int REQUEST_TIMEOUT_IN_SECONDS__INFINITY = -1;
    public static final int REQUEST_TIMEOUT_IN_SECONDS__30 = 30;
    public static final int REQUEST_RETRY_COUNT__ZERO = 0;

    public static final String REQEUST_PREFIX_DRWS = "MRA_IMS-";

    public static final String ACTIVE_STATUS = "A";
    public static final String PREFIX_MRA_IMS_ADMIN = "MRA-IMS-Admin";
    public static final String SOLVED = "SOLVED";
    public static final String ACTIVE = "Active";
    public static final String RUNNING = "Running";
    public static final String INACTIVE = "Inactive";
    public static final String STATUS_DUE = "Due";
    public static final String STATUS_PAID = "Paid";
    public static final String STATUS_PENDING = "Pending";
    public static final String STATUS_SELECTED = "Selected";
    public static final String STATUS_SUBMITTED = "Submitted";
    public static final String STATUS_APPROVED = "Approved";
    public static final String STATUS_PUBLISHED = "Published";
    public static final String STATUS_PARTIAL_PUBLISHED = "Partial Published";
    public static final String STATUS_PROMOTED = "Promoted";
    public static final String ADMISSION_FEE_GROUP_CODE = "101";

    public static final String PRESENT = "Present";
    public static final String ABSENT = "Absent";

    public static final String TUITION_FEE = "TUITION_FEE";

    public static final String CHARGE_APPLICATION = "50";
    public static final String REQUEST_RECEIVED = "RequestReceived";
    public static final String RESPONSE_SENT = "ResponseSent";
    public static final String MESSAGE_SENT = "Sent";
    public static final String TRANSACTION_TYPE_ATM = "ATM";
    public static final String MESSAGE_OUTPUT_SMS = "Sms";
    public static final String MESSAGE_OUTPUT_EMAIL = "Email";
    public static final String TRANSACTION_TYPE_POS = "POS";
    public static final String TRANSACTION_TYPE_FT = "Fund Transfer";
    public static final String TRANSACTION_TYPE_CC = "Clearing Cheque";
    public static final int MESSAGE_LENGTH = 160;
    public static final String TEMPLATE_IGNORE = "Ignore";
    public static final String SMS_FILTER_TYPE_BRANCH = "BRANCH";
    public static final String SMS_FILTER_TYPE_STAFF = "STAFF";
    public static final String STAFF_SECTOR_CODE = "1002";
    public static final String STAFF_BRANCH_CODE = "BD0014006";

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";
    public static final String INVALID_CREDENTIAL = "Invalid Credential";
    public static final String REQUEST_CLIENT = "abl";
    public static final boolean PREETY_JSON = true;

    public static final String MESSAGETYPE_DEBIT = "900";
    public static final String MESSAGETYPE_CREDIT = "910";

    public static final String AUTHENTICATE_CLIENT = "authenticate-client";
    public static final String AUTHENTICATE_APPLICATION = "authenticate-application";
    public static final String AUTHENTICATE_USER = "authenticate-user";
    public static final String VALIDATE_TOKEN = "validate-token";
    public static final String AUTHORIZE_RESOURCE = "validate-by-role";

    public static final String CLIENT = "abl";
    public static final String REQUEST_SOURCE__SWP = "swp";
    public static final String REQUEST_SOURCE_SERVICE__SWP = "swp";
    public static final String TRANSACTION_TYPE_FUND_TRANSFER = "Fund Transfer";
    public static final String TRANSACTION_TYPE_TELLER_TRANSACTION = "Teller Transaction";
    public static final String TRANSACTION_TYPE_ALERT = "Alert";

    public static final String CBS_CONNECTION_ERROR = "CBS Connection Error";

    public static final String STATUS_OK = "OK";
    public static final String STATUS_FAILED = "FAILED";
    public static final String DUPLICATE = "Duplicate";

    public static final String SCHEDULE_YML = "schedule.yml";
    public static final String STATUS_ACTIVE = "Active";
    public static final String STATUS_SUBMIT = "Submitted";
    public static final String STATUS_ON_SHIP = "On Shipped";
    public static final String STATUS_APPROVE = "Approved";
    public static final String STATUS_REJECT = "Rejected";
    public static final String STATUS_CANCEL = "Cancelled";
    public static final String PRIORITY_REGULAR = "Regular";
    public static final String PRIORITY_URGENT = "Urgent";
    public static final String STATUS_SAVE_AS_DRAFT = "Draft";
    public static final String DRAFT = "Draft";
    public static final String STATUS_SAVE_AS_PUBLISHED = "Published";
    public static final String PREFIX_MRA_IMS = "MRA-IMS";
    public static final String PREFIX_SAMITY_ID = "SMT-";
    public static final String PREFIX_BRANCH_ID = "B-";
    public static final String PREFIX_COM_BRANCH_ID = "CBR-1";



    public static final String PREFIX_STUDENT_ID = "S";
    public static final String PREFIX_TEACHER_ID = "T";
    public static final String PREFIX_PAYMENT_ID = "P";
    public static final String PREFIX_GUARDIAN_FATHER_ID = "SGF";
    public static final String PREFIX_GUARDIAN_MOTHER_ID = "SGM";
    public static final String PREFIX_FESS_COLLECTION_ID = "FC";
    public static final String PREFIX_FEE_MAPPING_KEY_ID = "KY";
    public static final String PREFIX_ASSET_INCOME_ID = "AST-I-";
    public static final String PREFIX_STUDENT_PROMOTION_ID = "STDP";
    public static final String PREFIX_BANK_ID = "B";
    public static final String PREFIX_BANK_BRANCH_ID = "BB";
    public static final String PREFIX_EMPLOYEE_ID = "Employee-";
    public static final String PREFIX_VOUCHER_NO = "V";

    public static final String PREFIX_LOGIN_ID = "user";

    public static final String SMS_SERVICE_TYPE_SMS = "SMS";
    public static final String SMS_SERVICE_TYPE_GROUP_SMS = "Group SMS";
    public static final String SMS_SERVICE_TYPE_EMAIL = "Email";
    public static final String SMS_SERVICE_TYPE_GROUP_EMAIL = "Group Email";

    public static final String ACCOUNT_PAYABLE = "AccountPayable";
    public static final String ACCOUNT_RECEIVABLE = "AccountReceivable";
    public static final String ACCOUNT_PAYMENT = "VendorCredit";
    public static final String ACCOUNT_RECEIVED = "CreditNote";
    public static final String SALARY_PAYABLE = "SalaryPayable";
    public static final String ACADEMIC_FEE = "AcademicFee";
    public static final String ACADEMIC_FINE = "AcademicFine";

    public static final String SCHEDULE_TYPE_SMS = "SMS";
    public static final String SCHEDULE_TYPE_EMAIL = "Email";

    public static final String SUCCESS = "OK";
    public static final String FAILED = "Failed";
    public static final String SUCCESS_RESPONSE_CODE = "200";
    public static final String USER_ID_NOT_FOUND_RESPONSE_CODE = "204";
    public static final String DB_FAILED_RESPONSE_CODE = "501";
    public static final int DB_FAILED_RESPONSE_CODE_INT = 501;
    public static final String DUPLICATE_RESPONSE_CODE = "Duplicate";
    public static final String DUPLICATE_LOGIN_ID_RESPONSE_CODE = "Duplicate.Login.Id";
    public static final String DUPLICATE_EIIN_NUMBER_RESPONSE_CODE = "Duplicate.Eiin.Number";
    public static final String SYSTEM = "System";
    public static final String DUPLICATE_GROUP_CODE_RESPONSE_CODE = "Duplicate";

    public static final String BANGLA = "bn";
    public static final String ENGLISH = "en";

    // admission
    public static final String APPROVED = "Approved";
    public static final String OPENED = "Opened";
    public static final String CLOSED = "Closed";
    public static final String DEFAULT_PASSWORD = "123456";
    public static final String ROLE_TEACHER = "SCHOOL.ERP.TEACHER";
    public static final String ROLE_STUDENT = "SCHOOL.ERP.STUDENT";
    public static final String ROLE_GUARDIAN = "SCHOOL.ERP.GUARDIAN";
    public static final String ROLE_SCHOOL_ADMIN = "SCHOOL.ERP.SCHOOL.ADMIN";

    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // New Properties for otp and security
    public static final String OTP_SUBMITTED = "Submitted";
    public static final String OTP_SENT = "OtpSent";
    public static final String OTP_VERIFIED = "OtpVerified";
    public static final String OTP_EXPIRED = "OtpExpired";
    public static final String OTP_CANCELLED = "OtpCancelled";

    public static final String ALL = "All";
    public static final String YES = "Yes";
    public static final String NO = "No";

    public static final String FATHER = "father";
    public static final String MOTHER = "mother";
    public static final String BOTH = "both";
    public static final String LOCAL_GUARDIAN = "local-guardian";

    // SMS Properties
    public static final String SEND_SMS_BEARER_TOKEN = "85eecc93-9a55-4141-8a99-6279fe5faf2a";   //AGRANI BANK MASKING
    //	public static final String SEND_SMS_BEARER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiJzZXJwIiwic2NoZW1hIjoic2VycCIsImlhdCI6MTY2NTU2NzA0MywiZXhwIjoxNjk3MTAzMDQzfQ.ugr0_WIEyld_858tsT4kBoX3flXRZUTzP-DyflDE2Ks"; // DOER
    // SCHOOL
    // MASKING
    public static final String SEND_SMS_REQUEST_TYPE = "messenger/message/v1/send-sms";

    public static final String SEND_SMS_LANGUAGE_BANGLA = "bn";
    public static final String SEND_SMS_LANGUAGE_ENGLISH = "en";
    public static final String SEND_MESSAGE_TYPE = "Notice";
    public static final String SEND_SMS_SERVICE_TYPE_COLD = "cold";
    public static final String SEND_SMS_SERVICE_TYPE_HOT = "hot";
    public static final String SEND_SMS_DOER_MRA_IMS_MASKING = "MRA-IMS";
    public static final String SEND_SMS_REQUEST_CLIENT = "abl";
    public static final String SEND_SMS_REQUEST_SOURCE = "curl";

    public static final String SEND_SMS_REQUEST_SOURCE_SERVICE = "terminal";
    public static final String SEND_EMAIL_REQUEST_SOURCE_SERVICE = "send-email";

    public static final String SEND_SMS_TRANSACTION_TYPE = "MRA-IMS";
    public static final String SEND_SMS_REQUEST_VERSION = "1.0";
    public static final int SEND_SMS_REQUEST_TIME_IN_SECONDS = 160;
    public static final int SEND_SMS_REQUEST_RETRY_COUNT = 160;

    public static final String APP_SETTINGS_SMS = "sms";
    public static final String APP_SETTINGS_EMAIL = "email";

    public static final String REQEUST_PREFIX_MRAIMS = "MRA-IMS-";
    public static final String CUSTOMER_ID_PREFIX_HOOTHUT = "MRA-IMS-CUS";
    public static final String UNIT_PROMOTER_ID_PREFIX_HOOTHUT = "MRA-IMS-UP";
    public static final String REGISTRATION_ID_PREFIX_HOOTHUT = "MRA-IMS-REG";
    public static final String QUOTE_REQUEST_ID_PREFIX_HOOTHUT = "MRA-IMS-QR";
    public static final String QUOTE_ID_PREFIX_HOOTHUT = "MRA-IMS-Q";

    public static final String ROLE_ID_HOOTHUT_REGISTERED_USER = "MRA-IMS.REGISTERED.USER";
    public static final String ROLE_ID_HOOTHUT_CUSTOMER = "MRA-IMS.CUSTOMER";
    public static final String ROLE_ID_HOOTHUT_UNIT_PROMOTER = "MRA-IMS.UNIT.PROMOTER";

    public static final String ROLE_TYPE_UNIT_PROMOTER = "Unit Promoter";
    public static final String CUSTOMER = "Customer";

    public static final String NO_DATA_FOUND = "No Data Found";

    // NOTIFICATION CONF PROPERTIES AND VALUE
    public static final String EMAIL = "delivery@mx2.doer.com.bd";
    public static final String EMAIL_PASSWORD = "Doe@FiT2019";
    public static final String EMAIL_HOST = "mx2.doer.com.bd";
    public static final String EMAIL_PORT = "587";
    public static final String TLS_ENABLE_STATUS = "true";
    public static final String AUTH = "true";
//	public static final String EMAIL = "help.desk@doer.com.bd";
//	public static final String EMAILPASSWORD = "asdf024";
//	public static final String HOST = "smtp.gmail.com";
//	public static final String PORT = "465";
//	public static final String SSLENABLE = "true";
//	public static final String AUTH = "true";

    public static final String REQUEST_SERVICE_SOURCE = "DOER-ERP-Portal";

    // Email credential

    public static final String SEND_EMAIL_REQUEST_SOURCE = "doer-schoolerp-system";

    public static final String OTP_VERIFICATION = "OTP_VERIFICATION";
    public static final String RESET_PASSWORD = "RESET_PASSWORD";
    public static final String APPLICANT_ADMISSION = "Admission";
    public static final String STUDENT_ADMISSION_APPROVED = "STUDENT_ADMISSION_APPROVED";
    public static final String SCHEDULED_MESSAGE = "SCHEDULED_MESSAGE";

    // Mail Subject
    public static final String OTP_VERIFICATION_MAIL_SUBJECT = "Test Mail For OTP verification";
    public static final String RESET_PASSWORD_MAIL_SUBJECT = "Test Mail For Reset Password";
    public static final String STUDENT_SELECTED_FOR_ADMISSION_MAIL_SUBJECT = "Test Mail For Student Selected for Admission";
    public static final String STUDENT_ADMISSION_APPROVED_MAIL_SUBJECT = "Test Mail For Student's Admission Approved";

    // Once, Daily, Weekly, Monthly, Yearly

    public static final String ONCE = "Once";
    public static final String DAILY = "Daily";
    public static final String WEEKLY = "Weekly";
    public static final String MONTHLY = "Monthly";
    public static final String YEARLY = "Yearly";

    public static final String ON = "On";
    public static final String OFF = "Off";

    public static final String SMS_LANGUAGE_BANGLA = "Bangla";
    public static final String SMS_LANGUAGE_ENGLISH = "English";

    public static final String SMS_TEMPLATE_NAME_ADMISSION = "Admission";
    public static final String SMS_TEMPLATE_NAME_ADMISSION_SELECTION = "Admission_Selection";
    public static final String SMS_TEMPLATE_NAME_ADMISSION_APPROVE = "Admission_Approve";
    public static final String SMS_TEMPLATE_NAME_STUDENT_CREDENTIAL = "Student_Credential";
    public static final String SMS_TEMPLATE_NAME_GUARDIAN_CREDENTIAL = "Guardian_Credential";
    public static final String SMS_TEMPLATE_NAME_TEACHER_CREDENTIAL = "Teacher_Credential";
    public static final String SMS_TEMPLATE_NAME_STUDENT_ABSENT = "Student_Absent";
    public static final String SMS_TEMPLATE_NAME_STUDENT_PRESENT = "Student_Present";
    public static final String SMS_TEMPLATE_NAME_EXAM_PUBLISH = "Exam_Publish";
    public static final String SMS_TEMPLATE_NAME_EXAM_RESULT_PUBLISH = "Exam_Result_Publish";

    public static final String SMS_REFFERENCE_SOURCE_TYPE_ADMISSION = "Admission";
    public static final String SMS_REFFERENCE_SOURCE_TYPE_TEACHER = "Teacher";
    public static final String SMS_REFFERENCE_SOURCE_TYPE_GUARDIAN = "Guardian";
    public static final String SMS_REFFERENCE_SOURCE_TYPE_CONTACT = "Contact";
    public static final String SMS_STATUS_SENT = "SENT";
    public static final String SMS_STATUS_FAILED = "FAILED";

    public static final String STUDENT_FEE_VOUCHER = "StudentFeeVoucher";

    // IMPORTANT WEBSITE URLS
    public static final String DOER_OFFICIAL_URL = "http://www.doer.com.bd/";
    public static final String SCHOOL_ERP_OFFICIAL_URL = "https://test-schoolerp.celloscope.net/";
    public static final String DOER_FACEBOOK_URL = "https://www.facebook.com/DOER.BD";
    public static final String DOER_YOUTUBE_URL = "https://www.youtube.com/channel/UCg1DylF5Z-q34Y611ZT5iQA";
    public static final String DOER_LINKED_IN_URL = "https://bd.linkedin.com/company/doer/";
    public static final String DOER_TWITTER_URL = "#";

    // IMPORTANT LOGO URLS
    public static final String DOER_SERVICE_LOGO = "http://www.doer.com.bd/img/dlogo.png";
    public static final String SCHOOL_ERP_LOGO = "http://www.doer.com.bd/img/dlogo.png";
    public static final String FACEBOOK_LOGO = "https://www.seekpng.com/png/detail/4-42719_high-quality-facebook-logo-facebook-icon-png-blue.png";
    public static final String YOUTUBE_LOGO = "https://www.seekpng.com/png/detail/2-27587_youtube-play1600-icons-youtube.png";
    public static final String LINKED_IN_LOGO = "https://www.seekpng.com/png/detail/374-3745342_linkedin-how-to-add-third-degree-connections-to.png";
    public static final String TWITTER_LOGO = "https://www.seekpng.com/png/detail/119-1191363_share-button-how-to-twitter-symbol-in-circle.png";

    // IMPORTAN ICON URL
    public static final String LOCATION_ICON = "https://img.icons8.com/ios-filled/512/order-delivered.png";
    public static final String PHONE_ICON = "https://img.icons8.com/ios-filled/512/ringer-volume.png";
    public static final String EMAIL_ICON = "https://img.icons8.com/ios-filled/512/circled-envelope.png";

    @Synchronized
    public static ImmutablePair<String, String> getDateTime(DateTime now) {
        if (now == null)
            now = new DateTime();
        String time = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS").print(now);
        return new ImmutablePair<String, String>("to_timestamp(?, 'YYYY-MM-DD HH24:MI:SS.MS')::timestamp", time);
    }

    public static String print(Object object) {
        // GsonBuilder builder = new GsonBuilder().registerTypeAdapter(BigDecimal.class,
        // new GsonBigDecimalUtil()).registerTypeAdapter(DateTime.class, new
        // GsonDateTimeUtil());
        GsonBuilder builder = new GsonBuilder().registerTypeAdapter(BigDecimal.class, new GsonBigDecimalUtil())
                .registerTypeAdapter(DateTime.class, new GsonDateTimeUtil());
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE, Modifier.FINAL);
        // builder.serializeNulls();
        if (Constant.PREETY_JSON) {
            builder.setPrettyPrinting();
        }
        return builder.create().toJson(object);
    }

}
