package ro.mpp2025.proiectiss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mpp2025.proiectiss.Domain.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    // Add any additional methods specific to StationRepository if needed
}
