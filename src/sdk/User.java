package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class is exactly the same as the User.class from the server
 * This class represent an object of User and contains the variables that User object must have
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
     * @param id ID for an User object
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
     * @param firstName First name for an User object
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
     * @param lastName Last name for an User object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method gets username of User
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method is setting username for an object of User
     * @param username Username for an User object
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method gets password of User
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is setting password for an object of User
     * @param password Password for an User object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method gets the registration of User object
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method is setting registration date for an object of User
     * @param created Registration date for an User object
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method gets the status of User object
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method is setting status for an object of User
     * @param status Status for an User object, String status = "active" or "deleted"
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method gets email of User object
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is setting email for an object of User
     * @param email Email for an User object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method gets user type of User object
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * This method is setting user type for an object of User
     * @param type User type for an User object, int type = 0 (admin) or 1 (user)
     */
    public void setType(int type) {
        this.type = type;
    }
}
