
package com.be_servicie.saigon_travel.be_service.services;

import com.be_servicie.saigon_travel.be_service.entity.FavoriteDestination;
import com.be_servicie.saigon_travel.be_service.entity.User;
import com.be_servicie.saigon_travel.be_service.dto.response.FavoriteDestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.Destination;
import com.be_servicie.saigon_travel.be_service.repository.FavoriteDestinationRepository;
import com.be_servicie.saigon_travel.be_service.repository.AdminRepository;
import com.be_servicie.saigon_travel.be_service.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteDestinationService {

    @Autowired
    private FavoriteDestinationRepository favoriteDestinationRepository;

    @Autowired
    private AdminRepository userRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    public void addFavorite(String userId, String destinationId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Destination> destination = destinationRepository.findById(destinationId);
    
        if (user.isEmpty() || destination.isEmpty()) {
            throw new RuntimeException("User or Destination not found");
        }
    
        // Kiểm tra nếu địa điểm đã tồn tại trong danh sách yêu thích
        if (favoriteDestinationRepository.existsByUserIdAndDestinationId(userId, destinationId)) {
            throw new RuntimeException("Favorite already exists");
        }
    
        FavoriteDestination favorite = FavoriteDestination.builder()
                .user(user.get())
                .destination(destination.get())
                .build();
        favoriteDestinationRepository.save(favorite);
    }

    public boolean isFavorite(String userId, String destinationId) {
        return favoriteDestinationRepository.existsByUserIdAndDestinationId(userId, destinationId);
    }
    
    public List<FavoriteDestinationDTO> getFavoritesByUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        
        if (user.isEmpty()) {
            return List.of();
        }

        return favoriteDestinationRepository.findByUser(user.get()).stream()
            .map(fav -> new FavoriteDestinationDTO(fav.getUser().getId(), fav.getDestination().getId()))
            .collect(Collectors.toList());
    }

    
    public void removeFavorite(String favoriteId) {
        favoriteDestinationRepository.deleteById(favoriteId);
    }

    public void removeFavoriteByUserAndDestination(String userId, String destinationId) {
        Optional<FavoriteDestination> favorite = favoriteDestinationRepository.findByUserIdAndDestinationId(userId, destinationId);
        favorite.ifPresent(favoriteDestinationRepository::delete);
    }
}