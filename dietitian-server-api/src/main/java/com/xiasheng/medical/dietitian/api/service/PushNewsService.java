package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.dto.PushNewsDTO;
import com.xiasheng.medical.dietitian.api.utils.IResponse;

import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
public interface PushNewsService {

    List<PushNewsDTO> getNews(int pageNo, int pageSize);

    IResponse addNews(PushNewsDTO pushNewsDTO);

}
