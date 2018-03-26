package com.xiasheng.medical.dietitian.biz;

import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.entity.AdGalleryEntity;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/27.
 */
public class AdGalleryDaoTest extends GenericTest {

    @Autowired
    private AdGalleryDao dao;

    @Test
    public void testInsert() {
        AdGalleryEntity entity = new AdGalleryEntity();
        entity.setImageUrl("444343imageuudfu");
        entity.setActivateStatus(1);
        entity.setDetailUrl("detaileireoir");
        entity.setSort(1000);
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        System.out.println(dao.loadById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println(dao.findAll());
    }
}
