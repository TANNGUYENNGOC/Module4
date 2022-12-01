package com.example.demo.controller;

import com.example.demo.dto.SongDto;
import com.example.demo.model.Song;
import com.example.demo.servie.ISongService;
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

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("list")
    private String showListSong(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "song/list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/create")
    private String createSong(@Validated @ModelAttribute("songDto") SongDto songDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/song/list";
    }

    @GetMapping("/{id}/update")
    private String showFormUpdate(@ModelAttribute("songDto") SongDto songDto, Model model) {
        model.addAttribute("songDto",songService.findById(songDto.getId()));
        return "song/update";
    }

    @PostMapping("/update")
    private String updateSong(@Validated @ModelAttribute("songDto") SongDto songDto,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "song/update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "chỉnh sửa thành công");
        return "redirect:/song/list";
    }
}
