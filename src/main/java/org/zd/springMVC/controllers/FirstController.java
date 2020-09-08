package org.zd.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        model.addAttribute("message","Hello, "+ name+" "+surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return  "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model){
        String message = "Result "+action+" = ";
        switch (action){
            case "addition":
                model.addAttribute("result",message+(a+b));
                break;
            case "subtraction":
                model.addAttribute("result",message+(a-b));
                break;
            case "multiplication":
                model.addAttribute("result",message+(a*b));
                break;
            case "division":
                if (b == 0) {
                    model.addAttribute("result","деление на ноль невозможно");
            }else{
                model.addAttribute("result",message+String.format("%.2f",(double)a/b));
            }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        return  "first/calculator";
    }
}
