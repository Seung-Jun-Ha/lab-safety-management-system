package com.safety.controller;

import com.safety.model.AlertLog;
import com.safety.model.User;
import com.safety.repository.AlertLogRepository;
import com.safety.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlertLogRepository alertLogRepository;

    @BeforeEach
    void setUp() {
        userRepository.clear();
        alertLogRepository.clear();
    }

    @Test
    void registerUserRequestSuccess() throws Exception {
        mockMvc.perform(post("/api/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "홍길동",
                                  "deptId": "CS101",
                                  "email": "hong@univ.ac.kr"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.requestId").isNotEmpty())
                .andExpect(jsonPath("$.status").value("PENDING"));

        List<AlertLog> logs = alertLogRepository.findAll();
        assertThat(logs).hasSize(1);
        assertThat(logs.get(0).getMessage()).isEqualTo("신규 사용자 등록 신청 발생");
        assertThat(logs.get(0).getSubSystem()).isEqualTo("USER");
    }

    @Test
    void searchUsersByCriteriaSuccess() throws Exception {
        userRepository.saveUser(new User(null, "홍길동", "CS101", "hong@univ.ac.kr", "USER", "ACTIVE"));

        mockMvc.perform(get("/api/user/search")
                        .param("name", "홍길동"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("홍길동"))
                .andExpect(jsonPath("$[0].deptId").value("CS101"))
                .andExpect(jsonPath("$[0].email").value("hong@univ.ac.kr"));
    }

    @Test
    void registerUserRequestFailsWhenEmailIsMissing() throws Exception {
        mockMvc.perform(post("/api/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "이몽룡",
                                  "deptId": "ME202",
                                  "email": ""
                                }
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void searchUsersReturnsEmptyListWhenNoUserMatches() throws Exception {
        userRepository.saveUser(new User(null, "홍길동", "CS101", "hong@univ.ac.kr", "USER", "ACTIVE"));

        mockMvc.perform(get("/api/user/search")
                        .param("name", "없는사람")
                        .param("role", "ADMIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
