# Write your MySQL query statement below
SELECT name AS Customers
FROM Customers AS cname
LEFT JOIN Orders AS o
ON cname.id = o.customerId
WHERE o.customerId IS NULL;
