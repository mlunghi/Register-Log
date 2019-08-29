package az.eurodesign.testingpostgres.database;

import login.submit.register.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static PreparedStatement ps;
    private static int status;

    public static void testing() {
        Customer customer = new Customer();
        customer.setUsername("Samir");
        customer.setPassword("somepass");
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Matteo74")) {
            System.out.println("Connected");
            ps = con.prepareStatement("insert into pgagent.customer values(?,?)"); //SQL request
            //ps.setString(1, customer.getName());
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());

            status = ps.executeUpdate(); //Executes the insertion i.e. the client's request
            con.close(); //Closes connection
        } catch (SQLException e) {
            System.out.println("DatabaseConnection failure.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testing();

    }

}
