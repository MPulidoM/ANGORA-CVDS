package com.logicbig.example.bean;

import com.logicbig.example.data.UserService;
import com.logicbig.example.data.Users;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Component
@ManagedBean(name = "userBean")
public class UserBean {
    private final static String MESSAJE = "messaje";
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
    static String rol;
    private int age;
    static String area;
    private String email;

    public UserBean() {
        username = "";
        password = "";
        personalName = "";
        profile = "";
        rol = "";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        UserBean.username = username;
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
        UserBean.rol = rol;
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
        UserBean.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addUser() {
        if (userService.userExist(username)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Este usuario ya existe"));
            PrimeFaces.current().ajax().update("messages");
        } else {
            userService.addUser(new Users(username, password, personalName, profile, rol, age, area, email));
        }

    }

    public String loginUser() {
        String bandera = "#{facesContext.getExternalContext().redirect(request.getRequestURI())}";
        if (userService.userExist(username)) {
            if (userService.getUser(username).getPassword().equals(password)) {
                bandera = perfileValidation();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "CLAVE", "Clave incorrecta"));
                PrimeFaces.current().ajax().update(MESSAJE);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "USUARIO", "Usuario no valido"));
            PrimeFaces.current().ajax().update(MESSAJE);
        }
        return bandera;
    }

    public String perfileValidation() {
        String perfile = userService.getUser(username).getProfile();
        if (perfile.equals("Proponente")) {
            return "consultaPro.xhtml?faces-redirect=true";
        } else if (perfile.equals("Administrador")) {
            return "administrador.xhtml?faces-redirect=true";
        } else {
            return "consulta.xhtml?faces-redirect=true";
        }
    }

}