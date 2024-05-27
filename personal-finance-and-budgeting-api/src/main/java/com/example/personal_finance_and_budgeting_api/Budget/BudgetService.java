package com.example.personal_finance_and_budgeting_api.Budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService
{
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository)
    {
        this.budgetRepository = budgetRepository;
    }

    // Create a new budget
    public Budget createBudget(Budget budget)
    {
        return budgetRepository.save(budget);
    }

    // Get all budgets
    public List<Budget> getAllBudgets()
    {
        return budgetRepository.findAll();
    }

    // Get budget by ID
    public Budget getBudgetById(Long id)
    {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        return budgetOptional.orElse(null);
    }

    // Update budget by ID
    public Budget updateBudget(Long id, Budget budgetDetails)
    {
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
        budget.setName(budgetDetails.getName());
        budget.setAmount(budgetDetails.getAmount());
        return budgetRepository.save(budget);
    }

    // Delete budget by ID
    public void deleteBudget(Long id)
    {
        Budget budget = budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
        budgetRepository.delete(budget);
    }
}
