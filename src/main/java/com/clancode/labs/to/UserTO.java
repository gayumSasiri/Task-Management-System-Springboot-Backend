package com.clancode.labs.to;

import com.clancode.labs.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid user name")
    String userName;
    @NotBlank(message = "username cannot be blank")
    String password;
    @NotBlank(message = "user role cannot be blank")
    UserRole role;
}
