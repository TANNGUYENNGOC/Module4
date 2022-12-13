package com.example.demo.controller;

import com.example.demo.dto.facility.FacilityDto;
import com.example.demo.model.facility.Facility;
import com.example.demo.service.IFacilityService;
import com.example.demo.service.IFacilityTypeService;
import com.example.demo.service.IRenTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IRenTypeService renTypeService;

//    @GetMapping("/list")
//    private String showListFacility(Model model,@PageableDefault(page = 0,size = 5) Pageable pageable){
//        model.addAttribute("list",facilityService.findAll(pageable));
//        model.addAttribute("listFacilityType",facilityTypeService.findAll(pageable));
//        return "facility/list";
//    }

    @GetMapping("/create")
    public String showFormCreateVilla(Model model,Pageable pageable){
        model.addAttribute("facilityDTO", new FacilityDto());
        model.addAttribute("listRentType",renTypeService.findAll(pageable));
        model.addAttribute("listFacilityType",facilityTypeService.findAll(pageable));
        return "facility/create";
    }


    @PostMapping("/createFacility")
    public String createFacility(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/facility/";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable("id") int id,Model model,Pageable pageable){
        Facility facility = facilityService.findById(id).get();
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("listRentType",renTypeService.findAll(pageable));
        model.addAttribute("listFacilityType",facilityTypeService.findAll(pageable));
        return "facility/update";
    }
    @PostMapping("/updateFacility")
    public String updateFacility(@ModelAttribute("facilityDto") FacilityDto facilityDto,RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","CHỉnh sửa thành công");
        return "redirect:/facility/";
    }

    @GetMapping("{id}/remove")
    public String showFormDelete(@PathVariable("id") int id,Model model,Pageable pageable){
        Facility facility = facilityService.findById(id).get();
        model.addAttribute("facility",facility);
        model.addAttribute("listRentType",renTypeService.findAll(pageable));
        model.addAttribute("listFacilityType",facilityTypeService.findAll(pageable));
        return "facility/deleteVilla";
    }
    @PostMapping("/removeFacility")
    public String removeFacility(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
        facilityService.removeFlagFacility(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/facility/";
    }

    @GetMapping("")
    public String searchFacility(@RequestParam(defaultValue = "")String name
            ,@RequestParam(defaultValue = "") String facilityType
            ,Model model
            ,  @PageableDefault(page = 0, size = 3) Pageable pageable){
        Page<Facility> list = facilityService.searchListFacility(name,facilityType,pageable);
        model.addAttribute("list",list);
        model.addAttribute("name",name);
        model.addAttribute("facilityType",facilityType);
        model.addAttribute("listFacilityType",facilityTypeService.findAll(pageable));
        return "facility/list";
    }
}
