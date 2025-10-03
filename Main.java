import java.util.*;
import src.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static SocialMediaApp app = new SocialMediaApp();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> addUser();
                case 2 -> addFollower();
                case 3 -> createPost();
                case 4 -> viewAllPosts();
                case 5 -> searchPost();
                case 6 -> viewFollowers();
                case 7 -> removeUser();
                case 8-> removeFollower();
                case 9 -> isFollower();
                case 10 -> getAllUsers();
                case 11 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }

   
    private static void printMenu() {
        System.out.println("\n=== Social Media Menu ===");
        System.out.println("1. Add User");
        System.out.println("2. Add Follower");
        System.out.println("3. Create Post");
        System.out.println("4. View All Posts");
        System.out.println("5. Search Post by Keyword");
        System.out.println("6. View Followers of a User");
        System.out.println("7. Remove User");
        System.out.println("8. Remove Follower");
        System.out.println("9. check follower");
        System.out.println("10. View All Users");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
    }

   
    private static void addUser() {
        System.out.print("Enter user ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        User user = new User(id, name);
        app.addUser(user);
        System.out.println("User added successfully!");
    }

    private static void addFollower() {
        System.out.print("Enter user ID to add follower: ");
        int userId = sc.nextInt();
        sc.nextLine();
        User u = app.searchUser(userId);
        if (u != null) {
            System.out.print("Enter follower name: ");
            String follower = sc.nextLine();
            if (u.addFollower(follower)) {
                System.out.println("Follower added!");
            } else {
                System.out.println("Follower already exists!");
            }
        } else {
            System.out.println("User not found!");
        }
    }

    private static void createPost() {
        System.out.print("Enter post content: ");
        String content = sc.nextLine();
        app.addPost(new Post(content));
        System.out.println("Post created successfully!");
    }

    private static void viewAllPosts() {
        System.out.println("All Posts:");
        for (Post p : app.getAllPosts()) {
            System.out.println("- " + p);
        }
    }

    private static void searchPost() {
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();
        if (app.searchPost(keyword)) {
            System.out.println("Post(s) found with keyword: " + keyword);
        } else {
            System.out.println("No posts found with keyword: " + keyword);
        }
    }

    private static void viewFollowers() {
        System.out.print("Enter user ID to view followers: ");
        int fId = sc.nextInt();
        sc.nextLine();
        User fUser = app.searchUser(fId);
        if (fUser != null) {
            System.out.println("Followers of " + fUser.getUsername() + ": " + fUser.getFollowers());
        } else {
            System.out.println("User not found!");
        }
    }

    private static void removeUser() {
        System.out.print("Enter user ID to remove: ");
        int removeId = sc.nextInt();
        sc.nextLine();
        if (app.removeUser(removeId)) {
            System.out.println("User removed successfully!");
        } else {
            System.out.println("User not found!");
        }
    }
    private static void removeFollower()
        {
        System.out.print("Enter user ID to remove follower: ");
        int userId = sc.nextInt();
        sc.nextLine();
        User u = app.searchUser(userId);
        if (u != null) {
            System.out.print("Enter follower name: ");
            String follower = sc.nextLine();
            if (u.removeFollower(follower)) {
                System.out.println("Follower removed!");
            } else {
                System.out.println("Follower does not exists!");
            }
        } else {
            System.out.println("User not found!");
        }
        }
    private static void isFollower()
    {
        System.out.print("Enter user ID to check follower: ");
        int userId = sc.nextInt();
        sc.nextLine();
        User u = app.searchUser(userId);
        if (u != null) {
            System.out.print("Enter follower name: ");
            String follower = sc.nextLine();
            if (u.isFollower(follower)) {
                System.out.println("is a Follower!");
            } else {
                System.out.println("not a follower");
            }
        } else {
            System.out.println("User not found!");
        }
    }
    private static void getAllUsers()
    {
        Map<Integer,User> map=app.getAllUsers();
        for(int i: map.keySet())
        {
            System.out.println("user id: "+i+", userName: "+map.get(i).getUsername());
        }
    }
}
