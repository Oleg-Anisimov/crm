package me.stepanov.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.stepanov.crm.domain.enums.ClientType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="clients")
@SequenceGenerator(name = "client_seq_gen", sequenceName = "client_seq", allocationSize = 1)
public class Client extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    private Long id;

    @Embedded
    private ContactPerson contactPerson;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_type")
    private ClientType clientType;

}
