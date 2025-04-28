package ro.mpp2025.proiectiss.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mpp2025.proiectiss.Domain.Station;
import ro.mpp2025.proiectiss.Domain.Train;
import ro.mpp2025.proiectiss.Domain.User;
import ro.mpp2025.proiectiss.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ComplaintRepository complaintRepository;
    private final StationRepository stationRepository;
    private final RouteRepository routeRepository;
    private final TicketRepository ticketRepository;
    private final TrainRepository trainRepository;;

    @Autowired
    public UserService(UserRepository userRepository,
                      ComplaintRepository complaintRepository,
                      StationRepository stationRepository,
                      RouteRepository routeRepository,
                      TicketRepository ticketRepository,
                      TrainRepository trainRepository) {
        this.userRepository = userRepository;
        this.complaintRepository = complaintRepository;
        this.stationRepository = stationRepository;
        this.routeRepository = routeRepository;
        this.ticketRepository = ticketRepository;
        this.trainRepository = trainRepository;
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public List<Train> getArrivals(String station) {
        // Replace with actual logic to fetch arrival trains from database
        List<Train> trains = trainRepository.findAll();
        return trains.stream()
                .filter(train -> train.getRoute().getArrivalStation().getName().equals(station))
                .toList(); // hypothetical method
    }

    // Fetch all departing trains
    public List<Train> getDepartures(String station) {
        // Replace with actual logic to fetch departure trains from database
        List<Train> trains = trainRepository.findAll();
        return trains.stream()
                .filter(train -> train.getRoute().getDepartureStation().getName().equals(station))
                .toList(); // hypothetical method // hypothetical method
    }
    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean veirfyLogin(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user==null)
            return false;
        if(password.equals(user.getPassword()))
            return true;
        return false;
    }
    // Add more logic as needed (e.g., delete, update)
}
