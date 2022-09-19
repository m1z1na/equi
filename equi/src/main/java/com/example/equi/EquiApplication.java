package com.example.equi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class EquiApplication {
//	private static String url = "jdbc:postgresql://localhost:5432/postgres";
//	private static Connection getConnection() throws Exception {
//		Class.forName("org.postgresql.Driver");
//		String url = "jdbc:postgresql://localhost:5432/postgres";
//		String login = "postgres";
//		String password = "password";
//		return DriverManager.getConnection(url, login, password);
//	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EquiApplication.class, args);


//		try (Connection connection = getConnection()) {
//			try (Statement statement = connection.createStatement()) {
//				String sql = String.format(
//						"create table if not exists equii(%s, %s, %s, %s, %s, %s);",
//						"id serial primary key",
//						"name text",
//						"amount integer",
//						"cost integer",
//						"waers text",
//						"markup integer"
//				);
//
//
//				statement.execute(sql);
//
////				ResultSet rs1 = statement.executeQuery("SELECT name FROM equii");
////				while ( rs1.next() ) {
////					String lastName = rs1.getString("name");
////					System.out.println(lastName);
////				}
////				while ( rs1.next() ) {
////					String name = rs1.getString("name");
////					String amount = rs1.getString("amount");
////					System.out.println(name);
////					System.out.println(amount);
////				}
//
//				connection.close();
//			} catch (Exception e) {
//				System.err.println("Got an exception! ");
//				System.err.println(e.getMessage());
//			}
//
//		}
	}
}

// public class StatementDemo {
//
//
//    private static Connection getConnection() throws Exception {
//        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String login = "postgres";
//        String password = "password";
//        return DriverManager.getConnection(url, login, password);
//    }
//
//    public static void main(String[] args) throws Exception {
//        try (Connection connection = getConnection()) {
//            try (Statement statement = connection.createStatement()) {
//                String sql = String.format(
//                        "create table if not exists demo_table(%s, %s);",
//                        "id serial primary key",
//                        "name text"
//                );
//                statement.execute(sql);
//
////                                 main2();
////
//                ResultSet rs1 = statement.executeQuery("SELECT name FROM equii");
//                while ( rs1.next() ) {
//                    String lastName = rs1.getString("name");
//                    System.out.println(lastName);
//                }
//
//                ResultSet rs = statement.executeQuery("SELECT name FROM demo_table");
////                ResultSet rs1 = statement.executeQuery("SELECT name FROM equi");
////                while ( rs.next() ) {
////                    String lastName = rs.getString("name");
////                    System.out.println(lastName);
////                }
////                while ( rs1.next() ) {
////                    String name = rs1.getString("name");
////                    String amount = rs1.getString("amount");
////                    System.out.println(name);
////                    System.out.println(amount);
////                }
//                connection.close();
//            } catch (Exception e) {
//                System.err.println("Got an exception! ");
//                System.err.println(e.getMessage());
//            }
//
//            }
//        }
////    private static final String SQL_INSERT = "INSERT INTO DEMO_TABLE (NAME) VALUES (?)";
//    private static final String SQL_INSERT = "INSERT INTO equii (NAME,AMOUNT,COST,MARKUP) VALUES (?,?,?,?)";
//    private static void main2() {
//
//            try (Connection conn = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
//
////                 String SQL_INSERT = "INSERT INTO equi (NAME) VALUES (?)";
////        String SQL_INSERT = "INSERT INTO equi(name,amount,cost,waers,markup) "
////                + "VALUES(?,?,?,?,?)";
//
//
//                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
//
//                preparedStatement.setString(1,  "test" );
//            preparedStatement.setInt(2,  1 );
//            preparedStatement.setInt(3,  100 );
////            preparedStatement.setString(4,  "RUB" );
//            preparedStatement.setInt(4,  10 );
//
//                int row = preparedStatement.executeUpdate();
//
//
//            } catch (SQLException e) {
//                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//    }

//}




//public class ConnectionDemo {
//    public static void main(String[] args) {
//        // create three connections to three different databases on localhost
//        Connection conn1 = null;
//        Connection conn2 = null;
//        Connection conn3 = null;
//
//        try {
//            // Connect method #1
//            String dbURL1 = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=password";
//            conn1 = DriverManager.getConnection(dbURL1);
//            if (conn1 != null) {
//                System.out.println("Connected to database #1");
//                System.out.println(conn1.getSchema( ));
//            }
//
//            // METHOD #2
//            String dbURL2 = "jdbc:postgresql://localhost:5432/postgres";
//            String username = "postgres";
//            String password = "password";
//            conn2 = DriverManager.getConnection(dbURL2, username, password);
//            if (conn2 != null) {
//                System.out.println("Connected with connection #2");
//            }
//
//            // METHOD #3
//            String dbURL3 = "jdbc:postgresql://localhost:5432/postgres";
//            Properties properties = new Properties();
//            properties.put("user", "postgres");
//            properties.put("password", "password");
//            properties.put("defaultRowPrefetch", "20");
//            conn3 = DriverManager.getConnection(dbURL3, properties);
//
//            if (conn3 != null) {
//                System.out.println("Connected with connection #3");
//            }
//            try (var statement = conn3 .createStatement()) {
//                System.out.println( conn3 .getSchema());
////                System.out.println( conn3 .get);
////                var selection = statement.executeQuery(String.format(
////                        "select * from %s role 1"
////                )
////                );
//            } catch (SQLException ex) {
//                ex.printStackTrace();}
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (conn1 != null && !conn1.isClosed()) {
//                    conn1.close();
//                }
//                if (conn2 != null && !conn2.isClosed()) {
//                    conn2.close();
//                }
//                if (conn3 != null && !conn3.isClosed()) {
//                    conn3.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//}
