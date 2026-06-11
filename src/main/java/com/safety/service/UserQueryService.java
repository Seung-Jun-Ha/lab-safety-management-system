package com.safety.service;

import com.safety.model.UserResponseDto;
import com.safety.model.UserSearchCriteria;
import com.safety.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryService {

    private final UserRepository userRepository;

    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> searchUsers(UserSearchCriteria criteria) {
        return userRepository.searchUsers(criteria).stream()
                .map(UserResponseDto::from)
                .toList();
    }
}
