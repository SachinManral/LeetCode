# Write your MySQL query statement below
Select e.name from 
Employee e
Join Employee m
on e.id = m.managerId
group by e.id, e.name
Having count(*)>=5; 
