package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class is exactly the same as the User.class from the server
 */
import java.sql.Date;
import java.util.Scanner;

public class User {

    //creating variables
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date created;
    private String status;
    private String email;
    private int type;

    public User () {}

    //creating get and set method for all the variables, so they can be used by other classes

    /**
     * This method gets id of User
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This method is setting id for an object of User
     * @param id ID for a User object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *This method gets first name of User
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method is setting first name for an object of User
     * @param firstName First name for a User object
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method gets last name of User
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method is setting last name for an object of User
     * @param lastName Fast name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method gets username of User
     * @return
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
