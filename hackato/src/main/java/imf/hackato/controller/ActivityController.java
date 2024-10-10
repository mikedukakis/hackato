package imf.hackato.controller;

import imf.hackato.entity.Activity;
import imf.hackato.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Data
@RestController
@RequestMapping("/appActivities/activity")
@Tag(name = "Activity", description = "Operations related to activity management")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Operation(summary = "Create activity", description = "Creates a new activity.")
    @PostMapping
    public Mono<Activity> createActivity(@RequestBody Activity activity){
        return activityService.createActivity(activity);
    }

    @Operation(summary = "Update activity", description = "Updates an existing activity, located with Id.")
    @PutMapping("/{id}")
    public Mono<Activity> updateActivity(@PathVariable String id, Activity activity) {
        return activityService.updateActivity(id, activity);
    }

    @Operation(summary = "Find activity", description = "Finds an existing activity, located with Id.")
    @GetMapping("/{id}")
    public Mono<Activity> findActivity(String id) {
        return activityService.findActivityById(id);
    }

    @Operation(summary = "Sign-up user", description = "Signs a user (via user Id) up in the activity with a certain activity Id")
    @PutMapping("/{id}/signUp")
    public Mono<Activity> signUserUp(@PathVariable String activityId, @RequestBody String userId) {
        return activityService.addUserToActivity(activityId, userId);
    }

    @Operation(summary = "Delete activity", description = "Deletes an existing activity, located with Id.")
    @DeleteMapping("/{id}")
    public Mono<Void> deleteActivity(@PathVariable String id) {
        return activityService.deleteActivity(id);
    }



}
