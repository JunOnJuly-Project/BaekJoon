select 
    SCORE,
    EMP.EMP_NO,
    EMP_NAME,
    POSITION,
    EMAIL
from
    HR_EMPLOYEES as EMP
join
    (
        select 
            EMP_NO,
            sum(score) as SCORE
        from
            HR_GRADE 
        group by
            EMP_NO
    ) as GRADE
using (EMP_NO)
order by SCORE desc
limit 1
                    