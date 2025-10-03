package src;

import java.util.*;

public class SocialMediaApp {
    private List<Post> posts;                
    private Map<Integer, User> userProfiles; 

    public SocialMediaApp() {
        posts = new ArrayList<>();
        userProfiles = new HashMap<>();
    }

   
    public void addPost(Post post) {
        posts.add(post);
    }

    public boolean removePost(Post post) {
        return posts.remove(post);
    }

    public boolean searchPost(String keyword) {
    for (Post p : posts) {
        if (p.getContent().contains(keyword)) {
            return true;
        }
    }
    return false;
}

    public List<Post> getAllPosts() {
        return posts;
    }

    
    public void addUser(User user) {
        userProfiles.put(user.getUserId(), user);
    }

    public boolean removeUser(int userId) {
        return userProfiles.remove(userId) != null;
    }

    public User searchUser(int userId) {
        return userProfiles.get(userId);
    }

    public Map<Integer, User> getAllUsers() {
        return userProfiles;
    }
}

