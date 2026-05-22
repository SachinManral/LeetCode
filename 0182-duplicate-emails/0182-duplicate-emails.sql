# Write your MySQL query statement below
-- select email 
-- from Person
-- group by email
-- having count(email)>1



-- select distinct email
-- from Person p1
-- where (
--      select count(*)
--      from Person p2
--      where p1.email = p2.email
--     )>1


WITH dup as (
    select email as Email
    from Person
    group by email
    having count(*)>1
)

select * from dup