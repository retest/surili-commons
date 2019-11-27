package de.retest.surili.commons.stringify;

import de.retest.surili.commons.actions.Action;

public class ActionStringifier implements Stringifier<Action> {

	private final String prefix;

	public ActionStringifier() {
		this( 0 );
	}

	public ActionStringifier( final int indentationLevel ) {
		prefix = Tabs.of( indentationLevel );
	}

	@Override
	public String toString( final Action action ) {
		return prefix + action.toString();
	}

}
