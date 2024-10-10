package imf.hackato.service;

import imf.hackato.entity.User;
import imf.hackato.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    user.setName(updatedUser.getName());
                    user.setLname(updatedUser.getLname());
                    user.setAge(updatedUser.getAge());
                    user.setEmail(updatedUser.getEmail());
                    user.setTelephone(updatedUser.getTelephone());
                    return userRepository.save(user);
                });
    }

    public Mono<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }


}
