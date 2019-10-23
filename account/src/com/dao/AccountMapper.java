package com.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Account;
import com.pojo.TransactionRecord;

public interface AccountMapper {
public int findAccoutNo(@Param("cardNo")String cardNo);
public int findAccoutPass(@Param("cardNo")String cardNo,@Param("password")String password);
public int findAccout(@Param("cardNo")String cardNo,@Param("password")String password);
public float findBalance(@Param("cardNo")String cardNo);
public String updatBalance(@Param("money")float money,@Param("cardNo1")String cardNo1,@Param("cardNo2")String cardNo2);
public String addBalance(@Param("money")float money,@Param("cardNo1")String cardNo1,@Param("cardNo2")String cardNo2,
						@Param("transactionDate")Date transactionDate );
public int findAccoutStatus(@Param("cardNo")String cardNo);
public float findAccoutBalance(@Param("cardNo")String cardNo);
public List<TransactionRecord> findTransaList(@Param("transactionDate1")Date transactionDate1,
										@Param("transactionDate2")Date transactionDate2,
										@Param("pageStart")Integer currentPageNo,@Param("pageSize")Integer pageSize);
public int findTransacount(@Param("transactionDate1")Date transactionDate1,@Param("transactionDate2")Date transactionDate2);
public int updatPwass(@Param("cardNo")String cardNo,@Param("password")String password);
}
