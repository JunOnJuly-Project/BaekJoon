select o.ANIMAL_ID, o.NAME
from ANIMAL_INS as i right join ANIMAL_OUTS as o using (ANIMAL_ID)
where i.ANIMAL_TYPE is null
order by o.ANIMAL_ID, o.NAME;