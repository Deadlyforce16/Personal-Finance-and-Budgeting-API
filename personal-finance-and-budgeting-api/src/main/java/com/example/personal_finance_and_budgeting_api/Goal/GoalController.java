package com.example.personal_finance_and_budgeting_api.Goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController
{
    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService)
    {
        this.goalService = goalService;
    }

    // Create a new goal
    @PostMapping
    public Goal createGoal(@RequestBody Goal goal)
    {
        return goalService.createGoal(goal);
    }

    // Get all goals
    @GetMapping
    public List<Goal> getAllGoals()
    {
        return goalService.getAllGoals();
    }

    // Get goal by ID
    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id)
    {
        Goal goal = goalService.getGoalById(id);
        if (goal == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(goal);
    }

    // Update goal by ID
    @PutMapping("/{id}")
    public Goal updateGoal(@PathVariable Long id, @RequestBody Goal goalDetails)
    {
        return goalService.updateGoal(id, goalDetails);
    }

    // Delete goal by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id)
    {
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
}
