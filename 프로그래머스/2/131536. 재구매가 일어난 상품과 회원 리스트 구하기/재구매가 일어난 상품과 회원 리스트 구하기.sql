select distinct t1.USER_ID, t1.PRODUCT_ID
from ONLINE_SALE as t1 join ONLINE_SALE as t2 using(USER_ID)
where   t1.USER_ID = t2.USER_ID and 
        t1.PRODUCT_ID = t2.PRODUCT_ID and 
        t1.SALES_DATE != t2.SALES_DATE
order by t1.USER_ID asc, t1.PRODUCT_ID desc;