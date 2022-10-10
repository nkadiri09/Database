package com.example.database.repo;

import com.example.database.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long > {
    Profile findByEmail(String email);
}