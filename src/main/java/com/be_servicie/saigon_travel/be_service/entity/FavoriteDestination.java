package com.be_servicie.saigon_travel.be_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite_destinations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteDestination {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;
}
