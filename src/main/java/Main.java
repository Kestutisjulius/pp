import dao.Dao;
import model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        Dao dao = new Dao();
        User user1 = new User(null, "Petras Petraitis", "petras@pastas.lt", false);
        User user2 = new User(null, "Jonas Jonaitis", "jonas@pastas.lt", false);
        User user3 = new User(null, "Vardenis Pavardenis", "vardenis@pastas.lt", true);

        System.out.println("new USER to DB...");
        dao.createUser(user1);
        dao.createUser(user2);
        dao.createUser(user3);



       List<User> userList = dao.getUsersEmail();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //fghdfgjfgjsfghj
}
