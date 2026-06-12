package com.safety.repository;

import com.safety.model.User;
import com.safety.model.UserRegistrationRequest;
import com.safety.model.UserSearchCriteria;

import java.util.List;

public interface UserRepository {

    UserRegistrationRequest saveRegistrationRequest(UserRegistrationRequest request);

    User saveUser(User user);

    List<User> searchUsers(UserSearchCriteria criteria);

    void clear();
}
