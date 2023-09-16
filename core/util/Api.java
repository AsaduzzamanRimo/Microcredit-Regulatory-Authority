package com.doer.mraims.core.util;

public abstract class Api {
	public static final String IMS_CMN_SERVICE_SERVER_PATH = "http://localhost:8080/";
	public static final String IMS_MFI_SERVICE_SERVER_PATH = "http://localhost:8081/";

	//	public static final String SCHOOL_ERP_SERVICE_SERVER_PATH = "http://192.168.0.126:9090/";

	public static final String SERVER_BASE = "*";
	public static final String API_BASE = "/mra-ims/common/api";
	public static final String BRANCH_BASE_PATH = "/v1/branch";
	public static final String USER_BASE_PATH = "/v1/user";
	public static final String UNAUTH_USER_BASE_PATH = "/v1/user/unauth";
	public static final String LOGIN_BASE_PATH = "/v1/login";
	public static final String ROLE_BASE_PATH = "/v1/role";



	//	public static final String SERVER_BASE = "http://localhost:4200";
	//	public static final String SERVER_BASE = "http://172.16.5.203:4200";
	//	public static final String SERVER_BASE = "https://schoolerp.celloscope.net";

	// For Local Server Sent SMS API Url by celloscope
	public static final String SEND_SMS_SERVER_PATH = "https://sms.celloscope.net/app/drws/messenger/message/v1/send-sms";
	//	public static final String SEND_SMS_SERVER_PATH = "https://drws.celloscope.net/sms/v1/send-sms";

	// For Live Server Sent SMS API Url
	// public static final String SEND_SMS_SERVER_PATH
	// ="http://172.16.6.13:80/app/drws/messenger/message/v1/send-sms";

	// Uploaded File in Local Server
	public static final String originalFile = "/home/ishtiak/Office/SCHOOL_ERP/school-management/school-erp/service/java/school/school-erp/school-erp-app/uploads/";

	// Invalid Uploaded File in Local Server
	public static final String invalidFile = "/home/ishtiak/Office/SCHOOL_ERP/school-management/school-erp/service/java/school/school-erp/school-erp-app/invaliduploads/";

	// Uploaded File in Live Server
	//	public static final String originalFile = "/home/ubuntu/serverside/uploads/";

	// Invalid Uploaded File in Live Server
	//	public static final String invalidFile = "/home/ubuntu/serverside/invaliduploads/";

	// In Live Server
	//	public static final String UPLOADS = "../uploads";

	// In Local Server
	public static final String UPLOADS = "uploads";

	public static final String CLASS_TEST_LIST = "/v1/class/test/list";

	public static final String LOAN_EMI_CALCULATE = "/v1/loan-emi-calculate";

	// class routine

	// end

	public static final String SUBJECT_BY_SECTION_OID = "/v1/subject/section/oid";
	public static final String SUBJECT_BY_OID = "/v1/subject/oid";

	public static final String CLASS_TEST_BY_SCST_OID = "/v1/class/test/scst/oid";

	// Update student API service and components
	public static final String CREATE_SUBJECT = "/v1/create/subject";

	public static final String ADD_CLASS_TEST = "/v1/add/class/test";

	public static final String ADD_CLASS_TEST_MARKS = "/v1/add/class/test/marks";

	public static final String CREATE_ATTENDANCE = "/v1/create/attendance";

	public static final String SAVE_EXAM_ROUTINE = "/v1/save-exam-routine";

	public static final String UPDATE_EXAM_ROUTINE = "/v1/update-exam-routine";

	public static final String GET_EXAM_ROUTINE_BY_OID = "/v1/get-exam-routine-by-oid";

	public static final String CREATE_TEACHER_PROFILE = "/v1/create/teacher";

	public static final String SAVE_TEACHER_ATTENDANCE = "/v1/save-teacher-attendance";

	public static final String SAVE_CONTACT_GROUP = "/v1/save-contact-group";

	public static final String UPDATE_CONTACT_GROUP = "/v1/update-contact-group";

	public static final String SAVE_GUARDIAN = "/v1/create/guardian";

	public static final String EDIT_TEACHER_PROFILE = "/v1/edit/teacher";

	public static final String UPDATE_TEACHER_PROFILE = "/v1/update-teacher";

	public static final String EDIT_EXAM = "/v1/edit-exam";

	public static final String SUBMIT_EXAM = "/v1/submit-exam";

	public static final String REJECT_EXAM = "/v1/reject-exam";

	public static final String APPROVE_EXAM = "/v1/approve-exam";

	public static final String PUBLISH_EXAM = "/v1/publish-exam";

	public static final String UPDATE_EXAM_RESULT = "/v1/update-exam-result";

	public static final String EDIT_TEACHER_PROFILE_BY_USERNAME = "/v1/update/teacher/profile";

	public static final String GET_TEACHER_LIST = "/v1/get-teacher-list";

	public static final String GRADING_SYSTEM_LIST = "/v1/grading/system/list";

	public static final String APPROVE_EXAM_RESULT = "/v1/approve-exam-result";

	public static final String PUBLISH_EXAM_RESULT = "/v1/publish-exam-result";

	public static final String GET_EXAM_RESULT_LIST = "/v1/get-exam-result-list";

	public static final String GET_EXAM_RESULT_LIST_BY_STUDENT = "/v1/get-exam-result-list-by-student";

	public static final String GET_EXAM_RESULT_DETAIL_LIST = "/v1/get-exam-result-detail-list";

	public static final String EDU_GRADING_SYSTEM_DETAIL_LIST = "/v1/edu/grading/system/detail/list";

	public static final String GET_EDUCATION_PROGRAM_LIST = "/v1/education/program/list";

	public static final String SECTION_LIST = "/v1/section/list";

	public static final String EDUCATION_MEDIUM_LIST = "/v1/education/medium/list";

	public static final String EDUCATION_SHIFT_LIST = "/v1/education/shift/list";

	public static final String EDUCATION_SHIFT_BY_OID = "/v1/education/shift/by/oid";

	public static final String EDUCATION_TEXTBOOK_LIST = "/v1/education/textbook/list";

	public static final String GET_EDUCATION_TEXTBOOK_LIST = "/v1/get-education-textbook-list";

	public static final String EDUCATION_TEXTBOOK_BY_OID = "/v1/education-textbook-by-oid";

	public static final String SAVE_EDUCATION_TEXTBOOK = "/v1/save-education-textbook";

	public static final String UPDATE_EDUCATION_TEXTBOOK = "/v1/update-education-textbook";

	public static final String CHECK_EXISTING_EDUCATION_TEXTBOOK = "/v1/check/existing/education/textbook";

	public static final String EDUCATION_GROUP_LIST = "/v1/education/group/list";

	public static final String EDUCATION_GROUP_LIST_BY_SESSION = "/v1/get-education-group-list-by-session";

	public static final String EDUCATION_CURRICULUM_LIST = "/v1/education/curriculum/list";
	public static final String EDUCATION_VERSION_LIST = "/v1/education/version/list";

