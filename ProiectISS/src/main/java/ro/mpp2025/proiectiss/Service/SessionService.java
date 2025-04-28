package ro.mpp2025.proiectiss.Service;

import org.springframework.stereotype.Service;
import ro.mpp2025.proiectiss.Domain.User;

@Service
public class SessionService {
    private User currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void clear() {
        currentUser = null;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
