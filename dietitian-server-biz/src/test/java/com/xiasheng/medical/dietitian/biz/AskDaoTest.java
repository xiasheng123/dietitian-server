package com.xiasheng.medical.dietitian.biz;

import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.GenericTest;
import com.xiasheng.medical.dietitian.api.constants.AskPostTypeEnum;
import com.xiasheng.medical.dietitian.api.constants.CensorStatusEnum;
import com.xiasheng.medical.dietitian.api.constants.UserTypeEnum;
import com.xiasheng.medical.dietitian.biz.dao.AdGalleryDao;
import com.xiasheng.medical.dietitian.biz.dao.AskDao;
import com.xiasheng.medical.dietitian.biz.entity.AskEntity;
import com.xiasheng.medical.dietitian.biz.entity.AskPostEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by fu on 2018/3/27.
 */
public class AskDaoTest extends GenericTest {

    @Autowired
    private AskDao dao;

    @Test
    public void testInsert() {

        AskEntity entity = new AskEntity();
        entity.setUserId(1);
        entity.setTitle("2342353");
        entity.setAskDate(new Date());
        entity.setCensorStatus(1);
        entity.setLikeCount(0);
        entity.setSolvedStatus(0);
        dao.insert(entity);
        System.out.println(entity);
    }

    @Test
    public void testLoadById() {
        System.out.println(dao.loadById(1));
    }

    @Test
    public void testInsertAskPost() {
        AskPostEntity entity = new AskPostEntity();
        entity.setUserType(UserTypeEnum.DIETITIAN.getValue());
        entity.setPostType(AskPostTypeEnum.ANSWER.getValue());
        entity.setRank(2);
        entity.setContent("dakhdkjhfkjadf");
        entity.setAskId(1);
        entity.setUserId(2);
        dao.insertAskPost(entity);
        System.out.println(entity);
    }

    @Test
    public void testFindByFuzzyTitle() {
        //TODO 未通过
        System.out.println(dao.findByFuzzyTitle("he"));

    }

    @Test
    public void testFindByIds() {
        System.out.println(dao.findByIds(Lists.newArrayList(1,2)));

    }
    @Test
    public void testFindByUserId() {
        System.out.println(dao.findByUserId(1));

    }
    @Test
    public void testFindByUserIdAndType() {
        System.out.println(dao.findByUserIdAndType(2, UserTypeEnum.DIETITIAN.getValue()));

    }
    @Test
    public void testGetAskPost() {
        System.out.println(dao.getAskPost(1, 0,4, Lists.newArrayList(CensorStatusEnum.APPROVED.getValue())));

    }
    @Test
    public void testGetRankCount() {
        System.out.println(dao.getRankCount(1));
    }
    @Test
    public void testUpdateLikeCount() {
        dao.updateLikeCount(1,10);
    }
    @Test
    public void testUpdateSolvedStatus() {
        dao.updateSolvedStatus(1, 1);
    }
}
