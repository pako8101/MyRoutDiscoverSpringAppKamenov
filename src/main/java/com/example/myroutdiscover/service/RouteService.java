package com.example.myroutdiscover.service;

import com.example.myroutdiscover.model.service.RouteServiceModel;
import com.example.myroutdiscover.model.view.RouteDetailsViewModel;
import com.example.myroutdiscover.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);
}
