package com.ShadowSong.PetManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PetService service;

    @RequestMapping("/")
    public String viewHomePage(Model model){

        List<Pet> listPets = service.listAll();
        model.addAttribute("listPets",listPets);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewPetForrm(Model model){
        Pet pet = new Pet();

        //这一行addAttribute, 对应的是new_product里面的${product}.
        model.addAttribute("pet",pet);

        return "new_pet";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePet(@ModelAttribute("pet") Pet pet){
        service.save(pet);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPetPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_pet");
        Pet pet = service.get(id);
        mav.addObject("pet", pet);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePet(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
