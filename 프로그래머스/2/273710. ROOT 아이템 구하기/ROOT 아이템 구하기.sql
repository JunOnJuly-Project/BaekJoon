select
    ITEM_ID,
    ITEM_NAME
from 
    ITEM_INFO 
join 
    ITEM_TREE 
using 
    (ITEM_ID)
where 
    isnull(PARENT_ITEM_ID)
order by
    ITEM_ID