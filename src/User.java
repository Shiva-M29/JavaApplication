package src;

import java.util.*;
public class User {
    private int userId;
    private String username;
    private Set<String> followers; 

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.followers = new HashSet<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean addFollower(String follower) {
        return followers.add(follower); 
    }

    public boolean removeFollower(String follower) {
        return followers.remove(follower);
    }

    public boolean isFollower(String follower) {
        return followers.contains(follower);
    }

    public Set<String> getFollowers() {
        return followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", followers=" + followers +
                '}';
    }
}
