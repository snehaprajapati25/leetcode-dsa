/* Write your PL/SQL query statement below */
Select Max(salary) AS SecondHighestSalary 
From employee 
WHERE salary< (Select Max(salary) From employee);