package first;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class LineParser {
    private List<String> lines;

    public LineParser(String filename)
    {
        saveLines(filename);
    }

    private void saveLines(String filename)
    {
        try {
            lines = Files.readAllLines(new File(filename).toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
    }

    public List<String> getLines() {
        return lines;
    }
}
