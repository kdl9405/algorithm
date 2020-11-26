SELECT 제조업체, COUNT(*) AS 제품 수, MAX(단가) AS 최고가
FROM 제품
ORDER BT 제조업체 HAVING COUNT(*) >=3;

SELECT 등급, COUNT(*) AS 고객 수 ,AVA(적립금) AS 적립금 평균
FROM 고객
ORDER BY 등급 HAVING AVG(적립급) >= 1000;

SELECT 주문고객, 주문제품, SUM(주문량) AS 총 주문수량
FROM 주문
ORDER BY 주문고객, 주문제품;


SELECT 제품.제품명
FROM 제품, 주문
WHERE 주문.주문고객 = 'BANANA' AND 주문.주문번호 = 주문.제품번호;

SELECT 주문.주문제품, 주문.주문일자
FROM 주문, 고객
WHERE 고객.나이 >= 30 AND 고객.고객아이디 = 주문.주문고객;


SELECT 제품.제품명
FROM 고객,주문, 제품
WHERE 고객.고객이름 = '고명석' AND 고객.고객아이디 = 주문.주문고객 AND 주문.주문제품 = 제품.제품번호;

SELECT 제품.제품명, 제품.제조업체
FROM 제품
WHERE 제품번호 IN (SELECT 주문.주문제품
		  FROM 주문
		  주문고객 = 'BANANA');


SELECT 제품명, 단가, 제조업체
FROM 제품
WHERE 단가 > ALL (SELECT 단가
		FROM 제품
		WHERE 제조업체 '대한식품');

SELECT 고객이름
FORM 고객
WHERE EXISTS (SELECT *
		FORM 주문
		WHERE 주문일자 = '2019=03=15'
			AND 주문.주문고객 = 고객.고객아이디);


INSERT 
INTO 고객(고객아이디, 고객이름, 나이, 등급, 직업, 적립금)
VALUES ('strawberry', '최유경', 30, 'vip', '공무원', 100);


UPDATE 제품
SET 제품명 = '통큰파이'
WHERE 제품번호 = 'P03';

UPDATE 주문
SET 수량 = '5'
WHERE 주문고객 = (SELECT 고객아이디
		FROM 고객
		WHERE 고객이름 ='정소화');


DELETE 
FROM 주문
WHERE 주문고객 = (SELECT 고객아이디
		FROM 고객
		WHERE 고객이름 ='정소화');

CREATE VIEW 우수고객(고객아이디, 고객이름, 나이)
AS SELECT 고객아이디, 고객이름, 나이
	FROM 고객
	WHERE 등급 ='VIP'
WITH CHECK OPTION;

CREATE VIEW 업체별제품수(제조업체, 제품수)
AS SELECT 제조업체, COUNT(*)
FROM 제품
GROUP BY 제조업체
WITH CHECK OPTION;

SELECT * 
FROM 우수고객
WHERE 나이 >=25;











