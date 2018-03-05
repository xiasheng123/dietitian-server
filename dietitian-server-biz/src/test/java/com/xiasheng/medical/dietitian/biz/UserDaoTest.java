package com.xiasheng.medical.dietitian.biz;

import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.biz.dao.UserDao;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by fu on 2018/3/5.
 */
public class UserDaoTest extends GenericTest {

    @Autowired
    private UserDao dao;

    @Test
    public void testInsert() {
        UserEntity entity = new UserEntity();
        entity.setPhone("13222223333");
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        UserEntity entity = dao.loadById(4);
        System.out.println(entity);

    }
}
