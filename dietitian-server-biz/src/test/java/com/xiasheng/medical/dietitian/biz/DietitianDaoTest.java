package com.xiasheng.medical.dietitian.biz;

import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.dao.DietitianDao;
import com.xiasheng.medical.dietitian.biz.entity.DietitianEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/27.
 */
public class DietitianDaoTest extends GenericTest {

    //TODO
    @Autowired
    private DietitianDao dao;

    @Test
    public void testInsert() {

        DietitianEntity entity = new DietitianEntity();
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        System.out.println(dao.loadById(1));
    }
}
