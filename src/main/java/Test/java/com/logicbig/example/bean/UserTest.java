package Test.java.com.logicbig.example.bean;
import com.logicbig.example.bean.UserBean;
import com.logicbig.example.data.UserRepository;
import com.logicbig.example.data.UserService;

import com.logicbig.example.data.Users;
import com.logicbig.example.faces.PrimeFacesWrapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.faces.context.FacesContextWrapper;


import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserTest {
    @Mock
    private FacesContextWrapper facesContextWrapper;

    @Mock
    private PrimeFacesWrapper primeFacesWrapper;

    @Mock // Esta es la clase real
    private UserService userService;
    private UserRepository userRepository;

    @InjectMocks // Esta es la clase real
    private UserBean userBean;

    private Users user;
    private String username;

    @Test
    public void getUsernameOnString() {
        user = new Users("Mpulido21", "lhanna.23", "Mariana Pulido", "Proponente", "Estudiante", 20, "Matematicas", "mpm@gmail.com");
        assertEquals("Mpulido21", user.getUsername());
    }
    @Test
    public void getProfileOnString() {
        user = new Users("Mpulido21", "lhanna.23", "Mariana Pulido", "Proponente", "Estudiante", 20, "Matematicas", "mpm@gmail.com");
        assertEquals("Proponente", user.getProfile());
    }

    @Test
    public void UpdateUserUsername() {
        user = new Users("Mpulido21", "lhanna.23", "Mariana Pulido", "Proponente", "Estudiante", 20, "Matematicas", "mpm@gmail.com");
        user.setUsername("Mpulido5");
        assertEquals( "Mpulido5", user.getUsername());
    }

    @Test
    public void UpdateUserPassword() {
        user = new Users("Mpulido21", "lhanna.23", "Mariana Pulido", "Proponente", "Estudiante", 20, "Matematicas", "mpm@gmail.com");
        user.setPassword("junior10");
        assertEquals( "junior10", user.getPassword());
    }
    @Test
    public void AddExistsUser() {
        when(userService.userExist("Mpulido21")).thenReturn(true);
        user = new Users("Mpulido21", "lhanna.23", "Mariana Pulido", "Proponente", "Estudiante", 20, "Matematicas", "mpm@gmail.com");
        userService.addUser(user);
        boolean useradd = userService.userExist("Mpulido21");
        assertEquals( true, useradd);
    }
    @Test
    public void UserDontExists() {
        when(userService.userExist("Mpulido2")).thenReturn(false);
        user = new Users("Mpulido21", "lhanna.23", "Mariana Pulido", "Proponente", "Estudiante", 20, "Matematicas", "mpm@gmail.com");
        userService.addUser(user);
        boolean useradd = userService.userExist("Mpulido2");
        assertEquals( false, useradd);
    }
}
