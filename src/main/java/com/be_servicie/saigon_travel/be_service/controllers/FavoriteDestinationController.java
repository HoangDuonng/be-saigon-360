package com.be_servicie.saigon_travel.be_service.controllers;


import com.be_servicie.saigon_travel.be_service.dto.response.FavoriteDestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.FavoriteDestination;
import com.be_servicie.saigon_travel.be_service.services.FavoriteDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteDestinationController {

    @Autowired
    private FavoriteDestinationService favoriteDestinationService;

    @PostMapping("/{userId}/{destinationId}")
    public void addFavorite(@PathVariable String userId, @PathVariable String destinationId) {
        favoriteDestinationService.addFavorite(userId, destinationId);
    }
    @GetMapping("/{userId}/{destinationId}")
    public boolean checkIfFavorite(@PathVariable String userId, @PathVariable String destinationId) {
        return favoriteDestinationService.isFavorite(userId, destinationId);
    }

     @GetMapping("/{userId}")
    public List<FavoriteDestinationDTO> getUserFavorites(@PathVariable String userId) {
        return favoriteDestinationService.getFavoritesByUser(userId);
    }
    @DeleteMapping("/{favoriteId}")
    public void removeFavorite(@PathVariable String favoriteId) {
        favoriteDestinationService.removeFavorite(favoriteId);
    }
    @DeleteMapping("/{userId}/{destinationId}")
    public void removeFavorite(@PathVariable String userId, @PathVariable String destinationId) {
        favoriteDestinationService.removeFavoriteByUserAndDestination(userId, destinationId);
    }
}