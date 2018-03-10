package com.xiasheng.medical.dietitian.web.controller;

import com.xiasheng.medical.dietitian.api.dto.MomentDTO;
import com.xiasheng.medical.dietitian.api.dto.UserDTO;
import com.xiasheng.medical.dietitian.api.service.MomentService;
import com.xiasheng.medical.dietitian.api.utils.IResponse;
import com.xiasheng.medical.dietitian.web.controller.base.BaseController;
import com.xiasheng.medical.dietitian.web.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fu on 2018/3/7.
 */
@Controller
@RequestMapping(value = "/moment")
public class MomentController extends BaseController {

    @Autowired
    private MomentService momentService;

    @RequestMapping(value = "/myMoment")
    @ResponseBody
    public WebResult myMoment(@RequestParam(value = "appKey") String appKey) {
        UserDTO userDTO = getUserDTO(appKey);
        if (userDTO == null) {
            return WebResult.fail("请重新登录");
        }
        List<MomentDTO> momentDTOList = momentService.getMoments(userDTO.getId());
        return WebResult.success(momentDTOList);
    }

    @RequestMapping(value = "/addMoment")
    @ResponseBody
    public WebResult addMoment(@RequestParam(value = "appKey") String appKey) {
        UserDTO userDTO = getUserDTO(appKey);
        if (userDTO == null) {
            return WebResult.fail("请重新登录");
        }
        //TODO 在此之前会触发上传，上传成功后，服务器给客户端返回URL，包括原始图片和缩略图URL
        MomentDTO momentDTO = new MomentDTO();
        momentDTO.setUserId(userDTO.getId());
        momentDTO.setContent("123");
        momentDTO.setCategoryId(1);
        momentDTO.setImageUrls(null);
        momentDTO.setThumbnailUrls(null);
        IResponse response = momentService.addMoment(momentDTO);
        if (response.isSuccess()) {
            return WebResult.success("发布成功");
        }
        return WebResult.fail("发布失败");
    }

    @RequestMapping(value = "/newComment")
    @ResponseBody
    public WebResult newComment(@RequestParam(value = "appKey") String appKey) {

        return null;
    }
}
