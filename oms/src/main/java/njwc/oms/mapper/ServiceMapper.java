package njwc.oms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import njwc.oms.po.T_entry;
import njwc.oms.po.T_order;
import njwc.oms.po.T_product;
import njwc.oms.po.T_seller;
import njwc.oms.po.T_user;

@Mapper
public interface ServiceMapper {
	
	// �û���¼
	public abstract T_user login0(T_user user);
	
	// �̻���¼
	public abstract T_seller login1(T_seller seller);
	
	//��ѯ������Ʒ
	public abstract List<Object> queryProducts();
	
	//�����¶���
	public abstract boolean insertOrder(T_order order);
	
	//������Ŀ
	public abstract boolean insertEntry(T_entry entry);
	
	//��ѯ�ҵĶ���
	public abstract List<Object> queryMyOrders(@Param("user_id")Integer user_id,@Param("status")Integer status);
	
	//���ݶ����Ų���Ŀ
	public abstract List<Object> queryEntry(String order_number);
	
	//�ı䶩��״̬
	public abstract boolean changeOrderStatus(@Param("order_number")String order_number, @Param("status")Integer status);
	
	//ɾ������
	public abstract boolean deleteOrder(String order_number);
	
	
	
	//��ѯ�̼ҷ�������Ʒ
	public abstract List<Object> queryMyProducts(Integer seller_id);
	
	//ɾ����Ʒ
	public abstract boolean deleteProducts(Integer product_id);
	
	//������Ʒ
    public abstract boolean insertProduct(T_product product);
    
    //������Ʒ��Ϣ
    public abstract boolean updateProduct(@Param("product_id")Integer product_id,@Param("name")String name,@Param("price")double price);
    
    //������Ʒid����������Ŀ
	public abstract List<Object> queryMyEntry(Integer product_id);
	//�����̼Ҳ�ѯ��Ʒid
	public abstract List<Integer> queryProduct_id(Integer seller_id);

}
