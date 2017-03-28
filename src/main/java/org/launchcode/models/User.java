package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Andrew Bell on 3/22/17.
 */
public class User {

    @NotNull
    @Size(min=5, max=15, message = "Your username must be between 5 and 15 characters long.")
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min=6, message="Password must be at least six characters long.")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;
    private int userId;
    private static int nextId = 1;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        this.userId = nextId;
        this.nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword(){
        if (this.password != null && this.verifyPassword != null) {
            if (!this.password.equals(verifyPassword)) {
                this.verifyPassword = null;
            }
        }
    }
}