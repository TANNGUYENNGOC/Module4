package com.example.demo.controller;

import com.example.demo.dto.facility.FacilityDto;
import com.example.demo.model.facility.Facility;
import com.example.demo.service.IFacilityService;
import com.example.demo.service.IFacilityTypeService;
import com.example.demo.service.IRenTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list")
    private String showListFacility(Model model,@PageableDefault(page = 0,size = 5) Pageable pageable){
        model.addAttribute("list",facilityService.findAll(pageable));
        return "facility/list";
    }

    @GetMapping("/createVilla")
    public String showFormCreateVilla(Model model,Pageable pageable){
        model.addAttribute("facilityDTO", new FacilityDto());
        model.addAttribute("listRentType",renTypeService.findAll(pageable));
        return "facility/createVilla";
    }

    @GetMapping("/createHouse")
    public String showFormCreateHouse(Model model, Pageable pageable){
        model.addAttribute("facilityDTO", new FacilityDto());
        model.addAttribute("listRentType",renTypeService.findAll(pageable));
        return "facility/createHouse";
    }

    @GetMapping("/createRoom")
    public String showFormCreateRoom(Model model, Pageable pageable){
        model.addAttribute("facilityDTO", new FacilityDto());
        model.addAttribute("listRentType",renTypeService.findAll(pageable));
        return "facility/createRoom";
    }

    @PostMapping("/createFacility")
    public String createFacility(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable("id") int id,Model model){
        model.addAttribute("facility",facilityService.findById(id));
        return "facility/update";
    }

    @GetMapping("{id}/remove")
    public String showFormDelete(@PathVariable("id") int id,Model model){
        Facility facility = facilityService.findById(id).get();
        model.addAttribute("facility",facility);
        return "facility/deleteVilla";
    }
}
