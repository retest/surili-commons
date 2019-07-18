package de.retest.surili.commons.core;

import java.io.Serializable;
import java.util.Set;

public interface TestSuite extends Serializable {

	String getName();

	Set<TestCase> getTestCases();

	int getSize();

}
