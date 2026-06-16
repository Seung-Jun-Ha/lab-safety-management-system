package com.safety;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.controller.EducationCategoryController;
import com.safety.controller.EducationQueryController;
import com.safety.model.EducationSearchCriteria;
import com.safety.model.ResearcherCategoryRegisterDto;
import com.safety.model.ResearcherCategoryResponseDto;
import com.safety.service.EducationCategoryService;
import com.safety.service.EducationQueryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EducationCategoryController.class, EducationQueryController.class})
public class EducationCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EducationCategoryService educationCategoryService;

    @MockBean
    private EducationQueryService educationQueryService;

    @Test
    @DisplayName("■ TC-6001 [정상-01] 신규 연구활동종사자 분류 등록 성공")
    void registerCategory_Success() throws Exception {
        ResearcherCategoryRegisterDto requestDto = new ResearcherCategoryRegisterDto("과학기술분야 대학원생", "정기 6시간 교육 대상자");
        ResearcherCategoryResponseDto responseDto = new ResearcherCategoryResponseDto("UUID-6001", "과학기술분야 대학원생", "정기 6시간 교육 대상자", 0);
        
        given(educationCategoryService.registerResearcherCategory(any())).willReturn(responseDto);

        mockMvc.perform(post("/api/education/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.categoryId").value("UUID-6001"))
                .andExpect(jsonPath("$.researcherCount").value(0));
    }

    @Test
    @DisplayName("■ TC-6002 [정상-02] 종사자 분류 및 소속 인원 통계 조회 성공")
    void getCategories_Success() throws Exception {
        List<ResearcherCategoryResponseDto> mockList = List.of(
            new ResearcherCategoryResponseDto("UUID-6001", "과학기술분야 대학원생", "정기 6시간", 5),
            new ResearcherCategoryResponseDto("UUID-6002", "과학기술분야 학부생", "정기 2시간", 12)
        );
        
        given(educationQueryService.getResearcherCategories(any())).willReturn(mockList);

        mockMvc.perform(get("/api/education/queries")
                        .param("categoryName", "과학기술분야"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].researcherCount").value(5))
                .andExpect(jsonPath("$[1].researcherCount").value(12));
    }

    @Test
    @DisplayName("■ TC-6003 [예외-01] 이미 존재하는 동일한 카테고리명 등록 요청 시 실패")
    void registerCategory_Exception_Duplicate() throws Exception {
        ResearcherCategoryRegisterDto requestDto = new ResearcherCategoryRegisterDto("과학기술분야 대학원생", "중복 테스트");
        
        given(educationCategoryService.registerResearcherCategory(any()))
                .willThrow(new ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 카테고리명입니다."));

        mockMvc.perform(post("/api/education/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("■ TC-6004 [예외-02] 카테고리 등록 시 글자 수 초과 예외 발생")
    void registerCategory_Exception_LengthOver() throws Exception {
        ResearcherCategoryRegisterDto requestDto = new ResearcherCategoryRegisterDto("너무너무긴카테고리이름이름이름이름이름이름이름...", "내용");
        
        given(educationCategoryService.registerResearcherCategory(any()))
                .willThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "카테고리 이름 글자 수 초과"));

        mockMvc.perform(post("/api/education/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isBadRequest());
    }
}