import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();
    public void addUser(User user) { users.add(user); }
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) user.receive(message);
        }
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;
    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
    abstract void send(String message);
    abstract void receive(String message);
}

class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) { super(mediator, name); }
    public void send(String message) { 
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }
    public void receive(String message) { System.out.println(name + " received: " + message); }
}

public class Mediator {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();
        
        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");
        
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        
        user1.send("Hello, everyone!");
    }
}
