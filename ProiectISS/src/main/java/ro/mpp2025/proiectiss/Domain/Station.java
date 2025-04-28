package ro.mpp2025.proiectiss.Domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stations")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StationType type;

    @Column(nullable = false)
    private int numberOfPlatforms;

    @Column(nullable = false)
    private int numberOfTracks;

    public Station() {}

    public Station(String name, String location, StationType type, int numberOfPlatforms, int numberOfTracks) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.numberOfPlatforms = numberOfPlatforms;
        this.numberOfTracks = numberOfTracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StationType getType() {
        return type;
    }

    public void setType(StationType type) {
        this.type = type;
    }

    public int getNumberOfPlatforms() {
        return numberOfPlatforms;
    }

    public void setNumberOfPlatforms(int numberOfPlatforms) {
        this.numberOfPlatforms = numberOfPlatforms;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return numberOfPlatforms == station.numberOfPlatforms && numberOfTracks == station.numberOfTracks && Objects.equals(id, station.id) && Objects.equals(name, station.name) && Objects.equals(location, station.location) && type == station.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, type, numberOfPlatforms, numberOfTracks);
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type=" + type +
                ", numberOfPlatforms=" + numberOfPlatforms +
                ", numberOfTracks=" + numberOfTracks +
                '}';
    }
}