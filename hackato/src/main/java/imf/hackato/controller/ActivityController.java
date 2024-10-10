package imf.hackato.controller;

import imf.hackato.entity.Activity;
import imf.hackato.service.ActivityService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/appActivities/activity")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public Mono<Activity> createActivity(@RequestBody Activity activity){
        return activityService.createActivity(activity);
    }

    @PutMapping("/{id}")
    public Mono<Activity> updateActivity(@PathVariable String id, Activity activity) {
        return activityService.updateActivity(id, activity);
    }

    @GetMapping("/{id}")
    public Mono<Activity> findActivity(String id) {
        return activityService.findActivityById(id);
    }

    @PutMapping("/{id}/signUp")
    public Mono<Activity> signUserUp(@PathVariable String activityId, @RequestBody String userId) {
        return activityService.addUserToActivity(activityId, userId);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteActivity(@PathVariable String id) {
        return activityService.deleteActivity(id);
    }



}
