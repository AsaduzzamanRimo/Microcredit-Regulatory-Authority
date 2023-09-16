package com.doer.mraims.security.adapter.out.persistance.database.entity;

import com.doer.mraims.core.util.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseEntity extends BaseEntity {



    private String districtNameEn;
    private String districtNameBn;

    private String branchTypeNameEn;
    private String branchTypeNameBn;

}
