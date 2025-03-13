package com.be_servicie.saigon_travel.be_service.entity;

import jakarta.persistence.*;
import lombok.*;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "destination")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Destination extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name_vi", nullable = false, length = 255)
    private String name_vi;

    @Column(name = "name_en", nullable = false, length = 255)
    private String name_en;

    @Column(name = "address_vi")
    private String address_vi;

    @Column(name = "address_en")
    private String address_en;

    @Column(name = "title_vi")
    private String title_vi;

    @Column(name = "title_en")
    private String title_en;

    @Column(name = "description_vi", columnDefinition = "TEXT")
    private String description_vi;
    
    @Column(name = "description_en", columnDefinition = "TEXT")
    private String description_en;

    @Column(name = "content_en", columnDefinition = "TEXT")
    private String content_en;
    
    @Column(name = "content_vi", columnDefinition = "TEXT")
    private String content_vi;

    @Column(name = "image_banner")
    private String image_banner;

    @Column(name = "image_content")
    private String image_content;

    @Column(name = "open_time")
    private String open_time;

    @Column(name = "status", nullable = false)
    private Boolean status;
}
