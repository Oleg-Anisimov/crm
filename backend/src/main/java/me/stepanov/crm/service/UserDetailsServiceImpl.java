package me.stepanov.crm.service;

import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.Role;
import me.stepanov.crm.domain.User;
import me.stepanov.crm.dto.UserDto;
import me.stepanov.crm.repo.EntityRepository;
import me.stepanov.crm.repo.UserRepository;
import me.stepanov.crm.util.SecurityUtils;
import me.stepanov.crm.util.UserDetailsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Transactional
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

    @Transactional
    public void delete(Long id){
         User user = entityRepository.getById(User.class, id);
        entityRepository.delete(user);
    }
    @Transactional
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

    @Transactional
    public UserDto getById(Long id) {
        User userId = entityRepository.getById(User.class, id);
        return mapper.map(userId,UserDto.class);
    }

    @Transactional
    public List<UserDto> getAll(){
        return entityRepository.list(User.class).stream()
                .map(entity ->mapper.map(entity,UserDto.class)).collect(Collectors.toList());
    }

    public User getCurrentUser(){
        String username = SecurityUtils.getCurrentUsername();
        return userRepository.findUserByLogin(username);
    }


    public Boolean isLoggedIn(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
    }
    public User findByLogin(String login){
        return userRepository.findUserByLogin(login);
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(findByLogin(login));
        UserDetails userDetails = userDetailsMapper.convertToUserDetails(user.orElseThrow(() ->
                new  UsernameNotFoundException("Wrong user or password")));
        return userDetails;
    }

}
