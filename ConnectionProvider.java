package login.submit.register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider implements MyProvider {

    static Connection con = null;

    public static Connection getCon() {
	  /*try {
		  Class.forName("org.postgresql.Driver");
		  con = DriverManager.getConnection(connectionURL,username, password);
		  System.out.println("connected1");
	  } catch(Exception e) {
		  System.out.println(e);
	  }*/
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Matteo74");
            System.out.println("Connected");
        }
        catch (SQLException e) {
            System.out.println("DatabaseConnection failure.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return con;
    }
    public static void main(String[] args) {
        getCon();
    }

}