package com.example.springbootdemo.Controller;

import com.example.springbootdemo.Service.UserService;
import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("delete/user")
    public String delete(int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping("update/user")
    public String updateUserByid(Model model, int id) {
        User userId = userService.selectById(id);
        model.addAttribute("userId", userId);
        return "updateUser";
    }

    @RequestMapping(value = "/adduser")
    public String addUser() {
        return "adduser";
    }

    @Value("${fileimgLocation}")
    String fileLocation;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(String name,
                          String password,
                          String PaymentPassword,
                          MultipartFile file,
                          double Balance,
                          int grade
    ) throws IOException {
        Date date = new Date();
        String filename = date.getTime() + file.getOriginalFilename();
        String fileDirPath = new String("src/main/resources/" + fileLocation);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
        file.transferTo(newFile);
        // 生成到服务器中在打包war包使用
        // String realPath= ResourceUtils.getURL("classpath:").getPath()+fileLocation;
        // File newFile =new File(realPath);
        // Date date=new Date();
        // if (!newFile.exists()) newFile.mkdirs();
        // // 上传
        // String fileName = date.getTime() +"@" + file.getOriginalFilename();
        // file.transferTo(new File(newFile, fileName));
        User user = new User(name, password, PaymentPassword, "files/"+"imguser/" + filename, Balance, grade);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping("download")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        String realPath = "src/main/resources/" + fileLocation;
        fileName = fileName.substring(fileName.lastIndexOf("/")+1, fileName.length());
        FileInputStream inputStream = new FileInputStream(new File(realPath, fileName));
        response.setHeader("content-disposition", "attachment; fileName=" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(String name,
                             String password,
                             String payword,
                             MultipartFile file,
                             double balance,
                             int grade,
                             HttpSession session) throws IOException {
        Date date = new Date();
        String filename = date.getTime() + file.getOriginalFilename();
        String fileDirPath = new String("src/main/resources/" + fileLocation);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
        file.transferTo(newFile);
        // 生成到服务器中在打包war包使用
        // String realPath= ResourceUtils.getURL("classpath:").getPath()+fileLocation;
        // File newFile =new File(realPath);
        // Date date=new Date();
        // if (!newFile.exists()) newFile.mkdirs();
        // // 上传
        // String fileName = date.getTime() +"@" + file.getOriginalFilename();
        // file.transferTo(new File(newFile, fileName));
        int uid=((User)session.getAttribute("user")).getId();
        User user = new User(name, password, payword, "files/"+"imguser/" + filename, balance, grade);
        user.setId(uid);
        userService.updateUser(user);
        return "redirect:/users";

    }

}
