CREATE TABLE member(
    num INT NOT NULL AUTO_INCREMENT,
    id CHAR(20) NOT NULL,
    name CHAR(20) NOT NULL,
    gender CHAR(1),
    post_num CHAR(8),
    address CHAR(80),
    tel CHAR(20),
    age INT,
    PRIMARY KEY(num)
);

INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('yjhwang', '황영주', 'M', '100-011', '서울시 중구 충무로 1가', '234-8879', 35);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('khshul', '설기형', 'M', '607-010', '부산시 동래구 명륜동', '767-3784', 33);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('chpark', '박철호', 'M', '503-200', '광주시 남구 지석동', '298-9730', 34);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('shlee', '이상훈', 'M', '503-201', '광주시 남구 도금동', '838-4347', 32);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('jyjang', '장영숙', 'W', '606-065', '부산시 영도구 봉래동5가', '399-9809', 24);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('yjbae', '배용진', 'M', '122-014', '서울시 은평구 응암4동', '857-5683', 30);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('hbpark', '박혜빈', 'W', '427-760', '경기도 과천시 중앙동', '234-7677', 22);
INSERT INTO member(id, name, gender, post_num, address, tel, age) values ('mskim', '김문수', 'M', '427-760', '경기도 시흥시 신천동', '370-6003', 22);