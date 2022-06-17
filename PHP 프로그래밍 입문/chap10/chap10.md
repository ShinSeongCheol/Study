# MySQL 조작
## 테이블에서의 데이터 삽입
### 테이블 데이터 삽입
```
INSERT INTO friend(name, tel, address) VALUES ('송예진', '031-123-4567', '경기도 용인시 수지구 정평로 30');
INSERT INTO friend(name, tel, address) VALUES ('김수정', '031-333-4444', '양평균 지평면 묵방길 123번지');
```

## 데이터 검색과 관리
### 전체 필드와 데이터 검색
```
SELECT * FROM friend;
SELECT * FROM member;
```

### 특정 필드의 전체 레코드 검색
```
SELECT name, tel, address FROM member;
```

### 특정 조건에 맞는 레코드 검색
```
SELECT id, name, address, gender FROM member WHERE gender='W';
SELECT name, tel, gender, age FROM member WHERE age>50 and gender='M';
SELECT name, gender, address, age FROM member WHERE age>=20 and age<=29;
SELECT name, tel, age, gender FROM member WHERE ((age>=30 and age<=39) or (age>=50 and age <=59) and gender = 'M');
SELECT num, name, tel, address, post_num, age, gender FROM member WHERE name='안철영';
```

### 특정 문자열이 포함된 레코드 검색
```
SELECT name, tel FROM member WHERE name like '박%';
SELECT num, name, address, gender FROM member WHERE address LIKE '서울%';
SELECT * FROM member WHERE address LIKE '%은평구%';
SELECT * FROM member WHERE address LIKE '%광주%' AND name LIKE '김%';
```

### 레코드 정렬
```
SELECT name, age, address, tel FROM member WHERE address LIKE '서울%' ORDER BY age;
SELECT name, age, address, tel, gender FROM member WHERE address LIKE '부산%' ORDER BY age DESC;
```

### 레코드 수정
```
UPDATE member SET tel='123-4567' WHERE name='고재진';
SELECT name, tel FROM member WHERE name='고재진';

SELECT name, age FROM member WHERE name='정한나';
UPDATE member set age=37 WHERE name='정한나';
SELECT name, age FROM WHERE name='정한나';
```

### 레코드 삭제
```
DELETE FROM member WHERE age>=40 AND age<=49;
SELECT name, age, gender FROM member WHERE age>=35 AND age<=53 ORDER BY age;
```
