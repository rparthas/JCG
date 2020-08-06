import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    public List<String> read(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
