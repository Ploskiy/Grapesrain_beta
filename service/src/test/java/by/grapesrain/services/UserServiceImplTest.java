package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import by.grapesrain.dao.DepartamentDao;
import by.grapesrain.dao.RoleDao;
import by.grapesrain.dao.UserDao;
import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Role;
import by.grapesrain.entitys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alexandr on 17.07.2017.
 */
public class UserServiceImplTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartamentService departamentService;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void save(){
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        User findUser = userService.allUsers().get(0);
        assertEquals(findUser, user);
    }

    @Test
    public void allUsers(){
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Role role = new Role("User");
        roleDao.save(role);
        userService.save(user);

        User findUser = userService.allUsers().get(0);
        assertNotNull(findUser);
    }

    @Test
    public void getDepartamentBylogin(){
        User user = new User("asd", "qwe", "zxc", "123", "qwe@awde.df");
        Departament departament = new Departament("test");
        departamentService.save(departament);
        Role role = new Role("User");
        roleDao.save(role);
        user.setDepartament(departamentService.allDepartaments().get(0));
        userService.save(user);

        Departament findDepartament = departamentService.findById(userService.getDepartamentBylogin("zxc"));
        assertEquals(findDepartament, departament);
    }
}