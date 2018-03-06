package com.xiasheng.medical.dietitian.biz.service.impl;

import com.xiasheng.medical.dietitian.api.dto.PushNewsDTO;
import com.xiasheng.medical.dietitian.api.service.PushNewsService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
@Service
public class PushNewsServiceImpl implements PushNewsService {
    @Override
    public List<PushNewsDTO> getNews(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public IResponse addNews(PushNewsDTO pushNewsDTO) {
        return null;
    }
}
