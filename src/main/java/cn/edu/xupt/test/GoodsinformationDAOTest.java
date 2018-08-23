package cn.edu.xupt.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import antlr.collections.impl.LList;
import cn.edu.xupt.bean.Goodsinformation;
import cn.edu.xupt.daoImpl.GoodsinformationDAO;

public class GoodsinformationDAOTest {
	//@Autowired
	private GoodsinformationDAO goodsinformationDAO=new GoodsinformationDAO();
	
	@Test
	public void testSaveGoodsinformation() {
		goodsinformationDAO.save(new Goodsinformation(1111, "照相机", 23, 56.0));
	}

	@Test
	public void testDeleteGoodsinformation() {
		Goodsinformation iGoodsinformation=goodsinformationDAO.findById(1111);
		goodsinformationDAO.delete(iGoodsinformation);
	}

	@Test
	public void testUpdateGoodsinformation() {
		Goodsinformation goodsinformation=goodsinformationDAO.update(new Goodsinformation(1111, "照相机", 2, 90.0));
		System.out.println(goodsinformation.getGoodsNum());
	}

	@Test
	public void testFindGoodsinfoqmationById() {
		System.out.println(goodsinformationDAO.findById(1111));
	}

	@Test
	public void testFindGoodsinformationByProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindGoodsinformationByGoodsName() {
		List<Goodsinformation> goodsinformation=goodsinformationDAO.findByGoodsName("iphone");
		System.out.println(goodsinformation.get(0).getGoodsName());
	}

	@Test
	public void testFindGoodsinformationByGoodsNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindGoodsinformationByGoodsPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllGoodsinformation() {
		List<Goodsinformation> list=goodsinformationDAO.findAll();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getGoodsName());
		}
	
	}

	@Test
	public void testUpdateGoodsNumber() {
		
	}

}
