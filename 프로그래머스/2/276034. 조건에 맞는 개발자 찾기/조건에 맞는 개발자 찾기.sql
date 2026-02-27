select distinct
    ID,
    EMAIL, 
    FIRST_NAME, 
    LAST_NAME
from 
    DEVELOPERS as dev
left join
    (
        select *
        from 
            SKILLCODES
    ) as skill
on skill.NAME in ("C#", "PYTHON")
where
    dev.SKILL_CODE & skill.CODE != 0
order by ID