package ro.mpp2025.proiectiss.Domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "departure_station_id", nullable = false)
    private Station departureStation;

    @ManyToOne
    @JoinColumn(name = "arrival_station_id", nullable = false)
    private Station arrivalStation;

    @Column(nullable = false)
    private boolean isActive;

    public Ticket() {}

    public Ticket(User client, Train train, String seatNumber, LocalDateTime departureTime, LocalDateTime arrivalTime, double price, Station departureStation, Station arrivalStation) {
        this.client = client;
        this.train = train;
        this.seatNumber = seatNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 && isActive == ticket.isActive && Objects.equals(id, ticket.id) && Objects.equals(client, ticket.client) && Objects.equals(train, ticket.train) && Objects.equals(seatNumber, ticket.seatNumber) && Objects.equals(departureTime, ticket.departureTime) && Objects.equals(arrivalTime, ticket.arrivalTime) && Objects.equals(departureStation, ticket.departureStation) && Objects.equals(arrivalStation, ticket.arrivalStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, train, seatNumber, departureTime, arrivalTime, price, departureStation, arrivalStation, isActive);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client +
                ", train=" + train +
                ", seatNumber='" + seatNumber + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", price=" + price +
                ", departureStation=" + departureStation +
                ", arrivalStation=" + arrivalStation +
                ", isActive=" + isActive +
                '}';
    }
}