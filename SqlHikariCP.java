package Day24;

import java.sql.Connection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SqlHikariCP {
private static HikariConfig config = new HikariConfig();
private static HikariDataSource dataSource;
	
	public static Connection getDBConnection() throws Exception
	{
		if(dataSource==null)
			{
		config.setJdbcUrl("jdbc:mysql://localhost:3306/employee_management");
		config.setUsername("root");
		config.setPassword("D.arjun@14");
		
		dataSource = new HikariDataSource(config);
			}
		return dataSource.getConnection();
	}
}