	public static final String EDUCATION_SESSION_LIST = "/v1/education/session/list";
	public static final String EDUCATION_SESSION_BY_OID = "/v1/education-session-by-oid";
	public static final String SAVE_EDUCATION_SESSION = "/v1/save-education-session";
	public static final String CONFIGURE_EDUCATION_SESSION = "/v1/configure-education-session";
	public static final String EDIT_EDUCATION_SESSION = "/v1/edit-education-session";
	public static final String EDUCATION_SESSION_INSTITUTE_LIST = "/v1/education-session-institute-list";
	public static final String ALL_EDUCATION_SESSION_LIST = "/v1/all/education/session/list";

	public static final String EDUCATION_GRADING_SYSTEM_LIST = "/v1/education-grading-system-list";

	public static final String GRADING_SYSTEM = "/v1/grading-system";

	public static final String COUNTRY_LIST = "/v1/country-list";

	public static final String GET_DIVISION_LIST = "/v1/get-division-list";

	public static final String ATTENDANCE_LIST_BY_MONTH = "/v1/attendance/list/by/month";

	public static final String PARTICULAR_SECTION_NO = "/v1/particular/section";

	public static final String GROUP_LIST = "/v1/group/list";

	public static final String GET_THANA_LIST = "/v1/get-thana-list";

	public static final String EXAM_BY_OID = "/v1/exam/by/oid";

	public static final String EXAM_TEXT_BOOK_BY_OID = "/v1/get-exam-textbook-by-oid";

	public static final String EXAM_SUBJECT_BY_OID = "/v1/get-exam-subject-by-oid";

	public static final String EXAM_RESULT_BY_OID = "/v1/exam-result-by-oid";

	public static final String EXAM_RESULT_BY_STUDENT_ID = "/v1/exam-result-by-student-id";

	public static final String GET_EXAM_RESULT_BY_SECTION_OID = "/v1/get-exam-result-by-section-oid";

	public static final String EXAM_LIST = "/v1/exam/list";

	public static final String EXAM_ROUTINE_LIST = "/v1/exam-routine-list";

	public static final String WEEK_DAY_NAME_LIST = "/v1/week/day/name/list";

	public static final String INSTITUTE_VERSION_LIST = "/v1/institute-version-list";

	public static final String INSTITUTE_CLASS_SECTION_LIST = "/v1/institute-class-section-list";

	public static final String INSTITUTE_CLASS_LEVEL_LIST = "/v1/institute/class/level/list";

	public static final String INSTITUTE_CLASS_TEXTBOOK_LIST = "/v1/institute/class/textbook/list";

	public static final String INSTITUTE_SHIFT_LIST = "/v1/institute-shift-list";
	public static final String GET_INSTITUTE_SHIFT_LIST = "/v1/get-institute-shift-list";

	public static final String CREATE_INSTITUTE_SHIFT = "/v1/create-institute-shift";
	public static final String UPDATE_INSTITUTE_SHIFT = "/v1/update-institute-shift";
	public static final String GET_INSTITUTE_SHIFT_BY_OID = "/v1/get-institute-shift-by-oid";

	public static final String INSTITUTE_TYPE_LIST = "/v1/institute-type-list";

	// Text Book
	public static final String GET_CLASS_TEXT_BOOK_LIST_BY_EXAM_OID = "/v1/get-class-textbook-list-by-exam-oid";

	public static final String GET_CLASS_TEXT_BOOK_LIST_BY_SESSION = "/v1/get-class-textbook-list-by-session";

	// guardian
	public static final String GET_GUARDIAN_LIST = "/v1/get-guardian-list";

	public static final String GET_INSTITUTE_GUARDIAN_LIST = "/v1/get-institute-guardian-list";

	public static final String GUARDIAN_STUDENT_LIST = "/v1/guardian/student/list";

	public static final String GET_STUDENT_LIST_BY_EXAMTEXTBOOK = "/v1/get-student-list-by-examtextbook";

	public static final String GET_STUDENT_LIST_BY_EXAMSUBJECT = "/v1/get-student-list-by-examsubject";

	public static final String CURRICULUM_LIST = "/v1/curriculum/list";

	public static final String SUBJECT_LIST = "/v1/subject/list";

	public static final String PARTICULAR_TEACHER_LIST = "/v1/particular/teacher/list";

	public static final String VIEW_TEACHER_PROFILE = "/v1/view/teacher/by/oid";

	public static final String GET_TEACHER_BY_GUARDIAN = "/v1/get-teacher-by-guardian-oid";

	public static final String GET_TEACHER_BY_OID = "/v1/teacher/by/oid";

	public static final String GET_TEACHER_ATTENDANCE = "/v1/get-teacher-attendance";

	public static final String GET_TEACHER_ATTENDANCE_LIST_BY_OID = "/v1/get-teacher-attendance-list-by-oid";

	public static final String GET_CONTACT_GROUP_LIST = "/v1/get-contact-group-list";

	public static final String GET_TEACHER_ATTENDANCE_DETAILS_BY_OID = "/v1/get-teacher-attendance-details-by-oid";

	public static final String GET_CONTACT_GROUP_DETAILS_BY_OID = "/v1/get-contact-group-details-by-oid";

	public static final String GET_GUARDIAN_BY_OID = "/v1/guardian/by/oid";

	public static final String DASHBOARD = "/v1/dashboard/info";

	public static final String DASHBOARD_BDEX = "/v1/dashboard/info/bdex";

	public static final String DASHBOARD_AGENT = "/v1/dashboard/info/agent";

	public static final String KEYCLOAK_USER_INFO = "/v1/keycloak/user/info";

	public static final String USER_LOGIN = "/v1/user/login";

	public static final String CHANGE_USER_PROFILE = "/v1/user/change-user-profile";

	public static final String CHANGE_USER_PASSWORD = "/v1/user/change-password";

	public static final String CHANGE_USER_PASSWORD_BY_OTP = "/v1/user/change-password-by-otp";

	public static final String CREATE_USER_ACCOOUNT = "/v1/user/create-user-account";

	public static final String USER_ROLE_LIST = "/v1/user/role/list";

	public static final String CREATE_CLASS = "/v1/create-class";

	public static final String CLASS_LIST = "/v1/class-list";

	public static final String GET_CLASS_BY_OID = "/v1/get-class-by-oid";

	public static final String ALL_CLASS_LIST = "/v1/all-class-list-by-status";

	public static final String CREATE_SECTION = "/v1/create-section";

	public static final String CREATE_SCHOOL_CLASS = "/v1/user/create/schoolclass";

	public static final String CLASS_ROOM = "/v1/add/class/room";

	public static final String EDIT_CLASS_ROOM = "/v1/update/class/room";

	public static final String ADMIN_LOGIN = "/v1/admin/login";

	public static final String BRANCH_REPORT = "/v1/branch/list";

	public static final String CREATE_PRODUCT = "/v1/create/product";

