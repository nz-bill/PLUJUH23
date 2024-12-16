package com.example.SpringSecurityEx1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserAuthDTO {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Min(value = 8,message = "Password has to  be at lest 8 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
