package com.example.SpringSecurityEx1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecureDataRepository extends JpaRepository<SecureData, Long> {
}
