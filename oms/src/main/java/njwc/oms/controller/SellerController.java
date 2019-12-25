package njwc.oms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import njwc.oms.po.T_seller;
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
		T_seller seller=(T_seller) session.getAttribute("seller");
		return iService.queryMyProducts(seller.getId());
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
	public boolean insertProduct(Integer product_id,String name,Integer type,double price,HttpSession session)
	{
		T_seller seller=(T_seller) session.getAttribute("seller");
		return iService.insertProduct(product_id, name,type, (double) price, seller.getId());
	}
	
	//������Ʒ��Ϣ
	@RequestMapping("updateProduct.do")
	@ResponseBody
	public boolean updateProduct(Integer product_id,String name,double price)
	{
		return iService.updateProduct(product_id, name, price);
	}
	
	//�鿴�ҵ�������¼
	@RequestMapping("queryMyEntry.do")
	@ResponseBody
	public Map<Object,Object> queryMyEntry(HttpSession session)
	{
		T_seller seller=(T_seller) session.getAttribute("seller");
		return iService.queryMyEntry(seller.getId());
	}
}
