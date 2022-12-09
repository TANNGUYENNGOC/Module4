package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO1;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    private String showListCustomer(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<CustomerDTO1> customerDTO1s = customerService.listCustomerDto(pageable);
        model.addAttribute("customers", customerDTO1s);
//        model.addAttribute("customers",customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model, Pageable pageable) {
        Page<CustomerType> customerTypes = customerTypeService.findAll(pageable);
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("listCustomerType", customerTypes);
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customerDto") CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới khách hàng thành công");
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdateCustomer(@PathVariable("id") int id, Model model, Pageable pageable) {
        Customer customer = customerService.findById(id).get();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customer", customerDto);
        model.addAttribute("listCustomerType", customerTypeService.findAll(pageable));
        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/remove")
    public String showFormRemove(@PathVariable("id") int id, Model model, Pageable pageable) {
        Customer customer = customerService.findById(id).get();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customer", customerDto);
        model.addAttribute("listCustomerType", customerTypeService.findAll(pageable));
        return "customer/remove";
    }

    @PostMapping("/remove")
    public String removeCustomer(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/customer/list";
    }
}
