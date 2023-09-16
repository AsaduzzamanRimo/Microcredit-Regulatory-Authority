package com.doer.mraims.user.application.port.in.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LockUnlockUserRequest {

    private String loginId;

    @NotNull(message = "Oid List is required")
    @NotEmpty(message = "Oid List can not be empty")
    private List<String> oidList;

    private String oid;

}
