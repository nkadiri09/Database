package com.example.database.repo;

import com.example.database.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long > {
    Profile findByEmail(String email);

    @Modifying
    @Query("update Profile p set p.password = :password where p.email = :email")
    void updateProfile(@Param(value = "password") String password, @Param(value = "email") String email);
}