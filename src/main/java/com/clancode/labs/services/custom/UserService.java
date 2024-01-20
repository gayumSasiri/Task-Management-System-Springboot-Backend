package com.clancode.labs.services.custom;

import com.clancode.labs.to.UserTO;

import java.util.List;

public interface UserService {

    UserTO saveUser (UserTO userTO);
    void updateUser (UserTO userTO);
    void deleteUser (Integer userId);
    UserTO getUserDetails (Integer userId);
    List<UserTO> getUserList();
}
