package com.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountMapper;
import com.pojo.Account;
import com.pojo.TransactionRecord;
import com.service.AccountService;
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper objMapper;
	@Override
	public int findAccoutNoService(String cardNo) {
		// TODO 自动生成的方法存根
		return objMapper.findAccoutNo(cardNo);
	}

	@Override
	public int findAccoutPassService(String cardNo, String password) {
		// TODO 自动生成的方法存根
		return objMapper.findAccoutPass(cardNo, password);
	}

	@Override
	public int findAccoutService(String cardNo, String password) {
		// TODO 自动生成的方法存根
		return objMapper.findAccout(cardNo, password);
	}

	@Override
	public float findBalanceService(String cardNo) {
		// TODO 自动生成的方法存根
		return objMapper.findBalance(cardNo);
	}

	@Override
	public String updatBalanceService(float money, String cardNo1, String cardNo2) {
		// TODO 自动生成的方法存根
		return objMapper.updatBalance(money, cardNo1, cardNo2);
	}

	@Override
	public String addBalanceService(float money, String cardNo1,
			String cardNo2, Date transactionDate) {
		// TODO 自动生成的方法存根
		return objMapper.addBalance(money, cardNo1, cardNo2, transactionDate);
	}

	@Override
	public int findAccoutStatusService(String cardNo) {
		// TODO 自动生成的方法存根
		return objMapper.findAccoutStatus(cardNo);
	}

	@Override
	public float findAccoutBalanceService(String cardNo) {
		// TODO 自动生成的方法存根
		return objMapper.findAccoutBalance(cardNo);
	}

	@Override
	public List<TransactionRecord> findTransaListService(Date transactionDate1,
			Date transactionDate2, Integer currentPageNo, Integer pageSize) {
		// TODO 自动生成的方法存根
		return objMapper.findTransaList(transactionDate1, transactionDate2, currentPageNo, pageSize);
	}

	@Override
	public int findTransacountService(Date transactionDate1, Date transactionDate2) {
		// TODO 自动生成的方法存根
		return objMapper.findTransacount(transactionDate1, transactionDate2);
	}

	@Override
	public int updatPwassService(String cardNo, String password) {
		// TODO 自动生成的方法存根
		return objMapper.updatPwass(cardNo, password);
	}

}
