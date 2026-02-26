select 
    e1.ID as ID,
    e1.GENOTYPE as GENOTYPE,
    e2.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as e1
join ECOLI_DATA as e2
where 
    e1.PARENT_ID = e2.ID 
    and
    e2.GENOTYPE = e1.GENOTYPE & e2.GENOTYPE
order by ID