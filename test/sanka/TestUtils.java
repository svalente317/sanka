package sanka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TestUtils {
	static String getTopDir() {
		String tmpdir = System.getProperty("java.io.tmpdir");
		long unixTime = System.currentTimeMillis() / 1000;
		File tmpfile = new File(tmpdir, "test" + unixTime);
		tmpfile.mkdir();
		return tmpfile.getAbsolutePath();
	}

	static String writeFile(String top, String[] text) throws Exception {
		File tmpfile = new File(top, "testsrc.san");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));
		for (String line : text) {
			writer.write(line);
			writer.newLine();
		}
		writer.close();
		return tmpfile.getAbsolutePath();
	}
}
