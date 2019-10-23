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
@SessionAttributes("No")//�ŵ�Session�����б��У��Ա�������Կ��Կ��������
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
					model.addAttribute("error", "��¼ʧ�ܣ��ʻ��Ѷ��ᣡ");
					return "log";
				}
			}else{
				model.addAttribute("error", "��¼ʧ�ܣ��������");
				return "log";
			}
		}else{
			model.addAttribute("error", "��¼ʧ�ܣ�������Ŀ��Ų����ڣ�");
			return "log";
		}
	}
	@RequestMapping("/eixtAccount")
	public String eixtAccount(SessionStatus sessionStatus,HttpSession session){
		session.removeAttribute("No");//���HttpSession������
		sessionStatus.setComplete();//���session���������HttpSession������
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
					model.addAttribute("errorer", "ת��ʧ�ܣ�Ŀ���˻����㣡");
					return "transfer";
				}
				
			}else{
				model.addAttribute("errorer", "ת��ʧ�ܣ��ʻ��Ѷ��ᣡ");
				return "transfer";
			}
		}else{
			model.addAttribute("errorer", "ת��ʧ�ܣ�Ŀ���˻������ڣ�");
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
		//pageNo��ȡҳ��
	//���ҳ��Ϊ����Ĭ�ϵ�1ҳ
	if(pageNo==null || pageNo.equals("")||pageNo.equals("0")){
		pageNo="1";
	}
	int pageNo1=Integer.parseInt(pageNo);
	//pageSizeÿҳ��ʾ3��
	int pageSize=3; 
	//count��ȡ������
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date tran=null;
		Date tran1=null;
		try {
			tran = format.parse(transactionDate1);
			tran1=format.parse(transactionDate2);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		int count=service.findTransacountService(tran, tran1);
		System.out.println("count:"+count);
		//page2��ҳ��
		int page2=count%pageSize==0?count/pageSize:count/pageSize+1;
		
		
		System.out.println("page2:"+page2);
		int pageCount = (pageNo1 - 1) * pageSize;
		List<TransactionRecord> list=service.findTransaListService(tran, tran1, pageCount, pageSize);
		int coun=list.size();
		model.addAttribute("list", list); //ÿҳ���ݼ���
		if(coun==0){
			model.addAttribute("find",1);
		}else{
			model.addAttribute("finds",1);
		}
		model.addAttribute("page2", page2); //��ҳ��
		model.addAttribute("count", count); //������
		model.addAttribute("pageNo", pageNo); //��ǰҳ��
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
				model.addAttribute("errs", "�޸ĳɹ�");
				return "pass";
			}else{
				model.addAttribute("errors", "�޸�ʧ��");
				return "pass";
			}
		}else{
			model.addAttribute("errors", "�������������");
			return "pass";
		}
	}
}
