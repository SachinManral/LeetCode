# Write your MySQL query statement below
select d.name as Department, x.name as Employee, x.salary as Salary from (
    select e.*,
    dense_rank() over(partition by e.departmentId order by e.salary desc) as rnk from Employee e)x
    join Department d
    on d.id = x.departmentId
where x.rnk <=3;

