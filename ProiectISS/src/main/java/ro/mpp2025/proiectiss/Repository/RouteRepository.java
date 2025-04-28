package ro.mpp2025.proiectiss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mpp2025.proiectiss.Domain.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // Add any additional methods specific to RouteRepository if needed
}
