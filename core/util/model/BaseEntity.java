package com.doer.mraims.core.util.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseEntity {

    private String oid;

    private String status;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;
}
