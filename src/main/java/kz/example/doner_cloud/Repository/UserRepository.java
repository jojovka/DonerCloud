package kz.example.doner_cloud.Repository;

import kz.example.doner_cloud.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
