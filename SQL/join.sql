-- 없어진 기록 찾기

SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
FROM ANIMAL_OUTS
LEFT OUTER JOIN ANIMAL_INS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_INS.ANIMAL_ID IS NULL
ORDER BY ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME;


--있었는데요 없었습니다

SELECT INS.ANIMAL_ID, INS.NAME
FROM ANIMAL_INS INS 
JOIN ANIMAL_OUTS OUTS  ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.DATETIME > OUTS.DATETIME
ORDER BY INS.DATETIME;


--오랜 기간 보호한 동물(1)

SELECT INS.NAME, INS.DATETIME
FROM ANIMAL_INS INS
LEFT JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE OUTS.ANIMAL_ID IS NULL
ORDER BY INS.DATETIME
LIMIT 3;


-- 보호소에서 중성화한 동물

SELECT INS.ANIMAL_ID, INS.ANIMAL_TYPE, INS.NAME
FROM ANIMAL_INS INS
INNER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.SEX_UPON_INTAKE LIKE 'Intact%' AND (OUTS.SEX_UPON_OUTCOME = 'Neutered Male' OR OUTS.SEX_UPON_OUTCOME = 'Spayed Female')
ORDER BY INS.ANIMAL_ID;