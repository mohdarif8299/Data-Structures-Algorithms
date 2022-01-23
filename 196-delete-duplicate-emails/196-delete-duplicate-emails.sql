# Write your MySQL query statement below
delete e1 from Person e1, Person e2 
where e1.email = e2.email and e1.id > e2.id;