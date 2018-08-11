package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {
	public ConnectToDatabase() {

	}

	public static Connection getConnect() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WebBanGiay", "postgres",
					"kid159753");
			System.out.println("Connect success");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error when you connect to database!Error is: " + e.getMessage());
		}
		return connection;
	}

	public static void main(String[] args) {
		System.out.println(getConnect());
	}

	public void excuteSql(String sql) throws Exception {
		Connection connect = getConnect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}

	public ResultSet selectData(String sql) throws Exception {
		Connection connect = getConnect();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
}
