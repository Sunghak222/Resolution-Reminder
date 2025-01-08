//package dev.sunghak.resolution_reminder.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class NotificationLog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id; // 알림 기록 ID
//
//    @ManyToOne
//    @JoinColumn(name = "res_id", nullable = false)
//    private Resolution resolution; // 어떤 다짐과 연결되어 있는지
//
//    private LocalDateTime sentDate; // 알림이 실제로 보낸 날짜
//
//    private String status; // 성공/실패 상태 (e.g., "SENT", "FAILED")
//
//    public NotificationLog(Resolution resolution, LocalDateTime sentDate, String status) {
//        this.resolution = resolution;
//        this.sentDate = sentDate;
//        this.status = status;
//    }
//
//    public NotificationLog() {
//
//    }
//
//    //Getters and Setters
//    public Long getId() {
//        return id;
//    }
//    public Resolution getResolution() {
//        return resolution;
//    }
//    public void setResolution(Resolution resolution) {
//        this.resolution = resolution;
//    }
//    public LocalDateTime getSentDate() {
//        return sentDate;
//    }
//    public void setSentDate(LocalDateTime sentDate) {
//        this.sentDate = sentDate;
//    }
//    public String getStatus() {
//        return status;
//    }
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}