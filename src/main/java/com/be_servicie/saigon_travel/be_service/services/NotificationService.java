package com.be_servicie.saigon_travel.be_service.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.be_servicie.saigon_travel.be_service.entity.Notification;
import com.be_servicie.saigon_travel.be_service.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Chạy mỗi phút để kiểm tra thông báo cần gửi
    @Scheduled(fixedRate = 60000)
    public void sendNotifications() {
        LocalDateTime now = LocalDateTime.now();

        // Lấy danh sách thông báo chưa gửi đến hạn
        List<Notification> notifications = notificationRepository.findByNotifyTimeBeforeAndSentIsFalse(now);

        for (Notification notification : notifications) {
            sendNotificationToUser(notification.getUserId(), notification.getMessage());

            // Đánh dấu là đã gửi
            notification.setSent(true);
            notificationRepository.save(notification);
        }
    }

    // Giả lập hàm gửi thông báo
    private void sendNotificationToUser(String userId, String message) {
        System.out.println("📢 Sending notification to user " + userId + ": " + message);
        // Nếu dùng WebSocket hoặc Firebase thì thay thế đoạn này
    }
}