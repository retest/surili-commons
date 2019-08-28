package de.retest.surili.commons.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestSuiteTest {

	@Test
	void default_impl_should_sort_test_cases_alphabetically_according_to_name() {
		final TestCase c0 = new TestCaseImpl( "c", Collections.emptyList() );
		final TestCase c1 = new TestCaseImpl( "1", Collections.emptyList() );
		final TestCase c2 = new TestCaseImpl( "b", Collections.emptyList() );

		final TestSuite cut = mock( TestSuite.class );
		when( cut.getTestCases() ).thenReturn( new HashSet<>( Arrays.asList( c0, c1, c2 ) ) );
		when( cut.getTestCasesAsList() ).thenCallRealMethod();

		final List<TestCase> testCases = cut.getTestCasesAsList();

		assertThat( testCases ).containsExactly( c1, c2, c0 );
	}

}
