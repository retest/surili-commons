package de.retest.surili.commons.core;

import java.util.Set;

import lombok.NonNull;
import lombok.Value;

@Value
public class NamedTestSuiteImpl implements NamedTestSuite {

	private static final long serialVersionUID = 1L;

	@NonNull
	private final Set<NamedTestCase> testCases;
	@NonNull
	private final String name;

	@Override
	public int getSize() {
		return testCases.size();
	}

}
