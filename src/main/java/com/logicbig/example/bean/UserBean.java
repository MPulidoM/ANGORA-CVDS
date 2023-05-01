package com.logicbig.example.bean;

import com.logicbig.example.data.UserService;
import com.logicbig.example.data.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean(name = "userBean")
public class UserBean  {
    @Autowired
    private UserService userService;
    // Nombre que tengra el usuario dentro de la aplicacion y con el cual se identifica (ID)
    static String username;
    private String password;
    // Nombre real de la persona que ingresa la informacion (Jorge Useche)
    private String personalName;
    // Perfil que maneja dentro de nuestra aplicacion, de esto dependen los permisos
    private String profile;
    // Cargo que desempeña
    private String rol;
    private int age;
    private String area;
    private String email;
    private String message;

    public UserBean() {
        this.username = "";
        this.password = "";
        this.message = "";
        this.personalName = "";
        this.profile = "";
        this.rol = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public void addUser() {

       if (userService.userExist(username)){
           message = "Este usuario ya existe";
           System.out.println(userService.getUser(username));
           System.out.println(message);
       } else {
           userService.addUser(new Users(username, password, personalName, profile,rol, age, area, email));
           message = " ";
       }

    }
    public String loginUser(){
        String bandera = "#{facesContext.getExternalContext().redirect(request.getRequestURI())}" ;
        if (userService.userExist(username)) {
            if(userService.getUser(username).getPassword().equals(password)){
                bandera = perfileValidation();
                message = " ";
            }else {
                message = "clave incorrecta";
            }
        } else {
            message = "Usuario no valido";
        }

        return bandera;
    }

    public String perfileValidation (){
        String perfile = userService.getUser(username).getProfile();
        if ( perfile.equals("Proponente")) {
            return "consuPro.xhtml?faces-redirect=true";
        }
        else if (perfile.equals("Administrador")) {
            return "administrador.xhtml?faces-redirect=true";
        } else {
            return "consu.xhtml?faces-redirect=true";
        }
    }

}