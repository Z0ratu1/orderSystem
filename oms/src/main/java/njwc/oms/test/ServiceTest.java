package njwc.oms.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import njwc.oms.mapper.ServiceMapper;
import njwc.oms.po.T_user;
import njwc.oms.service.IService;


public class ServiceTest extends BaseTest
{
	@Resource
	private ServiceMapper serviceMapper;
	@Resource
	private IService iService;
	
	//��¼����
//	@Test
//	public void mapperLogin0() throws Exception
//	{
//		T_user user=new T_user();
//		user.setAccount("a001");
//		user.setPassword("123");
//		System.out.println(user.toString());
//		user=serviceMapper.login0(user);
//		System.out.println(user.toString());
//	}
	
	//��ѯ������Ʒ
//	@Test
//	public void queryProducts() throws Exception
//	{
//		List<Object> object = iService.queryProducts();
//		System.out.println(object);
//	}
	
//	//��������
//	@Test
//	public void createOrder() throws Exception
//	{
//		Integer user_id=1;
//		Integer product_id=001;
//		float product_price=(float)52.0;
//		Integer product_num=2;
//		System.out.println(iService.createOrder(user_id, product_id, product_price, product_num));
//	}

//	//��ѯ�ҵ����ж���
//	@Test
//	public void queryMyOrders() throws Exception
//	{
//		List<Object> object=iService.queryMyOrders(1);
//		System.out.println(object);
//	}

//	//���Ķ���״̬
//	@Test
//	public void changeOrderStatus() throws Exception
//	{
//		String order_number="b644777671f3489cb34047bd6fe2796c";
//		Integer status=1;
//		System.out.println(iService.changeOrderStatus(order_number, status));
//	}
	
//	//ɾ������
//	@Test
//	public void deleteOrder() throws Exception
//	{
//		String order_number="ad3bf8ccca274e41913527896fbbe2c8";
//		System.out.println(iService.deleteOrder(order_number));
//	}
	
//	//��ѯ�ҵ����в�Ʒ
//	@Test
//	public void queryMyProducts() throws Exception
//	{
//		System.out.println(iService.queryMyProducts(1));
//	}
	
//	//������Ʒ
//	@Test
//	public void insertProduct() throws Exception
//	{
//		System.out.println(iService.insertProduct(003, "�𻨸�", 12.8, 1));
//	}
	
//	//�޸���Ʒ
//	@Test
//	public void updateProduct() throws Exception
//	{
//		System.out.println(iService.updateProduct(3, "�̶���", 14.5));
//	}
	
//	//ɾ����Ʒ
//	@Test
//	public void deleteProducts() throws Exception
//	{
//		System.out.println(iService.deleteProducts(3));
//	}
	
//	//�鿴�ҵ�������¼
//	@Test
//	public void queryMyEntry() throws Exception
//	{
//		System.out.println(iService.queryMyEntry(1));
//	}
}
