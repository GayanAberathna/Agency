package com.sample.mybatisdemo;

import com.sample.mybatisdemo.domain.User;
import com.sample.mybatisdemo.service.UserService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class UserServiceTest
{
    private static UserService userService;

    @BeforeClass
    public static void setup()
    {
        userService = new UserService();
    }

    @AfterClass
    public static void teardown()
    {
        userService = null;
    }

    @Test
    public void testGetUserById()
    {
        User user = userService.getUserById(1);
        Assert.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void testGetAllUsers()
    {
        List<User> users = userService.getAllUsers();
        Assert.assertNotNull(users);
        for (User user : users)
        {
            System.out.println(user);
        }

    }

    @Test
    public void testInsertUser()
    {
        User user = new User();
        user.setUserId(3);
        user.setEmailId("test_email_" +System.currentTimeMillis()+ "@gmail.com");
        user.setPassword("secret");
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");

        userService.insertUser(user);
        Assert.assertTrue(user.getUserId() != 0);
        User createdUser = userService.getUserById(user.getUserId());
        Assert.assertNotNull(createdUser);
        Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
        Assert.assertEquals(user.getPassword(), createdUser.getPassword());
        Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
        Assert.assertEquals(user.getLastName(), createdUser.getLastName());

    }

    @Test
    public void testUpdateUser()
    {
        long timestamp = System.currentTimeMillis();
        User user = userService.getUserById(3);
        user.setFirstName("TestFirstName" +timestamp);
        user.setLastName("TestLastName" +timestamp);
        userService.updateUser(user);
        User updatedUser = userService.getUserById(3);
        Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
        Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
    }

    @Test
    public void testDeleteUser()
    {
        User user = userService.getUserById(3);
        userService.deleteUser(user.getUserId());
        User deletedUser = userService.getUserById(3);
        Assert.assertNull(deletedUser);

    }
}
