package models;

public class User {
    private int id;
    private String username;
    private String password;
    private String role; // "TENANT" or "LANDLORD"

    // Constructor
    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {} // Empty constructor (needed by DAO when mapping from DB)

    // Getters
    public int getId()           { return id; }
    public String getUsername()  { return username; }
    public String getPassword()  { return password; }
    public String getRole()      { return role; }

    // Setters
    public void setId(int id)             { this.id = id; }
    public void setUsername(String u)     { this.username = u; }
    public void setPassword(String p)     { this.password = p; }
    public void setRole(String r)         { this.role = r; }
}
