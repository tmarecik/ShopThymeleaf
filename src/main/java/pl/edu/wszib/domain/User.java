package pl.edu.wszib.domain;


public class User {
    private long id;
    private String login;
    private String email;
    private int age;
    private String country;
    private boolean active;

    public User() {
    }

    public User(long id, String login, String email, int age, String country, boolean active) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.age = age;
        this.country = country;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
