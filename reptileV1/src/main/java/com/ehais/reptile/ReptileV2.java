package com.ehais.reptile;


import org.ehais.tools.ReturnObject;
import org.junit.Test;

import com.ehais.bean.Brand;

public interface ReptileV2 extends Reptile{

	@Test
	public void brandJUnit();
	
	public ReturnObject<Brand> get_Brand(String url);
	
	
	@Test
	public void categoryJUnit();
	
	public ReturnObject<Object> get_Category(String url);
	
}
