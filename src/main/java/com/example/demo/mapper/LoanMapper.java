package com.example.demo.mapper;

import com.example.demo.bean.Loan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoanMapper{
	
    /**
     * 根据id查询用户
     * @param loanId
     * @return
     */
   public Loan findByLoanId(String loanId);
}
