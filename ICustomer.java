package login.submit.register;

public interface ICustomer {

    public int insertCustomer(Customer customer); //Method to insert a customer into the database
    public Customer getCustomer(String username, String password); //Method to fetch a customer from database


}