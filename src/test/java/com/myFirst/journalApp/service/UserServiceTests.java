package com.myFirst.journalApp.service;

import com.myFirst.journalApp.entity.User;
import com.myFirst.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    private @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "PRAVESH"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userRepository.findByUserName(name), "Failed for " + name);
    }


    @Test
    public void test() {
        User user = userRepository.findByUserName("PRAVESH");
        assertFalse(user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "5,4,9", //test1
//            "2,4,5"  //test2
    })
    public void test1(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }

//    @BeforeEach   -Before each test
//    @AfterEach    -After each test
//    @BeforeAll    -Before all test
//    @AfterAll     -After all test


}
