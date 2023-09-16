package com.doer.mraims.security.domain;

import com.doer.mraims.security.adapter.out.persistance.database.entity.LoginResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login extends LoginResponseEntity {

    private String loginId;
    private String password;
    private String nameEn;
    private String nameBn;
    private String instituteOid;
    private String roleOid;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }


}
