package njwc.oms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import njwc.oms.po.T_user;
import njwc.oms.service.IService;
import njwc.oms.vo.UserVO;

@Controller
public class UserController {
	
	@Resource
	private IService iService=null;
	
	//�û���¼
	@RequestMapping("login0.do")
	@ResponseBody
	public UserVO login0(String account, String password,HttpSession session)
	{
		UserVO uservo=iService.login0(account, password);
		session.setAttribute("user", uservo.getUser());
		return uservo;
	}
	
	//��ʾ������Ʒ
	@RequestMapping("queryProducts.do")
	@ResponseBody
	public List<Object> queryProducts()
	{
		return iService.queryProducts();
	}
	
	//��������
	@RequestMapping("createOrder.do")
	@ResponseBody
	public boolean createOrder(Integer product_id,double product_price,Integer product_num,HttpSession session)
	{
		T_user user=(T_user) session.getAttribute("user");
		return iService.createOrder(user.getId(), product_id, product_price, product_num);
	}

	//��ѯ�ҵ����ж���
	@RequestMapping("queryMyOrders.do")
	@ResponseBody
	public List<Object> queryMyOrders(Integer status,HttpSession session)
	{
		T_user user=(T_user) session.getAttribute("user");
		return iService.queryMyOrders(user.getId(),status);
	}
	
	//���¶���״̬
	@RequestMapping("changeOrderStatus.do")
	@ResponseBody
	public boolean changeOrderStatus(String order_number,Integer status)
	{
		return iService.changeOrderStatus(order_number, status);
	}
	
	//ɾ������
	@RequestMapping("deleteOrder.do")
	@ResponseBody
	public boolean deleteOrder(String order_number)
	{
		return iService.deleteOrder(order_number);
	}
	
	
}
