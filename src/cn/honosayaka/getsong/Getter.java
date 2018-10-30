package cn.honosayaka.getsong;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Getter {
	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static Random r;
	
	public static Songbean getId() throws Exception {
		if(connection==null) {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://www.honosayaka.club:3306/Songs", "root", "123456789a");
		}
		if(prepareStatement ==null) {			
			prepareStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM songDatial WHERE nomber=?;");
		}
		if(r == null) {
			r = new Random();			
		}
		prepareStatement.setInt(1, r.nextInt(168662));
		ResultSet set = prepareStatement.executeQuery();
		while(set.next()) {
			return new Songbean(set.getString(2), set.getString(3),set.getString(4));
		}
		return null;
	}
}
