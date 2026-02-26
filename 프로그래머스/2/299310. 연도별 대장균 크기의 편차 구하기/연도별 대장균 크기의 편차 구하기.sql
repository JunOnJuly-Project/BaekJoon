select
    e2.year,
    e2.max_YEAR_DEV - e1.SIZE_OF_COLONY as YEAR_DEV,
    e1.ID
from ECOLI_DATA as e1
join 
(
    select 
        year(DIFFERENTIATION_DATE) as year,
        max(SIZE_OF_COLONY) as max_YEAR_DEV
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
) as e2
where year(e1.DIFFERENTIATION_DATE) = e2.year
order by e2.year, YEAR_DEV