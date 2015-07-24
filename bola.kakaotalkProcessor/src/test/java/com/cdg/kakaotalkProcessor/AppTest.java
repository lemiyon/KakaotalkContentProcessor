package com.cdg.kakaotalkProcessor;

import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	KakaotalkProcessor kprocessor;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    @Before
    public void setUp()
    {
    
    }
    
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public void test()
    {
    	
    }
}
