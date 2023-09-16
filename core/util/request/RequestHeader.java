package com.doer.mraims.core.util.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RequestHeader {

    private String requestId;
    private Date requestDateTime;
    private String requestSource;
    private String requestServiceSource;
    private String requestSourceService;

}
