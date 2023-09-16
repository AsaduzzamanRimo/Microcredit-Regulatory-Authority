package com.doer.mraims.user.application.port.in.dto.request;

import com.google.gson.GsonBuilder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveRequest {

    private String oid;
    //private String loginOid;
    @NotNull(message = "loginId is required")
    @NotEmpty(message = "loginId can not be empty")
    private String loginId;
    private String password;
    @NotNull(message = "nameEn is required")
    @NotEmpty(message = "nameEn can not be empty")
    private String nameEn;
    private String nameBn;
    private String email;
    private String contactNo;
    private String photoPath;
    private String photoUrl;
    private String currentVersion;
    private String isNewRecord;
    private String lockedBy;
    private Date lockedOn;
    private String approvedBy;
    private Date approvedOn;
    private String remarkedBy;
    private Date remarkedOn;
    private String isApproverRemarks;
    private String approverRemarks;
    private String editCommit;
    private String status;
    private String loginStatus;
    @NotNull(message = "instituteOid is required")
    @NotEmpty(message = "instituteOid can not be empty")
    private String instituteOid;
    private String instituteType;
    private String instituteNameEn;
    private String instituteNameBn;
    private String logoUrl;
    @NotNull(message = "roleOid is required")
    @NotEmpty(message = "roleOid can not be empty")
    private String roleOid;
    private String roleId;
    private String roleDescription;
    private String roleNameEn;
    private String roleNameBn;
    private String menuJson;
    private String apiJson;
    private String authorizationKey;
    private Boolean isExistPassword;
    private Date loginDateTime;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;

    @Override
    public String toString(){
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
