-- 코드를 입력하세요
# SELECT A.TITLE
#         , A.BOARD_ID 
#         , B.REPLY_ID
#         , B.WRITER_ID 
#         , B.CONTENTS
#         , DATE_FORMAT(B.CREATED_DATE, '%y-%m-%d') AS CREATED_DATE
# FROM USED_GOODS_BOARD A INNER JOIN USED_GOODS_REPLY B ON A.BOARD_ID = B.BOARD_ID
# WHERE B.CREATED_DATE > '2022-09-30' AND B.CREATED_DATE <'2022-11-01'
# ORDER BY B.CREATED_DATE ASC, A.TITLE ASC 
# ;


# 1안
SELECT  A.TITLE
        , A.BOARD_ID
        , B.REPLY_ID
        , B.WRITER_ID
        , B.CONTENTS
        , DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') AS CRAETED_DATE
  FROM  USED_GOODS_BOARD AS A
 INNER
  JOIN  USED_GOODS_REPLY AS B
    ON  A.BOARD_ID = B.BOARD_ID
 WHERE  SUBSTR(A.CREATED_DATE,1,7) = '2022-10'
 ORDER
    BY  B.CREATED_DATE ASC, A.TITLE ASC;