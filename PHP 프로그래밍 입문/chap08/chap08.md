# MySQL 데이터베이스
## 데이터베이스 테이블 관리
### 데이터베이스 테이블 생성
```
CREATE TABLE mem(
  num INT NOT NULL AUTO_INCREMENT,
  id CHAR(20) NOT NULL,
  pass CHAR(20) NOT NULL,
  name CHAR(20) NOT NULL,
  age INT,
  PRIMARY KEY(num)
  );
```

## 데이터베이스 테이블의 구조
### 데이터베이스 테이블 구조 보기
```
DESC mem;
```

## 데이터베이스 테이블 필드 관리
### 새로운 필드 추가하기
```
ALTER TABLE mem ADD email CHAR(30);
```

### 필드 삭제하기
```
ALTER TABLE mem DROP email
```

### 필드 수정하기
```
ALTER TABLE mem CHANGE age phone CHAR(20);
```

### 필드 데이터형 수정하기
```
ALTER TABLE mem MODIFY phone INT;
```

### 데이터베이스 테이블 이름 관리
```
ALTER TABLE mem RENAME mem2;
```

### 데이터베이스 테이블 삭제
```
DROP TABLE mem2;
```