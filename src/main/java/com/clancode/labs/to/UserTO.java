package com.clancode.labs.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTO implements Serializable {
    @Null(message = "User id should not be null")
    Integer userId;
    @NotBlank(message = "user name cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Invalid user name")
    String userName;
    @NotBlank(message = "Password cannot be blank")
    @Length(min = 7)
    String password;
    @Pattern(regexp = "^(ADMIN)|(REGULAR)$", message = "Invalid role")
    String role;
}
