package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"})
    User findByUsername(String username);
    Optional<User> findById(Long id);
}
