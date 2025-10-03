import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SocialMediaAppTest {

    @Test
    public void testAddUser() {
        SocialMediaApp app = new SocialMediaApp();
        User u1 = new User(1, "Alice");
        app.addUser(u1);

        assertEquals(u1, app.searchUser(1));
    }

    @Test
    public void testRemoveUser() {
        SocialMediaApp app = new SocialMediaApp();
        User u1 = new User(1, "Bob");
        app.addUser(u1);

        assertTrue(app.removeUser(1));
        assertNull(app.searchUser(1));
    }

    @Test
    public void testAddFollower() {
        User u1 = new User(1, "Charlie");
        assertTrue(u1.addFollower("David"));
        assertTrue(u1.getFollowers().contains("David"));

        
        assertFalse(u1.addFollower("David"));
    }

    @Test
    public void testCreateAndSearchPost() {
        SocialMediaApp app = new SocialMediaApp();
        Post p1 = new Post("Hello World from Shiva!");
        app.addPost(p1);

        assertTrue(app.searchPost("Shiva"));
        assertFalse(app.searchPost("Random"));
    }
}
