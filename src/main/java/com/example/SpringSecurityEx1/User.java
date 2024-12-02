package com.example.SpringSecurityEx1;


import jakarta.persistence.*;

@Entity
@Table(name = "\"USER\"")           //vi sätter explicit name till "USER" i table eftersom user är ett reserverat ord i h2-databasene
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
