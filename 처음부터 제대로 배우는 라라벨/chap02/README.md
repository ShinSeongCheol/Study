# 라라벨 개발 환경 구성하기
## 컴포저
## 로컬 개발 환경
### 라라벨 발렛
### 라라벨 홈스테드
## 라라벨 프로젝트 생성하기
### 라라벨 인스톨러를 사용해서 라라벨 프로젝트 설치하기
``` composer global require "laravel/installer"   laravel new projectName   laravel new projectName --jet ```
- --jet 명령어는 웹 애플리케이션을 만들 때 보편적으로 필요한 기능을 신속하게 만들어주는 패키지
- 로그인, 회원가입, 이메일 인증, 2단계 인증, 세션관리, 생텀을 이용한 API 지원, 팀 관리 기능 등이 포함된 라라벨 프로젝트 파일이 설치
### 컴포저의 create-project 기능을 사용해서 라라벨 프로젝트 설치하기
``` composer create-project laravel/laravel projectName ```
### 설정
- 라라벨 애플리케이션의 핵심적인 설정(데이터베이스 연결, 큐 설정, 메일 설정등)은 config 디렉토리에 들어있다.
- services.php