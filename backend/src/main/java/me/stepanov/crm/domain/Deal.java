package me.stepanov.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.stepanov.crm.domain.enums.ClientType;
import me.stepanov.crm.domain.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="deals")
@SequenceGenerator(name = "deal_seq_gen", sequenceName = "deal_seq", allocationSize = 1)
public class Deal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deal_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "created_date")
    private LocalDate created;

    @Column(name = "updated_date")
    private LocalDate updated;

    @Column(name = "details")
    private String details;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "archived")
    private Boolean archived;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}
