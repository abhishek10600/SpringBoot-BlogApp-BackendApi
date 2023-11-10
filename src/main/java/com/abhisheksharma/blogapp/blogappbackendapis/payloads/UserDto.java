package com.abhisheksharma.blogapp.blogappbackendapis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be of atleast 4 characters")
    private String name;

    @Email(message = "Your email address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 5, message = "Password must be of atleast 5 characters")
    private String password;

    @NotEmpty
    @Size(max = 100, message = "About cannot be more than 100 characters")
    private String about;

}
