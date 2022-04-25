package com.academy.carrental.entity;

import com.academy.carrental.security.dto.UserForRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column
    private String username;

    @Column(name="is_active")
    private Boolean isActive;

    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name= "user_roles",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Roles> roles = new HashSet<>();

    public User(UserForRegistrationDTO userForRegistrationDTO)
    {
        this.setFirstName(userForRegistrationDTO.getFirstName());
        this.setLastName(userForRegistrationDTO.getLastName());
        this.setUsername(userForRegistrationDTO.getUsername());
        this.setPassword(userForRegistrationDTO.getPassword());
    }

    public void addRole(Roles role)
    {
        this.getRoles().add(role);
    }
}
