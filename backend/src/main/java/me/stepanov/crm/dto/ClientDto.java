package me.stepanov.crm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.stepanov.crm.domain.ContactPerson;
import me.stepanov.crm.domain.enums.ClientType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDto {

    private Long id;
    private String person;
    private String phone;

    private ContactPerson contactPerson;

    private ClientType clientType;

    public ClientDto(Long id, String person, String phone, ClientType clientType) {
        this.id = id;
        this.person = person;
        this.phone = phone;
        this.clientType = clientType;
    }
}
