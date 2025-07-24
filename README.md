# 코인자동매매 (진행중)
> 코인 선물 (ETHUSDT) 자동거래 시스템 <br />
---

## 프로젝트 개요

이 프로젝트는 TradingView에서 보낸 매매 신호(Webhook)를 Spring Boot에서 수신하여
실시간으로 Binance 선물 거래를 자동으로 실행하고, 거래 기록을 저장 및 시각화하는 자동매매 플랫폼 입니다.

향후 추가 기능
  + LSTM 기반 가격 예측
  + 코인 뉴스 감성 분석 기능
  + 세계 경제 캘린더 기능

---

## 시스템 구성도
TradingView → Spring Boot (Webhook 수신 + DB 저장)
↓
FastAPI (Binance 주문 실행)
↓
React (거래 내역, 전략 성능 시각화)

---

## 디렉토리 구조
coin-auto-trading/
├── backend/
│ ├── java-service/ # Spring Boot 서버 (Webhook, DB 연결)
│ └── python-service/ # FastAPI 서버 (Binance 주문 실행, 추후 ML 분석)
├── frontend/
│ └── react/ # 사용자 UI: 전략 설정, 거래 내역 조회
└── README.md

---

## 기술스택
  + Java 17
  + Python
  + Spring Boot
  + React
  + JPA
  + MyBatis
  + MySQL
  + Swagger (개발 환경 전용)

---

## 개발 환경
  + IntelliJ IDEA ultimate
  + Visual Studio Code
  + DBeaver
  + GitHub
  + Vultr

---

## 주요 기능

### 자동매매
  - TradingView 전략에 따른 웹훅 신호 수신
  - Spring Boot에서 DB 저장 및 FastAPI 호출
  - FastAPI가 Binance API를 통해 시장가 주문 실행

### 전략 관리
  - 전략 ID 기반 trade_history 연동
  - 전략별 수익률 및 거래내역 조회

### 확장 예정 기능
  - LSTM 기반 가격 예측
  - 뉴스 감성 분석 기반 보조지표 활용
  - 전략별 성능 리포트 / 백테스트 결과 시각화
  - 세계 경제 캘린더(일정) 시각화
