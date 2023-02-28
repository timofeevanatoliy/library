package com.example.library.controller;

import com.example.library.model.Person;
import com.example.library.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    public String index(Model model){
        model.addAttribute("persons", personService.findByAll());
        return "index";

    }
    @GetMapping("{id}")
    public String show(@PathVariable Long id,Model model){
        model.addAttribute("person",personService.findByOne(id));
       // model.addAttribute("books",personService.getByBooksPersonId(id));
        return "show";
    }


    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Person());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute Person person){
        personService.save(person);
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        personService.delete(id);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("person", personService.findByOne(id));

        return "edit";
    }


    @PatchMapping("{id)")
    public String update(@PathVariable Long id,@ModelAttribute Person person){
        personService.update(id,person);
        return "redirect:/people";
    }

}
