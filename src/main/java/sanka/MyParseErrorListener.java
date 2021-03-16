package sanka;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MyParseErrorListener extends BaseErrorListener {
    private final String filename;

    public MyParseErrorListener(String filename) {
        this.filename = filename;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
            int charPos, String message, RecognitionException exception) {
        Environment env = Environment.getInstance();
        System.out.println(this.filename + ":" + line + ":" + charPos + " " + message);
        env.errorCount++;
    }
}
