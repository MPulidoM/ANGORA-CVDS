package Test.java.com.logicbig.example.bean;

import com.logicbig.example.data.Comments;
import com.logicbig.example.data.CommentsService;
import com.logicbig.example.data.LikeService;
import com.logicbig.example.data.Likes;
import com.logicbig.example.faces.PrimeFacesWrapper;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.faces.context.FacesContextWrapper;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommentTest {
    @Mock
    private FacesContextWrapper facesContextWrapper;

    @Mock
    private PrimeFacesWrapper primeFacesWrapper;

    @Mock // Esta es la clase real
    private CommentsService commentService;


    private Comments likes;
    private long idd;
}
