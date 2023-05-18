package ru.kata.spring.boot_security.demo.configs;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class UtilDateBase {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UtilDateBase(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void addUser() {
        Role role = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleRepository.save(role);
        roleRepository.save(role2);

        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        roleList.add(role2);

        User user = new User("Ivan","Ivanov",
                23,"$2a$12$vqCH3HhXq0TUUXQAUObOcuwB50.XltvRcvX24IGL3gPP9UwFwNQpG"
                ,roleList);
        userRepository.save(user);
    }
}
