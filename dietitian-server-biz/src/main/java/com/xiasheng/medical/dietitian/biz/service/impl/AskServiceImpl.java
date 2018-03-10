package com.xiasheng.medical.dietitian.biz.service.impl;

import com.google.common.collect.Lists;
import com.xiasheng.medical.dietitian.api.constants.AskPostTypeEnum;
import com.xiasheng.medical.dietitian.api.constants.CensorStatusEnum;
import com.xiasheng.medical.dietitian.api.constants.UserTypeEnum;
import com.xiasheng.medical.dietitian.api.dto.AskListDTO;
import com.xiasheng.medical.dietitian.api.dto.AskPostDTO;
import com.xiasheng.medical.dietitian.api.service.AskService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.biz.dao.AskDao;
import com.xiasheng.medical.dietitian.biz.dao.DietitianDao;
import com.xiasheng.medical.dietitian.biz.dao.UserDao;
import com.xiasheng.medical.dietitian.biz.entity.AskEntity;
import com.xiasheng.medical.dietitian.biz.entity.AskPostEntity;
import com.xiasheng.medical.dietitian.biz.entity.DietitianEntity;
import com.xiasheng.medical.dietitian.biz.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by fu on 2018/3/7.
 */
@Service
public class AskServiceImpl implements AskService {

    @Autowired
    private AskDao askDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DietitianDao dietitianDao;

    @Override
    public List<AskListDTO> getAskList(int pageNo, int pageSize, List<CensorStatusEnum> censorStatusEnumList) {
        return null;
    }

    @Override
    public List<AskListDTO> getAskListByUserId(int userId) {
        UserEntity userEntity = userDao.loadById(userId);
        if (userEntity == null) {
            return null;
        }
        List<AskListDTO> askListDTOList = Lists.newArrayList();
        List<AskEntity> askEntityList = askDao.findByUserId(userId);
        for (AskEntity askEntity : askEntityList) {
            AskListDTO askListDTO = new AskListDTO();
            askListDTO.setId(askEntity.getId());
            askListDTO.setAskDate(askEntity.getAskDate());
            askListDTO.setCensorStatus(askEntity.getCensorStatus());
            askListDTO.setLikeCount(askEntity.getLikeCount());
            askListDTO.setSolvedStatus(askEntity.getSolvedStatus());
            askListDTO.setTitle(askEntity.getTitle());
            askListDTO.setUserNickName(userEntity.getNickName());
            askListDTOList.add(askListDTO);
        }
        return askListDTOList;
    }

    @Override
    public List<AskListDTO> getAskListByDietitianId(int dietitianId) {
        DietitianEntity dietitianEntity = dietitianDao.loadById(dietitianId);
        if (dietitianEntity == null) {
            return null;
        }
        List<AskPostEntity> askPostEntityList = askDao.findByUserIdAndType(dietitianId, UserTypeEnum.DIETITIAN.getValue());
        List<Integer> askIds = Lists.newArrayList();
        for (AskPostEntity askPostEntity : askPostEntityList) {
            if (askIds.contains(askPostEntity.getAskId())) {
                continue;
            }
            askIds.add(askPostEntity.getAskId());
        }
        List<AskEntity> askEntityList = askDao.findByIds(askIds);
        List<AskListDTO> askListDTOList = Lists.newArrayList();
        for (AskEntity askEntity : askEntityList) {
            AskListDTO askListDTO = new AskListDTO();
            askListDTO.setId(askEntity.getId());
            askListDTO.setAskDate(askEntity.getAskDate());
            askListDTO.setCensorStatus(askEntity.getCensorStatus());
            askListDTO.setLikeCount(askEntity.getLikeCount());
            askListDTO.setSolvedStatus(askEntity.getSolvedStatus());
            askListDTO.setTitle(askEntity.getTitle());
            askListDTO.setUserNickName(dietitianEntity.getRealName());
            askListDTOList.add(askListDTO);
        }
        return askListDTOList;
    }

