package me.stepanov.crm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.Role;
import me.stepanov.crm.domain.User;
import me.stepanov.crm.dto.UserDto;
import me.stepanov.crm.repo.EntityRepository;
import me.stepanov.crm.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final EntityRepository entityRepository;
    private final UserRepository userRepository;

    
    public UserDto create(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setMiddleName(userDto.getMiddleName());
        user.setRole(entityRepository.getById(Role.class,userDto.getRoleId()));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        entityRepository.persist(user);
        return mapper.map(user, UserDto.class);
    }

    
    public void delete(Long id){
         User user = entityRepository.getById(User.class, id);
        entityRepository.delete(user);
    }
    
    public void update(UserDto userDto) {
        User user = entityRepository.getById(User.class, userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setMiddleName(userDto.getMiddleName());
        user.setRole(entityRepository.getById(Role.class,userDto.getRoleId()));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        entityRepository.persist(user);
    }

    
    public User getById(Long id) {
        return entityRepository.getById(User.class,id);
    }

    public UserDto findUser(Long id) {
        User user = entityRepository.getById(User.class, id);
        return new UserDto(user.getId(), user.getFirstName(), user.getSecondName(), user.getMiddleName(), user.getPhone(), user.getEmail());
    }
    
    public List<UserDto> getAll(){
        return entityRepository.list(User.class).stream()
                .map(entity ->mapper.map(entity,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not fount with email " + username);
        }
        return user;
    }
    
    
}
