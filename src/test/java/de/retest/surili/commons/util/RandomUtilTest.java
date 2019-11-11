package de.retest.surili.commons.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomUtilTest {

	@ParameterizedTest
	@ValueSource( doubles = { 0.0, 0.5, 1.0 } )
	void should_return_given_probability_if_in_range_0_to_1( final double probability ) throws Exception {
		assertThat( RandomUtil.requireProbability( probability ) ).isEqualTo( probability );
	}

	@ParameterizedTest
	@ValueSource( doubles = { -0.1, 1.1 } )
	void should_throw_exception_if_out_of_range_0_to_1( final double probability ) throws Exception {
		assertThatThrownBy( () -> RandomUtil.requireProbability( probability ) ) //
				.isInstanceOf( IllegalArgumentException.class ) //
				.hasMessage( "The given probability is not in the range [0, 1]: " + probability );
	}

	@Test
	void should_create_random_booleans_with_given_success_probability() throws Exception {
		final Random random = new Random( 0L );
		assertThat( RandomUtil.randomBoolean( random, 0.0 ) ).isFalse();
		assertThat( RandomUtil.randomBoolean( random, 1.0 ) ).isTrue();
		assertThat( RandomUtil.randomBoolean( random, 0.4 ) ).isFalse();
		assertThat( RandomUtil.randomBoolean( random, 0.6 ) ).isTrue();
	}

}
