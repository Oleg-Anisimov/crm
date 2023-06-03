package me.stepanov.crm.repo;

import me.stepanov.crm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByLogin(String login);
}
