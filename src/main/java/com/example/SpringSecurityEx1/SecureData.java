package com.example.SpringSecurityEx1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SecureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String encryptedValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncryptedValue() {
        return EncryptionUtil.decrypt( encryptedValue);
    }

    public void setEncryptedValue(String encryptedValue) {
        this.encryptedValue = EncryptionUtil.encrypt( encryptedValue);
    }
}
