package core.application.interfaces;

import core.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<User> GetAll();
    void  Create(User user);
    public  void Delete(UUID userId);

}
