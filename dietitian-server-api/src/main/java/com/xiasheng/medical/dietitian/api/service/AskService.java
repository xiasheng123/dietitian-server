package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.constants.CensorStatusEnum;
import com.xiasheng.medical.dietitian.api.dto.AskListDTO;
import com.xiasheng.medical.dietitian.api.dto.AskPostDTO;
import com.xiasheng.medical.dietitian.api.utils.IResponse;

import java.util.List;

/**
 * Created by fu on 2018/3/7.
 */
public interface AskService {

    List<AskListDTO> getAskList(int pageNo, int pageSize, List<CensorStatusEnum> censorStatusEnumList);

    List<AskListDTO> getAskListByUserId(int userId);

    List<AskListDTO> getAskListByDietitianId(int dietitianId);

    List<AskPostDTO> getAskPostList(int askId, int pageNo, int pageSize, List<CensorStatusEnum> censorStatusEnumList);

    IResponse newAsk(AskListDTO askListDTO, AskPostDTO askPostDTO);

    IResponse answer(AskPostDTO askPostDTO);

    IResponse askAgain(AskPostDTO askPostDTO);
}
