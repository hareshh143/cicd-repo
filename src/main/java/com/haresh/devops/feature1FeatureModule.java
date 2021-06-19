package com.haresh.devops;

import org.etlunit.feature.FeatureModule;
import org.etlunit.feature.AbstractFeature;
import org.etlunit.NullClassListener;
import org.etlunit.TestAssertionFailure;
import org.etlunit.TestExecutionError;
import org.etlunit.TestWarning;
import org.etlunit.parser.ETLTestOperation;
import org.etlunit.parser.ETLTestValueObject;
import org.etlunit.context.VariableContext;
import org.etlunit.ExecutionContext;
import org.etlunit.ClassListener;

import java.util.Arrays;
import java.util.List;

@FeatureModule
public class feature1FeatureModule extends AbstractFeature {
	private static final List<String> prerequisites = Arrays.asList("logging");

	@Override
	public List<String> getPrerequisites() {
		return prerequisites;
	}

	public String getFeatureName() {
		return "feature1";
	}

	@Override
	public ClassListener getListener() {
		return new Listener();
	}
}

class Listener extends NullClassListener implements TestOperationProcessor {
	public action_code processTest(TestOperation operation, ETLTestOperation op, ETLTestValueObject obj, VariableContext context, ExecutionContext econtext) throws TestAssertionFailure, TestExecutionError, TestWarning
	{
		String name = op.getOperationName();
		if (name.equals("test"))
		{
			return action_code.handled;
		}

		return action_code.defer;
	}
}
