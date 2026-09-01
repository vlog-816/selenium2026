package test_flows.computer;

import model.components.computer.ComputerEssentialComponent;
import model.pages.ComputerItemDetailPage;
import org.openqa.selenium.WebDriver;
import test_data.computer.ComputerData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderTestFlow<T extends ComputerEssentialComponent> {

    private final WebDriver driver;
    private Class<T> computerEssentialClass;
    private ComputerData computerData;


    public OrderTestFlow(WebDriver driver, Class<T> computerEssentialClass, ComputerData computerData) {
        this.driver = driver;
        this.computerEssentialClass = computerEssentialClass;
        this.computerData = computerData;
    }

    public void buildAndAddToCart() {

        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        T computerEssentialComp = computerItemDetailPage.computerComp(computerEssentialClass);

        String processorFullStr = computerEssentialComp.selectProcessorType(computerData.getProcessorType());
        double processorAdditionalPrice = extractAdditionalPrice(processorFullStr);
        System.out.println("processorAdditionalPrice: " + processorAdditionalPrice);

        String ramFullStr = computerEssentialComp.selectRAMType(computerData.getRam());
        double ramAdditionalPrice = extractAdditionalPrice(ramFullStr);
        System.out.println("ramAdditionalPrice: " + ramAdditionalPrice);

        double osAdditionalPrice = 0;
        if (computerData.getOs() != null) {
            String osFullStr = computerEssentialComp.selectOSType(computerData.getOs());
            osAdditionalPrice = extractAdditionalPrice(osFullStr);
        }
        System.out.println("osAdditionalPrice: " + osAdditionalPrice);

        String hddFullStr = computerEssentialComp.selectHDDType(computerData.getHdd());
        double hddAdditionalPrice = extractAdditionalPrice(hddFullStr);
        System.out.println("hddAdditionalPrice: " + hddAdditionalPrice);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double extractAdditionalPrice(String itemStr) {
        double price = 0;

        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(itemStr);

        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replaceAll("[-+]]", ""));
        }
        return price;

    }
}
