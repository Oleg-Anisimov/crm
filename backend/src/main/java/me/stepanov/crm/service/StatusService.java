package me.stepanov.crm.service;

import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.Status;
import me.stepanov.crm.dto.StatusDto;
import me.stepanov.crm.repo.EntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StatusService {
    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public StatusDto create(StatusDto statusDto){
        Status status = new Status();
        status.setName(statusDto.getName());
        entityRepository.persist(status);
        return mapper.map(status,StatusDto.class);
    }

    @Transactional
    public void delete(Long id){
        Status status = entityRepository.getById(Status.class, id);
        entityRepository.delete(status);
    }

    @Transactional
    public void update(StatusDto statusDto){
        Status status = entityRepository.getById(Status.class, statusDto.getId());
        status.setName(statusDto.getName());
        entityRepository.persist(status);
    }

    @Transactional
    public StatusDto getById(Long id){
        Status statusId = entityRepository.getById(Status.class, id);
        return mapper.map(statusId, StatusDto.class);
    }

    @Transactional
    public List<StatusDto> getAll(){
        return entityRepository.list(Status.class).stream()
                .map(entity ->mapper.map(entity,StatusDto.class)).collect(Collectors.toList());
    }
}
