package com.doer.mraims.core.util;

public abstract class Message {
	public static final String REQUEST_MSG_PREFIX = "request_";
	public static final String request_msg_prefix = "request_";
	public static final String FAIL_HEADER_INVALID_REQUEST_CLIENT = "fail_header_invalid_request_client";
	public static final String FAIL_HEADER_INVALID_REQUEST_TYPE = "fail_header_invalid_request_type";
	public static final String FAIL_HEADER_INVALID_REQUEST_VERSION = "fail_header_invalid_request_version";

	public static final String REQUEST_NULL_MESSAGE_TEXT = "request_null_message_text ";
	public static final String REQUEST_EMPTY_MESSAGE_TEXT = "request_empty_message_text ";
	public static final String REQUEST_NULL_REFERENCE_NO = "request_null_reference_no ";
	public static final String REQUEST_EMPTY_REFERENCE_NO = "request_empty_reference_no ";
	public static final String REQUEST_NULL_DESTINATION_LIST = "request_null_destination_list ";
	public static final String REQUEST_EMPTY_TEMPLATE_TEXT = "Template Text must not be empty : request_empty_template_text";

	public static final String REQUEST_UNKNOWN_ATTRIBUTE = "request_header_null_request_source";
	public static final String REQUEST_MALFORMED_DESTINATION_LIST = "request_malformed_destination_list";
	public static final String REQUEST_NULL_TRANSACTION_TYPE = " request_null_transaction_type ";
	public static final String REQUEST_EMPTY_TRANSACTION_TYPE = " request_empty_transaction_type ";
	public static final String REQUEST_INVALID_TRANSACTION_TYPE = " request_invalid_transaction_type ";

}
