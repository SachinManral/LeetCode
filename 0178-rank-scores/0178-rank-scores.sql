# Write your MySQL query statement below
-- select s1.score, count(distinct s2.score) as 'rank'
-- from Scores s1
-- join Scores s2
-- on s1.score <= s2.score
-- group by s1.id, s1.score
-- order by s1.score desc



select score,
dense_rank() over (order by score desc) as 'rank'
from Scores
