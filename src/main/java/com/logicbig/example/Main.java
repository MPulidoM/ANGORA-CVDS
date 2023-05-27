package com.logicbig.example;

import com.logicbig.example.data.Ideas;
import com.logicbig.example.data.IdeasService;
import com.logicbig.example.data.Users;
import com.logicbig.example.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;

@SpringBootApplication
public class Main{
    @Autowired
    UserService userService;
    @Autowired
    IdeasService ideasService;

    public static void main (String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean(name = "database")
    public CommandLineRunner run() {
        return args -> {
            userService.addUser(new Users("AdminAngora","Ad101Angora","Carlos Leal","Administrador","Empleado",45,"Sistemas","Adminastor.Angora@gmail.com"));
            userService.addUser(new Users("Mpulido23","lhanna.23","Mariana Pulido","Proponente","Estudiante",20,"Matematicas","mpm@gmail.com"));
            userService.addUser(new Users("AmbientalINC.ADMIN","pro.ambiental","Alberto Pardo","Cliente","Gerente de Proyectos ",39,"Deporte","ProyectosPlaneta@ambientalINC.com"));
            ideasService.addIdeas(new Ideas("Actualizacion de Software","Tecnologia","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales"));
            ideasService.addIdeas(new Ideas("Teorema ed Karatsuba","Deportes","Campaña de nuevos metodos verdes","Ad101Angora","Trabajador","para que, no lo se, amigable","Administracion"));
            ideasService.addIdeas(new Ideas("Procesos contables","Salud","Campaña de nuevos metodos verdes","AmbientalINC.ADMIN","Profesor","vida, salud, recuperacion","Matematicas"));
            ideasService.addIdeas(new Ideas("Flujo de caja Positivo","Economia","Campaña de nuevos metodos verdes","Ad101Angora","Mesero","software, hardware, elementos","Sistemas"));
            ideasService.addIdeas(new Ideas("Venta de computo","Infraestructura","Campaña de nuevos metodos verdes","Mpulido23","Filosofo","otorrinonaingologo, parangaricutirimicuaro","Sistemas"));
            ideasService.addIdeas(new Ideas("pañales","Ambiental","Campaña de nuevos pañales","Mpulido23","Urologo","niños, pañal, rojo, ecofriendly","Administracion"));
            ideasService.addIdeas(new Ideas("pañales2.0","Social","Campaña de nuevos pañales2.0","Mpulido23","Pediatra","llorone,niños, pañal, verde, ecofriendly","Sociales"));
            ideasService.addIdeas(new Ideas("computadores","Tecnología","Campaña Tecnología","Mpulido23","mecanico","mundo,tecnologia","Matematicas"));
            ideasService.addIdeas(new Ideas("Tableros","Educación","Campaña de Educación","Mpulido23","papa","niños, estudiantes","Sociales"));
            ideasService.addIdeas(new Ideas("Muebles","Infraestructura","Campaña de nuevos muebles","Mpulido23","estudiante","muebles,nuevos, verde, ecofriendly","Administracion"));
        };
    }

    @Bean
    @DependsOn({"database"})
    public ServletRegistrationBean<javax.servlet.Servlet> jsfServletRegistration(ServletContext servletContext) {
        //spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

        //registration
        ServletRegistrationBean<javax.servlet.Servlet> srb = new ServletRegistrationBean<>();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }
}