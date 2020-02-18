package com.rao.controller.web;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rao.config.LocalOssConfig;
import com.rao.util.file.DownLoadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import pojo.entity.resource.ResourceLocationsConfig;
import pojo.entity.resource.ResourceVideo;
import pojo.entity.resource.ServicePath;
import pojo.vo.file.FileUploadVO;
import service.resource.ResourceLocationsConfigService;
import service.resource.ResourceVideoService;
import service.resource.ServicePathService;
import util.result.ResultMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

/**
 * 资源文件管理 controller
 *
 * @author raojing
 * @date 2019/8/18 1:38
 */
@Slf4j
@RestController
@RequestMapping("/resource/manager")
public class ResourceFileManagerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LocalOssConfig localOssConfig;
    @Resource
    private ResourceVideoService resourceVideoService;
    @Resource
    private ServicePathService servicePathService;
    @Resource
    private ResourceLocationsConfigService resourceLocationsConfigService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/file_upload")
    public ResultMessage fileUpload(@RequestParam(value = "file") MultipartFile file) {
        // 根据当前系统拿到本地 OSS 服务文件上传地址
        String os = System.getProperty("os.name");
        String restApi = os.toLowerCase().startsWith("win") ? localOssConfig.getWdRestApi() : localOssConfig.getLmRestApi();
        File tempFile = new File("");
        try {
            // 在当前服务器中生成临时文件
            String originalFilename = UUID.randomUUID().toString() + file.getOriginalFilename();
            String classpath = ResourceUtils.getURL("classpath:").getPath();
            tempFile = new File(classpath, originalFilename);
            file.transferTo(tempFile);

            // 通过 restTemplate 上传文件到本地 OSS 服务器
            FileSystemResource fileSystemResource = new FileSystemResource(tempFile);
            LinkedMultiValueMap multiValueMap = new LinkedMultiValueMap();
            multiValueMap.add("file", fileSystemResource);
            String uploadInfoJsonStr = restTemplate.postForObject(restApi, multiValueMap, String.class);
            JSONObject uploadInfoJsonObject = JSONUtil.parseObj(uploadInfoJsonStr).getJSONObject("data").getJSONObject("uploadInfo");
            log.info("oss 返回的信息:{}", uploadInfoJsonObject);
            FileUploadVO fileUploadVO = JSONUtil.toBean(uploadInfoJsonObject, FileUploadVO.class);
            fileUploadVO.setFileUrl(localOssConfig.getFullPath(fileUploadVO.getFilePath()));
            // 删除当前服务器的临时文件
            tempFile.delete();
            return ResultMessage.success().add("uploadInfo", fileUploadVO).addMessage("文件上传成功");
        } catch (Exception e) {
            return ResultMessage.fail().addMessage("文件上传失败");
        } finally {
            tempFile.delete();
        }
    }

    /**
     * 资源下载
     */
    @RequestMapping("/download")
    public String downloadFile(Long resourceId, HttpServletResponse response) throws Exception {
        //获取资源信息
        ResourceVideo video = resourceVideoService.find(resourceId);
        if (video == null) {
            return null;
        }
        //获取文件地址信息
        ServicePath servicePath = servicePathService.find(video.getServiceId());
        ResourceLocationsConfig config = resourceLocationsConfigService.find(servicePath.getConfigId());
        String fileName = video.getVideoPath();

        String os = System.getProperty("os.name");
        log.info("当前的系统为:{}", os);
        String basePath = os.toLowerCase().startsWith("win") ? config.getWdLocationPath() : config.getLmLocationPath();
        log.info("资源文件所在的路径:{}", basePath);
        String dataAddress = basePath + "/" + fileName;

        //设置文件路径
        File file = new File(dataAddress);
        // 如果文件名存在，则进行下载
        if (file.exists()) {
            DownLoadUtil.downLoad(response, file, fileName);
        }
        return null;
    }

}