	public static final String PRODUCT_LIST = "/v1/product/list";

	// Admission

	public static final String ADMISSION_APPLICATION_BY_OID = "/v1/admission-application-by-oid";
	public static final String CREATE_ADMISSION_APPROVAL = "/v1/admission-approval";
	public static final String ADMISSION_SELECTION = "/v1/admission-selection";
	public static final String ADMISSION_LIST = "/v1/admission-list";
	public static final String SAVE_ADMISSION_APPLICATION = "/v1/save-admission-application";
	public static final String UPDATE_ADMISSION_APPLICATION = "/v1/update-admission-application";

	public static final String CREATE_APPLICANT_PROFILE = "/v1/create/applicant";

	// Institute New API end-point
	public static final String GET_INSTITUTE_DASHBOARD_INFO = "/v1/get-institute-dashboard-info";
	public static final String GET_STUDENT_DASHBOARD_INFO = "/v1/get-student-dashboard-info";
	public static final String GET_GUARDIAN_DASHBOARD_INFO = "/v1/get-guardian-dashboard-info";
	public static final String GET_INSTITUTION_LIST = "/v1/get-institute-list";
	public static final String GET_STAFF_LIST = "/v1/get-staff-list";

	// Routine New API End Point

	public static final String FILE_UPLOAD = "/v1/file/image/upload";

	public static final String MOVE_UPLOADED_FILE = "/v1/uploaded/file/move";

	public static final String FILE_LIST = "/v1/file/receipt/getlist";

	public static final String FILE_DOWNLOAD = "/v1/file/receipt/download/";

	public static final String CLASS_ROOM_LIST = "/v1/class/room/list";

	public static final String PARTICULAR_CLASS_ROOM_LIST = "/v1/particular/class/room";

	public static final String CLASS_LIST_TEACHER_BY_TEACHER_USERNAME = "/v1/particular/class/byteacher/username";

	public static final String CREATE_EXAM = "/v1/create/exam";

	public static final String SAVE_EXAM_RESULT = "/v1/save-exam-result";

	public static final String ALL_EXAM_LIST = "/v1/all/exam/list";

	public static final String GET_EXAM_LIST = "/v1/get-exam-list";

	public static final String GET_GUARDIAN_EXAM_LIST = "/v1/get-guardian-exam-list";

	public static final String EDUCATION_TYPE_LIST = "/v1/education-type-list";

	public static final String ALL_INSTITUTION_LIST = "/v1/institution/list";

	public static final String INSTITUTION_LIST = "/v1/get-institution-list";

	public static final String GET_INSTITUTE_INFO = "/v1/get-institute-info";

	public static final String GET_EDUCATION_INFO = "/v1/get-education-info";

	public static final String INSTITUTE_BY_OID = "/v1/get-institute-by-oid";

	public static final String GET_INSTITUTE_SECTION_BY_OID = "/v1/get-institute-section-by-oid";

	public static final String ALL_SESSION_LIST = "/v1/session/list";

	public static final String CREATE_INSTITUTE = "/v1/create-institute";

	public static final String EDIT_INSTITUTE = "/v1/edit/institute";

	public static final String CONFIGURE_MESSAGE_SCHEDULE_BY_INSTITUTE_OID = "/v1/configure-message-schedule-by-institute-oid";

	public static final String UPDATE_INSTITUTE_CLASS_SECTION = "/v1/update-institute-class-section";

	public static final String UPDATE_CLASS = "/v1/update-class";

	public static final String EDUCATION_BOARD_LIST = "/v1/education-board-list";

	public static final String EDUCATION_SYSTEM_LIST = "/v1/education/system/list";

	public static final String INSTITUTE_SESSION_LIST = "/v1/institute-session-list";

	public static final String INSTITUTE_CLASS_LIST = "/v1/institute-class-list";
	public static final String INSTITUTE_CLASS_LIST_BY_SESSION = "/v1/institute-class-list-by-session";

	public static final String CHILD_LIST = "/v1/child-list";

	public static final String INSTITUTE_CLASS_GROUP_LIST = "/v1/institute/class/group/list";

	public static final String INSTITUTE_CLASS_GROUP_LIST_BY_CLASS_OID = "/v1/institute-class-group-list-byclassoid";

	// attendance
	public static final String STUDENT_ATTENDANCE_LIST = "/v1/student/attendance/list";
	public static final String GET_STUDENT_ATTENDANCE_BY_OID = "/v1/get-student-attendance-by-oid";
	public static final String SAVE_STUDENT_ATTENDANCE = "/v1/save/student/attendance";
	public static final String UPDATE_STUDENT_ATTENDANCE = "/v1/update-student-attendance";
	public static final String CHECK_STUDENT_ATTENDANCE = "/v1/check-student-attendance";
	public static final String GET_ATTENDANCE_BY_STUDENT_OID = "/v1/get-attendance-by-student-oid";
	public static final String UPDATE_ATTENDANCE_DETAILS = "/v1/update/attendance/details";

	// Institute Subject

	public static final String SAVE_INSTITUTE_SUBJECT = "/v1/save-institute-subject";
	public static final String UPDATE_INSTITUTE_SUBJECT = "/v1/update-institute-subject";
	public static final String GET_INSTITUTE_SUBJECT_LIST = "/v1/get-institute-subject-list";
	public static final String GET_INSTITUTE_SUBJECT_BY_OID = "/v1/get-institute-subject-by-oid";

	// Asset
	public static final String GET_ASSET_LIST = "/v1/get-asset-list";
	public static final String GET_ASSET_BY_OID = "/v1/get-asset-by-oid";
	public static final String SAVE_ASSET = "/v1/save-asset";
	public static final String UPDATE_ASSET = "/v1/update-asset";

	// expense
	public static final String SAVE_EXPENSE = "/v1/save-expense";
	public static final String UPDATE_EXPENSE = "/v1/update-expense";
	public static final String GET_EXPENSE = "/v1/get-expense";
	public static final String GET_EXPENSE_LIST = "/v1/get-expense-list";

	// People
	public static final String GET_PEOPLE_LIST = "/v1/get-people-list";
	public static final String GET_PEOPLE_BY_OID = "/v1/get-people-by-oid";
	public static final String SAVE_PEOPLE = "/v1/save-people";
	public static final String UPDATE_PEOPLE = "/v1/update-people";

	//	Ledger
	public static final String GET_LEDGER_BY_OID = "/v1/get-ledger-by-oid";
	public static final String GET_LEDGER_LIST = "/v1/get-ledger-list";
	public static final String SAVE_LEDGER = "/v1/save-ledger";
	public static final String UPDATE_LEDGER = "/v1/update-ledger";
	public static final String GET_LEDGER_COMBO_LIST = "/v1/get-ledger-combo-list";

	// Ledger Setting
	public static final String GET_LEDGER_SETTING_BY_OID = "/v1/get-ledger-setting-by-oid";
	public static final String GET_LEDGER_SETTING_LIST = "/v1/get-ledger-setting-list";
	public static final String UPDATE_LEDGER_SETTING = "/v1/update-ledger-setting";

