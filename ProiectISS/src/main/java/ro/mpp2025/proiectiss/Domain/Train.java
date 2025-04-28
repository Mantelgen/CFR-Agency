package ro.mpp2025.proiectiss.Domain;

import jakarta.persistence.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

@Entity
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String trainNumber;

    @Column(nullable = false)
    private int noSeats;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column(nullable = false)
    private String departureTime;

    @Column(nullable = false)
    private String arrivalTime;

    @Column(nullable = false)
    private String trainType;

    public Train() {}

    public Train(String trainNumber, int noSeats, Route route, String departureTime, String arrivalTime, String trainType) {
        this.trainNumber = trainNumber;
        this.noSeats = noSeats;
        this.route = route;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.trainType = trainType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return noSeats == train.noSeats && Objects.equals(id, train.id) && Objects.equals(trainNumber, train.trainNumber) && Objects.equals(route, train.route) && Objects.equals(departureTime, train.departureTime) && Objects.equals(arrivalTime, train.arrivalTime) && Objects.equals(trainType, train.trainType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainNumber, noSeats, route, departureTime, arrivalTime, trainType);
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainNumber='" + trainNumber + '\'' +
                ", noSeats=" + noSeats +
                ", route=" + route +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", trainType='" + trainType + '\'' +
                '}';
    }

    public StringProperty trainNumberProperty() {
        return new SimpleStringProperty(trainNumber);
    }

    public StringProperty departureTimeProperty() {
        return new SimpleStringProperty(departureTime);
    }

    public StringProperty routeArrivalProperty() {
        return new SimpleStringProperty(route != null ? route.getArrivalStation().getName() : ""); // Assuming Route has a getName() method
    }

    public StringProperty routeDepartureProperty() {
        return new SimpleStringProperty(route != null ? route.getDepartureStation().getName() : ""); // Assuming Route has a getName() method
    }


    public StringProperty trainTypeProperty() {
        return new SimpleStringProperty(trainType);
    }

    public StringProperty arrivalTimeProperty() {
        return new SimpleStringProperty(arrivalTime);
    }
}