package servicesImpl;

import models.UserToTravel;
import models.UserToTravelPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.UserToTravelRepository;
import services.UserToTravelService;

import java.util.List;

@Service
public class UserToTravelAlbumServiceImpl implements UserToTravelService {

    @Autowired
    private UserToTravelRepository userToTravelRepository;
    @Transactional
    public UserToTravel addOrUpdate(UserToTravel obj) {
        return userToTravelRepository.saveAndFlush(obj);
    }
    @Transactional
    public List<UserToTravel> getAll() {
        return userToTravelRepository.findAll();
    }
    @Transactional
    public void delete(UserToTravelPK id) {
        userToTravelRepository.delete(id);
    }
    @Transactional
    public UserToTravel get(UserToTravelPK id) {
        return userToTravelRepository.findOne(id);
    }
}
