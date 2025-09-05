select t.ID
from ECOLI_DATA as f
join ECOLI_DATA as s on f.ID = s.PARENT_ID
join ECOLI_DATA as t on s.ID = t.PARENT_ID
where f.PARENT_ID is null
order by t.ID;