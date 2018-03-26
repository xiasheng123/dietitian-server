package com.xiasheng.medical.dietitian.biz.service.impl;

import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.api.constants.NewsEditStatusEnum;
import com.xiasheng.medical.dietitian.api.dto.PushNewsDTO;
import com.xiasheng.medical.dietitian.api.service.PushNewsService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.biz.dao.PushNewsDao;
import com.xiasheng.medical.dietitian.biz.entity.PushNewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
@Service
public class PushNewsServiceImpl implements PushNewsService {

    @Autowired
    private PushNewsDao pushNewsDao;

    @Override
    public List<PushNewsDTO> getNewsList(int pageNo, int pageSize, List<NewsEditStatusEnum> editStatusEnumList) {
        List<PushNewsDTO> pushNewsDTOList = Lists.newArrayList();
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 1) {
            pageSize = 1;
        }
        int start = (pageNo - 1) * pageSize;
        List<Integer> editStatusList = Lists.newArrayList();
        for (NewsEditStatusEnum newsEditStatusEnum : editStatusEnumList) {
            editStatusList.add(newsEditStatusEnum.getValue());
        }
        List<PushNewsEntity> pushNewsEntityList = pushNewsDao.findNews(editStatusList, start, pageSize);
        for (PushNewsEntity pushNewsEntity : pushNewsEntityList) {
            PushNewsDTO pushNewsDTO = new PushNewsDTO();
            pushNewsDTO.setClickCount(pushNewsEntity.getClickCount());
            pushNewsDTO.setContentAbstract(pushNewsEntity.getContentAbstract());
            pushNewsDTO.setDetailUrl(pushNewsEntity.getDetailUrl());
            pushNewsDTO.setEditStatus(pushNewsEntity.getEditStatus());
            pushNewsDTO.setImageUrl(pushNewsEntity.getImageUrl());
            pushNewsDTO.setNewsDate(pushNewsEntity.getNewsDate());
            pushNewsDTO.setTitle(pushNewsEntity.getTitle());
            pushNewsDTO.setId(pushNewsEntity.getId());
            pushNewsDTOList.add(pushNewsDTO);
        }
        return pushNewsDTOList;
    }

    @Override
    public IResponse addNews(PushNewsDTO pushNewsDTO) {

        PushNewsEntity pushNewsEntity = new PushNewsEntity();
        pushNewsEntity.setTitle(pushNewsDTO.getTitle());
        String content = pushNewsDTO.getContent();
        //TODO 根据正文提取摘要，需要排除富文本中的非文字部分
        int subLength = 100;
        if (content.length() < 100) {
            subLength = content.length() - 2;
        }
        String contentAbstract = content.substring(0, subLength);
        pushNewsEntity.setContentAbstract(contentAbstract);
        pushNewsEntity.setNewsDate(new Date());
        pushNewsEntity.setEditStatus(pushNewsDTO.getEditStatus());
        pushNewsEntity.setDetailUrl(pushNewsDTO.getDetailUrl());
        pushNewsEntity.setImageUrl(pushNewsDTO.getImageUrl());

        pushNewsDao.insert(pushNewsEntity);
        //pushNewsDao.insertContent(pushNewsEntity.getId(), content);
        return IResponse.success("done");
    }

    @Override
    public PushNewsDTO getNewsDetail(int pushNewsId) {
        PushNewsDTO pushNewsDTO = new PushNewsDTO();
        PushNewsEntity pushNewsEntity = pushNewsDao.loadById(pushNewsId);
        if (pushNewsEntity == null) {
            return null;
        }
        pushNewsDTO.setTitle(pushNewsEntity.getTitle());
        pushNewsDTO.setNewsDate(pushNewsEntity.getNewsDate());
        pushNewsDTO.setEditStatus(pushNewsEntity.getEditStatus());
        pushNewsDTO.setClickCount(pushNewsEntity.getClickCount());
        pushNewsDTO.setContent(pushNewsEntity.getContent());
        return pushNewsDTO;
    }

    @Override
    public void addClickCount(int pushNewsId) {
        PushNewsEntity pushNewsEntity = pushNewsDao.loadById(pushNewsId);
        if (pushNewsEntity == null) {
            return;
        }
        pushNewsEntity.setClickCount(pushNewsEntity.getClickCount() + 1);
        pushNewsDao.updateNews(pushNewsEntity);
    }
}
