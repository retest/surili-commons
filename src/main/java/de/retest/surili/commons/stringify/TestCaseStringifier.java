package de.retest.surili.commons.stringify;

import java.util.List;
import java.util.stream.Collectors;

import de.retest.surili.commons.actions.Action;
import de.retest.surili.commons.core.TestCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestCaseStringifier implements Stringifier<TestCase> {

	private final int indentationLevel;
	private final ActionStringifier actionStringifier;

	public TestCaseStringifier() {
		this( 0 );
	}

	public TestCaseStringifier( final int indentationLevel ) {
		this( indentationLevel, new ActionStringifier( indentationLevel + 1 ) );
	}

	@Override
	public String toString( final TestCase testCase ) {
		final List<Action> actions = testCase.getActions();
		if ( actions.isEmpty() ) {
			return "TestCase: empty";
		}
		return Tabs.of( indentationLevel ) + "TestCase:\n" + actions.stream() //
				.map( actionStringifier::toString ) //
				.collect( Collectors.joining( "\n" ) );
	}

}
