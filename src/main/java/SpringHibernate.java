
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHibernate {

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/java/beans.xml");

        UserDao dao = (UserDao) context.getBean("userDaoImpl");
        User userTest = new User();
        userTest.setEmail("Aya@ay7aga");
        userTest.setFirstName("Ayaaaa");
        userTest.setGoldenCoins(1200);
        userTest.setPassword("password");
        userTest.setPhone("0111444444");
        userTest.setLastName("Ashraaaaf");
        userTest.setSilverCoins(1303400);

//        dao.makePersistent(user);
//        User user = dao.getUserByEmail("shall@gmail.com");
//        System.out.println(dao.findAll().size());
//        System.out.println("Last Name: " + user.getLastName());
//        dao.transferCoinsToUser("silver", 1000, "Aya@ay7aga", "shall@gmail.com");
    }

}
