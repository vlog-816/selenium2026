package api_learning;

public class AbsTest {

    public static void main(String[] args) {
        AbsParent absParent = new AbsParent("hi") {
            @Override
            protected void sayHello() {

            }
        };

        absParent.sayHi();
        absParent.sayHello();
    }


}
