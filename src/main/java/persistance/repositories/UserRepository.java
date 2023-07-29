package persistance.repositories;

import core.application.interfaces.IUserRepository;
import core.domain.entities.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

@ApplicationScoped
public class UserRepository extends BaseRepository<User> implements IUserRepository {

    public UserRepository(){
        super(User.class);
    }

}
