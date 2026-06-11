package com.safety.repository;

import com.safety.model.User;
import com.safety.model.UserRegistrationRequest;
import com.safety.model.UserSearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FakeUserRepository implements UserRepository {

    private final AtomicLong userSequence = new AtomicLong(1);
    private final AtomicLong requestSequence = new AtomicLong(1);
    private final ConcurrentMap<String, User> users = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, UserRegistrationRequest> requests = new ConcurrentHashMap<>();

    @Override
    public UserRegistrationRequest saveRegistrationRequest(UserRegistrationRequest request) {
        if (request.getRequestId() == null || request.getRequestId().isBlank()) {
            request.setRequestId("REQ-" + requestSequence.getAndIncrement());
        }
        requests.put(request.getRequestId(), request);
        return request;
    }

    @Override
    public User saveUser(User user) {
        if (user.getUserId() == null || user.getUserId().isBlank()) {
            user.setUserId("USER-" + userSequence.getAndIncrement());
        }
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public List<User> searchUsers(UserSearchCriteria criteria) {
        return users.values().stream()
                .filter(user -> matches(criteria.getName(), user.getName()))
                .filter(user -> matches(criteria.getRole(), user.getRole()))
                .sorted((left, right) -> left.getUserId().compareTo(right.getUserId()))
                .toList();
    }

    @Override
    public void clear() {
        users.clear();
        requests.clear();
        userSequence.set(1);
        requestSequence.set(1);
    }

    private boolean matches(String expected, String actual) {
        if (expected == null || expected.isBlank()) {
            return true;
        }
        if (actual == null) {
            return false;
        }
        return actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT));
    }
}
