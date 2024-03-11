package com.example.myroutdiscover.repository;

import com.example.myroutdiscover.model.entity.Route;
import com.example.myroutdiscover.model.view.RouteDetailsViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {


}
