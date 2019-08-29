package login.submit.register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerImplementation implements ICustomer {

    static Connection con;
    static PreparedStatement ps;

    //Method to insert a customer into the databse
    @Override
    public int insertCustomer(Customer customer) {

        int status = 0;
        try {

            con = ConnectionProvider.getCon(); //Starts connection
            System.out.println("connected2");

            //Sets up database: layout, and picks data to be stores
            ps = con.prepareStatement("insert into pgagent.customer values(?,?,?)"); //SQL request
            ps.setString(3, customer.getName());
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());

            status = ps.executeUpdate(); //Executes the insertion i.e. the client's request
            System.out.println(status);
            con.close(); //Closes connection

        } catch (Exception e) {
            System.out.println(e);
        }


        return status;

    }

    @Override
    public Customer getCustomer(String username, String password) {

        Customer c = new Customer();

        try {

            con = ConnectionProvider.getCon(); // Sets up connection
            ps = con.prepareStatement("select * from pgagent.customer where username=? and password=?"); //SQL query

            //Database set up
            ps.setString(1, username);
            ps.setString(2, password);


            ResultSet rs = ps.executeQuery(); //Executes query

            while (rs.next()) {
                c.setName(rs.getString(3));
                c.setUsername(rs.getString(1));
                c.setPassword(rs.getString(2));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return c;
    }

}
