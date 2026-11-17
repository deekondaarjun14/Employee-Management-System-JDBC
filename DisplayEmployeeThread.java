package Day24;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayEmployeeThread {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		executor.submit(()->{
			try(Connection connection=SqlHikariCP.getDBConnection();
					PreparedStatement ps=connection.prepareStatement("SELECT * FROM Employees");
					ResultSet rs = ps.executeQuery())
			{
				while(rs.next()) {
					System.out.println("-----------");
					System.out.println("Employee Id:"+rs.getInt("eno"));
					System.out.println("Employee name:"+rs.getString("ename"));
					System.out.println("Employee salary:"+rs.getDouble("salary"));
					System.out.println("Employee deportment:"+rs.getString("dept"));
					System.out.println("Employee gender:"+rs.getString("gender"));
					System.out.println("Employee date of birth:"+rs.getDate("dob"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executor.shutdown();
	}

}
