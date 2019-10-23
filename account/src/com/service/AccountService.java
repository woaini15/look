package com.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.TransactionRecord;

public interface AccountService {
	public int findAccoutNoService(String cardNo);
	public int findAccoutPassService(String cardNo,String password);
	public int findAccoutService(String cardNo,String password);
	public float findBalanceService(String cardNo);
	public String updatBalanceService(float money,String cardNo1,String cardNo2);
	public String addBalanceService(float money,String cardNo1,String cardNo2,Date transactionDate );
	public int findAccoutStatusService(String cardNo);
	public float findAccoutBalanceService(String cardNo);
	public List<TransactionRecord> findTransaListService(Date transactionDate1,Date transactionDate2,Integer currentPageNo,Integer pageSize);
	public int findTransacountService(Date transactionDate1,Date transactionDate2);
	public int updatPwassService(String cardNo,String password);
}
