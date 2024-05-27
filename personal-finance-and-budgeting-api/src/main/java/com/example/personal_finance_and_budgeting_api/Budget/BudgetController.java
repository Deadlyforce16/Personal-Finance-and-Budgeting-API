package com.example.personal_finance_and_budgeting_api.Budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController
{
    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService)
    {
        this.budgetService = budgetService;
    }

    // Create a new budget
    @PostMapping
    public Budget createBudget(@RequestBody Budget budget)
    {
        return budgetService.createBudget(budget);
    }

    // Get all budgets
    @GetMapping
    public List<Budget> getAllBudgets()
    {
        return budgetService.getAllBudgets();
    }

    // Get budget by ID
    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id)
    {
        Budget budget = budgetService.getBudgetById(id);
        if (budget == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(budget);
    }

    // Update budget by ID
    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budgetDetails)
    {
        return budgetService.updateBudget(id, budgetDetails);
    }

    // Delete budget by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id)
    {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }
}
