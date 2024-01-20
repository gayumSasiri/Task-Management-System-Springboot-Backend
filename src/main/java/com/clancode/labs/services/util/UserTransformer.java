package com.clancode.labs.services.util;

import com.clancode.labs.entity.User;
import com.clancode.labs.to.UserTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer {

    private final ModelMapper mapper;

    public UserTransformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User fromUserTO (UserTO userTO) {
        return mapper.map(userTO, User.class);
    }

    public UserTO toUserTO (User user) {
        return mapper.map(user, UserTO.class);
    }

    public List<UserTO> toUserTOList (List<User> userList) {
        return userList.stream().map(this::toUserTO).collect(Collectors.toList());
    }

}
