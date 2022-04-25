package com.academy.carrental.repository;

import com.academy.carrental.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    @Query(
            value = "SELECT role.id FROM Roles as role WHERE role.name = :roleName"
    )
    Integer findIdByName(String roleName);

}
