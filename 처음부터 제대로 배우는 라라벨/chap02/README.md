# 라라벨 개발 환경 구성하기
## 컴포저
## 로컬 개발 환경
### 라라벨 발렛
### 라라벨 홈스테드
## 라라벨 프로젝트 생성하기
### 라라벨 인스톨러를 사용해서 라라벨 프로젝트 설치하기
``` composer global require "laravel/installer" ```   
``` laravel new projectName ```   
``` laravel new projectName --jet ```
- --jet 명령어는 웹 애플리케이션을 만들 때 보편적으로 필요한 기능을 신속하게 만들어주는 패키지
- 로그인, 회원가입, 이메일 인증, 2단계 인증, 세션관리, 생텀을 이용한 API 지원, 팀 관리 기능 등이 포함된 라라벨 프로젝트 파일이 설치
### 컴포저의 create-project 기능을 사용해서 라라벨 프로젝트 설치하기
``` composer create-project laravel/laravel projectName ```
## 설정
- 라라벨 애플리케이션의 핵심적인 설정(데이터베이스 연결, 큐 설정, 메일 설정등)은 config 디렉토리에 들어있다.
- services.php
- 배열의 값은 파일명과 배열 키를 점으로 구분하는 방식으로 액세스 Ex(config('services.sparkpost.secret'))
### .env 파일
#### APP_KEY
- 무작위로 생성되는 문자열, 데이터를 암호화하는데 사용
- ``` php artisan key:generate ``` 명령어로 생성할 수 있음
#### APP_DEBUG
- 에러 디버깅 정보를 출력하는 옵션 TRUE, FALSE 로 지정
- 실제 서버스 운영환경에서는 활성화 하지 않음
#### DB_DATABASE, DB_USERNAME, DB_PASSWORD
- 프로젝트 이름 설정
- 사용자 이름 설정
- 비밀번호 설정
## 라라벨 애플리케이션 구동하기
### 실행
#### 발렛 X
- ```laravel new myProject && cd myProject && php artisan serve ```
#### 발렛 O
- ``` laravel new myProject && cd myProject && valet open ```
## 테스트
- 라라벨은 PHPUnit을 기반으로 함
- 테스트를 실행하면 tests 디렉터리의 Test.php로 끝나는 파일에 들어있는 테스트를 확인함
- 테스트 파일을 작성하는 가장 간단한 방법은 tests 디렉토리에서 Test.php 로 끝나는 파일을 생성하는 것
- 그 다음 프로젝트의 루트 디렉토리 콘솔에서 ./vendor/bin/phpunit 을 실행