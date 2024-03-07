package com.example.myroutdiscover.web;

import com.example.myroutdiscover.model.view.RouteViewModel;
import com.example.myroutdiscover.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/all")
    public String allRoutes(Model model){

        List<RouteViewModel> routeViewModelList = routeService.findAllRoutesView();
model.addAttribute("routes",routeViewModelList);


        return "routes";
    }

    @GetMapping("/add")
    public String add(){


        return "add-route";
    }
//    @PostMapping("/")
//    public String Routes(){
//        return "routes";
//    }

}
