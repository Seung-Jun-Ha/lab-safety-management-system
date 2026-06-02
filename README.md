# 연구실 안전관리 시스템

간단한 로컬 실행 가이드와 개발 체크리스트입니다. 팀원이 GitHub에서 코드를 가져와 빠르게 실행하고 개발을 시작할 수 있도록 정리했습니다.

## 사전 요구사항
- Java 17 (OpenJDK 또는 Oracle JDK)
- Maven 3.6+ (또는 로컬에 설치된 Maven 실행 파일)
- Git

윈도우( PowerShell ) 환경 기준으로 예시를 적었습니다.

## 복제 및 빌드
1. 저장소 복제

```powershell
git clone <repo-url>
cd <repo-folder>/STP
```

2. 패키지(테스트 제외)

```powershell
mvn -DskipTests package
```

만약 `mvn` 가 PATH에 없으면 로컬 설치한 Maven 경로를 직접 사용합니다:

```powershell
& "$env:USERPROFILE\tools\apache-maven-3.9.16\bin\mvn.cmd" -DskipTests package
```

## 실행
- 빌드한 JAR 실행:

```powershell
java -jar target/lab-safety-management-system-0.0.1-SNAPSHOT.jar
```

- 개발 중 바로 실행(핫 리로드 없음):

```powershell
mvn spring-boot:run
```

웹브라우저에서 접속: http://127.0.0.1:3000

## 프로젝트 구조 (요약)
- `src/main/java/com/safety/controller` — HTTP 엔드포인트
- `src/main/java/com/safety/service` — 비즈니스 로직(서비스 레이어)
- `src/main/java/com/safety/repository` — JPA 리포지토리
- `src/main/java/com/safety/model` — 엔티티/DTO
- `src/main/resources/static` — 보존된 UI (index.html)

## 빠른 문제해결
- 포트 충돌: 로그에서 `Port` 메시지를 확인하고, 다른 프로세스(예: 이전 실행 중인 Java)를 종료하거나 `src/main/resources/application.properties`에 `server.port=<다른포트>` 설정
- Java 버전 문제: `java -version` 확인 (JDK 17 필요). IntelliJ/VSCode에서 프로젝트 SDK 설정 확인
- 빌드 실패: `mvn -DskipTests package` 로그의 첫 번째 오류 스택 트레이스 복사해서 알려주시면 원인 분석 도와드릴게요

## 개발 가이드 / 체크리스트
- UI(프론트)는 `src/main/resources/static/index.html`에 보존되어 있습니다. 버튼은 현재 엔드포인트로 포워딩되도록 되어 있어, 각 기능에 대해 별도 컨트롤러/뷰를 구현하세요.
- 각 도메인별로 `controller`, `service`, `repository`, `model` 폴더를 사용해 SDD 평면 구조를 유지하세요.
<!-- DB note removed per request -->
- 테스트: 핵심 유스케이스부터 단위 테스트(JUnit 5)와 통합 테스트(SpringBootTest) 추가 권장

## 커밋 & 배포(간단)
- 로컬에서 변경 후

```powershell
git add -A
git commit -m "Implement <작업 내용>"
git push origin main
```
