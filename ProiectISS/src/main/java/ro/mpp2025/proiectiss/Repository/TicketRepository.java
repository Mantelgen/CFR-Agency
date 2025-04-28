package ro.mpp2025.proiectiss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mpp2025.proiectiss.Domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Add any additional methods specific to TicketRepository if needed
}
