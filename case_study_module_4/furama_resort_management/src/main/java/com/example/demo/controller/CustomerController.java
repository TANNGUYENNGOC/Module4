package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    private String showListCustomer(Model model, @PageableDefault(page = 0,size = 5) Pageable pageable){
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers",customers);
        return "customer/list";
    }

   @GetMapping("/create")
    private String showFormCreate(Model model,Pageable pageable){
       Page<CustomerType> customerTypes = customerTypeService.findAll(pageable);
       model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("listCustomerType",customerTypes);
        return "customer/create";
   }

//   @PostMapping("/create")
//    public String createCustomer()
}
