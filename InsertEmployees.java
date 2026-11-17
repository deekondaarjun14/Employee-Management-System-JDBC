package Day24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class InsertEmployees {

		public static void main(String[] args) throws Exception
		{
			Connection connection=SqlConnection.getDBConnection();
			
			Scanner sc= new Scanner(System.in);
			int choice;
			
			do {
				System.out.println("\n===EMPLOYEE MANAGEMENT SYSTEM===");
				System.out.println("1. Insert employee");
				System.out.println("2. Modify employee");
				System.out.println("3. Delete employee");
				System.out.println("4. Display employee");
				System.out.println("5. Employee statistics");
				System.out.println("6. Exit");
				System.out.println("Enter your choice");
				
				choice=sc.nextInt();
				
		switch (choice){
		
		case 1:	
				
			String query="insert into Employees values(?,?,?,?,?,?)";
			
			PreparedStatement ps= connection.prepareStatement(query);
			
			
			System.out.println("How many employes do you want to insert:");
			int n=sc.nextInt();
			sc.nextLine();
			
			int totalRows=0;
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
			
			totalRows +=ps.executeUpdate();
			}
			System.out.println("Total employees inserted:"+totalRows);
			ps.close();
			
			break;
			
		case 2:
			System.out.println("Select the field you want to update");
			System.out.println("1. Update Id");
			System.out.println("2. Update name");
			System.out.println("3. Update salary");
			System.out.println("4. Update deportment");
			System.out.println("5. Update gender");
			System.out.println("6. Update date of birth ");
			System.out.println("7. Back to main menu");
			int Updatechoice=sc.nextInt();
			
			switch(Updatechoice) {
			
			case 1:
			
			String query1="UPDATE Employees SET eno=? WHERE eno=? ";
			PreparedStatement ps1=connection.prepareStatement(query1);
			
			System.out.println("Enter existing employee Id:");
			int oldEno= sc.nextInt();
			
			System.out.println("Enter new employee Id:");
			int newEno= sc.nextInt();
			sc.nextLine();
			
			ps1.setInt(1, newEno);
			ps1.setInt(2, oldEno);
			int rows=ps1.executeUpdate();
			
			if(rows>0)
				System.out.println("Employee Id updated successfully");
			else
				System.out.println("Employee id not found");
			ps1.close();
			
			break;
			
			case 2:
				
			String query2="UPDATE Employees SET ename=? WHERE eno=? ";
			PreparedStatement ps2=connection.prepareStatement(query2);
			
			System.out.println("Enter existing employee Id:");
			int eno= sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter new employee Name:");
			String newEname= sc.nextLine();
			
			ps2.setString(1, newEname);
			ps2.setInt(2, eno);
			int rows1=ps2.executeUpdate();
			
			if(rows1>0)
				System.out.println("Employee name updated successful");
			else
				System.out.println("Employee Id not found");
			ps2.close();
			
			break;
			
			case 3:
				
				String query3="UPDATE Employees SET salary=? WHERE eno=? ";
				PreparedStatement ps3=connection.prepareStatement(query3);
				
				System.out.println("Enter existing employee Id:");
				int eno1= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter new employee salary:");
				double newSalary= sc.nextDouble();
				
				ps3.setDouble(1, newSalary);
				ps3.setInt(2, eno1);
				int rows2=ps3.executeUpdate();
				
				if(rows2>0)
					System.out.println("Employee Salary update successful");
				else
					System.out.println("Employee Id not found");
				ps3.close();
				
				break;
				
			case 4:
				String query4="UPDATE Employees SET dept=? WHERE eno=? ";
				PreparedStatement ps4=connection.prepareStatement(query4);
				
				System.out.println("Enter existing employee Id:");
				int eno2= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter new deportment Name:");
				String newDept= sc.next();
				
				ps4.setString(1, newDept);
				ps4.setInt(2, eno2);
				int rows3=ps4.executeUpdate();
				
				if(rows3>0)
					System.out.println("Employee deportment update successful");
				else
					System.out.println("Employee Id not found");
				ps4.close();
				
				break;
				
			case 5:
				String query5="UPDATE Employees SET gender=? WHERE eno=? ";
				PreparedStatement ps5=connection.prepareStatement(query5);
				
				System.out.println("Enter existing employee Id:");
				int eno3= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter new gender:");
				String newGender= sc.next();
				
				ps5.setString(1, newGender);
				ps5.setInt(2, eno3);
				int rows4=ps5.executeUpdate();
				
				if(rows4>0)
					System.out.println("Employee gender update successful");
				else
					System.out.println("Employee Id not found");
				ps5.close();
				
				break;
				
			case 6:
				String query6="UPDATE Employees SET dob=? WHERE eno=? ";
				PreparedStatement ps6=connection.prepareStatement(query6);
				
				System.out.println("Enter existing employee Id:");
				int eno4= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter new date of birth (YYYY-MM-DD):");
				String newDob= sc.next();
				
				ps6.setDate(1, java.sql.Date.valueOf(newDob));
				ps6.setInt(2, eno4);
				int rows5=ps6.executeUpdate();
				
				if(rows5>0)
					System.out.println("Employee date of birth update successful");
				else
					System.out.println("Employee Id not found");
				ps6.close();
				
				break;
				
			case 7:
				System.out.println("Return to main menu");
				break;
				
				default:
				System.out.println("Invalid update choice");
				break;

			}
			break;
			
			
		case 3:
			System.out.println("\n===Delete employee===");
			System.out.println("1. Delete sellected employees");
			System.out.println("2. Delete All employees");
			System.out.println("3. Back to main menu");
			int Deletechoice=sc.nextInt();
			
			switch(Deletechoice) {
			
			case 1:
			System.out.println("Enter how many employees do you want to delete?");
			int n1=sc.nextInt();
			
			for(int i=1;i<=n1;i++)
			{
			String deleteQuery="Delete from employees WHERE eno=?";
			PreparedStatement ps1=connection.prepareStatement(deleteQuery);
			
			System.out.println("Enter employee id");
			int eno=sc.nextInt();
			ps1.setInt(1, eno);
			int rows=ps1.executeUpdate();
			
			if(rows>0)
			System.out.println("Employee is deleted successfully");
			else
				System.out.println("Employee Id not found");
			ps1.close();
			}
			break;
			
			case 2:
				System.out.println("Are you sure you want to delete all employees?");
				System.out.println("Enter YES to confirm");
				String confirm=sc.next();
				
				if(confirm.equalsIgnoreCase("YES"))
				{
				String deleteAllquerys="Delete from employees";
				PreparedStatement ps2=connection.prepareStatement(deleteAllquerys);
				
				int rows=ps2.executeUpdate();
				
				System.out.println("Total employees deletd:"+rows);
				ps2.close();
				}
				else 
					System.out.println("Delete operetion cancelled");
				break;
			case 3:
				System.out.println("Return to main menu");
				break;
				
				default:
				System.out.println("Invalid update choice");
				break;

			}
			break;
		case 4:
			System.out.println("1. Display All employees");
			System.out.println("2. Display employee by Id");
			System.out.println("3. Display employee by deportment");
			System.out.println("4. Display employee by gender");
			System.out.println("5. Display employee by year");
			System.out.println("6. Back to main menu");
			int Displaychoice = sc.nextInt();
			
			switch(Displaychoice) {
			case 1:
				Statement st=connection.createStatement();
				ResultSet rs=st.executeQuery("SELECT*FROM employees");
				
				while(rs.next()) {
					
					int eno = rs.getInt("eno");
					String ename = rs.getString("ename");
					double salary = rs.getDouble("salary");
					String dept = rs.getString("dept");
					String gender = rs.getString("gender");
					java.sql.Date dob= rs.getDate("dob");
			
					System.out.println("Employee Id:"+eno);
					System.out.println("Employee name:"+ename);
					System.out.println("Employee salary:"+salary);
					System.out.println("Employee deportment:"+dept);
					System.out.println("Employee gender:"+gender);
					System.out.println("Employee date of birth:"+dob);
					}
				rs.close();
				st.close();
				break;
			case 2:
				System.out.println("Enter employee Id");
				int Id=sc.nextInt();
				
				String query1 ="SELECT * FROM Employees WHERE eno=?";
				PreparedStatement ps1=connection.prepareStatement(query1);
				ps1.setInt(1, Id);
				
				ResultSet rs1=ps1.executeQuery();
				
				if(rs1.next()) {
				System.out.println("Employee Id:"+rs1.getInt("eno"));
				System.out.println("Employee name:"+rs1.getString("ename"));
				System.out.println("Employee salary:"+rs1.getDouble("salary"));
				System.out.println("Employee deportment:"+rs1.getString("dept"));
				System.out.println("Employee gender:"+rs1.getString("gender"));
				System.out.println("Employee date of birth:"+rs1.getDate("dob"));
				}
				else {
					System.out.println("Invalid Id");
				}
				rs1.close();
				ps1.close();
				break;
				
			case 3:
				System.out.println("Enter employee deportment");
				String Dept=sc.next();
				
				String query2 ="SELECT * FROM Employees WHERE dept=?";
				PreparedStatement ps2=connection.prepareStatement(query2);
				ps2.setString(1, Dept);
				
				ResultSet rs2=ps2.executeQuery();
				System.out.println("Employees on "+Dept+" deportment");
				
				while(rs2.next()) {
				System.out.println("Employee Id:"+rs2.getInt("eno"));
				System.out.println("Employee name:"+rs2.getString("ename"));
				System.out.println("Employee salary:"+rs2.getDouble("salary"));
				System.out.println("Employee deportment:"+rs2.getString("dept"));
				System.out.println("Employee gender:"+rs2.getString("gender"));
				System.out.println("Employee date of birth:"+rs2.getDate("dob"));
				}
				rs2.close();
				ps2.close();
				break;			
			case 4:
				System.out.println("Enter employee gender");
				String Gender=sc.next();
				
				String query3 ="SELECT * FROM Employees WHERE gender=?";
				PreparedStatement ps3=connection.prepareStatement(query3);
				ps3.setString(1, Gender);
				
				ResultSet rs3=ps3.executeQuery();
				System.out.println("Employees with gender:"+Gender);
				
				while(rs3.next()) {
				System.out.println("Employee Id:"+rs3.getInt("eno"));
				System.out.println("Employee name:"+rs3.getString("ename"));
				System.out.println("Employee salary:"+rs3.getDouble("salary"));
				System.out.println("Employee deportment:"+rs3.getString("dept"));
				System.out.println("Employee gender:"+rs3.getString("gender"));
				System.out.println("Employee date of birth:"+rs3.getDate("dob"));
				}
				rs3.close();
				ps3.close();
				break;
			case 5:
				System.out.println("1. Employees born before a year");
				System.out.println("2. Employees born after a year");
				
				int yearChoice=sc.nextInt();
				
				System.out.println("Enter year");
				int year=sc.nextInt();
				
				switch(yearChoice)
				{
				case 1:
					String query4 ="SELECT * FROM Employees WHERE year(dob)<=?";
					PreparedStatement ps4=connection.prepareStatement(query4);
					ps4.setInt(1, year);
					
					ResultSet rs4=ps4.executeQuery();
					System.out.println("Employees born before:"+year);
					while(rs4.next()) {
						
						int eno = rs4.getInt("eno");
						String ename = rs4.getString("ename");
						double salary = rs4.getDouble("salary");
						String dept = rs4.getString("dept");
						String gender = rs4.getString("gender");
						java.sql.Date dob= rs4.getDate("dob");
				
						System.out.println("Employee Id:"+eno);
						System.out.println("Employee name:"+ename);
						System.out.println("Employee salary:"+salary);
						System.out.println("Employee deportment:"+dept);
						System.out.println("Employee gender:"+gender);
						System.out.println("Employee date of birth:"+dob);
						}
					rs4.close();
					ps4.close();
					break;
					
				case 2:
					String query5 ="SELECT * FROM Employees WHERE year(dob)>=?";
					PreparedStatement ps5=connection.prepareStatement(query5);
					ps5.setInt(1, year);
					
					ResultSet rs5=ps5.executeQuery();
					System.out.println("Employees born before:"+year);
					
					while(rs5.next()) {
						
						int eno = rs5.getInt("eno");
						String ename = rs5.getString("ename");
						double salary = rs5.getDouble("salary");
						String dept = rs5.getString("dept");
						String gender = rs5.getString("gender");
						java.sql.Date dob= rs5.getDate("dob");
				
						System.out.println("Employee Id:"+eno);
						System.out.println("Employee name:"+ename);
						System.out.println("Employee salary:"+salary);
						System.out.println("Employee deportment:"+dept);
						System.out.println("Employee gender:"+gender);
						System.out.println("Employee date of birth:"+dob);
						}
					rs5.close();
					ps5.close();
					break;
				}
				break;
				
			case 6:
				System.out.println("Return to main menu");
				break;
			default:
				System.out.println("Invalid update choice");
				break;
			}
			break;
			
		case 5:
			System.out.println("1. Employees max salary");
			System.out.println("2. Employees max age");
			
			int maxChoice=sc.nextInt();
			
			switch(maxChoice) {
			case 1:
				 System.out.println("Enter salary amount");
				    double Salary = sc.nextDouble();
				String query6 ="SELECT * FROM Employees WHERE salary>?";
				PreparedStatement ps6=connection.prepareStatement(query6);
				
				ps6.setDouble(1, Salary);
				
				ResultSet rs6=ps6.executeQuery();
			
				if(rs6.next()) {
					do {
					System.out.println("Employee salary:"+rs6.getDouble("salary"));
					System.out.println("Employee Id:"+rs6.getInt("eno"));
					System.out.println("Employee name:"+rs6.getString("ename"));
				}while(rs6.next());
				}
				else
				{
					System.out.println("No employee found above "+Salary+" salary");
				}
				rs6.close();
				ps6.close();
				break;
			case 2:
				 System.out.println("Enter age");
				 int age = sc.nextInt();
				String query7 ="SELECT * FROM Employees WHERE TIMESTAMPDIFF(YEAR, dob, CURDATE())>?";
				PreparedStatement ps7=connection.prepareStatement(query7);
				
				ps7.setInt(1, age);
				
				ResultSet rs7=ps7.executeQuery();
				if(rs7.next()) {
					do {
					System.out.println("Employee Id:"+rs7.getInt("eno"));
					System.out.println("Employee name:"+rs7.getString("ename"));
					System.out.println("Employee salary:"+rs7.getDouble("salary"));
					System.out.println("Employee deportment:"+rs7.getString("dept"));
					System.out.println("Employee gender:"+rs7.getString("gender"));
					System.out.println("Employee date of birth:"+rs7.getDate("dob"));
				}while(rs7.next());
				}
				else
				{
					System.out.println("No employee found above "+age+" age");
				}
				rs7.close();
				ps7.close();
				break;
			}
			break;
		case 6:
			System.out.println("Exiting employee management system");
			
			}
			}while (choice !=6);
			connection.close();
			sc.close();
	}

}