	//	Financial Period
	public static final String GET_FINANCIAL_PERIOD_BY_OID = "/v1/get-financial-period-by-oid";
	public static final String GET_FINANCIAL_PERIOD_LIST = "/v1/get-financial-period-list";
	public static final String SAVE_FINANCIAL_PERIOD = "/v1/save-financial-period";
	public static final String UPDATE_FINANCIAL_PERIOD = "/v1/update-financial-period";
	public static final String CLOSE_FINANCIAL_PERIOD_BY_OID = "/v1/close-financial-period-by-oid";

	// ledger group
	public static final String GET_LEDGER_GROUP_BY_OID = "/v1/get-ledger-group-by-oid";
	public static final String GET_LEDGER_GROUP_LIST = "/v1/get-ledger-group-list";
	public static final String SAVE_LEDGER_GROUP = "/v1/save-ledger-group";
	public static final String UPDATE_LEDGER_GROUP = "/v1/update-ledger-group";

	// ledger sub group
	public static final String GET_LEDGER_SUB_GROUP_LIST = "/v1/get-ledger-sub-group-list";
	public static final String GET_LEDGER_SUB_GROUP_BY_OID = "/v1/get-ledger-sub-group-by-oid";
	public static final String SAVE_LEDGER_SUB_GROUP = "/v1/save-ledger-sub-group";
	public static final String UPDATE_LEDGER_SUB_GROUP = "/v1/update-ledger-sub-group";

	// Accounting
	public static final String GET_ACCOUNTING_INFO = "/v1/get-accounting-info";
	public static final String GET_SUB_LEDGER_LIST = "/v1/get-sub-ledger-list";
	public static final String GET_SUB_LEDGER_BY_OID = "/v1/get-sub-ledger-by-oid";
	public static final String GET_SUB_LEDGER_COMBO_LIST = "/v1/get-sub-ledger-combo-list";

	// cashbook
	public static final String GET_CASH_BOOK_BY_OID = "/v1/get-cash-book-by-oid";
	public static final String GET_CASH_BOOK_LIST = "/v1/get-cash-book-list";
	public static final String SAVE_CASH_TRANSACTION = "/v1/save-cash-transaction";

	// Notice
	public static final String SAVE_NOTICE = "/v1/save-notice";
	public static final String UPDATE_NOTICE = "/v1/update-notice";
	public static final String PUBLISH_NOTICE = "/v1/publish-notice";
	public static final String APPROVE_NOTICE = "/v1/approve-notice";
	public static final String GET_NOTICE_BY_OID = "/v1/get-notice-by-oid";
	public static final String GET_NOTICE_LIST = "/v1/get-notice-list";

	// Asset Income

	public static final String SAVE_ASSET_INCOME = "/v1/save-asset-income";
	public static final String UPDATE_ASSET_INCOME = "/v1/update-asset-income";
	public static final String GET_ASSET_INCOME_LIST = "/v1/get-asset-income-list";
	public static final String GET_ASSET_DUE_INCOME_LIST = "/v1/get-asset-due-income-list";
	public static final String GET_ASSET_INCOME_BY_OID = "/v1/get-asset-income-by-oid";
	public static final String GET_ASSET_HOLDER_BY_ASSET_DETAILS_OID = "/v1/get-asset-holder-by-asset-details-oid";

	// Asset Detail

	public static final String SAVE_ASSET_DETAIL = "/v1/save-asset-detail";
	public static final String UPDATE_ASSET_DETAIL = "/v1/update-asset-detail";
	public static final String GET_ASSET_DETAIL_LIST = "/v1/get-asset-detail-list";
	public static final String GET_ASSET_DETAIL_BY_OID = "/v1/get-asset-detail-by-oid";

	// Asset Allocation

	public static final String SAVE_ASSET_ALLOCATION = "/v1/save-asset-allocation";
	public static final String UPDATE_ASSET_ALLOCATION = "/v1/update-asset-allocation";
	public static final String GET_ASSET_ALLOCATION_LIST = "/v1/get-asset-allocation-list";
	public static final String GET_ASSET_ALLOCATION_BY_OID = "/v1/get-asset-allocation-by-oid";

	// institute class subject
	public static final String SAVE_INSTITUTE_CLASS_SUBJECT = "/v1/save-institute-class-subject";
	public static final String UPDATE_INSTITUTE_CLASS_SUBJECT = "/v1/update-institute-class-subject";
	public static final String UPDATE_STUDENT_SUBJECT = "/v1/update-student-subject";
	public static final String GET_INSTITUTE_CLASS_SUBJECT_LIST = "/v1/get-institute-class-subject-list";
	public static final String GET_INSTITUTE_CLASS_SUBJECT_LIST_BY_CLASS_OID = "/v1/get-institute-class-subject-list-by-class-oid";
	public static final String GET_INSTITUTE_CLASS_SUBJECT_BY_CLASS_OID = "/v1/get-institute-class-subject-by-class-oid";
	public static final String GET_SUBJECT_LIST_BY_INSTITUTE_TYPE = "/v1/get-subject-list-by-insitute-type";
	public static final String GET_SUBJECT_LIST_BY_STUDENT_ID = "/v1/get-subject-list-by-student-id";

	// class subject
	public static final String GET_CLASS_SUBJECT_LIST = "/v1/get-class-subject-list";
	public static final String GET_CLASS_SUBJECT_LIST_BY_STUDENT = "/v1/get-class-subject-list-by-student";

	// Education Class
	public static final String SAVE_EDUCATION_CLASS = "/v1/save-education-class";
	public static final String UPDATE_EDUCATION_CLASS = "/v1/update-education-class";
	public static final String GET_EDUCATION_CLASS_LIST = "/v1/get-education-class-list";
	public static final String GET_EDUCATION_CLASS_BY_OID = "/v1/get-education-class-by-oid";
	public static final String GET_EDUCATION_CLASS_LIST_BY_SESSION = "/v1/get-education-class-list-by-session";

	// Curriculum
	public static final String GET_EDUCATION_CURRICULUM_BY_OID = "/v1/get-education-curriculum-by-oid";
	public static final String SAVE_EDUCATION_CURRICULUM = "/v1/save-education-curriculum";
	public static final String UPDATE_EDUCATION_CURRICULUM = "/v1/update-education-curriculum";

	// Education System
	public static final String GET_EDUCATION_SYSTEM_BY_OID = "/v1/get-education-system-by-oid";
	public static final String UPDATE_EDUCATION_SYSTEM = "/v1/update-education-system";
	public static final String SAVE_EDUCATION_SYSTEM = "/v1/save-education-system";

	/// Contact
	public static final String CONTACT = "/v1/save-contact";
	public static final String UPDATE_CONTACT = "/v1/update-contact";
	public static final String GET_CONTACT_BY_OID = "/v1/get-contact-by-oid";
	public static final String GET_CONTACT_LIST = "/v1/get-contact-list";
	public static final String GET_CONTACT_LIST_BY_STUDENT = "/v1/get-contact-list-by-student";

