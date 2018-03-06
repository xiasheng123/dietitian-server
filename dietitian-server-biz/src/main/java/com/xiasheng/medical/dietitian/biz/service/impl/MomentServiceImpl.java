package com.xiasheng.medical.dietitian.biz.service.impl;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.api.dto.MomentCommentDTO;
import com.xiasheng.medical.dietitian.api.dto.MomentDTO;
import com.xiasheng.medical.dietitian.api.service.MomentService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.biz.dao.DietitianDao;
import com.xiasheng.medical.dietitian.biz.dao.MomentDao;
import com.xiasheng.medical.dietitian.biz.entity.DietitianEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentCommentEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentEntity;
import com.xiasheng.medical.dietitian.biz.entity.MomentPicMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
@Service
public class MomentServiceImpl implements MomentService {

    @Autowired
    private MomentDao momentDao;

    @Autowired
    private DietitianDao dietitianDao;

    @Override
    public List<MomentDTO> getMoments(int userId) {
        List<MomentDTO> momentDTOList = Lists.newArrayList();
        List<MomentEntity> momentEntityList = momentDao.findByUserId(userId);
        //TODO 检查
        for (MomentEntity momentEntity : momentEntityList) {
            MomentDTO momentDTO = new MomentDTO();
            momentDTO.setUserId(momentEntity.getUserId());
            momentDTO.setCategoryId(momentEntity.getCategoryId());
            momentDTO.setContent(momentEntity.getContent());

            List<MomentCommentEntity> momentCommentEntityList = momentDao.findCommentsByMomentId(momentEntity.getId());
            List<MomentCommentDTO> momentCommentDTOList = Lists.newArrayList();
            for (MomentCommentEntity momentCommentEntity : momentCommentEntityList) {
                MomentCommentDTO momentCommentDTO = new MomentCommentDTO();
                momentCommentDTO.setDietitianId(momentCommentEntity.getDietitianId());
                DietitianEntity dietitianEntity = dietitianDao.loadById(momentCommentEntity.getDietitianId());
                momentCommentDTO.setDietitianName(dietitianEntity.getRealName());
                momentCommentDTO.setDietitianTitle(dietitianEntity.getTitle());
                momentCommentDTO.setContent(momentCommentEntity.getContent());
                momentCommentDTOList.add(momentCommentDTO);
            }
            List<MomentPicMappingEntity> momentPicMappingEntityList = momentDao.findPicsByMomentId(momentEntity.getId());
            List<String> thumbnailUrls = Lists.newArrayList();
            List<String> imageUrls = Lists.newArrayList();
            for (MomentPicMappingEntity momentPicMappingEntity : momentPicMappingEntityList) {
                thumbnailUrls.add(momentPicMappingEntity.getThumbnailUrl());
                imageUrls.add(momentPicMappingEntity.getImageUrl());
            }
            momentDTO.setComments(momentCommentDTOList);
            momentDTO.setThumbnailUrls(thumbnailUrls);
            momentDTO.setImageUrls(imageUrls);
            momentDTOList.add(momentDTO);
        }
        return  momentDTOList;
    }

    @Override
    public IResponse addMoment(MomentDTO momentDTO) {
        MomentEntity momentEntity = new MomentEntity();
        momentEntity.setUserId(momentDTO.getUserId());
        momentEntity.setCategoryId(momentDTO.getCategoryId());
        momentEntity.setContent(momentDTO.getContent());
        momentDao.insert(momentEntity);
        List<String> thumbnailUrls = momentDTO.getThumbnailUrls();
        List<String> imageUrls = momentDTO.getImageUrls();
        for (int i = 0; i < thumbnailUrls.size(); i++) {
            MomentPicMappingEntity momentPicMappingEntity = new MomentPicMappingEntity();
            momentPicMappingEntity.setImageUrl(imageUrls.get(i));
            momentPicMappingEntity.setThumbnailUrl(thumbnailUrls.get(i));
            momentPicMappingEntity.setMomentId(momentEntity.getId());
            momentDao.insertPic(momentPicMappingEntity);
        }
        return IResponse.success("done");
    }

    @Override
    public IResponse addComment(int momentId, int dietitianId, String content) {
        MomentEntity momentEntity = momentDao.loadById(momentId);
        if (momentEntity == null) {
            return IResponse.fail("moment不存在");
        }
        DietitianEntity dietitianEntity = dietitianDao.loadById(dietitianId);
        if (dietitianEntity == null) {
            return IResponse.fail("营养师不存在");
        }
        MomentCommentEntity momentCommentEntity = new MomentCommentEntity();
        momentCommentEntity.setMomentId(momentId);
        momentCommentEntity.setDietitianId(dietitianId);
        momentCommentEntity.setContent(content);
        momentDao.insertComment(momentCommentEntity);
        return IResponse.success("评论成功");
    }
}
