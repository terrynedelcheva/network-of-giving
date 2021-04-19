package com.vmware.talentboost.finaltask.networkofgiving.service;

import com.vmware.talentboost.finaltask.networkofgiving.model.User;

import java.util.List;

public interface IUserService {
    User create(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    User getUserByUsername(String username);
    void deleteUser(Long id);
}
