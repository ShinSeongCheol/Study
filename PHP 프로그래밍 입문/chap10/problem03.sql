SELECT * FROM worker WHERE department="홍보부";
SELECT id, name, address FROM worker WHERE age>=20 AND age<=29;
SELECT name, gender, department, phone FROM worker WHERE (department='경리부' AND name LIKE '정%');
SELECT name, address, gender, phone FROM worker WHERE address LIKE '%경기도%' ORDER BY age;
SELECT name, gender, id, phone, address FROM worker WHERE gender='F' ORDER BY age DESC;
SELECT name, gender, id, phone, address FROM worker WHERE gender='M' AND department LIKE '홍보부';
SELECT name, phone FROM worker WHERE address LIKE '%용인시';
UPDATE worker SET phone='010-2222-3333' WHERE name='김영철';
UPDATE worker SET age=33 WHERE id='chulsu';
DELETE FROM worker WHERE id='jhjang';
DELETE FROM worker WHERE department='경리부' AND name='이세영';

mysql -uuser1 -p12345 sample > sample.sql;
mysql -uuser1 -p12345 sample < sample.sql;