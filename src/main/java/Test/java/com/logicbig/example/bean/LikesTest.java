package Test.java.com.logicbig.example.bean;

import com.logicbig.example.bean.UserBean;
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
public class LikesTest {
    @Mock
    private FacesContextWrapper facesContextWrapper;

    @Mock
    private PrimeFacesWrapper primeFacesWrapper;

    @Mock // Esta es la clase real
    private LikeService likeService;


    private Likes likes;
    private long idd;

    @Test
    public void getIddOnLikes() {
        likes = new Likes("Depre-Ansie", "Mpulido4");
        assertEquals(0, likes.getIdd());
    }

    @Test
    public void getNameIdea() {
        likes = new Likes("Depre-Ansie", "Mpulido4");
        assertEquals("Depre-Ansie", likes.getNameIdea());
    }

    @Test
    public void getAutorLikeUsernam() {
        likes = new Likes("Depre-Ansie", "Mpulido4");
        assertEquals("Mpulido4", likes.getUsername());
    }

    @Test
    public void LikesCount() {
        when(likeService.countLikesByIdea("Depre-Ansie")).thenReturn(0);
        likes = new Likes("Depre-Ansie", "Mpulido4");
        likeService.countLikesByIdea("Depre-Ansie");
        assertEquals( 0,  likeService.countLikesByIdea("Depre-Ansie"));
    }
}

