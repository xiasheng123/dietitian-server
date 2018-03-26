package com.xiasheng.medical.dietitian.biz;

import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.dao.MomentDao;
import com.xiasheng.medical.dietitian.biz.entity.MomentCommentEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentPicMappingEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fu on 2018/3/27.
 */
public class MomentDaoTest extends GenericTest {

    //TODO
    @Autowired
    private MomentDao dao;

    @Test
    public void testInsert() {
        MomentEntity entity = new MomentEntity();
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {

        System.out.println(dao.loadById(1));
    }

    @Test
    public void testInsertComment() {

        MomentCommentEntity entity = new MomentCommentEntity();
        dao.insertComment(entity);
        System.out.println(entity);


    }

    @Test
    public void testInsertPic() {
        MomentPicMappingEntity entity = new MomentPicMappingEntity();
        dao.insertPic(entity);
        System.out.println(entity);

    }
    @Test
    public void testFindByUserId() {
        System.out.println(dao.findByUserId(1));

    }
    @Test
    public void testFindCommentsByMomentId() {
        System.out.println(dao.findCommentsByMomentId(1));

    }
    @Test
    public void testFindPicsByMomentId() {
        System.out.println(dao.findPicsByMomentId(1));
    }

}
