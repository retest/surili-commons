package de.retest.surili.commons.core;

import java.util.Optional;
import java.util.Set;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class TestSuiteImpl implements TestSuite {

	private static final long serialVersionUID = 1L;

	private final String name;
	@NonNull
	private final Set<TestCase> testCases;

	public TestSuiteImpl( final Set<TestCase> testCases ) {
		this( null, testCases );
	}

	@Override
	public Optional<String> getName() {
		return Optional.ofNullable( name );
	}

	@Override
	public int getSize() {
		return testCases.size();
	}

}
