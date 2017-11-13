package com.example.demo.service;

import com.example.demo.bean.Loan;
import com.example.demo.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xing on 2017/6/16.
 */
@Service
public class LoanService {

    @Autowired
    private LoanMapper loanMapper;

    public Loan findLoanById(String id){
        Loan loan = loanMapper.findByLoanId(id);
        return loan;
    }


}
