package me.stepanov.crm.service;

import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.Deal;
import me.stepanov.crm.dto.DealDto;
import me.stepanov.crm.repo.EntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DealService {

    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private ClientService clientService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public DealDto create(DealDto dealDto){
        Deal deal = new Deal();
        deal.setTitle(dealDto.getTitle());
        deal.setDetails(dealDto.getDetails());
        deal.setArchived(dealDto.getArchived());
        deal.setPrice(dealDto.getPrice());
        deal.setAvatarUrl(dealDto.getAvatarUrl());
        deal.setUser(userDetailsServiceImpl.getById(dealDto.getUserId()));
        deal.setStatus(statusService.getById(dealDto.getStatusId()));
        deal.setClient(clientService.getById(dealDto.getClientId()));
        entityRepository.persist(deal);
        return mapper.map(deal,DealDto.class);
    }
    @Transactional
    public void delete(Long id){
        Deal deal = entityRepository.getById(Deal.class, id);
        entityRepository.delete(deal);
    }

    @Transactional
    public void update(DealDto dealDto){
        Deal deal = entityRepository.getById(Deal.class, dealDto.getId());
        deal.setTitle(dealDto.getTitle());
        deal.setDetails(dealDto.getDetails());
        deal.setArchived(dealDto.getArchived());
        deal.setPrice(dealDto.getPrice());
        deal.setAvatarUrl(dealDto.getAvatarUrl());
        deal.setUser(userDetailsServiceImpl.getById(dealDto.getUserId()));
        deal.setStatus(statusService.getById(dealDto.getStatusId()));
        deal.setClient(clientService.getById(dealDto.getClientId()));
        entityRepository.persist(deal);
    }

    @Transactional
    public DealDto getById(Long id){
        Deal deal = entityRepository.getById(Deal.class, id);
        return mapper.map(deal, DealDto.class);
    }

    @Transactional
    public List<DealDto> getAll(){
        return entityRepository.list(Deal.class).stream()
                .map(entity ->mapper.map(entity,DealDto.class)).collect(Collectors.toList());
    }
}
