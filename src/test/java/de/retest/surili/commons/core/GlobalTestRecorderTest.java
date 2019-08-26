package de.retest.surili.commons.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import de.retest.surili.commons.actions.Action;

@Nested
class GlobalTestRecorderTest {

	static final Action ACTION = mock( Action.class );

	@Nested
	@TestMethodOrder( MethodOrderer.OrderAnnotation.class )
	class SomeSuite {

		@Test
		@Order( 1 )
		void should_record_and_reset() throws Exception {
			// FIXME Fix TestClassInformation to provide fallbacks.
			//			final TestSuite suite0 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			//			assertThat( suite0.getSize() ).isZero();

			GlobalTestRecorder.getInstance().recordAction( ACTION );

			final TestSuite suite1 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite1.getSize() ).isOne();
			final TestCase expectedTest = new TestCaseImpl( "should_record_and_reset", Arrays.asList( ACTION ) );
			assertThat( suite1.getTestCases() ).containsExactly( expectedTest );

			// Should not reset on get.
			final TestSuite suite2 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite2.getSize() ).isOne();
			assertThat( suite2 ).isEqualTo( suite1 );

			GlobalTestRecorder.getInstance().resetRecordedTestSuite();

			final TestSuite suite3 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite3.getSize() ).isZero();

			// Also for next test.
			GlobalTestRecorder.getInstance().recordAction( ACTION );

			final TestSuite suite4 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite4.getSize() ).isOne();
			assertThat( suite4 ).isEqualTo( suite1 );
		}

		@Test
		@Order( 2 )
		void should_record_across_tests() throws Exception {
			final TestSuite suite0 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite0.getSize() ).isOne();
			final TestCase expectedTest0 = new TestCaseImpl( "should_record_and_reset", Arrays.asList( ACTION ) );
			assertThat( suite0.getTestCases() ).containsExactly( expectedTest0 );

			final Action anotherAction = mock( Action.class );

			GlobalTestRecorder.getInstance().recordAction( anotherAction );

			final TestSuite suite1 = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite1.getSize() ).isEqualTo( 2 );
			final TestCase expectedTest1 =
					new TestCaseImpl( "should_record_across_tests", Arrays.asList( anotherAction ) );
			assertThat( suite1.getTestCases() ).contains( expectedTest0, expectedTest1 );
		}

	}

	@Nested
	class AnotherSuite {

		@Test
		void should_record_across_suites() throws Exception {
			final Action anotherAction = mock( Action.class );

			GlobalTestRecorder.getInstance().recordAction( anotherAction );

			final TestSuite suite = GlobalTestRecorder.getInstance().getRecordedTestSuite();
			assertThat( suite.getSize() ).isOne();
			final TestCase expectedTest =
					new TestCaseImpl( "should_record_across_suites", Arrays.asList( anotherAction ) );
			assertThat( suite.getTestCases() ).containsExactly( expectedTest );
		}

	}

}
