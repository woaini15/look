package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.pojo.TransactionRecord;
import com.service.AccountService;

@Controller
@SessionAttributes("No")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/acco")
public class AccountContoller {
	@Autowired
	private AccountService service;
	@RequestMapping("/lookAccount")
	public String lookAccount(){
		return "log";
	}
	@RequestMapping("/lookTilet")
	public String lookTilet(){
		return "tilet";
	}
	@RequestMapping("/lookTransfer")
	public String lookTransfer(){
		return "transfer";
	}
	@RequestMapping("/lookfind")
	public String lookfind(){
		return "find";
	}
	@RequestMapping("/lookpass")
	public String lookpass(){
		return "pass";
	}
	@RequestMapping("/findProjectinfolist")
	  public String findInformationslist(@RequestParam(value ="cardNo",required = false)String cardNo,
			  							@RequestParam(value ="password",required = false)String password,
			  							@RequestParam(value ="status",required = false)String status,
			  							Model model){
		int count=service.findAccoutNoService(cardNo);
		if(count>0){
			int count1=service.findAccoutPassService(cardNo, password);
			if(count1>0){
				int count2=service.findAccoutService(cardNo, password);
				if(count2>0){
					model.addAttribute("No", cardNo);
					return "main";
				}else{
					model.addAttribute("error", "登录失败！帐户已冻结！");
					return "log";
				}
			}else{
				model.addAttribute("error", "登录失败！密码错误！");
				return "log";
			}
		}else{
			model.addAttribute("error", "登录失败！您输入的卡号不存在！");
			return "log";
		}
	}
	@RequestMapping("/eixtAccount")
	public String eixtAccount(SessionStatus sessionStatus,HttpSession session){
		session.removeAttribute("No");//清除HttpSession的数据
		sessionStatus.setComplete();//清除session，不会清除HttpSession的数据
		return "log";
	}
	@RequestMapping("/findBalance")
	public String findBalance(@ModelAttribute("No")String No,Model model){
		float money=service.findBalanceService(No);
		model.addAttribute("money", money);
		return "balance";
	}
	@RequestMapping("/updatBalance")
	public String updatBalance(@ModelAttribute("No")String No,
								@RequestParam(value ="money",required = false)float money,
								@RequestParam(value ="cardNo2",required = false)String cardNo2,
								Model model){
		int count=service.findAccoutNoService(cardNo2);
		if(count>0){
			int count1=service.findAccoutStatusService(cardNo2);
			if(count1>0){
				float money1=service.findAccoutBalanceService(No);
				if(money1>money){
					service.updatBalanceService(money, No, cardNo2);
					Date transactionDate=new Date();
					service.addBalanceService(money, No, cardNo2, transactionDate);
					return "successful";
				}else{
					model.addAttribute("errorer", "转账失败！目标账户余额不足！");
					return "transfer";
				}
				
			}else{
				model.addAttribute("errorer", "转账失败！帐户已冻结！");
				return "transfer";
			}
		}else{
			model.addAttribute("errorer", "转账失败！目标账户不存在！");
			return "transfer";
		}
	}
	@RequestMapping("/findTransalist")
	  public String findTransalist(@RequestParam(value ="pageNo",required = false)String pageNo,
			  						@RequestParam(value ="transactionDate1",required = false)String transactionDate1,
			  						@RequestParam(value ="transactionDate2",required = false)String transactionDate2,
			  						Model model){
		model.addAttribute("transactionDate1", transactionDate1);
		model.addAttribute("transactionDate2", transactionDate2);
		//pageNo获取页码
	//如果页码为空则默认第1页
	if(pageNo==null || pageNo.equals("")||pageNo.equals("0")){
		pageNo="1";
	}
	int pageNo1=Integer.parseInt(pageNo);
	//pageSize每页显示3条
	int pageSize=3; 
	//count获取总条数
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date tran=null;
		Date tran1=null;
		try {
			tran = format.parse(transactionDate1);
			tran1=format.parse(transactionDate2);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int count=service.findTransacountService(tran, tran1);
		System.out.println("count:"+count);
		//page2总页数
		int page2=count%pageSize==0?count/pageSize:count/pageSize+1;
		
		
		System.out.println("page2:"+page2);
		int pageCount = (pageNo1 - 1) * pageSize;
		List<TransactionRecord> list=service.findTransaListService(tran, tran1, pageCount, pageSize);
		int coun=list.size();
		model.addAttribute("list", list); //每页数据集合
		if(coun==0){
			model.addAttribute("find",1);
		}else{
			model.addAttribute("finds",1);
		}
		model.addAttribute("page2", page2); //总页数
		model.addAttribute("count", count); //总条数
		model.addAttribute("pageNo", pageNo); //当前页码
		  return "find";
	  }
	@RequestMapping("/updatpwass")
	public String updatpwass(@ModelAttribute("No")String No,
				@RequestParam(value ="password1",required = false)String password1,
				@RequestParam(value ="password2",required = false)String password2,
				Model model){
		int count=service.findAccoutPassService(No, password1);
		if(count>0){
			int count1=service.updatPwassService(No, password2);
			if(count1>0){
				model.addAttribute("errs", "修改成功");
				return "pass";
			}else{
				model.addAttribute("errors", "修改失败");
				return "pass";
			}
		}else{
			model.addAttribute("errors", "旧密码输入错误");
			return "pass";
		}
	}
}
