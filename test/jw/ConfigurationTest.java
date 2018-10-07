package jw;

import static org.junit.Assert.*;

import org.junit.*;

public class ConfigurationTest
{
	Configuration _config;

	@Before
	public void before()
	{
		_config = new Configuration(new String[]
		{ "-t", "192.168.1.5:12001 ", "-sp", " 8888", " -in", " 20Kbps", " -out", " 30Kbps" });
	}

	@Test
	public void should_Return_Correct_ServicePort()
	{
		assertEquals("192.168.1.5", _config.getTargetHost());
	}

	@Test
	public void should_Return_Correct_TargetPort()
	{
		assertEquals(12001, _config.getTargetPort());
	}

	@Test
	public void should_Return_Correct_Service_Port()
	{
		assertEquals(8888, _config.getServicePort());
	}

	@Test
	public void shold_Return_Correct_InKbps()
	{
		assertEquals(20, _config.getInKbps());
	}

	@Test
	public void shold_Return_Correct_OutKbps()
	{
		assertEquals(30, _config.getOutKbps());
	}

}
