package test.computer;

import model.components.order.StandardComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_flows.computer.OrderTestFlow;

public class BuyingStandardComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testStandardComputerBuying(ComputerData computerData) {

        driver.get("https://demowebshop.tricentis.com/build-your-own-computer");

        OrderTestFlow<StandardComputerComponent> orderTestFlow =
                new OrderTestFlow<>(driver, StandardComputerComponent.class, computerData);

        orderTestFlow.buildAndAddToCart();
        orderTestFlow.verifyShoppingCartPage();
    }

    @DataProvider
    public ComputerData[] computerData() {

        String fileLocation = "/src/test/java/test_data/computer/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
    }
}