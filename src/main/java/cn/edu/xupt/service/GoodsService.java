package cn.edu.xupt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xupt.bean.Goodsinformation;
import cn.edu.xupt.daoImpl.GoodsinformationDAO;

@Service
public class GoodsService {
	
	private GoodsinformationDAO goodsinformationDAO=new GoodsinformationDAO();
	
	public List<Goodsinformation> getAllGoods(){
		return goodsinformationDAO.findAll();
	}
	@Transactional
	public Boolean add(Goodsinformation goodsinformation) {
		try {
			//查询根据商品是否存在，根据名字
			Goodsinformation goodsinformation2=(Goodsinformation) goodsinformationDAO.findById(goodsinformation.getGoodsId());
			System.out.println(goodsinformation2);
			//如果为空，不存在，插入记录，存在，更改记录
			if(goodsinformation2==null) {
				goodsinformationDAO.save(goodsinformation);;
			}else {
				int n=goodsinformationDAO.updateGoodsNumber(goodsinformation);
				System.out.println(n);
				if(n<=0)
					return false;
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteGoods(Integer id) {
		// TODO Auto-generated method stub
		goodsinformationDAO.delete(new Goodsinformation(id));
	}
	public Goodsinformation findGoodsById(Integer id) {
		// TODO Auto-generated method stub
		return goodsinformationDAO.findById(id);
	}
	public Goodsinformation updateGoods(Goodsinformation goodsinformation) {
		// TODO Auto-generated method stub
		return goodsinformationDAO.update(goodsinformation);
	}
	public Goodsinformation findGoodsByName(String name) {
		// TODO Auto-generated method stub
		List<Goodsinformation> list= goodsinformationDAO.findByGoodsName(name);
		if(list!=null&&list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
}
