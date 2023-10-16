package model;
import java.io.File;
import java.sql.*;
import java.util.LinkedList;

public class Database {
	
	Connection conn = null;
	String tableName;
	
	public Database(String tableName) {
		
		this.tableName = tableName;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:sqlite:" + tableName + ".db");
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
	}
	

	public static String getDateTime() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String output = sdf.format(dt);
		
		return output;
	}
	
	public void createTable() throws SQLException {
		String createTablesql = "" +
								"CREATE TABLE  " + tableName +
								"( " +
								"Category TEXT, " +
								"Activity TEXT, " +
								"DateTime DATETIME, " +
								"DayOfWeek int, " +
								"Duration int, " +
								"Mood int " +
								"); " +
								"";
		
		Statement stmt = conn.createStatement();
		stmt.execute(createTablesql);
										
	}
	
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public LinkedList<Activity> getDatabase() throws SQLException {
		String selectSQL = "SELECT * from " + tableName;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		LinkedList<Activity> output = new LinkedList<Activity>();
		
		return createArrayList(rs);
		
	}
	
	public LinkedList<Activity> getCategory(String Category) throws SQLException {
		String selectSQL = "SELECT * from " + tableName + " WHERE Category = ?";
		PreparedStatement stmt = conn.prepareStatement(selectSQL);
		stmt.setString(1, Category);
		
		ResultSet rs = stmt.executeQuery();
		
		return createArrayList(rs);
	}
	
	public LinkedList<Activity> getMood(int mood) throws SQLException {
		String selectSQL = "SELECT * from " + tableName + " WHERE Mood = ?";
		PreparedStatement stmt = conn.prepareStatement(selectSQL);
		stmt.setInt(1, mood);
		
		ResultSet rs = stmt.executeQuery();
		
		return createArrayList(rs);
		
	}
	
	public LinkedList<Activity> getDayOfWeek(int dayOfWeek) throws SQLException {
		String selectSQL = "SELECT * from " + tableName + " WHERE DayOfWeek = ?";
		PreparedStatement stmt = conn.prepareStatement(selectSQL);
		stmt.setInt(1, dayOfWeek);
		
		ResultSet rs = stmt.executeQuery();
		

		return createArrayList(rs);
		
	}


	private LinkedList<Activity> createArrayList(ResultSet rs) {
		
		LinkedList<Activity> output = new LinkedList<Activity>();
		
		try {
			while(rs.next()) {
				Activity temp = new Activity(rs.getString("Category"), rs.getString("Activity"), rs.getString("DateTime"), rs.getInt("DayOfWeek"), rs.getInt("Duration"), rs.getInt("Mood"));
				output.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}


	public void insertActivity(Activity input) throws SQLException {
		String insertSQL = "INSERT INTO " + tableName + "(Category, Activity, DateTime, DayOfWeek, Duration, Mood) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		pstmt.setString(1, input.getCategory());
		pstmt.setString(2, input.getActivity());
		pstmt.setString(3, input.getDateTime());
		pstmt.setInt(4, input.getDayOfWeek());
		pstmt.setInt(5, input.getDuration());
		pstmt.setInt(6, input.getMood());
		pstmt.executeUpdate();
		
	}



	public void delete() throws SQLException {
		String deleteTableSQL = "DROP TABLE " + this.tableName;
		Statement stmt = conn.createStatement();
		stmt.execute(deleteTableSQL);
		stmt.close();
		conn.close();
		
		boolean result = new File(this.tableName + ".db").delete();
		
//		if (result) {
//			System.out.println("Delete successful");
//		} else {
//			System.out.println("Delete failed");
//		}
		
	}

}
