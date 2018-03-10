package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.constants.NewsEditStatusEnum;
import com.xiasheng.medical.dietitian.api.dto.PushNewsDTO;
import com.xiasheng.medical.dietitian.api.utils.IResponse;

import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
public interface PushNewsService {

    List<PushNewsDTO> getNewsList(int pageNo, int pageSize, List<NewsEditStatusEnum> editStatusEnumList);

    IResponse addNews(PushNewsDTO pushNewsDTO);

    PushNewsDTO getNewsDetail(int pushNewsId);

    void addClickCount(int pushNewsId);

}
