# 연구실 안전관리 시스템

Spring Boot 기반의 SDD 스캐폴드입니다. UI 템플릿은 `src/main/resources` 아래에서 유지하고, 백엔드는 `com.safety` 기준의 평면 패키지 구조로 정리했습니다.

## 실행

```bash
mvn spring-boot:run
```

## 구조

- `src/main/java/com/safety/controller` : 컨트롤러
- `src/main/java/com/safety/service` : 서비스
- `src/main/java/com/safety/repository` : 저장소
- `src/main/java/com/safety/model` : 모델 / DTO / Entity

## 참고

- 현재 코드는 뼈대만 남긴 상태입니다.
- 각 팀원은 담당 유스케이스 기준으로 구현과 단위시험을 추가하면 됩니다.
