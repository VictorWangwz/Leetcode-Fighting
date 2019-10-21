-- 176. Second Highest Salary

-- select
-- IFNULL (
--     (Select distinct Salary
-- from Employee
-- Order by Salary desc
-- Limit 1 Offset 1),
--     NULL
-- )  as SecondHighestSalary

select max(Salary) as SecondHighestSalary from Employee
where Salary < (select max(salary) from Employee)