package co.edu.icesi.pf.domain.model.entities;

import co.edu.icesi.pf.domain.model.enums.EntityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class User {

    private String id;
    private Pool pool;
    private String idNumber;
    private String email;
    private String phone;
    private int age;
    private String name;
    private String nickname;
    private String password;
    private String photo;
    private String role;
    private String otp;
    private Double points;
    private EntityStatus state;
    private Date createdAt;
    private Date updatedAt;

}
