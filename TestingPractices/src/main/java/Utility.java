import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Utility {

    FileUtil fileUtil;

    DateUtil dateUtil;

    public int getNumberOfTokens(String filePath) {
        List<String> tokens = new ArrayList<>();
        try {
            List<String> lines = fileUtil.read(filePath);
            for (String line : lines) {
                tokens.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens.size();
    }

    public boolean isValidDate(Date date) {
        int result = dateUtil.compareWithToday(date);
        if (result > 0) {
            return false;
        }
        return true;
    }

    public int addList(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
