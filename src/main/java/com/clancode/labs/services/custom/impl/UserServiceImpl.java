package com.clancode.labs.services.custom.impl;

import com.clancode.labs.entity.User;
import com.clancode.labs.repository.UserRepository;
import com.clancode.labs.services.custom.UserService;
import com.clancode.labs.services.util.UserTransformer;
import com.clancode.labs.to.UserTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserTransformer transformer;
    private final UserRepository repository;
    @Override
    public UserTO saveUser(UserTO userTO) {
        User user = transformer.fromUserTO(userTO);
        User savedUser = repository.save(user);
        return transformer.toUserTO(savedUser);
    }

    @Override
    public void updateUser(UserTO userTO) {
        repository.findById(userTO.getUserId()).orElseThrow(()-> new EntityNotFoundException("User not found"));
        User updatedUser = transformer.fromUserTO(userTO);
        repository.save(updatedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = repository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        repository.delete(user);
    }

    @Override
    public UserTO getUserDetails(Integer userId) {
        Optional<User> optUser = repository.findById(userId);
        if (optUser.isEmpty()) throw new EntityNotFoundException("User not found");
        return transformer.toUserTO(optUser.get());
    }

    @Override
    public List<UserTO> getUserList() {
        List<User> userList = repository.findAll();
        return transformer.toUserTOList(userList);
    }
}
