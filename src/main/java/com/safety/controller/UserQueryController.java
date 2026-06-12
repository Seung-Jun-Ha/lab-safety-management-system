package com.safety.controller;

import com.safety.model.UserResponseDto;
import com.safety.model.UserSearchCriteria;
import com.safety.service.UserQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserQueryController {

    private final UserQueryService userQueryService;

    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping("/search")
    public List<UserResponseDto> searchUsers(@ModelAttribute UserSearchCriteria criteria) {
        return userQueryService.searchUsers(criteria);
    }
}
