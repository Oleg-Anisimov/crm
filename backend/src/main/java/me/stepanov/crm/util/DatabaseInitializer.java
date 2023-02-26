package me.stepanov.crm.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.BaseEntity;
import me.stepanov.crm.domain.ContactPerson;
import me.stepanov.crm.domain.enums.ClientType;
import me.stepanov.crm.dto.ClientDto;
import me.stepanov.crm.repo.EntityRepository;
import me.stepanov.crm.service.ClientService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class DatabaseInitializer {

    private final EntityRepository entityRepository;
    private final ClientService clientService;

    @PostConstruct
    void init() {
        var classes = ReflectionUtil.getEntityClasses("me.stepanov.crm.domain");
        classes.forEach(clazz -> {
            entityRepository.deleteAll(clazz);
        });

        initClients();
    }

    void initClients() {
        ClientDto clientDto = new ClientDto();
        clientDto.setClientType(ClientType.PERSONAL);
        clientDto.setContactPerson(new ContactPerson("Иван", "Иванов", "Иванович", "+79003123121"));

        clientService.create(clientDto);
        clientService.create(clientDto);
        clientService.create(clientDto);
        clientService.create(clientDto);

    }




}
