package com.cdg.kakaotalkProcessor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DialogFileLoaderTest {

	DialogFileLoader dfLoader;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dfLoader = new DialogFileLoader();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDialogFileLoad() throws Exception
	{
		Assert.assertNotNull(dfLoader);
		Assert.assertEquals(0, dfLoader.loadDialogFile());
	}
	
	public void test() {
		//fail("Not yet implemented");
	}
	

}
