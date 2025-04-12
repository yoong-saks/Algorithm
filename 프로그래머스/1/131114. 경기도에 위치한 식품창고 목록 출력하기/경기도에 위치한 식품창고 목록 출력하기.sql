select warehouse_id, warehouse_name, address, IFNULL(freezer_yn, 'N') as 'freezer_yn'
from food_warehouse
where address like '경기%'
order by warehouse_id;