	// Income Collection

	public static final String SAVE_INCOME_COLLECTION = "/v1/save-income-collection";
	public static final String UPDATE_INCOME_COLLECTION = "/v1/update-income-collection";
	public static final String GET_INCOME_COLLECTION_LIST = "/v1/get-income-collection-list";
	public static final String GET_INCOME_COLLECTION_LIST_BY_ALL_ASSET = "/v1/get-income-collection-list-by-all-asset";
	public static final String GET_INCOME_COLLECTION_BY_OID = "/v1/get-income-collection-by-oid";
	public static final String GET_INCOME_COLLECTION_BY_ASSET = "/v1/get-income-collection-by-asset";
	public static final String GET_INCOME_COLLECTION_BY_ASSET_HOLDER = "/v1/get-income-collection-by-asset-holder";
	public static final String GET_INCOME_COLLECTION_DETAIL_BY_ASSET_HOLDER = "/v1/get-income-collection-detail-by-asset-holder";
	public static final String GET_INCOME_COLLECTION_BY_ALL_ASSET = "/v1/get-income-collection-by-all-asset";

	// Bank Account
	public static final String SAVE_BANK_ACCOUNT = "/v1/save-bank-account";
	public static final String UPDATE_BANK_ACCOUNT = "/v1/update-bank-account";
	public static final String GET_BANK_ACCOUNT_LIST = "/v1/get-bank-account-list";
	public static final String GET_BANK_ACCOUNT_BY_OID = "/v1/get-bank-account-by-oid";
	public static final String SAVE_BANK_TRANSACTION = "/v1/save-bank-transaction";
	public static final String GET_BANK_TRANSACTION_LIST = "/v1/get-bank-transaction-list";

	// Bank
	public static final String SAVE_BANK = "/v1/save-bank";
	public static final String UPDATE_BANK = "/v1/update-bank";
	public static final String GET_BANK_LIST = "/v1/get-bank-list";
	public static final String GET_BANK_BY_OID = "/v1/get-bank-by-oid";

	// Bank Role
	public static final String SAVE_BANK_BRANCH = "/v1/save-bank-branch";
	public static final String UPDATE_BANK_BRANCH = "/v1/update-bank-branch";
	public static final String GET_BANK_BRANCH_LIST = "/v1/get-bank-branch-list";
	public static final String GET_BANK_BRANCH_BY_OID = "/v1/get-bank-branch-by-oid";

	// Homework

	public static final String CREATE_HOMEWORK = "/v1/create-homework";
	public static final String GET_HOME_WORK_DETAILS_BY_OID = "/v1/get-home-work-details-by-oid";
	public static final String GET_HOME_WORK_List = "/v1/get-home-work-list";
	public static final String UPDATE_HOMEWORK = "/v1/Update-homework";
	public static final String GET_SUBJECT_LIST = "/v1/get-subject-list";
	public static final String CREATE_HOMEWORK_SUBMISSION = "/v1/create-homework-submission";
	public static final String GET_HOME_WORK_LIST_BY_GUARDIAN_ID = "/v1/get-home-work-list-by-guardian-id";
	public static final String GET_HOME_WORK_LIST_BY_STUDENT_ID = "/v1/get-home-work-list-by-student-id";
	public static final String UPDATE_SUBJECT = "/v1/update-subject";

	// Routine New API End Point

	public static final String CREATE_CLASS_ROUTINE = "/v1/create-class-routine";
	public static final String GET_CLASS_ROUTINE_LIST = "/v1/get-class-routine-list";
	public static final String CHECK_CLASS_ROUTINE_BY_SECTION_OID = "/v1/check-class-routine-by-section-oid";
	public static final String CLASS_ROUTINE_DETAILS_SAVE = "/v1/class-routine-details-save";
	public static final String CLASS_ROUTINE_DETAILS_UPDATE = "/v1/class-routine-details-update";
	public static final String GET_CLASS_ROUTINE_DETAILS_BY_OID = "/v1/get-class-routine-details-by-oid";
	public static final String GET_CLASS_ROUTINE_DETAILS_BY_TEACHER_OID = "/v1/get-class-routine-details-by-teacher-oid";
	public static final String GET_EXISTING_CLASS_ROUTINE_DETAILS_BY_OID = "/v1/get-existing-class-routine-details-by-oid";

	public static final String CREATE_CLASS_PERIOD = "/v1/create-class-period";
	public static final String GET_CLASS_PERIOD_LIST = "/v1/get-class-period-list";
	public static final String CLASS_PERIOD_EDIT = "/v1/class-period-edit";
	public static final String CLASS_PERIOD_EDIT_LIST = "/v1/class-period-edit-list";

	public static final String GET_CLASS_TIME_DURATION_LIST = "/v1/get-class-time-duration-list";

	// Fee Collection New API End-Point Start From Here

	public static final String CREATE_FEE_HEAD = "/v1/create-fee-head";
	public static final String UPDATE_FEE_HEAD = "/v1/update-fee-head";
	public static final String INACTIVE_FEE_HEAD = "/v1/inactive-fee-head";
	public static final String ACTIVE_FEE_HEAD = "/v1/active-fee-head";
	public static final String GET_FEE_HEAD_LIST = "/v1/get-fee-head-list";
	public static final String GET_INACTIVE_FEE_HEAD_LIST = "/v1/get-inactive-fee-head-list";
	public static final String GET_FEE_HEAD_BY_OID = "/v1/get-fee-head-by-oid";
	public static final String GET_FEE_HEAD_LIST_BY_INSTITUTE_OID = "/v1/get-fee-head-list- by-institute-oid";

	public static final String GET_PAYMENT_MODE_LIST = "/v1/get-payment-mode-list";
	public static final String CREATE_FEE_HEAD_GROUP_MAPPING = "/v1/create-fee-head-group-mapping";
	public static final String UPDATE_FEE_HEAD_GROUP_MAPPING_BY_GROUP_CODE = "/v1/update-fee-head-group-mapping-by-group-code";
	public static final String GET_FEE_HEAD_GROUP_MAPPING_BY_INSTITUTE_AND_GROUP_CODE = "/v1/get-fee-head-group-mapping-by-institute-and-group-code";
	public static final String GET_FEE_HEAD_GROUP_MAPPING_LIST_BY_INSTITUTE = "/v1/get-fee-head-group-mapping-list-by-institute";

