package com.example.lrs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //ホームページ表示
    @GetMapping
    public String index(){
            return "index";
    }

}
