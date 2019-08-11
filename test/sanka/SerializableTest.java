package sanka;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import sanka.Translator;

class SerializableTest {
	
	// TODO How to get include_dir at runtime?
	static final String INCLUDE_DIR = "/home/svalente/src/sanka/runtime";

	static final String[] TEST1 = {
			"serializable class PlainObject { int i; String s; String n; }",
			"class Tester {",
			"static void main(String[] argv) {",
			"var po = new PlainObject();",
			"po.i = 17; po.s = \"test\";",
			"System.println(po.toJson().toString());",
			"}}",
	};
	
	@Test
	void testAddMethodsToClass() throws Exception {
		String top = TestUtils.getTopDir();
		String filename = TestUtils.writeFile(top, TEST1);
		Translator.main(new String[] { "-I", INCLUDE_DIR, "--top", top, filename });
	}

	static final String[] TEST2 = {
			"serializable class FirstClass { String s; }",
			"serializable class SecondClass { FirstClass[] arr; }"
	};
	
	@Test
	@Disabled("not implemented yet")
	void testSerializeArray() throws Exception {
		// String filename = TestUtils.writeFile(TEST2);
		// Translator.main(new String[] { "-I", INCLUDE_DIR, filename });
	}
	
	static final String[] TEST3 = {
			"class Test { void method() { var x = null;",
			"while (true) { x = new int[1]; break; } } }"
	};
	
	@Test
	void testDelayedVariableDeclaration() throws Exception {
		String top = TestUtils.getTopDir();
		String filename = TestUtils.writeFile(top, TEST3);
		Translator.main(new String[] { "-I", INCLUDE_DIR, "--top", top, filename });
	}
}