	public static final String CREATE_FEES_SETTING = "/v1/create-fees-setting";
	public static final String UPDATE_FEES_SETTING = "/v1/update-fees-setting";
	public static final String CREATE_DUE_FEES = "/v1/create-due-fees";
	public static final String CREATE_REPEATED_FEES = "/v1/create-repeated-fees";
	public static final String GET_DUE_FEES_DETAIL_BY_STUDENT = "/v1/get-due-fees-detail-by-student";
	public static final String GET_DUE_FEES_DETAIL_BY_APPLICATION_TRACKING_ID = "/v1/get-due-fees-detail-by-application-tracking-id";
	public static final String GET_INSTITUTION_CLASS_FEES_BY_OID = "/v1/get-institution-class-fees-by-oid";
	public static final String GET_FEES_SETTING_DETAIL_BY_INSTITUTE_AND_CLASS_OID = "/v1/get-fees-setting-detail-by-institute-and-class-oid";
	public static final String CREATE_FEES_COLLECTION_WITH_DETAIL = "/v1/create-fees-collection-with-detail";
	public static final String GET_FEES_COLLECTION_LIST = "/v1/get-fees-collection-list";
	public static final String GET_FEES_COLLECTION_WITH_DETAIL_BY_OID = "/v1/get-fees-collection-with-detail-by-oid";
	public static final String GET_FEES_COLLECTION_DETAIL_BY_FEES_COLLECTION_DETAIL_OID = "/v1/get-fees-collection-detail-by-fees-collection-oid";
	public static final String GET_FEES_COLLECTION_DETAIL_BY_STUDENT = "/v1/get-fees-collection-detail-by-student";
	public static final String CHECK_ADMISSION_FEES_SETTINGS = "/v1/check-admission-fess-settings";

	//	public static final String GET_FEE_HEAD_GROUP_LIST = "/v1/get-institute-shift-list";
	//NEED BOTH API FOR NOW
	public static final String GET_FEE_HEAD_GROUP_LIST = "/v1/get-fee-head-group-list";
	public static final String GET_ALL_FEE_HEAD_GROUP_LIST = "/v1/get-all-fee-head-group-list";
	// NEED BOTH API FOR NOW
	public static final String CREATE_FEE_HEAD_GROUP = "/v1/create-fee-head-group";
	public static final String UPDATE_FEE_HEAD_GROUP = "/v1/update-fee-head-group";
	public static final String GET_FEE_HEAD_GROUP_BY_OID = "/v1/get-fee-head-group-by-oid";

	// Fee Setting
	public static final String CREATE_FEE_SETTING = "/v1/create-fee-setting";
	public static final String GET_FEE_SETTING_LIST = "/v1/get-fee-setting-list";
	public static final String GET_FEE_SETTING_BY_OID = "/v1/get-fee-setting-by-oid";
	public static final String UPDATE_FEE_SETTING = "/v1/update-fee-setting";
	public static final String GET_FEE_SETTING_BY_FEE_CODE = "/v1/get-fee-setting-by-fee-code";

	public static final String GET_STUDENT_LIST_BY_FEE_SETTING_OID = "/v1/get-student-list-by-fee-setting-oid";

	public static final String INSTITUTE_CLASS_WISE_GET_DUE_FEES = "/v1/get-due-fees-by-institute-class";
	public static final String INSTITUTE_CLASS_WISE_GET_DUE_FEES_HISTORY = "/v1/get-due-fees-history-by-institute-class";

	public static final String INSTITUTE_CLASS_WISE_GET_FEES_COLLECTION = "/v1/get-fees-collection-by-institute-class";
	public static final String INSTITUTE_CLASS_WISE_GET_FEES_COLLECTION_DETAIL = "/v1/get-fees-collection-detail-by-institute-class";

	// student promotion api

	public static final String GET_STUDENT_PROMOTION_INFO = "/v1/get-student-promotion-info";
	public static final String GET_STUDENT_PROMOTION_LIST = "/v1/get-student-promotion-list";
	public static final String GET_PROMOTION_DETAIL_STUDENT_LIST = "/v1/get-promotion-detail-student-list";
	public static final String GET_PROMOTION_BY_DETAIL_OID = "/v1/get-promotion-by-detail-oid";
	public static final String GET_STUDENT_PROMOTION_BY_OID = "/v1/get-student-promotion-by-oid";
	public static final String SAVE_STUDENT_PROMOTION = "/v1/save-student-promotion";
	public static final String MODIFY_STUDENT_PROMOTION = "/v1/modify-student-promotion";
	// Student New API End-Point
	public static final String ADD_STUDENT = "/v1/add-student";
	public static final String EDIT_STUDENT_PROFILE = "/v1/edit-student";
	public static final String STUDENT_LIST = "/v1/student-list";
	public static final String STUDENT_LIST_BY_TEXTBOOK_OID = "/v1/student-list-by-textbook-oid";
	public static final String STUDENT_LIST_BY_SUBJECT_OID = "/v1/student-list-by-subject-oid";
	public static final String STUDENT_PROFILE_BY_OID = "/v1/student-profile-by-oid";
	public static final String STUDENT_PROFILE = "/v1/student-profile";
	public static final String STUDENT_LIST_BY_SECTION_OID = "/v1/student-list-by-section-oid";
	public static final String STUDENT_TEXT_BOOK_LIST = "/v1/student-text-book-list";
	public static final String PARTICULAR_STUDENT_LIST = "/v1/particular-student-list";
	public static final String UPDATE_STUDENT_PROFILE_BY_USERNAME = "/v1/update-student-profile-by-username";

	public static final String GET_STUDENT_BY_OID = "/v1/get-student-by-oid";
	public static final String UPDATE_STUDENT = "/v1/update-student";
	public static final String UPDATE_GUARDIAN = "/v1/update-guardian";

	public static final String GET_DISTRICT_LIST = "/v1/conf/get-district-list";
	public static final String GET_BRANCH_TYPE_LIST = "/v1/conf/get-branch-type-list";


	public static final String GET_VOUCHER_STUDENT_LIST = "/v1/get-voucher-student-list";

	// Report
	public static final String GET_EXAM_ROUTINE_BY_EXAM_OID_REPORT = "/v1/get-exam-routine-by-exam-oid-report";
	public static final String GET_CLASS_ROUTINE_BY_SECTION_OID_REPORT = "/v1/get-class-routine-by-section-oid-report";
	public static final String GET_ATTENDANCE_REPORT_BY_SECTION = "/v1/get-attendance-report-by-section";
	public static final String GET_ATTENDANCE_REPORT_BY_STUDENT_OID = "/v1/get-attendance-report-by-student-oid";
	public static final String EXAM_MARKSHIT_BY_STUDENT_ID = "/v1/exam-markshit-by-student-id";
	public static final String GET_TEACHER_ATTENDANCE_REPORT_BY_DATE = "/v1/get-teacher-attendance-report-by-date";
	public static final String GET_EXPENSE_DETAILS_REPORT = "/v1/get-expense-details-report";
	public static final String GET_STUDENT_LIST_REPORT = "/v1/get-student-list-report";
	public static final String GET_EDUCATION_SUBJECT_LIST_REPORT = "/v1/get-education-subject-list-report";
	public static final String GET_GUARDIAN_LIST_REPORT = "/v1/get-guardian-list-report";
	public static final String GET_TEACHER_LIST_REPORT = "/v1/get-teacher-list-report";
	public static final String GET_PEOPLE_LIST_REPORT = "/v1/get-people-list-report";
	public static final String GET_BANK_ACCOUNT_LIST_REPORT = "/v1/get-bank-account-list-report";
	public static final String GET_TEXT_BOOK_LIST_REPORT = "/v1/get-text-book-list-report";
	public static final String GET_ASSET_LIST_REPORT = "/v1/get-asset-list-report";
	public static final String GET_EXAM_ROUTINE_REPORT = "/v1/get-exam-routine-report";
	public static final String GET_EXAM_RESULT_REPORT = "/v1/get-exam-result-report";
	public static final String GET_CONTACT_LIST_REPORT = "/v1/get-contact-list-report";
	public static final String GET_CONTACT_GROUP_LIST_REPORT = "/v1/get-contact-group-list-report";
	public static final String GET_ASSET_DETAILS_REPORT = "/v1/get-asset-details-report";
	public static final String GET_PROMOTION_STUDENT_LIST_REPORT = "/v1/get-promotion-student-list-report";
	public static final String GET_CLASS_ROUTINE_REPORT = "/v1/get-class-routine-report";

