CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE N INT DEFAULT N-1;
  
  RETURN (
      # Write your MySQL query statement below.
      SELECT(
          SELECT DISTINCT salary from Employee ORDER BY salary DESC LIMIT 1 OFFSET N
      )
  );
END