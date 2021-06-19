package com.haresh.devops;

import org.etlunit.TestResults;
import org.etlunit.feature.FeatureModule;
import org.etlunit.feature.Feature;
import org.etlunit.feature.AbstractFeature;
import org.etlunit.test_support.BaseFeatureModuleTest;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import java.io.IOException;

public class feature1FeatureModuleTest extends BaseFeatureModuleTest {
	public List<Feature> getTestFeatures()
	{
		return Arrays.asList((Feature) new feature1FeatureModule());
	}

	public boolean echoLog()
	{
		return false;
	}

	public void setUpSourceFiles() throws IOException
	{
		createSource("test.etlunit", "class test { @Test test_me() {test(option: \"NiceValue\");}}");
	}

	@Test
	public void test()
	{
		TestResults result = startTest();

		Assert.assertEquals(1, result.getNumTestsSelected());
		Assert.assertEquals(1, result.getMetrics().getNumberOfTestsPassed());
		Assert.assertEquals(0, result.getMetrics().getNumberOfAssertionFailures());
		Assert.assertEquals(0, result.getMetrics().getNumberOfWarnings());
		Assert.assertEquals(0, result.getMetrics().getNumberOfErrors());
	}
}