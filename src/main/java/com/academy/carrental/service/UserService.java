package com.academy.carrental.service;

import com.academy.carrental.entity.Roles;
import com.academy.carrental.entity.User;
import com.academy.carrental.repository.RolesRepository;
import com.academy.carrental.repository.UserRepository;
import com.academy.carrental.security.dto.UserForRegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final RolesRepository rolesRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void register(UserForRegistrationDTO userForRegistrationDTO)
    {
        String password = userForRegistrationDTO.getPassword();
        User user = new User(userForRegistrationDTO);

        for(String roleName:userForRegistrationDTO.getRoles())
        {
            Integer id = rolesRepository.findIdByName(roleName);
            Optional<Roles> roleOptional = rolesRepository.findById(id);
            if(roleOptional.isPresent())
            {
                Roles role = roleOptional.get();
                user.addRole(role);
            }
        }

        user.setIsActive(true);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public boolean existsByUsername(String username)
    {
        return userRepository.existsByUsername(username);
    }

    public User getByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
}
