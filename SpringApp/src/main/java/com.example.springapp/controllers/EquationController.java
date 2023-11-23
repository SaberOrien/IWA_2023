package com.example.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.springapp.model.Equation;

@Controller
public class EquationController {
    @RequestMapping("/equation")
    public String equation(Model model){
        model.addAttribute("message", "Simple site to solve QuadraticEquation.");
        Equation newEquation = new Equation();
        model.addAttribute("equation", newEquation);
        return "equation";
    }

    @RequestMapping(value = "/solveEquation.html", method=RequestMethod.POST)
    public String addEquation(@ModelAttribute("equation") Equation equation){
        try{
            equation.convertInput();
            equation.solveEquation();
        } catch(Exception e){
            System.out.println("Cannot solve the equation with invalid coefficients.");
        }
        return "redirect:equation";
    }
}
