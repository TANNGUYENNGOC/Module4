package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/create")
    private String showFormCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    private String createUser(@Validated @ModelAttribute("userDto") UserDto userDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes
                              ){
        if(bindingResult.hasErrors()){
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "user/create";
    }
}
