JUnit @Rule and annotation for testing Java assertions.

Simplest usage:

To enable all tests to run iff -ea or -enableassertions passed on JVM command line:
(see AssertionsRuleTest.java for examples)

@Rule
public AssertionsRule assertionsRule = new AssertionsRule();


