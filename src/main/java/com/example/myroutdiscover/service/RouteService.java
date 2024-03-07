package com.example.myroutdiscover.service;

import com.example.myroutdiscover.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();
}
