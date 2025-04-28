package ro.mpp2025.proiectiss.Domain;

import java.util.Objects;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "complaints")
public class Complaint  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintStatus status;

    public Complaint(User user, String message, ComplaintStatus status) {
        this.user = user;
        this.message = message;
        this.status = status;
    }
    public Complaint(Long id,User user, String message, ComplaintStatus status) {
        this.user = user;
        this.message = message;
        this.status = status;

    }

    public Complaint() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "user=" + user +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return Objects.equals(user, complaint.user) && Objects.equals(message, complaint.message) && status == complaint.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, message, status);
    }
}
