# Write your MySQL query statement below
-- select round(sum(tiv_2016),2) as tiv_2016
-- from Insurance
-- where tiv_2015 in(
--     select tiv_2015
--     from Insurance
--     group by tiv_2015
--     having count(*)>1
-- ) and 
--     (lat, lon) in(
--     select lat, lon
--     from Insurance
--     group by lat, lon
--     having count(*)=1
-- )





with cte as (
    select *, 
    count(*) over (partition by lat, lon) as attempts,
    count(*) over (partition by tiv_2015) as tivs
    from Insurance
)
Select round(sum(tiv_2016),2) as tiv_2016
from cte where attempts=1 and tivs>1