package com.codercampus.Assignment11.repository;

import com.codercampus.Assignment11.domain.Transaction;
import org.springframework.stereotype.Repository;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>(100);

    public TransactionRepository() {
        super();
        populateData();
    }

    public List<Transaction> findAll() {
        return transactions;
    } 

    @SuppressWarnings("unchecked")
    public void populateData() {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/doNotTouch/transactions.doNotTouch");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            this.transactions = (List<Transaction>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Transaction findById(Long transactionId) {
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(transactionId)) {
                return transaction;
            }
        }
        return null; 
    }
    
   
    
}
