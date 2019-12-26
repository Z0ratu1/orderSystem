package njwc.oms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import njwc.oms.vo.SellerVO;
import njwc.oms.vo.UserVO;

@Resource
public interface IService {
	
	//�û���¼
	public abstract UserVO login0(String account,String password);
	
	//�̻���¼
	public abstract SellerVO login1(String account,String password);
	
	
	
	/*
	 * //��ѯ������Ʒ
	 *
	 * 1.������ҳ��������Ʒ
	 * 2.���Ը�����Ʒ���Ͷ���Ʒ������ʾ
	 * 3.�����Ʒ��ʾ��Ʒ��������Ϣ
     */	
	public abstract List<Object> queryProducts();
	
	/**
	 *  //��������
	 *  //����µ����ɶ������Ҵ�����Ŀ
	 * @param user_id,product_id,product_price,product_num
	 * @return boolean
	 */
	public abstract boolean createOrder(Integer user_id,Integer product_id,double product_price,Integer product_num);
	
	/*
	 * //��ѯ�ҵ����ж���
	 * 
	 * 1.������ҵĶ�������ʾ���ҵ����ж���
	 * 2.���ݶ���״̬����������
	 * 3.���һ��������ʾ��������
	 * 4.������ȷ���ջ��ı䶩��״̬
	 * 5.���ɾ��ɾ������
	 */
	public abstract List<Object> queryMyOrders(Integer user_id,Integer status);
	
	//���¶���״̬��0��δ���1���Ѹ��
	public abstract boolean changeOrderStatus(String order_number,Integer status);
	
	//ɾ������
	public abstract boolean deleteOrder(String order_number);
	
	
	
	//��ɫ�� �̻�
	/**  
	 *  //��ѯ�ҵ����в�Ʒ
	 *  //�̻���¼��ҳ��ʾ���̻������������в�Ʒ
	 * @param seller_id
	 * @return List<Object>
	 */
	public abstract List<Object> queryMyProducts(Integer seller_id);
	
	/**
	 *  //ɾ����Ʒ
	 * @param product_id
	 * @return boolean
	 */
	public abstract boolean deleteProducts(Integer product_id);
	
	/**
	 *  //������Ʒ
	 *  //�̻������²�Ʒ
	 * @param product_id
	 * @param name
	 * @param price
	 * @param seller_id
	 * @return
	 */
	public abstract boolean insertProduct(Integer product_id,String name,Integer type,double price,Integer seller_id);

	/**
	 *  //������Ʒ��Ϣ
	 * @param product_id
	 * @param name
	 * @param price
	 * @return
	 */
	public abstract boolean updateProduct(Integer product_id,String name,double price);
	
	/**
	 *  //�鿴�ҵ�������¼
	 * @param product_id
	 * @return
	 */
	public abstract Map<Object, Object> queryMyEntry(Integer seller_id);
	
	// ��ɫ�� �̻�
	/**
	 * //��ѯ�ҵ����в�Ʒ //�̻���¼��ҳ��ʾ���̻������������в�Ʒ
	 * 
	 * @param product_name
	 * @return List<Object>
	 */
	public abstract List<Object> searchingProduct(String product_name);
}
