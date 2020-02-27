package de.retest.surili.commons.actionselection;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

class BigListOfNaughtyStrings {
	private static final String FILENAME = "blns.json";
	private static final List<String> bigListOfNaughtyStrings = loadBigListOfNaughtStrings();

	private static List<String> loadBigListOfNaughtStrings() {
		try ( final InputStream url = BigListOfNaughtyStrings.class.getClassLoader().getResourceAsStream( FILENAME ) ) {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue( url, mapper.getTypeFactory().constructCollectionType( List.class, String.class ) );
		} catch ( final IOException e ) {
			throw new UncheckedIOException( "Exception reading '" + FILENAME + "'.", e );
		}
	}

	public static List<String> getBigListOfNaughtStrings() {
		return Collections.unmodifiableList( bigListOfNaughtyStrings );
	}

	public static String getNaughtyStringAt( final int index ) {
		return StringEscapeUtils.escapeJava( bigListOfNaughtyStrings.get( index ) );
	}
}
