select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS join SKILLCODES on SKILL_CODE & CODE != 0
where CATEGORY = 'Front End'
order by ID;