package com.coderscampus.Assignment11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.coderscampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

//    @GetMapping("/transactions/{transactionId}")
//    public String getTransactionDetails(@PathVariable("transactionId") Long transactionId, Model model) {
//        Transaction transaction = transactionService.getTransactionById(transactionId);
//        model.addAttribute("transaction", transaction);
//        return "transactionDetails";
//    }
    
   
   
    
    
}
