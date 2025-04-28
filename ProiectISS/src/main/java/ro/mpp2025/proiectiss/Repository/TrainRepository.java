package ro.mpp2025.proiectiss.Repository;

import org.springframework.stereotype.Repository;
import ro.mpp2025.proiectiss.Domain.Train;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    // Add any additional methods specific to TrainRepository if needed

}
