package com.example.demo.controller;

import com.example.demo.dto.attach_facility.IAttachFacilityDTO;
import com.example.demo.dto.contract.ContractDTO1;
import com.example.demo.dto.contract.ContractDto;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.contract.ContractDetail;
import com.example.demo.repository.attach_facility.IAttachFacilityReposotory;
import com.example.demo.service.*;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IAttachFacilityService attachFacilityService;
    @Autowired IContractDetailService contractDetailService;

    @GetMapping("/list")
    public String showListContract(Model model,@PageableDefault(page = 0, size = 5) Pageable pageable){
        Page<ContractDTO1> contractDTO1s = contractService.listContract(pageable);
        model.addAttribute("listContract",contractDTO1s);
        return "contract/list";
    }

    @GetMapping("/listAttachFacility/{id}")
    public String showListAttach(Model model, @PathVariable("id") int id, Pageable pageable){
        Page<IAttachFacilityDTO> attachFacilityDTOS = contractService.listAttachFacility(id,pageable);
        model.addAttribute("list",attachFacilityDTOS);
        return "contract/listAttachFacility";
    }
    @GetMapping("/addContract")
    public String showFormAddContract(Model model,Pageable pageable){
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("listCustomer",customerService.findAll(pageable));
        model.addAttribute("listEmployee",employeeService.findAll(pageable));
        model.addAttribute("listFacility",facilityService.findAll());
        return "contract/addContract";
    }
    @PostMapping("/addContract")
    public String addContract(@ModelAttribute("contractDto") ContractDto contractDto, RedirectAttributes redirectAttributes){
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("mess","Thêm mới hợp đồng thành công");
        return "redirect:/contract/list";
    }

    @GetMapping("/{id}/createContractDetail")
    public String showFormAddContractDetai(Model model, Pageable pageable, @PathVariable("id") int id){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("attachFacilityList",attachFacilityService.findAll(pageable));
        model.addAttribute("id",id);
        return "contract/addContractDetail";
    }
    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail,RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
}
