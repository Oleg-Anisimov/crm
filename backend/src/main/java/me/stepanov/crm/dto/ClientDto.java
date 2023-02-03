package me.stepanov.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.stepanov.crm.domain.ContactPerson;
import me.stepanov.crm.domain.enums.ClientType;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private ContactPerson contactPerson;
    private ClientType clientType;
}
