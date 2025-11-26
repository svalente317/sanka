package sanka.c;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Helper class to read an InputStream (either stdout or stderr of a process)
 * and redirect its content in raw byte chunks to a specified output stream.
 * Running this in a separate thread prevents the external process from blocking.
 */
class StreamGobbler extends Thread {
    private final InputStream inputStream;
    private final PrintStream outputStream;

    /**
     * @param inputStream The stream to read from
     * @param outputStream The Java stream to write to
     */
    StreamGobbler(InputStream inputStream, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
        }
    }
}
