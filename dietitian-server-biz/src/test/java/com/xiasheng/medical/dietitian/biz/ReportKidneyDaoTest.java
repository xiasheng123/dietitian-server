package com.xiasheng.medical.dietitian.biz;

import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.dao.ReportKidneyDao;
import com.xiasheng.medical.dietitian.biz.entity.ReportKidneyEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/27.
 */
public class ReportKidneyDaoTest extends GenericTest {
//TODO
    @Autowired
    private ReportKidneyDao dao;

    @Test
    public void testInsert() {
        ReportKidneyEntity entity = new ReportKidneyEntity();
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        System.out.println(dao.loadById(1));

    }

    @Test
    public void testFindByUserId() {
        System.out.println(dao.findByUserId(1));
    }

    @Test
    public void testFindLatestReportByUserId() {
        System.out.println(dao.findLatestReportByUserId(1));
    }
}
