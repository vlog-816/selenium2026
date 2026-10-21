package test_data;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import test_data.computer.ComputerData;

import java.util.Arrays;

public class TestGSON {

    public static void main(String[] args) {

        //exploreGSON();
        testDataBuilder();
    }

    private static void testDataBuilder() {
        String fileLocation = "/src/test/java/test_data/computer/CheapComputerDataList.json";
        ComputerData[] computerData = DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
        System.out.println(Arrays.toString(computerData));
    }

    private static void exploreGSON() {
        String data = "  {\n" +
                "    \"processorType\": \"2.2GHz\",\n" +
                "    \"ram\": \"8GB\",\n" +
                "    \"hdd\": \"400 GB\",\n" +
                "    \"software\": \"Microsoft Office\"\n" +
                "  }";

        Gson gson = new Gson();
        ComputerData convertedData = gson.fromJson(data, ComputerData.class);
        System.out.println(convertedData);

        String jsonData = gson.toJson(convertedData);
        System.out.println(jsonData);
    }
}
