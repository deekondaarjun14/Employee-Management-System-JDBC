package Day24;

import java.sql.Connection;
import java.sql.Statement;


public class CreateTable {

	public static void main(String[] args) throws Exception
	{
		Connection connection=SqlConnection.getDBConnection();
		
		String query="create table Employees(\r\n"
				+ "eno int(5) primary key,\r\n"
				+ "ename varchar(15),\r\n"
				+ "salary numeric(10,2),\r\n"
				+ "dept varchar(10),\r\n"
				+ "gender varchar(7),\r\n"
				+ "dob date);";
		
		Statement st=connection.createStatement();
		st.execute(query);
		
		System.out.println("Table Created Successfully");
		st.close();
		connection.close();
		
	}

}
