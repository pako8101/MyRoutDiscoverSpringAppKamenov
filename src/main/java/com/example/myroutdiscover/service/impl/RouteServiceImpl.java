package com.example.myroutdiscover.service.impl;

import com.example.myroutdiscover.model.entity.Route;
import com.example.myroutdiscover.model.service.RouteServiceModel;
import com.example.myroutdiscover.model.view.RouteDetailsViewModel;
import com.example.myroutdiscover.model.view.RouteViewModel;
import com.example.myroutdiscover.repository.RouteRepository;
import com.example.myroutdiscover.service.CategoryService;
import com.example.myroutdiscover.service.RouteService;
import com.example.myroutdiscover.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
private final RouteRepository routeRepository;
private final UserService userService;
private final ModelMapper modelMapper;
private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, ModelMapper modelMapper, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {

        return routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
//                    if (routeViewModel.getPictureUrl().isEmpty()){
//                        routeViewModel.setPictureUrl("/images/pic4.jpg");
//                    }else {
//                        routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
//                    }
                    routeViewModel.setPictureUrl(route.getPictures()
//                            .stream().findFirst().orElse("/images/pic4.jpg"));
                            .isEmpty()
                    ? "/images/pic4.jpg" : route.getPictures().stream().findFirst().get().getUrl());

                    return routeViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = modelMapper.map(routeServiceModel, Route.class);

        route.setAuthor(userService.findCurrentUserLoginEntity());

route.setCategories(routeServiceModel.getCategories()
        .stream()
        .map(categoryService::findCategoryByName)
        .collect(Collectors.toSet()));

        routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {

        return routeRepository.findById(id)
                .map(route -> modelMapper.map(route, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