	public static final String GET_STUDENT_ATTENDANCE_REPORT = "/v1/get-student-attendance-report";

	public static final String GET_STUDENT_CLASS_DETAILS_REPORT = "/v1/get-student-class-details-report";

	// account report
	public static final String GET_ACCOUNT_RECEIVABLE_REPORT = "/v1/get-account-receivable-report";
	public static final String GET_ACCOUNT_PAYABLE_REPORT = "/v1/get-account-payable-report";
	public static final String GET_ADVANCE_PAYMENT_REPORT = "/v1/get-advance-payment-report";
	public static final String GET_ADVANCE_RECEIVED_REPORT = "/v1/get-advance-received-report";
	public static final String GET_SALARY_PAYABLE_REPORT = "/v1/get-salary-payable-report";
	public static final String GET_ACADEMIC_FEE_REPORT = "/v1/get-academic-fee-report";
	public static final String GET_ACADEMIC_FEE_BY_CLASS_REPORT = "/v1/get-academic-fee-by-class-report";

	public static final String GET_BALANC_SHEET_REPORT = "/v1/get-balance-sheet-report";
	public static final String GET_LEDGER_BALANC_REPORT = "/v1/get-ledger-balance-report";

	public static final String GET_JOURNAL_SUMMARY_REPORT = "/v1/get-journal-summary-report";

	public static final String GET_VOUCHER_REPORT = "/v1/get-voucher-report";

	public static final String GET_FEES_COLLECTION_REPORT_BY_STUDENT_ID = "/v1/get-fees-collection-report-by-student-id";
	public static final String INSTITUTE_CLASS_WISE_GET_FEES_COLLECTION_REPORT = "/v1/get-fees-collection-report-by-institute-class";
	public static final String INSTITUTE_CLASS_WISE_GET_FEES_COLLECTION_DETAIL_REPORT = "/v1/get-fees-collection-detail-report-by-institute-class";
	public static final String GET_DUE_FEES_DETAIL_REPORT_BY_STUDENT_ID = "/v1/get-due-fees-detail-report-by-student-id";
	public static final String INSTITUTE_CLASS_WISE_GET_DUE_FEES_REPORT = "/v1/get-due-fees-report-by-institute-class";
	public static final String INSTITUTE_CLASS_WISE_GET_DUE_FEES_HISTORY_REPORT = "/v1/get-due-fees-history-report-by-institute-class";

	public static final String GET_EXAM_RESULT_BY_TEXT_BOOK_REPORT = "/v1/get-exam-result-by-text-book-report";
	public static final String GET_STUDENT_LIST_REPORT_BY_PARAMS = "/v1/get-student-list-report-by-params";

	public static final String GET_INCOME_COLLECTION_REPORT_BY_OID = "/v1/get-income-collection-report-by-oid";
	public static final String GET_INCOME_COLLECTION_REPORT_BY_ASSET = "/v1/get-income-collection-report-by-asset";
	public static final String GET_INCOME_COLLECTION_REPORT_BY_ALL_ASSET = "/v1/get-income-collection-report-by-allAsset";

	public static final String GET_ADMISSION_LIST_REPORT = "/v1/get-admission-list-report";
	// Security Related API
	public static final String SECURITY_LOGIN_API_V1 = "/v1/login";
	public static final String GET_USER_INFO_BY_LOGIN_ID_API_V1 = "/v1/get-userinfo-by-loginId";
	public static final String SECURITY_REGISTRATION_API_V1 = "/v1/registration";
	public static final String SECURITY_SAVE_SMS_LOG_API_V1 = "/v1/save-sms-log";
	public static final String SECURITY_RESET_PASSWORD_OTP_API_V1 = "/v1/reset-password";
	public static final String SECURITY_VERIFY_SIGN_UP_API_V1 = "/v1/verify-sign-up";
	public static final String SECURITY_CHECK_LOGINID_API_V1 = "/v1/check-loginId";

	public static final String GET_PROFILE_BY_LOGIN_ID = "/v1/get-profile-by-login-id";
	public static final String UPDATE_PROFILE_BY_LOGIN_ID = "/v1/user/update-profile-by-loginId";

	// OTP Related API
	public static final String COMMON_SEND_OTP_BY_LOGIN_ID_API_V1 = "/v1/send-otp-by-loginId";
	public static final String COMMON_RESEND_OTP_BY_LOGIN_ID_API_V1 = "/v1/resend-otp-by-loginId";
	public static final String COMMON_VERIFY_OTP_BY_LOGIN_ID_API_V1 = "/v1/verify-otp-by-loginId";
	public static final String COMMON_SEND_OTP_BY_MOBILE_API_V1 = "/v1/send-otp-by-mobile";
	public static final String COMMON_RESEND_OTP_BY_MOBILE_API_V1 = "/v1/resend-otp-by-mobile";
	public static final String COMMON_VERIFY_OTP_BY_MOBILE_API_V1 = "/v1/verify-otp-by-mobile";

	// Notification Related API URL
	public static final String SECURITY_SEND_OTP_API_V1 = "/v1/send-otp";
	public static final String SECURITY_RESEND_OTP_API_V1 = "/v1/resend-otp";
	public static final String SECURITY_VERIFY_OTP_API_V1 = "/v1/verify-otp";
	public static final String SEND_EMAIL_API_V1 = "/v1/send-email";
	public static final String EMAIL_SEND_API_V1 = "/v1/email-send";

	// Institute Grading System Related API URL
	public static final String CREATE_INSTITUTE_GRADING_SYSTEM_API_V1 = "/v1/create-institute-grading-system";
	public static final String EDIT_INSTITUTE_GRADING_SYSTEM_API_V1 = "/v1/edit-institute-grading-system";
	public static final String EDIT = "/v1/edit";
	public static final String GET_INSTITUTE_GRADING_SYSTEM_BY_OID_API_V1 = "/v1/get-institute-grading-system-by-oid";
	public static final String GET_INSTITUTE_GRADING_SYSTEM_LIST_API_V1 = "/v1/get-institute-grading-system-list";

