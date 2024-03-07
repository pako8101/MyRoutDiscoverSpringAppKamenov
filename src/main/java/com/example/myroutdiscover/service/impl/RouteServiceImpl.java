package com.example.myroutdiscover.service.impl;

import com.example.myroutdiscover.model.entity.Picture;
import com.example.myroutdiscover.model.view.RouteViewModel;
import com.example.myroutdiscover.repository.RouteRepository;
import com.example.myroutdiscover.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
private final RouteRepository routeRepository;
private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
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
}
