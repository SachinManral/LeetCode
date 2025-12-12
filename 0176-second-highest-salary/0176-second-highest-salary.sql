# Write your MySQL query statement below
select (
    select max(salary)
    from Employee 
    Where salary < (Select Max(salary)
    from Employee)
) as SecondHighestSalary;


