package com.be_servicie.saigon_travel.be_service.repository;

import com.be_servicie.saigon_travel.be_service.entity.FavoriteDestination;
import com.be_servicie.saigon_travel.be_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FavoriteDestinationRepository extends JpaRepository<FavoriteDestination, String> {
    List<FavoriteDestination> findByUser(User user);

    @Query("SELECT f FROM FavoriteDestination f WHERE f.user.id = :userId AND f.destination.id = :destinationId")
    Optional<FavoriteDestination> findByUserIdAndDestinationId(@Param("userId") String userId, @Param("destinationId") String destinationId);

    boolean existsByUserIdAndDestinationId(String userId, String destinationId);

}