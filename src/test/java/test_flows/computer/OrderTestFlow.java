package test_flows.computer;

import model.components.cart.CartItemRowComponent;
import model.components.cart.TotalComponent;
import model.components.order.ComputerEssentialComponent;
import model.pages.ComputerItemDetailPage;
import model.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test_data.computer.ComputerData;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderTestFlow<T extends ComputerEssentialComponent> {

    private final WebDriver driver;
    private Class<T> computerEssentialClass;
    private ComputerData computerData;
    private int quantity = 1;
    private double totalItemPrice;


    public OrderTestFlow(WebDriver driver, Class<T> computerEssentialClass, ComputerData computerData) {
        this.driver = driver;
        this.computerEssentialClass = computerEssentialClass;
        this.computerData = computerData;
    }

    public OrderTestFlow(WebDriver driver, Class<T> computerEssentialClass, ComputerData computerData, int quantity) {
        this.driver = driver;
        this.computerEssentialClass = computerEssentialClass;
        this.computerData = computerData;
        this.quantity = quantity;
    }

    public void buildAndAddToCart() {

        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        T computerEssentialComp = computerItemDetailPage.computerComp(computerEssentialClass);

        computerEssentialComp.unselectAllOptions();

        String processorFullStr = computerEssentialComp.selectProcessorType(computerData.getProcessorType());
        double processorAdditionalPrice = extractAdditionalPrice(processorFullStr);

        String ramFullStr = computerEssentialComp.selectRAMType(computerData.getRam());
        double ramAdditionalPrice = extractAdditionalPrice(ramFullStr);

        double osAdditionalPrice = 0;
        if (computerData.getOs() != null) {
            String osFullStr = computerEssentialComp.selectOSType(computerData.getOs());
            osAdditionalPrice = extractAdditionalPrice(osFullStr);
        }

        String hddFullStr = computerEssentialComp.selectHDDType(computerData.getHdd());
        double hddAdditionalPrice = extractAdditionalPrice(hddFullStr);

        String softwareFullStr = computerEssentialComp.selectSoftWare(computerData.getSoftware());
        double softwareAdditionalPrice = extractAdditionalPrice(softwareFullStr);


        //Calculate item price and add to cart
        double basePrice = computerEssentialComp.productPrice();
        double addtionalsPrice = hddAdditionalPrice + softwareAdditionalPrice + osAdditionalPrice +
                processorAdditionalPrice + ramAdditionalPrice;

        totalItemPrice = (basePrice + addtionalsPrice) * quantity;

        computerEssentialComp.clickOnAddToCart();
        computerEssentialComp.waitUntilItemAddedToCart();

        //navigate to Cart
        computerItemDetailPage.headerComp().clickOnShoppingCart();

        //debug
        System.out.println(hddAdditionalPrice);
        System.out.println(softwareAdditionalPrice);
        System.out.println(osAdditionalPrice);
        System.out.println(processorAdditionalPrice);
        System.out.println(ramAdditionalPrice);
        System.out.println(basePrice);
        System.out.println("totalItemPrice: " + totalItemPrice);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyShoppingCartPage() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        List<CartItemRowComponent> cartItemRowComponents = shoppingCartPage.cartItemRowComponents();
        if (cartItemRowComponents.isEmpty()) {
            Assert.fail("[ERR] Shopping Cart is empty");
        }

        double currentSubtotalPrice = 0;
        double currentUnitPrice = 0;

        for (CartItemRowComponent row : cartItemRowComponents) {
            double rowSubtotalPrice = row.subTotal();
            double rowUnitPrice = row.unitPrice() * row.quantity();

            Assert.assertEquals(rowSubtotalPrice, rowUnitPrice, "[ERR] Current subtotal price is not matched in: " + row.produtName());

            currentSubtotalPrice += rowSubtotalPrice;
            currentUnitPrice += rowUnitPrice;
        }

        TotalComponent totalComp = shoppingCartPage.totalComponent();
        Map<String, Double> priceCategories = totalComp.priceCategories();

        double checkoutSubTotal = 0;
        double checkoutOtherFeesTotal = 0;
        double checkoutTotal = 0;

        for (String priceType : priceCategories.keySet()) {
            double priceValue = priceCategories.get(priceType);
            if (priceType.startsWith("Sub-Total")) {
                checkoutSubTotal = priceValue;
            } else if (priceType.startsWith("Total")) {
                checkoutTotal = priceValue;
            } else {
                checkoutOtherFeesTotal += priceValue;
            }
        }

        Assert.assertEquals(checkoutSubTotal, currentSubtotalPrice, "[ERR]Sub-total price and current sub-total price are not matching ");
        Assert.assertEquals(checkoutTotal, checkoutSubTotal + checkoutOtherFeesTotal, "[ERR] Sub-total price + other fees and total price are not matching");
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
