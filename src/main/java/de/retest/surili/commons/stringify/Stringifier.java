package de.retest.surili.commons.stringify;

import java.util.Collections;

@FunctionalInterface
public interface Stringifier<T> {

	static class Tabs {

		static String of( final int indentationLevel ) {
			if ( indentationLevel == 0 ) {
				return "";
			}
			return String.join( "", Collections.nCopies( indentationLevel, "\t" ) );
		}

	}

	String toString( T object );

}
