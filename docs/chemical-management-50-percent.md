# 화학물질관리 구현 및 단위시험 정리

## 팀 공유용 50% 완료 범위

이번 주 제출/공유용 50% 범위는 아래 항목입니다.

- [등록] `ChemicalStockController`, `ChemicalStockService`, `ChemicalRepository`, `FakeChemicalRepository`
- [조회] `ChemicalQueryController`, `ChemicalQueryService`
- [모델] `ReagentStockRegisterDto`, `ReagentStockResponseDto`, `ChemicalSearchCriteria`, `ReagentStock`, `ChemicalProduct`
- [공통 연계] 등록 성공 시 `AlertLogService.createLog("신규 시약 재고 등록 완료", "CHEMICAL")` 호출
- [단위시험] 정상 등록, 연구실별 조회, 음수 수량 예외, 잘못된 연구실 ID 조회 결과 없음

남은 50% 후속 확장 범위는 실제 DB/JPA 연동, 프론트 화면 연동, 공통 예외 처리 표준화, 수정/삭제/상세조회 확장입니다.

## 구현 API

- 신규 시약 재고 등록: `POST /api/chemical/stock/register`
- 연구실별/제품별 시약 재고 조회: `GET /api/chemical/search?labId=LAB001&productId=CHEM102`

## TC-01 (Normal-01)

| **항목** | **내용** |
| --- | --- |
| **테스트 케이스 ID** | TC-01 (Normal-01) |
| **테스트 목적** | 신규 시약 재고 정상 등록 및 알림 로그 연계 검증 |
| **사전 조건 (Prerequisite)** | 시스템 서버 정상 구동 상태, 가상 DB(List) 초기화 완료 |
| **테스트 입력 데이터** | `ReagentStockRegisterDto` (`labId="LAB001"`, `productId="CHEM102"`, `quantity=5.0`, `unit="L"`, `location="시약장 A-1"`) |
| **테스트 절차 (Steps)** | 1. `ChemicalStockController`의 등록 API 호출<br>2. `ChemicalStockService`에서 DTO를 `ReagentStock`으로 변환<br>3. `ChemicalRepository.save()`로 가상 DB에 저장<br>4. `AlertLogService.createLog()` 호출 확인<br>5. 생성된 응답 DTO 확인 |
| **예상 결과 (Expected)** | HTTP 201 반환, `stockId`가 발급된 `ReagentStockResponseDto` 반환, 알림 로그 생성 완료 |
| **실제 결과 (Actual)** | 예상 결과와 일치함 (Pass) |

## TC-02 (Normal-02)

| **항목** | **내용** |
| --- | --- |
| **테스트 케이스 ID** | TC-02 (Normal-02) |
| **테스트 목적** | 연구실별 시약 재고 현황 조회 검증 |
| **사전 조건 (Prerequisite)** | LAB001에 시약 재고 데이터가 1건 이상 등록되어 있음 |
| **테스트 입력 데이터** | `ChemicalSearchCriteria` (`labId="LAB001"`, `productId=null`) |
| **테스트 절차 (Steps)** | 1. `ChemicalQueryController`의 조회 API 호출<br>2. `ChemicalQueryService`에서 검색 조건 전달<br>3. `ChemicalRepository.findByCriteria()`로 LAB001 재고 필터링<br>4. `List<ReagentStockResponseDto>` 반환값 확인 |
| **예상 결과 (Expected)** | HTTP 200 반환, LAB001에 등록된 시약 재고 리스트 반환 |
| **실제 결과 (Actual)** | 예상 결과와 일치함 (Pass) |

## TC-03 (Exception-01)

| **항목** | **내용** |
| --- | --- |
| **테스트 케이스 ID** | TC-03 (Exception-01) |
| **테스트 목적** | 등록 수량이 음수일 때 등록 거부 및 400 응답 처리 검증 |
| **사전 조건 (Prerequisite)** | 시스템 서버 정상 구동 상태 |
| **테스트 입력 데이터** | `ReagentStockRegisterDto` (`labId="LAB001"`, `productId="CHEM102"`, `quantity=-2.5`, `unit="L"`, `location="시약장 A-1"`) |
| **테스트 절차 (Steps)** | 1. `ChemicalStockController`의 등록 API 호출<br>2. `ChemicalStockService`에서 수량 검증 수행<br>3. 음수 수량이면 `IllegalArgumentException` 발생<br>4. 컨트롤러 예외 핸들러가 HTTP 400으로 변환하는지 확인 |
| **예상 결과 (Expected)** | HTTP 400 반환, 메시지 `등록 수량은 0보다 커야 합니다.`, 저장 및 알림 로그 미호출 |
| **실제 결과 (Actual)** | 예상 결과와 일치함 (Pass) |

## TC-04 (Exception-02)

| **항목** | **내용** |
| --- | --- |
| **테스트 케이스 ID** | TC-04 (Exception-02) |
| **테스트 목적** | 잘못된 연구실 ID로 조회 시 결과 부재 응답 검증 |
| **사전 조건 (Prerequisite)** | 가상 DB에 `INVALID_ID` 연구실 재고 데이터가 없음 |
| **테스트 입력 데이터** | `ChemicalSearchCriteria` (`labId="INVALID_ID"`, `productId=null`) |
| **테스트 절차 (Steps)** | 1. `ChemicalQueryController`의 조회 API 호출<br>2. `ChemicalQueryService`에서 검색 조건 전달<br>3. `ChemicalRepository.findByCriteria()`로 조건 검색<br>4. 반환 리스트가 비어 있는지 확인 |
| **예상 결과 (Expected)** | HTTP 200 반환, 빈 배열 `[]` 반환 |
| **실제 결과 (Actual)** | 예상 결과와 일치함 (Pass) |
