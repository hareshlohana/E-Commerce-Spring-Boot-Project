package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.TransactionDTO;

import java.util.List;

public interface ITransactionService {

   List <TransactionDTO> getAllTransactions();

    TransactionDTO addTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransactionById(Long id);

    void deleteTransactionById(Long id);
}
