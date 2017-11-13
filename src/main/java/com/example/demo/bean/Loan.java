package com.example.demo.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by xing on 2017/6/7.
 */
public class Loan implements Serializable{

    private static final long serialVersionUID = 1L;

    
    private String loanId;

    private String name;

    private String parentLoanId;

    private String borrowerUserAccountId;

    private String investId;

    private Integer srcLoanId;

    private Integer status;

    private BigDecimal amount;

    private BigDecimal currentAmount;

    private BigDecimal rate;

    private BigDecimal feeRate;

    private BigDecimal riskRate;

    private Integer repaymentType;

    private String orderNumber;

    private Integer days;

    private BigDecimal starLevel;

    private String brrowerUserName;

    private Integer raiseDays;

    private Integer loanType;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentLoanId() {
        return parentLoanId;
    }

    public void setParentLoanId(String parentLoanId) {
        this.parentLoanId = parentLoanId;
    }

    public String getBorrowerUserAccountId() {
        return borrowerUserAccountId;
    }

    public void setBorrowerUserAccountId(String borrowerUserAccountId) {
        this.borrowerUserAccountId = borrowerUserAccountId;
    }

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId;
    }

    public Integer getSrcLoanId() {
        return srcLoanId;
    }

    public void setSrcLoanId(Integer srcLoanId) {
        this.srcLoanId = srcLoanId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public BigDecimal getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(BigDecimal riskRate) {
        this.riskRate = riskRate;
    }

    public Integer getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(Integer repaymentType) {
        this.repaymentType = repaymentType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    public String getBrrowerUserName() {
        return brrowerUserName;
    }

    public void setBrrowerUserName(String brrowerUserName) {
        this.brrowerUserName = brrowerUserName;
    }

    public Integer getRaiseDays() {
        return raiseDays;
    }

    public void setRaiseDays(Integer raiseDays) {
        this.raiseDays = raiseDays;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", name=" + name
				+ ", borrowerUserAccountId=" + borrowerUserAccountId
				+ ", investId=" + investId + ", srcLoanId=" + srcLoanId
				+ ", status=" + status + ", amount=" + amount
				+ ", currentAmount=" + currentAmount + "]";
	}
    
}
