import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.example.DemoApplication;
import org.example.demo.User;
import org.example.demo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.server.ObjID;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes= DemoApplication.class)
public class AppTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void addUser(){
        User user = new User();
        user.setName("blake");
        user.setId(1L);
        user.setAge(18);
        userRepository.save(user);
        Optional<User> byId = userRepository.findById(1L);
        System.out.println(byId.get().toString());

    }

    @Test
    public void getUsers(){
        Optional<User> byId = userRepository.findById(1L);
        if (byId.isPresent()) {
            System.out.println(byId.get().toString());
        }else {
            System.out.println("没有用户信息");
        }
    }


}
