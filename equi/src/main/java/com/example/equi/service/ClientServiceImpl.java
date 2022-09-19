package com.example.equi.service;

import com.example.equi.model.Client;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class ClientServiceImpl  implements ClientService {

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();


    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();


    @Override
    public String create(Client client) {

//        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
//        client.setId(clientId);
//        CLIENT_REPOSITORY_MAP.put(clientId, client);
//        CLIENT_REPOSITORY_MAP.put(clientId, client);
        String test = "null";


        String SQL_INSERT = "INSERT INTO equii (NAME,AMOUNT,COST,MARKUP,WAERS) VALUES (?,?,?,?,?)";

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "password");

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1,  client.getName() );
            preparedStatement.setInt(2,  client.getAmount() );
            preparedStatement.setInt(3,  client.getCost() );
            preparedStatement.setInt(4,  client.getMarkup() );
            preparedStatement.setString(5,  client.getWaers() );

                int row = preparedStatement.executeUpdate();
                test = "success";

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                test = "error";
            } catch (Exception e) {
                e.printStackTrace();
                test = "error";
            }

        return test;
        }


//    @Override
    public String readAll() throws Exception {
//    public List<Client> readAll() {
//        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
//        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());

        String response = null;
        String sql = "SELECT name, amount, cost, markup, waers FROM equii";
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {

                ResultSet rs1 = statement.executeQuery( sql);
                while ( rs1.next() ) {
//                    RowId out = rs1.getRowId(1);
                    Integer amount = rs1.getInt("amount");
                    Integer cost = rs1.getInt("cost");
                    Integer markup  = rs1.getInt("markup");
                    String name  = rs1.getString("name");
                    String waers  = rs1.getString("waers");
                    response = String.valueOf( amount);
//                return name ;
                    response = "{\n    \"name\": \"" +  name +  "\",\n" +
                            "    \"amount\": " +  amount + ",\n" +
                            "    \"cost\": " +  cost + ",\n" +
                            "    \"waers\": \"" + waers +"\",\n" +
                            "    \"markup\": " +  cost + "\n}";
                }
            } catch (Exception e) {
                return  e.getMessage();

//            }

            }
            return response;
    }
    }
    @Override
    public String read(int id) throws Exception {
        String response = null;
        String sql = "SELECT name, amount, cost, markup, waers FROM equii " +
                "WHERE id=" + id;
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {

                ResultSet rs1 = statement.executeQuery( sql);
                while ( rs1.next() ) {
//                    RowId out = rs1.getRowId(1);
                    Integer amount = rs1.getInt("amount");
                    Integer cost = rs1.getInt("cost");
                    Integer markup  = rs1.getInt("markup");
                    String name  = rs1.getString("name");
                    String waers  = rs1.getString("waers");
                    response = String.valueOf( amount);
//                return name ;
                      response = "{\n    \"name\": \"" +  name +  "\",\n" +
                                    "    \"amount\": " +  amount + ",\n" +
                                    "    \"cost\": " +  cost + ",\n" +
                                    "    \"waers\": \"" + waers +"\",\n" +
                                    "    \"markup\": " +  cost + "\n}";
                }
            } catch (Exception e) {
//				System.err.println("Got an exception! ");
//				System.err.println(e.getMessage());
                return 		 e.getMessage();

//            }

        }
        return response;
//        return CLIENT_REPOSITORY_MAP.get(id);
        }

    }

//    @Override
//    public boolean update(Client equi, int id) {
//        return false;
//    }


    public boolean update(Client equi, int id) {
        String sql = "UPDATE equii "
                + "SET name = '" + equi.getName()
                +  "' , amount = '" + equi.getAmount()
                +  "' , waers = '" + equi.getWaers()
                +  "' , markup = '" + equi.getMarkup()
                +  "' , cost = '" + equi.getCost()
                + "' WHERE id =" + id;
//    public boolean update(Client client, int id) {
//        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
//            client.setId(id);
//            CLIENT_REPOSITORY_MAP.put(id, client);
//            return true;
//        }
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
//                return  true;
                statement.executeUpdate(sql);
                return  true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
//        return CLIENT_REPOSITORY_MAP.remove(id) != null;
        String sql = "DELETE FROM equii " +
                "WHERE id=" + id;
        try (Connection connection = getConnection()) {
			try (Statement statement = connection.createStatement()) {
//                return  true;
				statement.executeUpdate(sql);
        return  true;
        }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        @Override
    public int getCostCustomer() throws Exception {
        Integer sum = 0;
        try (Connection connection = getConnection()) {
			try (Statement statement = connection.createStatement()) {
			    ResultSet rs1 = statement.executeQuery("SELECT amount, cost, markup FROM equii");
                while ( rs1.next() ) {
                    Integer amount = rs1.getInt("amount");
                    Integer cost = rs1.getInt("cost");
                    Integer markup  = rs1.getInt("markup");
                    sum =  sum + ( amount * cost + amount * cost / 100 * markup );
                }
                			} catch (Exception e) {
//				System.err.println("Got an exception! ");
//				System.err.println(e.getMessage());
			}

		}
//        final List<Client> equi = this.readAll();
//        for (int i = 0; i < equi.size(); i++) {
//            sum =  sum + ( equi.get(i).getAmount() * equi.get(i).getCost() +
//                    equi.get(i).getAmount() * equi.get(i).getCost() / 100 * equi.get(i).getMarkup() );
//        }
        return sum;
    }



    @Override
    public int getProfit() throws Exception {
//        Integer sum = 0;
//        final List<Client> equi = this.readAll();
//        for (int i = 0; i < equi.size(); i++) {
//            sum =  sum + ( equi.get(i).getAmount() * equi.get(i).getCost()  +
//                    equi.get(i).getAmount() * equi.get(i).getCost() / 100 * equi.get(i).getMarkup() -
//                    equi.get(i).getAmount() * equi.get(i).getCost() );
//
//        }
       return this.getCostCustomer() - this.getCost();
//       return   this.getCost();
    }

    @Override
    public int getCost(){
        Integer sum = 0;
//        final List<Client> equi = this.readAll();
//        for (int i = 0; i < equi.size(); i++) {
//                sum =  sum + equi.get(i).getAmount() * equi.get(i).getCost();
//        }

        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs1 = statement.executeQuery("SELECT amount, cost FROM equii");
                while ( rs1.next() ) {
                    Integer amount = rs1.getInt("amount");
                    Integer cost = rs1.getInt("cost");
                    sum =  sum + amount * cost ;
                }
            } catch (Exception e) {
//				System.err.println("Got an exception! ");
//				System.err.println(e.getMessage());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
}