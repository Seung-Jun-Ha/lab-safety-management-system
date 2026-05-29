# 연구실 안전관리 시스템

Node.js + Express 기반의 BCE 스캐폴드입니다.

## 실행

```bash
npm install
npm start
```

브라우저에서 `http://localhost:3000`을 열면 메인 화면을 볼 수 있습니다.

## 구조

- `src/views` : 화면(Boundary)
- `src/controllers` : 라우터/컨트롤러(Boundary)
- `src/services` : 서비스(Control)
- `src/repositories` : 저장소(Entity)

## 참고

- 모든 함수 본문은 빈 스텁입니다.
- 각 팀원은 자기 브랜치에서 유스케이스별 구현과 단위시험을 추가하면 됩니다.
