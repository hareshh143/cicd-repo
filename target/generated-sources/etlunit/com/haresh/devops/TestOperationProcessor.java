package com.haresh.devops;

import org.etlunit.*;
import org.etlunit.context.VariableContext;
import org.etlunit.parser.ETLTestOperation;
import org.etlunit.parser.ETLTestValueObject;

public interface TestOperationProcessor {
	public ClassResponder.action_code processTest(TestOperation operation, ETLTestOperation op, ETLTestValueObject obj, VariableContext context, ExecutionContext econtext) throws TestAssertionFailure, TestExecutionError, TestWarning;
}