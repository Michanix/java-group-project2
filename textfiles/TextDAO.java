package textfiles;

// Making use of Data Access Object pattern, sort of...

import java.nio.file.Path;
import java.util.Map;

public interface TextDAO {
    Map<String, Path> getAllTexts();
    Path getText(String textName);
}
