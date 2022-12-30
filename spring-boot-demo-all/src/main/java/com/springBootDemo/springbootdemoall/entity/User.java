package com.springBootDemo.springbootdemoall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_first_name")
    @NotBlank(message = "required")
    @Size(min = 1, message = "must be 1 letter long")
    private String firstName;
    @Column(name = "user_last_name")
    @NotBlank(message = "required")
    @Size(min = 1, message = "must be 1 letter long")
    private String lastName;
    @Column(name = "user_email")
    @NotBlank(message = "required")
    @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",message = "invalid email")
    private String email;
    @Column(name = "user_password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = "must use uppercase lowercase special")
    private String password;
    @Column(name = "user_login_count")
    private int loginCount;
    @Column(name = "user_login_status")
    private int loginStatus;

}
