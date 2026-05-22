# Write your MySQL query statement below
-- SELECT w1.id
-- FROM Weather w1 INNER JOIN Weather w2
-- WHERE DATEDIFF(w1.recordDate , w2.recordDate) = 1
-- AND w1.temperature > w2.temperature



with temp as (
    select w1.id
    from Weather w1
    inner join Weather w2
    where datediff(w1.recordDate, w2.recordDate)=1 and w1.temperature > w2.temperature
)

select * from temp