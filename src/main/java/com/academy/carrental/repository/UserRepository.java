package com.academy.carrental.repository;

import com.academy.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(
            value = "SELECT user " +
                    "from User user " +
                    "left join fetch user.roles " +
                    "where user.username = :username and user.isActive = true"
    )
    User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