	// SMS Dashboard
	public static final String GET_ADMIN_SMS_DASHBOARD = "/v1/get-admin-sms-dashboard";
	public static final String GET_INSTITUTE_SMS_DASHBOARD = "/v1/get-institute-sms-dashboard";

	// SMS Feature
	public static final String GET_SMS_FEATURE_LIST = "/v1/get-sms-feature-list";
	public static final String GET_SMS_FEATURE_BY_OID = "/v1/get-sms-feature-by-oid";
	public static final String SAVE_SMS_FEATURE = "/v1/save-sms-feature";
	public static final String UPDATE_SMS_FEATURE = "/v1/update-sms-feature";

	// SMS Service
	public static final String GET_INSTITUTE_SMS_SERVICE_LIST = "/v1/get-institute-sms-service-list";
	public static final String GET_SMS_SERVICE_LIST = "/v1/get-sms-service-list";
	public static final String GET_SMS_SERVICE_BY_OID = "/v1/get-sms-service-by-oid";
	public static final String SAVE_SMS_SERVICE = "/v1/save-sms-service";
	public static final String UPDATE_SMS_SERVICE = "/v1/update-sms-service";
	public static final String APPROVE_SMS_SERVICE = "/v1/approve-sms-service";
	public static final String REJECT_SMS_SERVICE = "/v1/reject-sms-service";
	public static final String CHECK_INSTITUTE_SMS_SERVICE = "/v1/check-institute-sms-service";

	// SMS Service
	public static final String GET_SMS_SERVICE_LOG_LIST = "/v1/get-sms-service-log-list";
	public static final String GET_SMS_SERVICE_LOG_BY_OID = "/v1/get-sms-service-log-by-oid";
	public static final String SAVE_SMS_SERVICE_LOG = "/v1/save-sms-service-log";
	public static final String UPDATE_SMS_SERVICE_LOG = "/v1/update-sms-service-log";

	// message template

	public static final String SAVE_MESSAGE_TEMPLATE_SERVICE = "/v1/save-message-template-service";
	public static final String UPDATE_MESSAGE_TEMPLATE_SERVICE = "/v1/update-message-template-service";
	public static final String GET_MESSAGE_TEMPLATE_LIST = "/v1/get-message-template-list";
	public static final String GET_MESSAGE_TEMPLATE_BY_OID = "/v1/get-message-template-by-oid";

	// voucher
	public static final String SAVE_VOUCHER = "/v1/save-voucher";
	public static final String UPDATE_VOUCHER = "/v1/update-voucher";
	public static final String GET_VOUCHER_LIST = "/v1/get-voucher-list";
	public static final String GET_VOUCHER_BY_OID = "/v1/get-voucher-by-oid";
	public static final String GET_VOUCHER_BY_STUDENT_ID = "/v1/get-voucher-by-student-id";
	public static final String GET_VOUCHER_BY_VOUCHER_NO = "/v1/get-voucher-by-voucher-no";
	public static final String CHECK_VOUCHER_STUDENT_LIST_BY_FEE = "/v1/check-voucher-student-list-by-fee";
	public static final String CHECK_STUDENT_VOUCHER_BY_FEE = "/v1/check-student-voucher-by-fee";

	public static final String GET_VOUCHER_LIST_BY_GUARDIAN_ID = "/v1/get-voucher-list-by-guardian-id";

	// voucher payment
	public static final String SAVE_VOUCHER_PAYMENT = "/v1/save-voucher-payment";
	public static final String UPDATE_VOUCHER_PAYMENT = "/v1/update-voucher-payment";
	public static final String GET_VOUCHER_PAYMENT_LIST = "/v1/get-voucher-payment-list";
	public static final String GET_VOUCHER_PAYMENT_BY_OID = "/v1/get-voucher-payment-by-oid";

	public static final String GET_VOUCHER_PAYMENT_LIST_BY_GUARDIAN_ID = "/v1/get-voucher-payment-list-by-guardian-id";

	// fee due
	public static final String SAVE_FEE_DUE = "/v1/save-fee-due";
	public static final String UPDATE_FEE_DUE = "/v1/update-fee-due";
	public static final String GET_FEE_DUE_LIST = "/v1/get-fee-due-list";
	public static final String GET_FEE_DUE_BY_OID = "/v1/get-fee-due-by-oid";
	public static final String GET_FEE_DUE_BY_APPLICATION_TRACKING_ID = "/v1/get-fee-due-by-application-tracking-id";

	// message template parameter

	public static final String GET_MESSAGE_TEMPLATE_PARAMETER_LIST = "/v1/get-message-template-parameter-list";

	// schedule template

	public static final String SAVE_MESSAGE_SCHEDULE_SERVICE = "/v1/save-message-schedule-service";
	public static final String UPDATE_MESSAGE_SCHEDULE_SERVICE = "/v1/update-message-schedule-service";
	public static final String GET_MESSAGE_SCHEDULE_LIST = "/v1/get-message-schedule-list";
	public static final String GET_MESSAGE_SCHEDULE_BY_OID = "/v1/get-message-schedule-by-oid";

	// job template

	public static final String SAVE_MESSAGE_JOB_SERVICE = "/v1/save-message-job-service";
	public static final String UPDATE_MESSAGE_JOB_SERVICE = "/v1/update-message-job-service";
	public static final String GET_MESSAGE_JOB_LIST = "/v1/get-message-job-list";
	public static final String GET_MESSAGE_JOB_BY_OID = "/v1/get-message-job-by-oid";
	public static final String TERMINATE_MESSAGE_JOB_SERVICE = "/v1/terminate-message-job-service";
	public static final String PAUSE_MESSAGE_JOB_SERVICE = "/v1/pause-message-job-service";
	public static final String RESUME_MESSAGE_JOB_SERVICE = "/v1/resume-message-job-service";

	/// Samity
	public static final String SAVE_SAMITY = "/v1/save-samity";
	public static final String UPDATE_SAMITY = "/v1/update-samity";
	public static final String GET_SAMITY_BY_OID = "/v1/get-samity-by-oid";
	public static final String GET_SAMITY_LIST = "/v1/get-samity-list";

	// Role Setting API for Template
	public static final String SAVE_BRANCH = "/v1/conf/save-branch";
	public static final String UPDATE_BRANCH = "/v1/conf/update-branch";
	public static final String GET_BRANCH_BY_OID = "/v1/conf/get-branch-by-oid";
	public static final String GET_BRANCH_LIST = "/v1/conf/get-branch-list";



	//		Employee 
	public static final String SAVE_EMPLOYEE = "/v1/save-employee";
	public static final String UPDATE_EMPLOYEE= "/v1/update-employee";
	public static final String GET_EMPLOYEE_LIST = "/v1/get-employee-list";
	public static final String GET_EMPLOYEE_BY_OID = "/v1/get-employee-by-oid";



}
