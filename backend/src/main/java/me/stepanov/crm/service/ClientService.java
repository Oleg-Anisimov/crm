package me.stepanov.crm.service;

import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.Client;
import me.stepanov.crm.dto.ClientDto;
import me.stepanov.crm.repo.EntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class ClientService {

    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public ClientDto create(ClientDto clientDto){
        Client client = new Client();
        client.setClientType(clientDto.getClientType());
        client.setContactPerson(clientDto.getContactPerson());
        entityRepository.persist(client);
        return mapper.map(client,ClientDto.class);

    }

    @Transactional
    public void delete(Long id){
        Client client = entityRepository.getById(Client.class, id);
        entityRepository.delete(client);
    }


}
