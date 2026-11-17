package Day24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmployeeBatch {

	public static void main(String[] args) throws Exception {
		try(Connection connection=SqlHikariCP.getDBConnection();
				PreparedStatement ps= connection.prepareStatement("insert into Employees values(?,?,?,?,?,?)");
				){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("How many employes do you want to insert:");
		int n=sc.nextInt();
		sc.nextLine();
		
		
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter details of employee:"+i);
		
		System.out.println("Enter employee Id:");
		int eno= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter employee name:");
		String ename=sc.nextLine();
		
		System.out.println("Enter employee salary:");
		double salary=sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Enter employee deportment:");
		String dept=sc.next();
		
		System.out.println("Enter employee gender:");
		String gender=sc.next();
		
		System.out.println("Enter employee date of birth");
		String dob=sc.next();
				
		ps.setInt(1, eno);																		
		ps.setString(2, ename);																		
		ps.setDouble(3, salary);																			
		ps.setString(4, dept);																			
		ps.setString(5, gender);																			
		ps.setDate(6, java.sql.Date.valueOf(dob));																		
		
		ps.addBatch();
		}
		int[] results=ps.executeBatch();
		System.out.println("Total batches operation excyted :"+results.length);
		sc.close();
		}
	}

}
