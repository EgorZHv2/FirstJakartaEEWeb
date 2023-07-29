package core.application.services;

import core.application.interfaces.IUserRepository;
import core.domain.entities.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import persistance.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService implements core.application.interfaces.IUserService {
    @Inject
    IUserRepository userRepository;

    public List<User> GetAll()
    {
      return  userRepository.getAll();
    }

    public void  Create(User user){
        userRepository.create(user);
    }

    public  void Delete(UUID userId){
        userRepository.delete(userId);
    }
}
