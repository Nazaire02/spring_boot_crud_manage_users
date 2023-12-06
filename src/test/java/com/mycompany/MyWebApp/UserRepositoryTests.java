package com.mycompany.MyWebApp;

import com.mycompany.MyWebApp.user.User;
import com.mycompany.MyWebApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("manda@gmail.com");
        user.setFirstname("Toure");
        user.setLastname("Ju");
        user.setPassword("RRRRR");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();

        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void updateTest(){
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        System.out.println(user);

        user.setPassword("QWERTY");
        repo.save(user);

        User updatedUser = repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("QWERTY");

    }

    @Test
    public void testDelete() {
        Integer userId = 4;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }

    @Test
    public void testGet() {
        Integer userId = 4;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
}
