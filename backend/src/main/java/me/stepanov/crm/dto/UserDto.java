package me.stepanov.crm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class UserDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private String email;
    private String password;
    private Long roleId;

    public UserDto(String firstName, String secondName, String middleName, String phone, String email, String password, Long roleId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public UserDto(Long id, String firstName, String secondName, String middleName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
    }
}
