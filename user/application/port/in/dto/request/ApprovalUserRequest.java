package com.doer.mraims.user.application.port.in.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalUserRequest {

    @NotNull(message = "Oid  is required")
    @NotEmpty(message = "Oid  can not be empty")
    private String oid;

    private String loginId;

    private String isApproverRemarks;
    private String approverRemarks;
}
