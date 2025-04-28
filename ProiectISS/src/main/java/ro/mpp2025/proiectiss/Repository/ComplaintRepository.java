package ro.mpp2025.proiectiss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mpp2025.proiectiss.Domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
