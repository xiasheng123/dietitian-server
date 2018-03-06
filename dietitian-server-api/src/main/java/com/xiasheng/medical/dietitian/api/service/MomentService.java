package com.xiasheng.medical.dietitian.api.service;

import com.xiasheng.medical.dietitian.api.dto.MomentDTO;
import com.xiasheng.medical.dietitian.api.utils.IResponse;

import java.util.List;

/**
 * Created by fu on 2018/3/6.
 */
public interface MomentService {

    List<MomentDTO> getMoments(int userId);

    IResponse addMoment(MomentDTO momentDTO);

    IResponse addComment(int momentId, int dietitian, String content);

}
