package com.example.equi;
import java.sql.*;

public class StatementDemo {


    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }

    public static void main(String[] args) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name text"
                );
                statement.execute(sql);

//                    main2();


                ResultSet rs = statement.executeQuery("SELECT name FROM demo_table");
                while ( rs.next() ) {
                    String lastName = rs.getString("name");
                    System.out.println(lastName);
                }
                connection.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            }
        }
    private static final String SQL_INSERT = "INSERT INTO DEMO_TABLE (NAME) VALUES (?)";
    private static void main2() {

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

                preparedStatement.setString(1, "le");

                int row = preparedStatement.executeUpdate();


            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

}



