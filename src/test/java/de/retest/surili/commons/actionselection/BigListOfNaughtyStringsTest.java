package de.retest.surili.commons.actionselection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class BigListOfNaughtyStringsTest {

	@Test
	void blns_should_contain_all_values() throws Exception {
		final List<String> blns = BigListOfNaughtyStrings.getBigListOfNaughtStrings();
		assertThat( blns ).hasSize( 511 );
	}

}
