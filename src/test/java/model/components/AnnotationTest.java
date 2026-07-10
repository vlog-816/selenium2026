package model.components;

public class AnnotationTest {

    public <T> void getComponentCssSelector(Class<T> componentClass){

        String cssSelector = componentClass.getAnnotation(ComponentCssSelector.class).value();
        System.out.println(cssSelector);
    }

    public static void main(String[] args) {
        new AnnotationTest().getComponentCssSelector(LoginPageComponent.class);
    }
}
