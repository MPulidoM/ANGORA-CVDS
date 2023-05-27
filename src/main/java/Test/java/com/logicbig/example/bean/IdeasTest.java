package Test.java.com.logicbig.example.bean;

import com.logicbig.example.bean.IdeasBean;
import com.logicbig.example.data.*;
import com.logicbig.example.faces.PrimeFacesWrapper;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.faces.context.FacesContextWrapper;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IdeasTest {
    @Mock
    private FacesContextWrapper facesContextWrapper;

    @Mock
    private PrimeFacesWrapper primeFacesWrapper;

    @Mock // Esta es la clase real
    private IdeasService ideasService;

    @InjectMocks // Esta es la clase real
    private IdeasBean IdeasBean;

    private Ideas ideas;
    private String name;

    @Test
    public void getNameOnString() {
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        assertEquals("Reciclaje a 1 pasos", ideas.getName());
    }
    @Test
    public void getStateOnString() {
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        assertEquals("Pendiente", ideas.getEstado());
    }

    @Test
    public void  getProponentOnString() {
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        assertEquals("Mpulido23", ideas.getProponent());
    }

    @Test
    public void  getKeyWordsOnString() {
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        assertEquals("Clasificacion de residuos, ambiental, verde, ecofriendly", ideas.getKeyWords());
    }

    @Test
    public void  getlikesCount() {
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        assertEquals(0, ideas.getLikesCount());
    }

    @Test
    public void  getTopicAndArea() {
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        assertEquals("Sociales", ideas.getProponentArea());
        assertEquals("Ambiental", ideas.getTopic());
    }

    @Test
    public void NotanExistsIdea() {
        when(ideasService.getIdea(name)).thenReturn(null);
        ideas = new Ideas("Reciclaje a 1 pasos","Ambiental","Campaña de nuevos metodos verdes","Mpulido23","estudiante","Clasificacion de residuos, ambiental, verde, ecofriendly","Sociales");
        ideasService.addIdeas(ideas);
        Ideas ideas1 = ideasService.getIdea("Reciclaje a 2 pasos");
        assertEquals( null, ideas1);
    }
}
