# Write your MySQL query statement below
-- select max(salary) as SecondHighestSalary 
-- from Employee
-- where salary < (
--             Select max(salary)
--             from Employee
--             )

-- SELECT (
--     SELECT salary FROM (
--         SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) rnk
--         FROM Employee
--     ) t
--     WHERE rnk = 2
--     LIMIT 1
-- ) SecondHighestSalary;



with secHighest as (
    select max(salary) as SecondHighestSalary from Employee
    where salary < (select max(salary) from Employee)
)

select * from secHighest