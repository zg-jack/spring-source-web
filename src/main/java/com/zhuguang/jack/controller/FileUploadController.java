package com.zhuguang.jack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "fileUpload"+File.separator + "temp"
                        + File.separator
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 重定向
        return "ok";
    }

    /*
    * localhost:8081/showView/xxx
    * */
    @RequestMapping("/showView/{viewName}")
    public String showView(@PathVariable("viewName") String viewName){
        return viewName;
    }
}
