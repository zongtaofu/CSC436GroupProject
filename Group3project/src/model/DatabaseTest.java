package model;

import java.sql.*;
import java.util.Calendar;

public class DatabaseTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database connection");
			
			try {
				deleteTables(conn);
			}
			catch(Exception igorned) {
				// Nothing because table doesn't exist
			}
			
			createTables(conn);
			
			System.out.println();
			System.out.println("Inserting data");
			
			insertActivity(conn, "Health", "Running", getDateTime(), 10, 5);
			insertActivity(conn, "Health", "Brush Teeth", getDateTime(), 2, 5);
			insertActivity(conn, "Cleaning", "Vacuum", getDateTime(), 10, 1);
			insertActivity(conn, "Health", "Running", getDateTime(), 7, 4);
			insertActivity(conn, "Health", "Running", getDateTime(), 10, 5);
			
			System.out.println("Displaying database");
			displayDatabase(conn, "Activities");
			
			System.out.println("Displaying category Health");
			displayCategory(conn, "Activities", "Health");
			
			System.out.println("Displaying category Cleaning");
			displayCategory(conn, "Activities", "Cleaning");
			
			System.out.println("Displaying mood = 5");
			displayMood(conn, "Activities", 5);
			
//			System.out.println("Displaying Sundays");
//			displayDayOfWeek(conn, "Activities", 5);
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		}

	}

	private static String getDateTime() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String output = sdf.format(dt);
		
		return output;
	}

	private static void displayDatabase(Connection conn, String tableName) throws SQLException {
		String selectSQL = "SELECT * from " + tableName;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		System.out.println("---------- " + tableName + " ----------");
		
		while(rs.next()) {
			printRecord(rs.getString("Category"), rs.getString("Activity"), rs.getString("DateTime"), rs.getInt("Duration"), rs.getInt("Mood"));
		}
		System.out.println("---------------------------------");
		
	}
	
	private static void displayCategory(Connection conn, String tableName, String Category) throws SQLException {
		String selectSQL = "SELECT * from " + tableName + " WHERE Category = ?";
		PreparedStatement stmt = conn.prepareStatement(selectSQL);
		stmt.setString(1, Category);
		
		ResultSet rs = stmt.executeQuery();
		
		System.out.println("---------- " + tableName + " ----------");
		
		while(rs.next()) {
			printRecord(rs.getString("Category"), rs.getString("Activity"), rs.getString("DateTime"), rs.getInt("Duration"), rs.getInt("Mood"));
		}
		System.out.println("---------------------------------");
		
	}
	
	private static void displayMood(Connection conn, String tableName, int mood) throws SQLException {
		String selectSQL = "SELECT * from " + tableName + " WHERE Mood = ?";
		PreparedStatement stmt = conn.prepareStatement(selectSQL);
		stmt.setInt(1, mood);
		
		ResultSet rs = stmt.executeQuery();
		
		System.out.println("---------- " + tableName + " ----------");
		
		while(rs.next()) {
			printRecord(rs.getString("Category"), rs.getString("Activity"), rs.getString("DateTime"), rs.getInt("Duration"), rs.getInt("Mood"));
		}
		System.out.println("---------------------------------");
		
	}
	
	private static void displayDayOfWeek(Connection conn, String tableName, int dayOfWeek) throws SQLException {
		String selectSQL = "select strftime('%w', DateTime) from " + tableName;
		PreparedStatement stmt = conn.prepareStatement(selectSQL);
		stmt.setInt(1, dayOfWeek);
		
		ResultSet rs = stmt.executeQuery();
		
		System.out.println("---------- " + tableName + " ----------");
		
		while(rs.next()) {
			printRecord(rs.getString("Category"), rs.getString("Activity"), rs.getString("DateTime"), rs.getInt("Duration"), rs.getInt("Mood"));
		}
		System.out.println("---------------------------------");
		
	}

	private static void printRecord(String category, String activity, String dateTime, int duration, int mood) {
		System.out.print("Category: " + category + ", ");
		System.out.print("Activity: " + activity + ", ");
		System.out.print("Date: " + dateTime + ", ");
		System.out.print("Duration: " + duration + ", ");
		System.out.print("Mood: " + mood);
		System.out.println();
		
	}

	private static void insertActivity(Connection conn, String category, String activity, String date, int duration, int mood) throws SQLException {
		String insertSQL = "INSERT INTO Activities(Category, Activity, DateTime, Duration, Mood) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		pstmt.setString(1, category);
		pstmt.setString(2, activity);
		pstmt.setString(3, date);
		pstmt.setInt(4, duration);
		pstmt.setInt(5, mood);
		pstmt.executeUpdate();
		
	}

	private static void createTables(Connection conn) throws SQLException {
		String createTablesql = "" +
								"CREATE TABLE Activities " +
								"( " +
								"Category TEXT, " +
								"Activity TEXT, " +
								"DateTime DATETIME, " +
								"Duration int, " +
								"Mood int " +
								"); " +
								"";
		
		Statement stmt = conn.createStatement();
		stmt.execute(createTablesql);
		
//		createTablesql = "" +
//				"CREATE TABLE Categories " +
//				"( " +
//				"id int, " +
//				"test2 varchar(255) " +
//				"); " +
//				"";
//		stmt = conn.createStatement();
//		stmt.execute(createTablesql);
										
		
	}

	private static void deleteTables(Connection conn) throws SQLException {
		String deleteTableSQL = "DROP TABLE Activities";
		Statement stmt = conn.createStatement();
		stmt.execute(deleteTableSQL);
		
	}

}