package Database;

public class Database {
	/**
	 Q175 注意左连接使用on关键字
	  select a.FirstName,a.LastName,b.City,b.State 
	  from Person as a left outer join Address as b //左外连接
	  on a.PersonId = b.PersonId;
	  
	  Q176
	  select  ifnull(( //这个函数不写也可以
	  	select distinct Salary //distinct是为了去重
	  	from Employee 
	  	order by Salary 
	  	desc limit 1,1),null)  //limit 1 1 从第二个开始  保留1个
	  as SecondHighestSalary
	  
	  Q177
	  CREATE FUNCTION getNthHighestSalary(N INT)
	  	RETURNS INT
	  	BEGIN
	  		DECLARE M INT;
    		SET M = N - 1;
    		RETURN (
        		SELECT DISTINCT Salary from Employee order by Salary desc limit M,1
    		);
		END
		
		
	  Q178
	  select t.score, t.rank from (
		select @row_num := @row_num + 1 rank, score from
			(select DISTINCT Score from Scores order by Score desc)t1 
			join
			(select @row_num := 0 from dual)t2
		)t
		join
		Scores s
		on t.score = s. score order by s.score desc
		
	  Q180
	  select distinct t1.num
	  	from Logs t1 , Logs t2, Logs t3
	  	where t1.id + 1 = t2.id and t2.id + 1 = t3.id
	  		and t1.num = t2.num and t2.num = t3.num
	  
	  Q181
	  select e2.Name
	  	from Employee e1, Employee e2
	  	where e1.Id = e2.ManagerId and e1.Salary < e2.Salary
	  	
	  Q182
	  select Email from Person group by Email having count(Email) >1
	  
	  Q183
	  select c.Name from Customers c
	  	where c.Id not in
	  	(select distinct customerid from Orders o)
	  	
	  Q196
	  delete from Person
	  	where Id not in
    		(select id from
        		(select min(p2.Id) as id from Person p2 group by p2.Email)t
    		)
    
      Q197
      select w1.Id Id
		from Weather w1, Weather w2
		where datediff(w1.Date,w2.Date)=1 and w1.Temperature>w2.Temperature
	 */
}
