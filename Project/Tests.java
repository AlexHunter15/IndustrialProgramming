import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProcessingTest {
    private DataProcessor dataProcessor;

    @BeforeEach
    public void setUp() {
        dataProcessor = new DataProcessor();
    }

    @Test
    public void testReadData() {
        String inputData = "Sample data";
        String result = dataProcessor.readData(inputData);
        assertEquals("Sample data", result);
    }

    @Test
    public void testProcessData() {
        String inputData = "2 + 3 * 4";
        String result = dataProcessor.processData(inputData);
        assertEquals("14", result);
    }

    @Test
    public void testWriteData() {
        String dataToWrite = "Data to write";
        boolean success = dataProcessor.writeData(dataToWrite);
        assertEquals(true, success);
    }
}
