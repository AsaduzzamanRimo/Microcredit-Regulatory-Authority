package com.doer.mraims.core.util;


public enum MessageCode{

    MSG_2000("MSG_2000", "Data Fetch Successfully"),
    MSG_2002("MSG_2002", "Data Fetch Successfully By Id"),
    MSG_2003("MSG_2003", "Data Fetch Successfully By Oid"),
    MSG_2005("MSG_2005", "Successfully Submitted Data Saved"),
    MSG_2007("MSG_2007", "Successfully Submitted Data Updated"),
    MSG_2009("MSG_2009", "Data Fetch Successfully By Reference Oid"),
    MSG_2010("MSG_2010", "Login Id Not Found"),
    MSG_2011("MSG_2011", "Wrong Password");

    private final String code;
    private final String message;

    MessageCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + " " + message;
    }

    public static MessageCode getByValue(String code) {
        for(MessageCode messageCode : values()) {
            if(messageCode.code == code) return messageCode;
        }
        throw new IllegalArgumentException("Invalid Message code: " + code);
    }

}
