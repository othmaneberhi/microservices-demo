package org.example.repository;

import org.example.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface INotificationRepository extends JpaRepository<Notification,Integer> {
}
