package me.stepanov.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealDto {

    private Long id;
    private String title;
    private String avatarUrl;
    private String details;
    private Boolean archived;
    private BigDecimal price;
    private Long statusId;
    private Long userId;
    private Long clientId;
}
