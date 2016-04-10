package ohtu.data_access;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {

    private List<User> users;

    public void testi(){
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        for(int i = 0; i < 100;i++){
            System.out.println("testi");
        }
        
    }
    
    
    public InMemoryUserDao() {
        users = new ArrayList<User>();
        users.add(new User("pekka", "akkep"));
    }        

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
