# Write your MySQL query statement below
select product_id, year as first_year, quantity, price
from Sales
WHERE (product_id, year) IN (
    SELECT product_id, MIN(year)
    FROM Sales
    GROUP BY product_id
);
