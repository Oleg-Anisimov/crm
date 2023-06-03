package me.stepanov.crm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContactPerson {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @JsonProperty("fullName")
    public String getFullName() {
        return this.getSecondName() + " "
                + this.getFirstName() + " "
                + this.getMiddleName();
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return this.getSecondName() + " "
                + this.getFirstName().charAt(0) + ". "
                + this.getMiddleName().charAt(0) + ".";
    }

}
