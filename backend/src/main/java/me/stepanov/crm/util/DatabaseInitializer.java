package me.stepanov.crm.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.ContactPerson;
import me.stepanov.crm.domain.enums.ClientType;
import me.stepanov.crm.dto.*;
import me.stepanov.crm.repo.EntityRepository;
import me.stepanov.crm.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Slf4j
@Component
@AllArgsConstructor
public class DatabaseInitializer {

    private final EntityRepository entityRepository;
    private final ClientService clientService;
    private final UserDetailsServiceImpl userDetailsService;
    private final RoleService roleService;
    private final StatusService statusService;
    private final DealService dealService;

    @PostConstruct
    void init() {
        var classes = ReflectionUtil.getEntityClasses("me.stepanov.crm.domain");
        classes.forEach(clazz -> {
            entityRepository.deleteAll(clazz);
        });

        initClients();
        initRole();
        initUsers();
        initStatus();
        initDeal();
    }

    void initClients() {
        ClientDto clientDto = new ClientDto();
        clientDto.setClientType(ClientType.PERSONAL);
        clientDto.setContactPerson(new ContactPerson("Иван", "Иванов", "Иванович", "+79003123121"));

        clientService.create(clientDto);
        clientService.create(clientDto);
        clientService.create(clientDto);

    }

    void initRole() {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("админ");

        roleService.create(roleDto);
        roleService.create(roleDto);
        roleService.create(roleDto);

    }

    void initUsers() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Олег");
        userDto.setSecondName("Анисимов");
        userDto.setMiddleName("Борисович");
        userDto.setEmail("Lemain99@yandex.ru");
        userDto.setPhone("+79175433205");
        userDto.setPassword("66321");
        userDto.setRoleId(1l);

        userDetailsService.create(userDto);
        userDetailsService.create(userDto);
        userDetailsService.create(userDto);


    }

    void initStatus() {
        StatusDto statusDto = new StatusDto();
        statusDto.setName("открыта");

        statusService.create(statusDto);
        statusService.create(statusDto);
        statusService.create(statusDto);

    }

    void initDeal() {
        DealDto dealDto = new DealDto();
        dealDto.setTitle("Проект");
        dealDto.setAvatarUrl("аватарка");
        dealDto.setPrice(BigDecimal.valueOf(123.666666));
        dealDto.setArchived(true);
        dealDto.setDetails("Что то");
        dealDto.setClientId(1l);
        dealDto.setStatusId(1l);
        dealDto.setUserId(1l);

        dealService.create(dealDto);
        dealService.create(dealDto);
        dealService.create(dealDto);

    }




}
