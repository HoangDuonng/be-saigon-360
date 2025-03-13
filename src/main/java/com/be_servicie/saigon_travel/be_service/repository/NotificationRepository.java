package com.be_servicie.saigon_travel.be_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be_servicie.saigon_travel.be_service.entity.Notification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findByNotifyTimeBeforeAndSentIsFalse(LocalDateTime now);
}