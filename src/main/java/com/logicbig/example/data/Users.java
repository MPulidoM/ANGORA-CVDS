package com.logicbig.example.data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Users {

    @Id
    private String username;

    private String password;

    private String personalName;

    private String profile ;

    private String rol;

    private int age;

    private String area;

    private String email;


    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password, String personalName, String profile, String rol, int age, String area, String email) {
        this.username = username;
        this.password = password;
        this.personalName = personalName;
        this.profile = profile;
        this.rol = rol;
        this.age = age;
        this.area = area;
        this.email = email;
    }

    public Users() {
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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


    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personalName='" + personalName + '\'' +
                ", profile='" + profile + '\'' +
                ", rol='" + rol + '\'' +
                ", age=" + age +
                ", area='" + area + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
