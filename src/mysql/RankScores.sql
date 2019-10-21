-- 178. Rank Scores

/* Write your PL/SQL query statement below */
select Score, dense_rank() over(order by Score desc) as Rank from Scores;