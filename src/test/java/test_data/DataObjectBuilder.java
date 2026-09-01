package test_data;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T buildDataObjectFrom(String fileLocation, Class<T> dataType) {
        T data = null;

        String currentLocation = System.getProperty("user.dir");
        String absoluteLocation = currentLocation + fileLocation;

        try (Reader jsonContentReader = Files.newBufferedReader(Paths.get(absoluteLocation))) {
            Gson gson = new Gson();
            data = gson.fromJson(jsonContentReader, dataType);

        } catch (IOException e) {
            throw new RuntimeException("[Err] Wrong absolute Path: " + absoluteLocation);
        }

        return data;
    }
}
