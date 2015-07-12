package java;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.domain.Role;
import ru.dz.labs.api.domain.Users;
import ru.dz.labs.api.service.impl.UserServiceImpl;

/**
 * Created by Айрат on 20.06.2015.
 */
public class T {

    public static SessionFactory sessionFactory;
    public static UserServiceImpl userServiceImpl;

    public static void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "lky-core.xml" }, true);
        userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
    }

    public static void main(String[] args) {
        init();
//        insertUser();
        selectUser();
    }

    public static void insertUser() {
        Users users = new Users(new Role("dev"),"testName", "testLogin", "password");
        userServiceImpl.addUser(users);
    }

    public static void selectUser() {
//        System.out.println(userService.getListAllTasksUserByFilterStatus(1l, new Status(1l)));
        System.out.println(userServiceImpl.getUserById(1L).getName());

    }

}
