package com.example.SpringSecurityEx1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    // i vår repository så lägger vi till en metod som vi kan använda för att hämta ut users baserat på namn.
    //den kommer vi använda i CustomUserDetailService som håller reda på vilken användare som är inloggad
    Optional<User> findByUsername(String username);
}
