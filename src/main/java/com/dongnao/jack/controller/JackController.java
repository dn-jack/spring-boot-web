package com.dongnao.jack.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dongnao.jack.bean.ConsultConfigArea;
import com.dongnao.jack.bean.ConsultContent;
import com.dongnao.jack.service.CommonService;

/** 
 * @Description TODO 
 * @ClassName   JackController 
 * @Date        2017年8月28日 下午2:02:37 
 * @Author      动脑学院-jack
 */
@Controller
/**
@RestController  @ResponseBody @Controller
 */
//@RestController
public class JackController {
    private static final Logger logger = LoggerFactory.getLogger(JackController.class);
    
    @Value("${application.hello:Hello jack}")
    private String hello = "";
    
    //    @RequestMapping("login")
    //    public String login(String param) {
    //        return "ssss";
    //    }
    
    @Autowired
    CommonService commonService;
    
    //    @RequestMapping(value = {"/", "/index"})
    //    public String index(Map<String, Object> model) {
    //        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
    //        // 本例为 /WEB-INF/jsp/index.jsp
    //        model.put("time", new Date());
    //        model.put("message", this.hello);
    //        return "index";
    //    }
    
    @RequestMapping("/page")
    public ModelAndView page() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("time", new Date());
        model.addObject("message", this.hello);
        return model;
    }
    
    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map) {
        map.put("name", "[Angel -- 守护天使]");
        map.put("gender", 1);//gender:性别，1：男；0：女；  
        
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "jack");
        friend.put("age", 30);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "jeff");
        friend.put("age", 36);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }
    
    @RequestMapping("/queryContent")
    public @ResponseBody List<ConsultContent> queryContent() {
        logger.info("查询开始！");
        List<ConsultContent> consults = commonService.queryContent(new HashMap());
        logger.info("查询结束！");
        return consults;
    }
    
    @RequestMapping("/queryArea")
    public @ResponseBody List<ConsultConfigArea> queryArea() {
        logger.info("查询开始！");
        List<ConsultConfigArea> areas = commonService.qryArea(new HashMap());
        logger.info("查询结束！");
        return areas;
    }
    
    /** 
     * @Description 文件上传 
     * @param  参数 
     * @return void 返回类型  
     * @throws 
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest req,
            MultipartHttpServletRequest multiReq) {
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
        logger.info("uploadFlePath:" + uploadFilePath);
        // 截取上传文件的文件名
        String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,
                uploadFilePath.indexOf('.'));
        logger.info("multiReq.getFile()" + uploadFileName);
        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1,
                uploadFilePath.length());
        logger.info("uploadFileSuffix:" + uploadFileSuffix);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = (FileInputStream)multiReq.getFile("file1").getInputStream();
            fos = new FileOutputStream(new File("D:" + File.separator
                    + "picture" + File.separator + uploadFileName + "."
                    + uploadFileSuffix));
            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1) {
                fos.write(temp, 0, temp.length);
                fos.flush();
                i = fis.read(temp);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @RequestMapping(value = "uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFiles(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    String uploadFilePath = file.getOriginalFilename();
                    System.out.println("uploadFlePath:" + uploadFilePath);
                    // 截取上传文件的文件名
                    String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,
                            uploadFilePath.indexOf('.'));
                    System.out.println("multiReq.getFile()" + uploadFileName);
                    // 截取上传文件的后缀
                    String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1,
                            uploadFilePath.length());
                    System.out.println("uploadFileSuffix:" + uploadFileSuffix);
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("D:" + File.separator + "picture"
                                    + File.separator + uploadFileName + "."
                                    + uploadFileSuffix)));
                    byte[] bytes = file.getBytes();
                    stream.write(bytes, 0, bytes.length);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                System.out.println("上传文件为空");
            }
        }
        System.out.println("文件接受成功了");
    }
    
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse res) {
        String fileName = "info.log";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("D:"
                    + File.separator + "picture" + File.separator + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bis != null) {
                try {
                    bis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
    
    //    @RequestMapping("/queryConsultContract")
    //    public @ResponseBody List<ConsultContract> queryConsultContract() {
    //        logger.info("查询开始！");
    //        List<ConsultContract> consults = commonService.queryConsultContract();
    //        logger.info("查询结束！");
    //        return consults;
    //    }
    //    
    //    @RequestMapping("/updateConsultContract")
    //    public @ResponseBody int updateConsultContract() {
    //        logger.info("修改开始！");
    //        int count = commonService.updateConsultContract("jpa test", 98);
    //        logger.info("修改结束！");
    //        return count;
    //    }
}
