package com.example.springbootdemo.Controller;

import com.example.springbootdemo.Service.LoginService;
import com.example.springbootdemo.Service.PageLogService;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.utils.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginservice;
    @Autowired
    private PageLogService pageLogServiceImpl;

    @GetMapping
    @PassToken
    public String login() {
        return "login";
    }
    @PostMapping
    @PassToken
    public String login(String name, String password, String check, HttpServletRequest request,HttpServletResponse response) {
        check=check.toLowerCase();
        String ans=request.getSession().getAttribute("checkcode").toString().toLowerCase();

        if (check.equals(ans)) {
            User user = new User();
            user.setName(name);
            user.setPassword(password);

            User user1 = loginservice.login(user,response);
            if (user1 != null) {
                request.getSession().setAttribute("user", user1);
                
                // model.addAttribute("user",user1);
                // model.addAttribute("data", pageLogServiceImpl.selcertPage());
                if (user1.getGrade() >= 1)
                    return "redirect:ConservatorIndex";
                else
                    return "redirect:index";
            } else
                return "404";
        }
        else
            return "404";

    }

    @RequestMapping(value = "/checkcode", method = RequestMethod.GET)
    @PassToken
    public void checkcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();
        int width = 100;
        int height = 40;
        //设置浏览器不要缓存此图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //创建内存图像并获得其图形上下文
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //产生随机验证码
        //定义验证码的字符表
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++) {
            int rand = (int) (Math.random() * 36);
            rands[i] = chars.charAt(rand);
        }
        //产生图像
        //画背景
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        //随机产生120个干扰点
        for (int i = 0; i < 120; i++) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            g.setColor(new Color(red, green, blue));
            g.drawOval(x, y, 1, 0);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
        //在不同的高度上输出验证码的不同字符
        g.drawString("" + rands[0], 2, 34);
        g.drawString("" + rands[1], 32, 30);
        g.drawString("" + rands[2], 62, 36);
        g.drawString("" + rands[3], 85, 32);
        //将图像输入到客户端
        ServletOutputStream sos = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", baos);
        byte[] buffer = baos.toByteArray();
        response.setContentLength(buffer.length);
        sos.write(buffer);
        baos.close();
        sos.close();
        //将验证码放到session中
        session.setAttribute("checkcode", new String(rands));
    }

    @RequestMapping(value = "/logcheck", method = RequestMethod.POST)
    @PassToken
    @ResponseBody
    public String logcheck(HttpSession session, String code) {
        boolean flag;
        String servercheckcode = (String) session.getAttribute("checkcode");
        if (!code.toLowerCase().equals(servercheckcode.toLowerCase())) {
            flag = false;
            session.setAttribute("info", flag);
            return "验证码错误";
        } else {
            flag = true;
            session.setAttribute("info", flag);
            // request.getRequestDispatcher("login.jsp").forward(request, response);
            return "验证码正确";
        }
    }
}
