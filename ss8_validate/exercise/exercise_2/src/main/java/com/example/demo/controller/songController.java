package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.servie.ISongService;
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
public class songController {
    @Autowired
    ISongService songService;

    @GetMapping("list-song")
    private String showListSong(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "song/list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/create")
    private String createSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Song().validate(song,bindingResult);
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/song/list-song";
    }

    @GetMapping("/{id}/update")
    private String showFormUpdate(@ModelAttribute("song") Song song, Model model) {
        model.addAttribute("song",songService.findById(song.getId()));
        return "song/update";
    }

    @PostMapping("/update")
    private String updateSong(@ModelAttribute("song") Song song, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "chỉnh sửa thành công");
        return "redirect:/song/list-song";
    }
}
