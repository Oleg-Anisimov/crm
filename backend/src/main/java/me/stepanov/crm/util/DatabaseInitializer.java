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
        clientDto.setOrganizationName("");
        clientDto.setContactPerson(new ContactPerson("Иван", "Иванов", "Иванович", "+79003123121", "ivan@mail.com"));
        clientService.create(clientDto);

        clientDto = new ClientDto(ClientType.PERSONAL, "", new ContactPerson("Петр", "Петров", "Петрович", "79775830249", "petr@mail.com"));
        clientService.create(clientDto);

        clientDto = new ClientDto(ClientType.CORPORATE, "ООО Рога и Копыта", new ContactPerson("Ирина", "Корсикова", "Ивановна", "79775830249", "ivanova.irina@roiko.ru"));
        clientService.create(clientDto);

    }

    void initRole() {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName("admin");

        roleService.create(roleDto);
        roleDto.setRoleName("manager");
        roleService.create(roleDto);
        roleDto.setRoleName("user");
        roleService.create(roleDto);

    }

    void initUsers() {
        UserDto first = new UserDto("Олег", "Анисимов", "Борисович", "79175433205", "Lemain99@yandex.ru", "Qwerty123",  1L);
        UserDto second = new UserDto("Николай", "Степанов", "Николаевич", "79283763276", "kor51221@yandex.ru", "Qwerty123",  1L);
        UserDto third = new UserDto("Екатерина", "Денисюк", "Андреевна", "79775830249", "kotyatina43@gmail.com", "Qwerty123",  1L);

        userDetailsService.create(first);
        userDetailsService.create(second);
        userDetailsService.create(third);


    }

    void initStatus() {
        StatusDto statusDto = new StatusDto();
        statusDto.setName("Новая");
        statusService.create(statusDto);

        statusDto.setName("На согласовании");
        statusService.create(statusDto);

        statusDto.setName("В работе");
        statusService.create(statusDto);

        statusDto.setName("Готова");
        statusService.create(statusDto);
    }

    void initDeal() {
        DealDto dealDto = new DealDto();
        dealDto.setTitle("Проект");
        dealDto.setPrice(BigDecimal.valueOf(123.666666));
        dealDto.setArchived(true);
        dealDto.setDetails("Что то");
        dealDto.setClientId(1l);
        dealDto.setStatusId(1l);
        dealDto.setUserId(1l);

        dealService.create(dealDto);
        dealDto.setUserId(2l);
        dealService.create(dealDto);
        dealDto.setClientId(3l);
        dealDto.setUserId(3l);
        dealService.create(dealDto);

    }




}
