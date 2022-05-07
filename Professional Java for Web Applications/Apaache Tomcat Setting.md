# 아파치 톰캣
## 아파치 톰캣 링크
* <https://tomcat.apache.org/>
## 아파치 톰캣 다운로드(윈도우)
1. 32-bit/64-bit Windows Service Installer (pgp, sha512)
2. 64-bit Windows zip (pgp, sha512)
## 아파치 톰캣 설치
1. 32-bit/64-bit Windows Service Installer (pgp, sha512) 실행
2. 64-bit Windows zip (pgp, sha512) 압축 해제
3. **Apache Software Foundation 속성->보안에서 Users의 사용권한을 모든 권한으로 변경**<br>C:\Program Files\Apache Software Foundation\Tomcat 10.0 에 압축 해제된 64-bit Windows zip (pgp, sha512)의 내용을 복사 붙여넣기
## 아파치 설정
1. C:\Program Files\Apache Software Foundation\Tomcat 10.0\conf\tomcat_users.xml의 ```<tomcat-users> </tomcat-users>``` 사이에 다음과 같은 코드를 추가
```
  <user username="admin" password="admin" roles="manager-gui,admin-gui />
```
**톰캣의 웹 관리로 로그인하는데 사용할 수 있는 관리자를 구성하기 위함(공개서버에서 사용할떄는 사용자명과 비멀번호명 변경)**<br>
2. C:\Program Files\Apache Software Foundation\Tomcat 10.0\config\web.xml에서 ```<servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>``` 밑에 다음과 같은 코드를 추가
```
        <init-param>
            <param-name>compilerSourceVM</param-name>
            <param-value>1.8</param-value>
        </init-param>
        <init-param>
            <param-name>compilerTargetVM</param-name>
            <param-value>1.8</param-value>
        </init-param>
```
**2개의 새로운 서블릿 초기화 매개변수는 톰캣이 자바 SE8언어를 사용해 JSP파일을 컴파일 하게 해줌**
---
커스텀 JSP 컴파일러를 구성하고 싶다면 다음과 같은 코드를 ```<servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>``` 안에 추가
```
        <init-param>
            <param-name>compiler</param-name>
            <param-value>modern</param-value>
        </init-param>
```
