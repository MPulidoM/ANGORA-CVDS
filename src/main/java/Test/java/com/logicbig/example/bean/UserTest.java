package Test.java.com.logicbig.example.bean;
import com.logicbig.example.bean.UserBean;
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

    @InjectMocks // Esta es la clase real
    private UserBean userBean;

    private Users user;
    private String username;

    @BeforeAll
    public void setup() {
        // this starts only the first time of we execute with class test
        MockitoAnnotations.initMocks(this);
        user = new Users("Mpulido21","lhanna.23","Mariana Pulido","Proponente","Estudiante",20,"Matematicas","mpm@gmail.com");

        username = user.getUsername();
        System.out.println(user);
        when(userService.getUser(username)).thenReturn(user);
        Mocks mocks = new Mocks();
        when(facesContextWrapper.getCurrentInstance()).thenReturn(mocks.facesContextMock);
        when(primeFacesWrapper.current()).thenReturn(mocks.primeFaces);
    }

    @Test
    public void checkIfTheUserAdds() {
        user = new Users("Mpulido21","lhanna.23","Mariana Pulido","Proponente","Estudiante",20,"Matematicas","mpm@gmail.com");
        System.out.println(user);

        String username = "Mpulido21";
        String password = "lhanna.23";
        String personalName = "Mariana Pulido";
        String profile = "Proponente";
        String rol = "Estudiante";
        int age = 20;
        String area = "Matematicas";
        String email = "mpm@gmail.com";
        userBean.addUser();
        System.out.println(userService.getAllUsers());
        boolean addUser = userService.userExist("Mpulido21");
        System.out.println(addUser);
        System.out.println(userService.getAllUsers());
        assertTrue(addUser);
    }


}
