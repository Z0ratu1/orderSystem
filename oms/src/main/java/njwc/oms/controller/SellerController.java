package njwc.oms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import njwc.oms.service.IService;
import njwc.oms.vo.SellerVO;

@Controller
public class SellerController {
	
	@Resource
	private IService iService=null;
	
	//�̻���¼
	@RequestMapping("login1.do")
	@ResponseBody
	public SellerVO login1(String account, String password,HttpSession session)
	{
		SellerVO sellervo=iService.login1(account, password);
		session.setAttribute("seller", sellervo.getSeller());
		return sellervo;
	}
	
	//��ѯ�ҵ����в�Ʒ
	@RequestMapping("queryMyProducts.do")
	@ResponseBody
	public List<Object> queryMyProducts(HttpSession session)
	{
		Integer seller_id=(Integer) session.getAttribute("seller");
		return iService.queryMyProducts(seller_id);
	}

	//ɾ����Ʒ
	@RequestMapping("deleteProducts.do")
	@ResponseBody
	public boolean deleteProducts(Integer product_id)
	{
		return iService.deleteProducts(product_id);
	}
	
	//�����²�Ʒ
	@RequestMapping("insertProduct.do")
	@ResponseBody
	public boolean insertProduct(Integer product_id,String name,float price,HttpSession session)
	{
		Integer seller_id=(Integer) session.getAttribute("seller");
		return iService.insertProduct(product_id, name, price, seller_id);
	}
	
	//������Ʒ��Ϣ
	@RequestMapping("updateProduct.do")
	@ResponseBody
	public boolean updateProduct(Integer product_id,String name,float price)
	{
		return iService.updateProduct(product_id, name, price);
	}
	
	//�鿴�ҵ�������¼
	@RequestMapping("queryMyEntry.do")
	@ResponseBody
	public Map<Object,Object> queryMyEntry(HttpSession session)
	{
		Integer seller_id=(Integer) session.getAttribute("seller");
		return iService.queryMyEntry(seller_id);
	}
}
