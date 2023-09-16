package com.doer.mraims.security.adapter.out.persistance.database.entity;


import com.google.gson.GsonBuilder;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Table(name ="branch")
public class LoginEntity extends LoginResponseEntity {
    private String loginId;
    private String password;
    private String nameEn;
    private String nameBn;
    private String instituteOid;
    private String roleOid;

    @Override
    public String toString(){
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
