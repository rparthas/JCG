import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UtilityTest {
    @InjectMocks
    Utility utility;

    @Mock
    FileUtil fileUtilMock;

    @Mock
    DateUtil dateUtilMock;

    @Test
    public void shouldReturnTokenLengthBasedOnFile() throws IOException {
        //Arrange
        final String FILE_PATH = "temp.txt";
        List<String> results = new ArrayList<>();
        results.add("This is line 1");
        results.add("This is line 2");
        results.add("This is line 3");
        when(fileUtilMock.read(FILE_PATH)).thenReturn(results);
        //Act
        int tokens = utility.getNumberOfTokens(FILE_PATH);
        //Assert
        verify(fileUtilMock, times(1)).read(FILE_PATH);
        Assert.assertEquals(12, tokens);
    }

    @Test
    public void shouldReturnValidIfLesserThanToday() {
        Calendar calendar = Calendar.getInstance();
        Date input = calendar.getTime();
        when(dateUtilMock.compareWithToday(input)).thenReturn(-1);
        Assert.assertTrue(utility.isValidDate(input));
    }

    @Test
    public void shouldReturnInValidIfGreaterThanToday() {
        Calendar calendar = Calendar.getInstance();
        Date input = calendar.getTime();
        when(dateUtilMock.compareWithToday(input)).thenReturn(1);
        Assert.assertFalse(utility.isValidDate(input));
    }

    @Test
    public void shouldReturnSumOfPassedList() {
        List<Integer> input = new ArrayList<>();
        IntStream.range(1, 4).forEach(x -> input.add(x));
        Assert.assertEquals(6, utility.addList(input));
    }

    @Test
    public void shouldValidateIfDateIsToday() {
        Calendar calendar = Calendar.getInstance();
        Date input = calendar.getTime();
        when(dateUtilMock.compareWithToday(input)).thenReturn(-1);
        Assert.assertTrue(utility.isValidDate(input));
        when(dateUtilMock.compareWithToday(input)).thenReturn(1);
        Assert.assertFalse(utility.isValidDate(input));
    }


}

