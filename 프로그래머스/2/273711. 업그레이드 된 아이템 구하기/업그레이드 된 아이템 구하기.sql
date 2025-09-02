select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO join ITEM_TREE using(ITEM_ID)
where PARENT_ITEM_ID in
    (
        select ITEM_ID
        from ITEM_INFO
        where RARITY = 'RARE'
    )
order by ITEM_ID desc;