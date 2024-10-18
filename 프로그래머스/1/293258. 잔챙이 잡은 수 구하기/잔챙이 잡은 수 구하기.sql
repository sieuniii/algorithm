-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO
where length is null or length < 10