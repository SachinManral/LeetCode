# Write your MySQL query statement below
-- select e.name as Employee
-- from Employee e
-- left join Employee m
-- on m.id = e.managerId
-- where e.salary > m.salary



-- select e.name as Employee 
-- from Employee e 
-- where salary > (
--             select salary
--             from employee
--             where id = e.managerId
--         )


with emp as (
    select e.name as Employee, e.salary as emp_salary, m.salary as m_salary
    from Employee e
    join Employee m
    on e.managerId = m.id
)

select Employee from emp
 where emp_salary>m_salary