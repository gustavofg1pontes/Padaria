package org.example.api.database.config;

public class DataBaseConfig {
    private String database;
    private String user;
    private String password;
    private String host;

    public DataBaseConfig() {
    }

    public DataBaseConfig(String database, String user, String password, String host) {
        this.database = database;
        this.user = user;
        this.password = password;
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
