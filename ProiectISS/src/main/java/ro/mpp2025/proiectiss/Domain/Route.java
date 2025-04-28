package ro.mpp2025.proiectiss.Domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_station_id", nullable = false)
    private Station departureStation;

    @ManyToOne
    @JoinColumn(name = "arrival_station_id", nullable = false)
    private Station arrivalStation;

    @Column(nullable = false)
    private int distance;

    @Column(nullable = false)
    private int duration;

    @ManyToMany
    private Set<Station> stations = new HashSet<>();

    public Route() {}


    public Route(Station departureStation, Station arrivalStation, int distance, int duration, String trainType) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.duration = duration;
    }

    public Route(Long id, Station departureStation, Station arrivalStation, int distance, int duration) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.distance = distance;
        this.duration = duration;
        this.id = id;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Station> getStations() {
        return stations;
    }
    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }
    public void addStation(Station station) {
        this.stations.add(station);
    }
    public void removeStation(Station station) {
        this.stations.remove(station);
    }

    @Override
    public String toString() {
        return "Route{" +
                "departureStation=" + departureStation +
                ", arrivalStation=" + arrivalStation +
                ", distance=" + distance +
                ", duration=" + duration +
                ", stations=" + stations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return distance == route.distance && duration == route.duration && Objects.equals(departureStation, route.departureStation) && Objects.equals(arrivalStation, route.arrivalStation) && Objects.equals(stations, route.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureStation, arrivalStation, distance, duration, stations);
    }
}
