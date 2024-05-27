package com.example.personal_finance_and_budgeting_api.Goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GoalService
{
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository)
    {
        this.goalRepository = goalRepository;
    }

    // Create a new goal
    public Goal createGoal(Goal goal)
    {
        return goalRepository.save(goal);
    }

    // Get all goals
    public List<Goal> getAllGoals()
    {
        return goalRepository.findAll();
    }

    // Get goal by ID
    public Goal getGoalById(Long id)
    {
        Optional<Goal> goalOptional = goalRepository.findById(id);
        return goalOptional.orElse(null);
    }

    // Update goal by ID
    public Goal updateGoal(Long id, Goal goalDetails)
    {
        Goal goal = goalRepository.findById(id).orElseThrow(() -> new RuntimeException("Goal not found"));
        goal.setDescription(goalDetails.getDescription());
        goal.setTargetAmount(goalDetails.getTargetAmount());
        return goalRepository.save(goal);
    }

    // Delete goal by ID
    public void deleteGoal(Long id)
    {
        Goal goal = goalRepository.findById(id).orElseThrow(() -> new RuntimeException("Goal not found"));
        goalRepository.delete(goal);
    }
}
