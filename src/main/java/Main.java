import dao.ProductDao;
import dao.UserDao;
import model.Product;
import model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        UserDao userDao = new UserDao();
        ProductDao productDao = new ProductDao();
        userDao.build3FirstUsers();
        productDao.build6FirstProducts();

        System.out.println("get user by ID --> " + userDao.getUserById(1L));
       //-------------------------------------------------------------------------
        List<User>users = userDao.getUserByFullName("Jonas");
        for (User user : users) {
            System.out.println("get user by full NAME --> " + user.getFullName());
        }
        //--------------------------------------------------------------------------

        List<User>usersEmail = userDao.getUsersEmail("as@");
        for (User user : usersEmail) {
            System.out.println("get user email --> " + user.getEMail());
        }
        //----------------------------------------------------------------------------
        User updatedUser = new User(2L, "Aida Asmenskaite", "aida@pastas.lt", true);
        userDao.updateUser(updatedUser);
        User user1 = new User(null, "Petras Petraitis", "petras@pastas.lt", false);
        User user2 = new User(null, "Jonas Jonaitis", "jonas@pastas.lt", false);
        userDao.createUser(user2);
        userDao.deleteUser(user1);



    }
}
