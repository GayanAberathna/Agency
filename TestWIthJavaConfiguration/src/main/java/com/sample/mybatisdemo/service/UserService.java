package com.sample.mybatisdemo.service;

import com.sample.mybatisdemo.domain.User;
import com.sample.mybatisdemo.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService
{

    public void insertUser(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            sqlSession.commit();
        } catch(Exception e){
            System.out.println(e);
        }
        finally{
            sqlSession.close();
        }
    }

    public User getUserById(Integer userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserById(userId);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }

        finally{
            sqlSession.close();
        }
    }

    public List<User> getAllUsers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getAllUsers();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        finally{
            sqlSession.close();
        }
    }

    public void updateUser(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            sqlSession.commit();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            sqlSession.close();
        }

    }

    public void deleteUser(Integer userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(userId);
            sqlSession.commit();
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            sqlSession.close();
        }

    }

}
