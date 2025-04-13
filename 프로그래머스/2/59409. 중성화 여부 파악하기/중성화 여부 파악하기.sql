select animal_id, name, if(sex_upon_intake like '%ed%', 'O', 'X') as '중성화'
from animal_ins