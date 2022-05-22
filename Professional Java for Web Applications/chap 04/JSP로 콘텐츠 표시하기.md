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