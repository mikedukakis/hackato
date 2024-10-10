package imf.hackato.repository;

import imf.hackato.entity.Activity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ActivityRepository extends ReactiveMongoRepository<Activity, String> {

}
