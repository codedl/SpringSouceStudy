package com.example.springsource.mvc;

import com.example.springsource.pojo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamController {

    @PostMapping("file")
    public String file(@RequestPart("file") MultipartFile file) throws IOException {

        file.transferTo(new File("./"+file.getOriginalFilename()).getAbsoluteFile());
        return "forward:/static/index.html";
    }

    @GetMapping("format")
    public User user(){
        User user1 = new User();
        user1.setName("Leding");
        return user1;
    }


    @RequestMapping("pojo")
    public User pojo(User user){
        return user;
    }

    @RequestMapping("/param/{path}")
    public Map param(@PathVariable Map path,
                     @RequestHeader Map header,
                     @RequestParam Map param,
                     @CookieValue(required = false,value = "cname") String cookie,
                     @RequestBody String body,
//                     @RequestAttribute Map attr,
                     HttpServletRequest request,
                     HttpServletResponse response,
                     User user
                    ){
        Map maps = new HashMap();
        maps.put("path",path);
        maps.put("header",header);
        maps.put("param",param);
        maps.put("cookie",cookie);
        maps.put("body",body);
        maps.put("user",user);

        /*javax.servlet.http.Cookie cooki = new Cookie("cname", "这是一个cookie");
        response.addCookie(cooki);*/
//        maps.put("attr",attr);
//        maps.put("request",request);
//        maps.put("response",response);

        return maps;
    }
}
