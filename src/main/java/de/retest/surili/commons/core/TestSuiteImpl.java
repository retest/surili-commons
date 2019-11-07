package de.retest.surili.commons.core;

import java.util.Set;

import lombok.NonNull;
import lombok.Value;

@Value
public class TestSuiteImpl implements TestSuite {

	private static final long serialVersionUID = 1L;

	@NonNull
	private final Set<TestCase> testCases;

	@Override
	public int getSize() {
		return testCases.size();
	}

}
