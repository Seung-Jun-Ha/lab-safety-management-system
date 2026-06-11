package com.safety.service;

import com.safety.model.User;
import com.safety.model.UserRegisterDto;
import com.safety.model.UserRegisterResponseDto;
import com.safety.model.UserRegistrationRequest;
import com.safety.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final AlertLogService alertLogService;

    public UserRegistrationService(UserRepository userRepository, AlertLogService alertLogService) {
        this.userRepository = userRepository;
        this.alertLogService = alertLogService;
    }

    public UserRegisterResponseDto registerUserRequest(UserRegisterDto dto) {
        UserRegistrationRequest request = userRepository.saveRegistrationRequest(UserRegistrationRequest.pending(dto));
        userRepository.saveUser(User.pendingFrom(dto));
        alertLogService.createLog("신규 사용자 등록 신청 발생", "USER");
        return new UserRegisterResponseDto(request.getRequestId(), request.getStatus());
    }
}
