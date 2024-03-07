package com.example.myroutdiscover.web;

import com.example.myroutdiscover.model.binding.RouteAddBindingModel;
import com.example.myroutdiscover.model.view.RouteViewModel;
import com.example.myroutdiscover.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        List<RouteViewModel> routeViewModelList = routeService.findAllRoutesView();
        model.addAttribute("routes", routeViewModelList);


        return "routes";
    }

    @GetMapping("/add")
    public String add() {


        return "add-route";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){

        }


        return "redirect:all";
    }

}
