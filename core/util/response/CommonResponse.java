package com.doer.mraims.core.util.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponse {
    private boolean status;
    private int code;
    private String message;
    private String messageCode;
}