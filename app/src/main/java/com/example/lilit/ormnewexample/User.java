package com.example.lilit.ormnewexample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Lilit on 5/22/15.
 */
@DatabaseTable(tableName = "users")
public class User {

    public User() {
    }

    @DatabaseField(id = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private String username;

    @DatabaseField
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "id : " + id + " username : " + username + " password : " + password;
    }
}