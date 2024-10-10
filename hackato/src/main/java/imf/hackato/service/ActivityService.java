package imf.hackato.service;

import imf.hackato.entity.Activity;
import imf.hackato.entity.User;
import imf.hackato.repository.ActivityRepository;
import imf.hackato.repository.UserRepository;
import reactor.core.publisher.Mono;

public class ActivityService {
    public final ActivityRepository activityRepository;
    public final UserRepository userRepository;

    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public Mono<Activity> createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Mono<Activity> updateActivity(String id, Activity updatedActivity) {
        return activityRepository.findById(id)
                .flatMap(activity -> {
                    activity.setName(updatedActivity.getName());
                    activity.setMaxCapacity(updatedActivity.getMaxCapacity());
                    activity.setDescription(updatedActivity.getDescription());
                    return activityRepository.save(activity);
                });
    }

    public Mono<Activity> findActivityById(String id) {
        return activityRepository.findById(id);
    }

    public Mono<Activity> addUserToActivity(String activityId, String userId) {
        return Mono.zip(
                activityRepository.findById(activityId),
                userRepository.findById(userId)
        ).flatMap(tuple -> {
            Activity activity = tuple.getT1();
            User user = tuple.getT2();

            if (activity.getParticipants().size() < activity.getMaxCapacity()) {
                activity.getParticipants().add(user);
                return activityRepository.save(activity);
            } else {
                return Mono.error(new RuntimeException("Activity is full"));
            }
        });
    }

    public Mono<Void> deleteActivity(String id) {
        return activityRepository.deleteById(id);
    }
}
