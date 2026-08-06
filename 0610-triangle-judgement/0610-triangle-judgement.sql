# Write your MySQL query statement below
select *,
if(x+y>z and y+z>x && z+x>y, "Yes", "No") as triangle
from Triangle