package first.games.whowantotbeamillionaire;

import first.IFileParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class MillionaireParser implements IFileParser {
    Integer index;
    List<String> lines;

    public MillionaireParser(String filename)
    {
        saveLines(filename);
    }

    public void saveLines(String filename)
    {
        try {
            lines = Files.readAllLines(new File(filename).toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
    }

    @Override
    public String getLine() {
        return lines.get(index++);
    }
}
