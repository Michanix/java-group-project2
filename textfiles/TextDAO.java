package textfiles.firstlevel;

// Making use of Data Access Object pattern, sort of...

import java.nio.file.Path;
import java.util.Map;

public interface TextDAO {
    public Map<String, Path> getAllTexts();
    public String getText(String textName);
}