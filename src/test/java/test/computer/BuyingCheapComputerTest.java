package test.computer;

import model.components.computer.CheapComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_flows.computer.OrderTestFlow;

public class BuyingCheapComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testCheapComputerBuying(ComputerData computerData){

        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");

        OrderTestFlow<CheapComputerComponent> orderTestFlow =
                new OrderTestFlow<>(driver, CheapComputerComponent.class, computerData);

        orderTestFlow.buildAndAddToCart();
    }

    @DataProvider
    public ComputerData[] computerData(){

        String fileLocation = "/src/test/java/test_data/computer/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
    }
}