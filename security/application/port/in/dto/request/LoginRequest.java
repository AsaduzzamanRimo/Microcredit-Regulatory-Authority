package com.doer.mraims.security.application.port.in.dto.request;

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
public class LoginRequest {

    private String oid;
    private String branchId;
    private String comBranchId;

    @NotNull(message = "nameEn is required")
    @NotEmpty(message = "nameEn can not be empty")
    private String nameEn;

    @NotNull(message = "nameBn is required")
    @NotEmpty(message = "nameBn can not be empty")
    private String nameBn;
    private String email;
    @NotNull(message = "Contact no can not be null")
    @NotEmpty(message = "Contact no can not be empty")
    @Pattern(regexp = "^01[3-9]\\d{8}$", message = "Contact no is not valid")
    private String contactNo;
    private String addressEn;
    private String addressBn;

    @NotNull(message = "districtOid is required")
    @NotEmpty(message = "districtOid can not be empty")
    private String districtOid;

    @NotNull(message = "branchTypeOid is required")
    @NotEmpty(message = "branchTypeOid can not be empty")
    private String branchTypeOid;
    private String status;
    private String createdBy;

    private Date createdOn;

    private String updatedBy;


    private Date updatedOn;

    @Override
    public String toString(){
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
