package com.rao.controller;

import com.rao.service.ResourceStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pojo.vo.file.FileUploadVO;
import util.result.ResultMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * 资源存储controller
 *
 * @author raojing
 * @date 2019/8/17 20:19
 */
@RestController
@RequestMapping("/resource/storage")
public class ResourceStorageController {

    @Resource
    private ResourceStorageService resourceStorageService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/file_upload")
    public ResultMessage fileUpload(@RequestParam(value = "file") MultipartFile file,
                                    HttpServletRequest request) {
        try {
            String projectUrl = request.getScheme() + "://" + InetAddress.getLocalHost().getHostAddress() + ":" +
                    request.getServerPort() + request.getContextPath() + "/storage";

            FileUploadVO filePath = resourceStorageService.fileUpload(file, projectUrl);
            return ResultMessage.success().add("uploadInfo", filePath);
        }catch (Exception e){
            return ResultMessage.fail().addMessage("文件上传失败");
        }
    }

}
