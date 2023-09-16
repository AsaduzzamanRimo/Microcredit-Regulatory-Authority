package com.doer.mraims.user.adapter.out.persistance.database.entity;


import com.doer.mraims.core.util.model.BaseEntity;
import com.google.gson.GsonBuilder;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Table(name ="login")
public class UserEntity extends BaseEntity {

    private String loginOid;
    private String loginId;
    private String password;
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
    private String instituteOid;
    private String instituteType;
    private String instituteNameEn;
    private String instituteNameBn;
    private String logoUrl;
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

    @Override
    public String toString(){
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
