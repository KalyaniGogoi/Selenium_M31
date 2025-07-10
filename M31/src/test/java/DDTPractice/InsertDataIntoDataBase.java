package DDTPractice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {
		
		//step1:*- Register/load the mysql database
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step2:- get connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainerdetails", "root", "root");
				
				//step3:-create sql statement
				Statement state = conn.createStatement();
				String query = "insert into trainers(firstName, lastName, address) values ('Hari', 'Ram', 'Bangalore')";
				int result = state.executeUpdate(query);
				
				if(result==1)
					
				{
					System.out.println("data is created");
				}
				else
				{
					System.out.println("data not created");
				}
				conn.close();

	}

}
