package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import model.Activity;
import model.Database;

class DatabaseTest {

	@Test
	void testCreateDatabase() {
		Database test = new Database("Test1");
		try {
			test.createTable();
		} catch (SQLException e) {
			fail("Unable to create database");
			e.printStackTrace();
		}
		
		try {
			test.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testInsertActivity() {
		Activity test1 = new Activity("Health", "Workout", "2023-10-15 04:44:44", 1, 1, 1);
		Activity test2 = new Activity("Hygine", "Brush Teeth", "2023-12-07 09:27:39", 2, 2, 2);
		Activity test3 = new Activity("Gardening", "Water plants", "2023-09-19 12:03:24", 1, 1, 3);
		Activity test4 = new Activity("Gardening", "Trim plants", "2023-01-01 00:00:01", 2, 2, 4);
		Activity test5 = new Activity("Health", "Workout", "2023-10-14 03:41:18", 1, 1, 1);
		Activity test6 = new Activity("Hygine", "Brush Teeth", "2023-10-14 04:17:28", 2, 2, 2);
		Activity test7 = new Activity("Gardening", "Water plants", "2023-10-15 12:57:12", 1, 1, 3);
		Activity test8 = new Activity("Gardening", "Trim plants", "2023-10-15 08:30:12", 2, 2, 4);
		Activity test9 = new Activity("Health", "Workout", "2023-10-12 09:43:54", 1, 1, 1);
		Activity test10 = new Activity("Health", "Workout", "2023-10-11 11:43:12", 1, 1, 1);
		Activity test11 = new Activity("Health", "Workout", "2023-10-10 10:02:07", 1, 1, 1);
		Activity test12 = new Activity("Hygine", "Brush Teeth", "2023-10-13 07:36:53", 2, 2, 2);
		Activity test13 = new Activity("Gardening", "Water plants", "2023-10-14 09:09:09", 1, 1, 3);
		Activity test14 = new Activity("Gardening", "Trim plants", "2023-10-10 13:36:02", 2, 2, 4);
		Activity test15 = new Activity("Health", "Workout", "2023-10-09 16:29:14", 1, 1, 1);
		Activity test16 = new Activity("Hygine", "Brush Teeth", "2023-10-08 08:08:08", 2, 2, 2);
		Activity test17 = new Activity("Gardening", "Water plants", "2023-10-09 06:26:42", 1, 1, 3);
		Activity test18 = new Activity("Gardening", "Trim plants", "2023-10-13 20:53:59", 2, 2, 4);
		Activity test19 = new Activity("Gardening", "Water plants", "2023-10-15 13:13:13", 1, 1, 3);
		Activity test20 = new Activity("Gardening", "Trim plants", "2023-10-15 14:14:14", 2, 2, 4);
		
		Database test = new Database("Test2");
		LinkedList<Activity> activities = null;
		try {
			test.createTable();
			
			
		} catch (SQLException e) {
			fail("Unable to create database");
			e.printStackTrace();
		}
		
		try {
			test.insertActivity(test1);
			test.insertActivity(test2);
			test.insertActivity(test3);
			test.insertActivity(test4);
			test.insertActivity(test5);
			test.insertActivity(test6);
			test.insertActivity(test7);
			test.insertActivity(test8);
			test.insertActivity(test9);
			test.insertActivity(test10);
			test.insertActivity(test11);
			test.insertActivity(test12);
			test.insertActivity(test13);
			test.insertActivity(test14);
			test.insertActivity(test15);
			test.insertActivity(test16);
			test.insertActivity(test17);
			test.insertActivity(test18);
			test.insertActivity(test19);
			test.insertActivity(test20);
		} catch (SQLException e) {
			fail("Unable to insert into database");
			e.printStackTrace();
		}
		
		
		try {
			activities = test.getDatabase();
		} catch (SQLException e) {
			fail("Unable to get activities from database");
			e.printStackTrace();
		}
		
		
		
		for (Activity a : activities) {
			System.out.println(a);
		}
		
		try {
			test.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testCategory() {
		Activity test1 = new Activity("Health", "Workout", "2023-10-15 04:44:44", 0, 1, 1);
		Activity test2 = new Activity("Hygine", "Brush Teeth", "2023-12-07 09:27:39", 4, 2, 2);
		Activity test3 = new Activity("Gardening", "Water plants", "2023-09-19 12:03:24", 2, 1, 3);
		Activity test4 = new Activity("Gardening", "Trim plants", "2023-01-01 00:00:01", 0, 2, 4);
		Activity test5 = new Activity("Health", "Workout", "2023-10-14 03:41:18", 6, 1, 1);
		Activity test6 = new Activity("Hygine", "Brush Teeth", "2023-10-14 04:17:28", 6, 2, 2);
		Activity test7 = new Activity("Gardening", "Water plants", "2023-10-15 12:57:12", 0, 1, 3);
		Activity test8 = new Activity("Gardening", "Trim plants", "2023-10-15 08:30:12", 0, 2, 4);
		Activity test9 = new Activity("Health", "Workout", "2023-10-12 09:43:54", 4, 1, 1);
		Activity test10 = new Activity("Health", "Workout", "2023-10-11 11:43:12", 3, 1, 1);
		Activity test11 = new Activity("Health", "Workout", "2023-10-10 10:02:07", 2, 1, 1);
		Activity test12 = new Activity("Hygine", "Brush Teeth", "2023-10-13 07:36:53", 5, 2, 2);
		Activity test13 = new Activity("Gardening", "Water plants", "2023-10-14 09:09:09", 6, 1, 3);
		Activity test14 = new Activity("Gardening", "Trim plants", "2023-10-10 13:36:02", 2, 2, 4);
		Activity test15 = new Activity("Health", "Workout", "2023-10-09 16:29:14", 1, 1, 1);
		Activity test16 = new Activity("Hygine", "Brush Teeth", "2023-10-08 08:08:08", 0, 2, 2);
		Activity test17 = new Activity("Gardening", "Water plants", "2023-10-09 06:26:42", 1, 1, 3);
		Activity test18 = new Activity("Gardening", "Trim plants", "2023-10-13 20:53:59", 5, 2, 4);
		Activity test19 = new Activity("Gardening", "Water plants", "2023-10-15 13:13:13", 0, 1, 3);
		Activity test20 = new Activity("Gardening", "Trim plants", "2023-10-15 14:14:14", 0, 2, 4);
		
		Database test = new Database("Test2");
		LinkedList<Activity> activities = null;
		try {
			test.createTable();
			
			
		} catch (SQLException e) {
			fail("Unable to create database");
			e.printStackTrace();
		}
		
		try {
			test.insertActivity(test1);
			test.insertActivity(test2);
			test.insertActivity(test3);
			test.insertActivity(test4);
			test.insertActivity(test5);
			test.insertActivity(test6);
			test.insertActivity(test7);
			test.insertActivity(test8);
			test.insertActivity(test9);
			test.insertActivity(test10);
			test.insertActivity(test11);
			test.insertActivity(test12);
			test.insertActivity(test13);
			test.insertActivity(test14);
			test.insertActivity(test15);
			test.insertActivity(test16);
			test.insertActivity(test17);
			test.insertActivity(test18);
			test.insertActivity(test19);
			test.insertActivity(test20);
		} catch (SQLException e) {
			fail("Unable to insert into database");
			e.printStackTrace();
		}
		
		
		try {
			activities = test.getCategory("Gardening");
		} catch (SQLException e) {
			fail("Unable to get activities from database");
			e.printStackTrace();
		}
		
		
		
		for (Activity a : activities) {
			System.out.println(a);
		}
		
		try {
			test.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testMood() {
		Activity test1 = new Activity("Health", "Workout", "2023-10-15 04:44:44", 0, 1, 1);
		Activity test2 = new Activity("Hygine", "Brush Teeth", "2023-12-07 09:27:39", 4, 2, 2);
		Activity test3 = new Activity("Gardening", "Water plants", "2023-09-19 12:03:24", 2, 1, 3);
		Activity test4 = new Activity("Gardening", "Trim plants", "2023-01-01 00:00:01", 0, 2, 4);
		Activity test5 = new Activity("Health", "Workout", "2023-10-14 03:41:18", 6, 1, 1);
		Activity test6 = new Activity("Hygine", "Brush Teeth", "2023-10-14 04:17:28", 6, 2, 2);
		Activity test7 = new Activity("Gardening", "Water plants", "2023-10-15 12:57:12", 0, 1, 3);
		Activity test8 = new Activity("Gardening", "Trim plants", "2023-10-15 08:30:12", 0, 2, 4);
		Activity test9 = new Activity("Health", "Workout", "2023-10-12 09:43:54", 4, 1, 1);
		Activity test10 = new Activity("Health", "Workout", "2023-10-11 11:43:12", 3, 1, 1);
		Activity test11 = new Activity("Health", "Workout", "2023-10-10 10:02:07", 2, 1, 1);
		Activity test12 = new Activity("Hygine", "Brush Teeth", "2023-10-13 07:36:53", 5, 2, 2);
		Activity test13 = new Activity("Gardening", "Water plants", "2023-10-14 09:09:09", 6, 1, 3);
		Activity test14 = new Activity("Gardening", "Trim plants", "2023-10-10 13:36:02", 2, 2, 4);
		Activity test15 = new Activity("Health", "Workout", "2023-10-09 16:29:14", 1, 1, 1);
		Activity test16 = new Activity("Hygine", "Brush Teeth", "2023-10-08 08:08:08", 0, 2, 2);
		Activity test17 = new Activity("Gardening", "Water plants", "2023-10-09 06:26:42", 1, 1, 3);
		Activity test18 = new Activity("Gardening", "Trim plants", "2023-10-13 20:53:59", 5, 2, 4);
		Activity test19 = new Activity("Gardening", "Water plants", "2023-10-15 13:13:13", 0, 1, 3);
		Activity test20 = new Activity("Gardening", "Trim plants", "2023-10-15 14:14:14", 0, 2, 4);
		
		Database test = new Database("Test2");
		LinkedList<Activity> activities = null;
		try {
			test.createTable();
			
			
		} catch (SQLException e) {
			fail("Unable to create database");
			e.printStackTrace();
		}
		
		try {
			test.insertActivity(test1);
			test.insertActivity(test2);
			test.insertActivity(test3);
			test.insertActivity(test4);
			test.insertActivity(test5);
			test.insertActivity(test6);
			test.insertActivity(test7);
			test.insertActivity(test8);
			test.insertActivity(test9);
			test.insertActivity(test10);
			test.insertActivity(test11);
			test.insertActivity(test12);
			test.insertActivity(test13);
			test.insertActivity(test14);
			test.insertActivity(test15);
			test.insertActivity(test16);
			test.insertActivity(test17);
			test.insertActivity(test18);
			test.insertActivity(test19);
			test.insertActivity(test20);
		} catch (SQLException e) {
			fail("Unable to insert into database");
			e.printStackTrace();
		}
		
		
		try {
			activities = test.getMood(3);
		} catch (SQLException e) {
			fail("Unable to get activities from database");
			e.printStackTrace();
		}
		
		
		
		for (Activity a : activities) {
			System.out.println(a);
		}
		
		try {
			test.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void testDayOfWeek() {
		Activity test1 = new Activity("Health", "Workout", "2023-10-15 04:44:44", 0, 1, 1);
		Activity test2 = new Activity("Hygine", "Brush Teeth", "2023-12-07 09:27:39", 4, 2, 2);
		Activity test3 = new Activity("Gardening", "Water plants", "2023-09-19 12:03:24", 2, 1, 3);
		Activity test4 = new Activity("Gardening", "Trim plants", "2023-01-01 00:00:01", 0, 2, 4);
		Activity test5 = new Activity("Health", "Workout", "2023-10-14 03:41:18", 6, 1, 1);
		Activity test6 = new Activity("Hygine", "Brush Teeth", "2023-10-14 04:17:28", 6, 2, 2);
		Activity test7 = new Activity("Gardening", "Water plants", "2023-10-15 12:57:12", 0, 1, 3);
		Activity test8 = new Activity("Gardening", "Trim plants", "2023-10-15 08:30:12", 0, 2, 4);
		Activity test9 = new Activity("Health", "Workout", "2023-10-12 09:43:54", 4, 1, 1);
		Activity test10 = new Activity("Health", "Workout", "2023-10-11 11:43:12", 3, 1, 1);
		Activity test11 = new Activity("Health", "Workout", "2023-10-10 10:02:07", 2, 1, 1);
		Activity test12 = new Activity("Hygine", "Brush Teeth", "2023-10-13 07:36:53", 5, 2, 2);
		Activity test13 = new Activity("Gardening", "Water plants", "2023-10-14 09:09:09", 6, 1, 3);
		Activity test14 = new Activity("Gardening", "Trim plants", "2023-10-10 13:36:02", 2, 2, 4);
		Activity test15 = new Activity("Health", "Workout", "2023-10-09 16:29:14", 1, 1, 1);
		Activity test16 = new Activity("Hygine", "Brush Teeth", "2023-10-08 08:08:08", 0, 2, 2);
		Activity test17 = new Activity("Gardening", "Water plants", "2023-10-09 06:26:42", 1, 1, 3);
		Activity test18 = new Activity("Gardening", "Trim plants", "2023-10-13 20:53:59", 5, 2, 4);
		Activity test19 = new Activity("Gardening", "Water plants", "2023-10-15 13:13:13", 0, 1, 3);
		Activity test20 = new Activity("Gardening", "Trim plants", "2023-10-15 14:14:14", 0, 2, 4);
		
		Database test = new Database("Test2");
		LinkedList<Activity> activities = null;
		try {
			test.createTable();
			
			
		} catch (SQLException e) {
			fail("Unable to create database");
			e.printStackTrace();
		}
		
		try {
			test.insertActivity(test1);
			test.insertActivity(test2);
			test.insertActivity(test3);
			test.insertActivity(test4);
			test.insertActivity(test5);
			test.insertActivity(test6);
			test.insertActivity(test7);
			test.insertActivity(test8);
			test.insertActivity(test9);
			test.insertActivity(test10);
			test.insertActivity(test11);
			test.insertActivity(test12);
			test.insertActivity(test13);
			test.insertActivity(test14);
			test.insertActivity(test15);
			test.insertActivity(test16);
			test.insertActivity(test17);
			test.insertActivity(test18);
			test.insertActivity(test19);
			test.insertActivity(test20);
		} catch (SQLException e) {
			fail("Unable to insert into database");
			e.printStackTrace();
		}
		
		
		try {
			activities = test.getDayOfWeek(0);
			System.out.println("Printing Sunday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
			
			activities = test.getDayOfWeek(1);
			System.out.println("Printing Monday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
			
			activities = test.getDayOfWeek(2);
			System.out.println("Printing Tuesday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
			
			activities = test.getDayOfWeek(3);
			System.out.println("Printing Wednesday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
			
			activities = test.getDayOfWeek(4);
			System.out.println("Printing Thursday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
			
			activities = test.getDayOfWeek(5);
			System.out.println("Printing Friday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
			
			activities = test.getDayOfWeek(6);
			System.out.println("Printing Saturday activities:");
			for (Activity a : activities) {
				System.out.println(a);
			}
		} catch (SQLException e) {
			fail("Unable to get activities from database");
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			test.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