    @Override
    public List<AskPostDTO> getAskPostList(int askId, int pageNo, int pageSize, List<CensorStatusEnum> censorStatusEnumList) {
        AskEntity askEntity = askDao.loadById(askId);
        if (askEntity == null) {
            IResponse.fail("问题不存在");
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 1) {
            pageSize = 1;
        }
        int start = (pageNo - 1) * pageSize;
        List<Integer> censorStatusList = Lists.newArrayList();
        for (CensorStatusEnum censorStatusEnum : censorStatusEnumList) {
            censorStatusList.add(censorStatusEnum.getValue());
        }
        List<AskPostEntity> askPostEntityList = askDao.getAskPost(askId, start, pageSize, censorStatusList);
        List<AskPostDTO> askPostDTOList = Lists.newArrayList();
        for (AskPostEntity askPostEntity : askPostEntityList) {
            AskPostDTO askPostDTO = new AskPostDTO();
            askPostDTO.setAddTime(askPostEntity.getAddTime());
            askPostDTO.setAskId(askPostEntity.getAskId());
            askPostDTO.setContent(askPostEntity.getContent());
            askPostDTO.setPostType(askPostEntity.getPostType());
            askPostDTO.setRank(askPostEntity.getRank());
            askPostDTO.setUserId(askPostEntity.getUserId());
            askPostDTO.setUserType(askPostEntity.getUserType());
            if (askPostEntity.getUserType() == UserTypeEnum.USER.getValue()) {
                UserEntity userEntity = userDao.loadById(askPostEntity.getUserId());
                if (userEntity != null) {
                    askPostDTO.setUserName(userEntity.getNickName());
                }
            }
            if (askPostEntity.getUserType() == UserTypeEnum.DIETITIAN.getValue()) {
                DietitianEntity dietitianEntity = dietitianDao.loadById(askPostEntity.getUserId());
                if (dietitianEntity != null) {
                    askPostDTO.setUserName(dietitianEntity.getRealName());
                }
            }
            askPostDTOList.add(askPostDTO);
        }
        return askPostDTOList;
    }

    @Override
    public IResponse newAsk(AskListDTO askListDTO, AskPostDTO askPostDTO) {
        UserEntity userEntity = userDao.loadById(askListDTO.getUserId());
        if (userEntity == null) {
            return IResponse.fail("用户不存在");
        }
        AskEntity askEntity = new AskEntity();
        askEntity.setAskDate(new Date());
        askEntity.setTitle(askListDTO.getTitle());
        askEntity.setUserId(askListDTO.getUserId());
        askDao.insert(askEntity);
        AskPostEntity askPostEntity = new AskPostEntity();
        askPostEntity.setUserId(askEntity.getUserId());
        askPostEntity.setAskId(askEntity.getId());
        askPostEntity.setContent(askPostDTO.getContent());
        askPostEntity.setRank(1);
        askPostEntity.setPostType(AskPostTypeEnum.ASK.getValue());
        askPostEntity.setUserType(UserTypeEnum.USER.getValue());
        askDao.insertAskPost(askPostEntity);
        return IResponse.success("success");
    }

    @Override
    public IResponse answer(AskPostDTO askPostDTO) {
        AskEntity askEntity = askDao.loadById(askPostDTO.getAskId());
        if (askEntity == null) {
            return IResponse.fail("问题不存在");
        }
        AskPostEntity askPostEntity = new AskPostEntity();
        askPostEntity.setUserId(askPostDTO.getUserId());
        askPostEntity.setAskId(askPostDTO.getAskId());
        askPostEntity.setContent(askPostDTO.getContent());
        askPostEntity.setRank(askDao.getRankCount(askPostDTO.getAskId()) + 1);
        askPostEntity.setPostType(AskPostTypeEnum.ANSWER.getValue());
        askPostEntity.setUserType(askPostDTO.getUserType());
        askDao.insertAskPost(askPostEntity);
        return IResponse.success("success");
    }

    @Override
    public IResponse askAgain(AskPostDTO askPostDTO) {
        AskEntity askEntity = askDao.loadById(askPostDTO.getAskId());
        if (askEntity == null) {
            return IResponse.fail("问题不存在");
        }
        AskPostEntity askPostEntity = new AskPostEntity();
        askPostEntity.setUserId(askPostDTO.getUserId());
        askPostEntity.setAskId(askPostDTO.getAskId());
        askPostEntity.setContent(askPostDTO.getContent());
        askPostEntity.setRank(askDao.getRankCount(askPostDTO.getAskId()) + 1);
        askPostEntity.setPostType(AskPostTypeEnum.ASK.getValue());
        askPostEntity.setUserType(UserTypeEnum.USER.getValue());
        askDao.insertAskPost(askPostEntity);
        return IResponse.success("success");
    }
}
