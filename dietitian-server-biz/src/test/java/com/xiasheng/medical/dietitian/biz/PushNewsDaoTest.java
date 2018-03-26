package com.xiasheng.medical.dietitian.biz;

import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.api.constants.NewsEditStatusEnum;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.dao.PushNewsDao;
import com.xiasheng.medical.dietitian.biz.entity.PushNewsEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/27.
 */
public class PushNewsDaoTest extends GenericTest {
//TODO
    @Autowired
    private PushNewsDao dao;

    @Test
    public void testInsert() {
        PushNewsEntity entity = new PushNewsEntity();
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        System.out.println(dao.loadById(1));

    }

    @Test
    public void testFindNews() {
        System.out.println(dao.findNews(Lists.newArrayList(NewsEditStatusEnum.APPROVED.getValue()),1,3));
    }

    @Test
    public void testUpdateNews() {
        PushNewsEntity entity = dao.loadById(1);
        dao.updateNews(entity);
    }
}
