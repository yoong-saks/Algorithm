select a.title, a.board_id, b.reply_id, b.writer_id, b.contents, date_format(b.created_date, '%Y-%m-%d')
from used_goods_board as a inner join used_goods_reply as b on a.board_id = b.board_id
where (month(a.created_date) = 10) and year(a.created_date) = 2022
order by b.created_date, a.title;