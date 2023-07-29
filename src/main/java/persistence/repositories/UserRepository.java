package persistence.repositories;

import core.application.interfaces.IUserRepository;
import core.domain.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository extends BaseRepository<User> implements IUserRepository {

    public UserRepository(){
        super(User.class);
    }

}
