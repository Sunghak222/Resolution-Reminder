package dev.sunghak.resolution_reminder.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Account author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime writtenDate;

    @Column(nullable = false)
    private LocalDateTime sendDate;

    private boolean isSent;

    public Resolution() {
        isSent = false;
    }
    public Resolution(Account author, String content, LocalDateTime writtenDate, LocalDateTime sendDate) {
        this();
        this.author = author;
        this.content = content;
        this.writtenDate = writtenDate;
        this.sendDate = sendDate;
    }

    //Getters and Setters
    public Long getResId() {
        return resId;
    }
    public void setResId(Long resId) {
        this.resId = resId;
    }
    public Account getAuthor() {
        return author;
    }
    public void setAuthor(Account author) {
        this.author = author;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getWrittenDate() {
        return writtenDate;
    }
    public void setWrittenDate(LocalDateTime writtenDate) {
        this.writtenDate = writtenDate;
    }
    public LocalDateTime getSendDate() {
        return sendDate;
    }
    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }
    public boolean isSent() {
        return isSent;
    }
    public void setSent(boolean sent) {
        isSent = sent;
    }
}
