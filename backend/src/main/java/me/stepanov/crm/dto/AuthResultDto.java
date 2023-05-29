package me.stepanov.crm.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthResultDto {

    private final String userName;
    private final String role;
}
