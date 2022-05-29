# JSP로 콘텐츠 표시하기
## 메이븐 의존성 설정
~~~
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>Hello-World-JSP</groupId>
	<artifactId>Hello-World-JSP</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<release>17</release>
				</configuration>
			</plugin>
			<plugin>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.3</version>
			</plugin>
		</plugins>
	</build>
	<dependencies>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>
	
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>javax.servlet.jsp-api</artifactId>
			<version>2.3.1</version>
			<scope>provided</scope>
		</dependency>

		<dependency>
			<groupId>javax.servlet.jsp.jstl</groupId>
			<artifactId>javax.servlet.jsp.jstl-api</artifactId>
			<version>1.2.1</version>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>javax.servlet.jsp.jstl</artifactId>
			<version>1.2.2</version>
			<scope>compile</scope>
			<exclusions>
				<exclusion>
					<groupId>javax.servlet.jsp</groupId>
					<artifactId>jsp-api</artifactId>
				</exclusion>
				<exclusion>
					<groupId>javax.servlet.jsp</groupId>
					<artifactId>jsp-api</artifactId>
				</exclusion>
				<exclusion>
					<groupId>javax.servlet.jsp.jstl</groupId>
					<artifactId>jstl-api</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>
</project>
~~~
## JSP의 장점
Servlet으로 작성할 경우 writer.append를 사용해서 일일이 html 태그를 사용해야한다. 하지만 JSP를 사용하게 되면 HTML태그와 java의 기능을 사용할 수 있어 훨씬 편하게 작성할 수 있다.
파일크기가 줄어들고 유효성 검사가 가능하다.
## JSP 컴파일러
JSP파일은 컴파일러에 의해 자바 코드로 해석되고 만들어진 servlet이 실행되어진다. 그리고 servlet의 service메서드가 실행되어서 요청하는 작업을 처리한다.
## 콘텐츠 형식, 문자 형식 지정 방법
```
response.setContentType("text/html;charset=UTF-8");

response.setContentType("text/html");
response.setCharacterEncoding("UTF-8");

response.setHeader("Content-Type", "text/html; charset=UTF-8");
```
## 지시문, 선언, 스크립트릿, 식
> <%@ 지시문 %>   
> <%! 선언문 %>   
> <% 스크립트릿 %>   
> <%= 식 %>   
### 지시문
- 지시문은 인터프리터에 특정한 작업 수행
- 파일이나 클래스를 가져오는데 사용 
- 변환시 다른 JSP를 포함하거나 JSP 태그 라이브러리를 포함하도록 지시
### 선언문
- JSP 서블릿 클래스의 범위에서 인스턴스 변수, 메서드 또는 클래스를 정의하는데 사용
- 정의된 모든 클래스는 JSP 서블릿 클래스의 내부 클래스
### 스크립트릿
- 선언문과는 범위가 다르다.
- jspServoce 메서드의 본문에 복사.
- 로컬변수 정의 가능하지만 인스턴스 변수는 정의 불가.
- 선언에서 수행할 수 없는 모든 작업 가능(조건문, 객체 조작, 산순 연산 등)
### 식 
- 클라이언트 출력으로 기록할 수 있는것을 반환하는 간단한 자바 코드
- 스크립트릿과 동일한 메서드 범위로 실행
### 예제
```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
	private final int five = 0;
	protected String comboy = "rodeo";
	
	public long addFive(long number){
		return number + 5L;
	}
	
	public class MyInnerClass{
	}
	
	MyInnerClass instanceVariable = new MyInnerClass();
%>
<%
	class WeridClassWithinMethod {
	
	}

	WeridClassWithinMethod weirdClass = new WeridClassWithinMethod();
	
	MyInnerClass innerClass = new MyInnerClass();
	int seven;
	seven = 7;
%>
<%= "Hello, World" %><br />
<%= addFive(12L) %>
```
## 주석
- \<!-- -->  클라이언트 응답에 보여진다.
- 선언과 스트릿트 문 안에서 //, /**/
- <%-- -->
## JSP 임포트
```
<%@ page import="java.util.*,java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
		import="java.util.*,java.io.IOException" 
%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.IOException" %>
```
출력 내용이 없는 JSP 는 클라이언트에 빈 행을 출력
## 지시문 사용
<table>
<tr>
	<th>지시문 속성</th>
	<td>pageEncoding</td>
	<td>session</td>
	<td>isElIgnored</td>
	<td>buffer</td>
	<td>autoFlush</td>
	<td>errorPage</td>
	<td>isErrorPage</td>
	<td>isThreadSafe</td>
	<td>extends</td>
</tr>
</table>

## 다른 JSP 포함
### 정적 포함
```
<@ include file="index.jsp" %>
```
### 동적 포함
```
<jsp:include page="index.jsp" />
```
### jsp 태그
<table>
	<tr>
		<th>jsp 태그 종류</th>
		<td>jsp:include</td>
		<td>jsp:forward</td>
		<td>jsp:userBean</td>
		<td>jsp:getProperty></td>
		<td>jsp:setProperty</td>
		<td>jsp:useBean</td>
	</tr>
</table>

### jsp 암시적 변수
<table>
	<tr>
		<td>request</td>
		<td>response</td>
		<td>session</td>
		<td>out</td>
		<td>application</td>
		<td>config</td>
		<td>pageContext</td>
		<td>page</td>
		<td>exception</td>
	</tr>
</table>   

## 서블릿과 JSP의 결합

### 배포설명자에 jsp 프로퍼티 구성
```
  <jsp-config>
  	<jsp-property-group>
  		<url-pattern>*.jsp</url-pattern>
  		<url-pattern>*.jspf</url-pattern>
  		<page-encoding>UTF-8</page-encoding>
  		<scripting-invalid>false</scripting-invalid>
  		<include-prelude>/WEB-INF/jsp/base.jspf</include-prelude>
  		<trim-directive-whitespaces>true</trim-directive-whitespaces>
  		<default-content-type>text/html</default-content-type>
  	</jsp-property-group>
  </jsp-config>
  ```
  url-pattern과 맡는 그룹에 프로퍼티를 적용

### 서블릿에서 JSP로 요청 전달
서블릿이 요청을 받고 필요한 비즈니스 로직 처리와 데이터 저장 또는 검색을 수행한 다음 JSP에서 쉽게 사용할 수 있는 모델을 준비하고 요청을 JSP로 전달
