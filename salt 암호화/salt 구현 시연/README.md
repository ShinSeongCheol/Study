# 솔트
## 솔트의 탄생 배경
- 해쉬함수를 이용하는 패스워드 관리의 안정성을 높이기 위하여 **솔트**가 제시
## 솔트의 원리
- 사용자마다 랜덤하게 부여되는 솔트를 패스워드 앞이나 뒤에 추가되어 패스워드 해시값을 생성하는데 사용
- 솔트를 사용하면 입력 메시지가 길어져 더 많은 크래킹 시간이 요구되므로 패스워드를 보다 안전하게 보호할 수 있는 방법
## 솔트의 취약점
- 솔트는 사용자마다 랜덤하게 생성되도, 생성된 후에는 특정 값으로 데이터베이스 솔트 칼럼에 저장
- 데이터베이스가 해킹된 경우 공격자는 사용자 별로 부여된 솔트를 쉽게 파악하여 패스워드 크래킹에 이용
## 접속로그 기반의 솔트
- 국내·외 개인정보보호 정책에 따라 웹사이트의 개인정보 처리자는 방문자의 접속기록 (IP 주소, 접속날짜, 브라우저, OS 종류 등)을 반드시 데이터베이스에 저장
- 로그인 시에 변경되는 접속 기록들을 솔트로 사용하면 패스워드 해쉬값을 자주 바꿀 수 있게 된다.
- 접속로그 기반의 솔트 (Access log-based Salt)는 로그인할 때마다 패스워드 해쉬값이 변경되므로 데이터베이스 관리자나 공격자 입장에서는 사용자가 패스워드를 자주 변경하는 것과 동일한 효과를 보이게 된다.
- 데이터베이스가 유출되더라도 Salt라는 컬럼이 별도로 존재하지 않으므로 공격자에게 솔트의 존재 및 사용여부를 감출 수 있게 된다.
- 공격자가 패스워드 크래킹 중에 사용자가 로그인을 하면 패스워드 해쉬값이 바뀌게 되어 크래킹을 새로 시도해야하므로, 패스워드의 보안 레벨이 매우 높게 안정적으로 유지
## 패스워드 별 동적솔트
- 접속로그 기반의 솔트는 소스코드가 공격자에 노출되는 경우에 솔트로 사용하는 접속기록도 노출
- 사용자가 입력한 패스워드를 숫자화하여 N개의 접속기록들 중에서 r개를 솔트로 선택하여 패스워드 해쉬값을 생성하는 방식
- 데이터베이스와 소스코드가 노출되더라도 사용자마다 서로 다른 r개의 솔트를 사용하므로 패스워드 해쉬값을 보다 안전하게 보호
- 접속로그 기반 솔트와 다르게 패스워드 별 동적솔트 방식에서는 소스코드가 노출되더라도 공격자는 사용자의 패스워드를 알 수 없으므로 어떤 솔트조합을 사용하여 패스워드 해쉬값을 생성하였는지 쉽게 알 수 없다.
- 접속기록 뿐만 아니라 사용자의 아이디, 이메일주소, 생일과 같은 고정값을 솔트로 같이 사용하면 조합의 수가 증가하고 해쉬함수의 입력도 길어져 보안이 더욱 강화된 패스워드 해쉬값을 생성할 수 있다.
- 고정값들이 솔트조합에 포함되더라도 접속기록과 같이 로그인할 때마다 변하는 가변값들이 솔트조합에 섞여 있으므로 동적솔트의 장점은 유지하면서 패스워드 해쉬값의 보안 레벨을 매우 높게 그리고 안정적으로 유지
## 접속로그 기반 동적 솔트 구현
### 시스템 요구사항
- PHP 8.1.6
- Apache
- Maria DB 10.6
### 사용된 언어
- php
- javascript
- css
### 사용된 모듈
- jQuery v3.6.0
### 데이터베이스 테이블 구조
![image](https://user-images.githubusercontent.com/46277114/185273825-972f180a-6b9a-48e1-9f1a-c336ae997c3e.png)
|이름|설명|
|:---|:---|
|id|데이터베이스에 값을 삽입할때마다 늘어나는 id값|
|account|계정|
|password|계정의 비밀번호|
|datetime|접속 기록|
|latest| 최근 접속 기록|
|loginCount| 로그인 성공 횟수|
|ip| ip 주소 값|

### php 파일 설명
|파일명|내용|
|:---:|:---|
|login.php|login.php는 사용자가 입력한 값을 받아서 데이터베이스에 정보가 있는지 비밀번호가 있는지 확인하고 맞으면 비밀번호를 새로운 해쉬값으로 수정한다.|
|register.php|register.php는 사용자가 입력한 값을 받아서 데이터베이스에 새로운 회원 정보를 삽입한다|

#### database.php  
|메서드|매개변수|내용|반환값|
|:---:|:---|:---|:---|
|connect()||데이터베이스에 연결한다|
|close()||데이터베이스의 연결을 끊는다|
|registerUser()|$id, $password|데이터베이스에 새로운 회원정보(account, password, datetime, latest, login_count, ip)를 삽입한다.| 성공: true, 실패: false|
|checkUserInfo()|$id|인수로 들어온 값을 사용하여 데이터베이스에 특정한 값이 있는지 조회한다.| 성공: true, 실패: false|
|getUserInfo()|$account|인수로 들어온 값을 사용하여 데이터베이스에 저장되어있는 특정한 값을 불러온다| 성공: userInfo, 실패: false|
|updatePassword()|$id, $password|인수로 들어온 id와 password값을 사용하여 새로운 salt 해쉬값을 만들고 데이터베이스에 저장되어있는 password를 수정한다|성공: $userInfo -> getPassword()  (새로운 비밀번호 해쉬값 반환)|
|checkPassword()|$id, $password|인수로 들어온 id와 password값을 사용해 현재 비밀번호 값과 맞는지 비교한다|성공: $dbUserInfo -> getPassword()  (데이터베이스에 저장되어 있는 암호화된 패스워드 값)||

#### salt.php
|메서드|매개변수|내용|반환값|
|:---:|:---|:---|:---|
|getFactorial()|$num| 팩토리얼 값이 얼마인지 구한다 | 계산된 팩토리얼 값 반환($result)|
|encryptPassword()|$arr| 인수로 들어온 $arr 배열을 이용하여 salt 조합중 하나를 선택하고 sha256으로 암호화한 패스워드를 반환한다.| hash('sha256', "$saltString[$mod]")|

#### userInfo.php
|메서드|매개변수|내용|반환값|
|:---:|:---|:---|:---|
|setId()|$id|userInfo 클래스 멤버 변수 id에 인수로 들어온 값을 저장한다|
|setPassword()|$password|userInfo 클래스 멤버 변수 password에 인수로 들어온 값을 저장한다|
|setLatest()|$latest|userInfo 클래스 멤버 변수 latest에 인수로 들어온 값을 저장한다|
|setDatetime()|$datetime|userInfo 클래스 멤버 변수 datetime에 인수로 들어온 값을 저장한다|
|setLoginCount()|$loginCount|userInfo 클래스 멤버 변수 loginCount에 인수로 들어온 값을 저장한다|
|setIp()|$ip|userInfo 클래스 멤버 변수 ip에 인수로 들어온 값을 저장한다|
|getId()||userInfo 클래스 멤버변수 id에 저장된 값을 가져온다| $id|
|getPassword()||userInfo 클래스 멤버변수 password에 저장된 값을 가져온다| $password|
|getLatest()||userInfo 클래스 멤버변수 latest에 저장된 값을 가져온다| $latest|
|getDatetime()||userInfo 클래스 멤버변수 datetime에 저장된 값을 가져온다| $datetime|
|getLoginCount()||userInfo 클래스 멤버변수 loginCount에 저장된 값을 가져온다| $loginCount|
|getIp()||userInfo 클래스 멤버변수 ip에 저장된 값을 가져온다| $ip|

### 구현 화면
#### 메인 화면
![image](https://user-images.githubusercontent.com/46277114/185273916-5008da28-b025-45cb-a66e-285563205f78.png)
#### 시작 버튼 누른 화면
![image](https://user-images.githubusercontent.com/46277114/185273984-b2a2cbf1-cb1b-4618-bc8f-9176fc7e0e6f.png)
#### 회원가입 화면
![image](https://user-images.githubusercontent.com/46277114/185274029-3d3ec5a7-2fc0-4126-87de-433e3086cdb0.png)
#### 로그인 화면
![image](https://user-images.githubusercontent.com/46277114/185274082-9aa3d9cb-defb-405e-a8df-2c0946e4240f.png)
#### 로그인 성공 화면
##### 첫번째 로그인
![image](https://user-images.githubusercontent.com/46277114/185274159-b939b9e3-172d-430e-8213-445e3a9d1dd5.png)
##### 두번째 로그인
![image](https://user-images.githubusercontent.com/46277114/185274217-ef96c290-5d4a-4d0f-a712-6dcc20e663d5.png)
##### 세번째 로그인
![image](https://user-images.githubusercontent.com/46277114/185274276-54c5c8c0-5c4e-40a5-9c31-7de75e9b04bb.png)
### 결론
접속로그 기반 동적 솔트는 사용자의 패스워드를 정수화 하여 (N+1)!개의 가변적인 솔트와 고정적인 솔트들의 조합중 하나를 선택하여 패스워드를 해시값을 생성하여 공격자가 데이터베이스나 소스코드를 알더라도 어떤 솔트 조합을 사용하여 패스워드를 해시화 하였는지 알수 없다.




