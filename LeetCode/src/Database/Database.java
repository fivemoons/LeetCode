package Database;

public class Database {
	/**
	 * Q175
	 * select a.FirstName,a.LastName,b.City,b.State 
	 * from Person as a left outer join Address as b //左外连接
	 * on a.PersonId = b.PersonId;
	 * 
	 * Q176
	 * select  ifnull(( //这个函数不写也可以
	 * 	select distinct Salary //distinct是为了去重
	 * 	from Employee 
	 * 	order by Salary 
	 * 	desc limit 1,1),null)  //limit 1 1 从第二个开始  保留1个
	 * as SecondHighestSalary
	 */
}
