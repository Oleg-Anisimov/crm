package me.stepanov.crm.service;

import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.Role;
import me.stepanov.crm.dto.RoleDto;
import me.stepanov.crm.repo.EntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleService {

    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public RoleDto create(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        entityRepository.persist(role);
        return mapper.map(role, RoleDto.class);
    }

    @Transactional
    public void delete(Long id) {
        Role role = entityRepository.getById(Role.class, id);
        entityRepository.delete(role);
    }

    @Transactional
    public void update(RoleDto roleDto) {
        Role role = entityRepository.getById(Role.class, roleDto.getId());
        role.setRoleName(roleDto.getRoleName());
        entityRepository.persist(role);
    }

    @Transactional
    public RoleDto getById(Long id) {
        Role roleId = entityRepository.getById(Role.class, id);
        return mapper.map(roleId,RoleDto.class);
    }

    @Transactional
    public List<RoleDto> getAll() {
        return entityRepository.list(Role.class).stream()
                .map(entity -> mapper.map(entity, RoleDto.class)).collect(Collectors.toList());
    }
}
