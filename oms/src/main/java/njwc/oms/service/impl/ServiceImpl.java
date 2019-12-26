package njwc.oms.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import njwc.oms.po.T_entry;
import njwc.oms.po.T_order;
import njwc.oms.po.T_product;
import njwc.oms.po.T_seller;
import njwc.oms.po.T_user;
import njwc.oms.service.IService;
import njwc.oms.vo.OrderVO;
import njwc.oms.vo.SellerVO;
import njwc.oms.vo.UserVO;
import njwc.oms.mapper.*;


@Service
public class ServiceImpl implements IService
{

	@Resource
    private ServiceMapper  serviceMapper;

	//�û���¼
	@Override
	public UserVO login0(String account, String password) {
		// TODO Auto-generated method stub
		T_user user=new T_user();
		user.setAccount(account);
		user.setPassword(password);
		user=serviceMapper.login0(user);
		UserVO uservo=new UserVO();
		if(user==null)
		{
			uservo.setMessage("�û������ڣ�");
			uservo.setUser(null);
			return uservo;
		}
		if(password.equals(user.getPassword()))
		{
			uservo.setMessage("200");
			uservo.setUser(user);
			return uservo;
		}
		uservo.setMessage("�������");
		return uservo;
	}

	//�̻���¼
	@Override
	public SellerVO login1(String account, String password) {
		// TODO Auto-generated method stub
		T_seller seller=new T_seller();
		seller.setAccount(account);
		seller.setPassword(password);
		seller=serviceMapper.login1(seller);
		SellerVO sellervo=new SellerVO();
		if(seller==null)
		{
			sellervo.setMessage("�û������ڣ�");
			sellervo.setSeller(null);
			return sellervo;
		}
		if(password.equals(seller.getPassword()))
		{
			sellervo.setMessage("200");
			sellervo.setSeller(seller);
			return sellervo;
		}
		sellervo.setMessage("�������");
		return sellervo;
	}

	//��ѯ���в�Ʒ
	@Override
	public List<Object> queryProducts() {
		// TODO Auto-generated method stub
		return serviceMapper.queryProducts();
	}

	//��������
	@Override
	public boolean createOrder(Integer user_id, Integer product_id, double product_price, Integer product_num) {
		// TODO Auto-generated method stub
		String order_number = UUID.randomUUID().toString().replaceAll("-", "");
		Timestamp create_time= new Timestamp(System.currentTimeMillis());//��ȡϵͳ��ǰʱ��
		T_order order=new T_order();
		order.setOrder_number(order_number);
		order.setCreate_time(create_time);
		order.setStatus(0);
		order.setUser_id(user_id);
		//�����¶���
		boolean sign1=serviceMapper.insertOrder(order);
		if(sign1==false) return false;
		
		T_entry entry=new T_entry();
		entry.setProduct_id(product_id);
		entry.setProduct_price(product_price);
		entry.setProduct_num(product_num);
		entry.setOrder_number(order_number);
		//������Ŀ
		boolean sign2=serviceMapper.insertEntry(entry);
		if(sign2==false) return false;
		return true;
	}

	//��ѯ�ҵĶ���
	@Override
	public List<Object> queryMyOrders(Integer user_id,Integer status) {
		// TODO Auto-generated method stub
		List<Object> list=new ArrayList<Object>();
		List<Object> result=new ArrayList<Object>();
		list=serviceMapper.queryMyOrders(user_id, status);
		for (Object object : list) {
			T_order order=(T_order) object;
			OrderVO ordervo=new OrderVO();
			ordervo.setOrder(order);
			List<Object> entry=serviceMapper.queryEntry(order.getOrder_number());
			ordervo.setEntry(entry);
			result.add(ordervo);
		}
		return result;
	}

	//�ı䶩��״̬
	@Override
	public boolean changeOrderStatus(String order_number, Integer status) {
		// TODO Auto-generated method stub
		return serviceMapper.changeOrderStatus(order_number, status);
	}

	//ɾ������
	@Override
	public boolean deleteOrder(String order_number) {
		// TODO Auto-generated method stub
		serviceMapper.deleteEntry(order_number);
		return serviceMapper.deleteOrder(order_number);
	}

	
	/**
	 *   //�̼ҹ���
	 */
	//��ѯ�ҷ�����������Ʒ
	@Override
	public List<Object> queryMyProducts(Integer seller_id) {
		// TODO Auto-generated method stub
		return serviceMapper.queryMyProducts(seller_id);
	}

	//ɾ��һ����Ʒ
	@Override
	public boolean deleteProducts(Integer product_id) {
		// TODO Auto-generated method stub
		return serviceMapper.deleteProducts(product_id);
	}

	//����һ����Ʒ
	@Override
	public boolean insertProduct(Integer product_id, String name,Integer type, double price, Integer seller_id) {
		// TODO Auto-generated method stub
		T_product product = new T_product();
		product.setProduct_id(product_id);
		product.setName(name);
		product.setType(type);
		product.setPrice(price);
		product.setSeller_id(seller_id);
		return serviceMapper.insertProduct(product);
	}
	
	//������Ʒ��Ϣ
	public boolean updateProduct(Integer product_id,String name,double price) {
		// TODO Auto-generated method stub
		return serviceMapper.updateProduct(product_id, name, price);
	}

	//�鿴����������Ŀ
	@Override
	public Map<Object,Object> queryMyEntry(Integer seller_id) {
		// TODO Auto-generated method stub
		Map<Object,Object> result=new HashMap<Object,Object>();
		List<Integer> arraylist=new ArrayList<Integer>();
		arraylist=serviceMapper.queryProduct_id(seller_id);
		for(Integer product_id : arraylist)
		{
			List<Object> list =new ArrayList<Object>();
			list=serviceMapper.queryMyEntry(product_id);
			result.put(product_id, list);
		}
		return result;
	}

	@Override
	public List<Object> searchingProduct(String product_name) {
		// TODO Auto-generated method stub
		return serviceMapper.serchingProduct(product_name);
	}

}
