package api_learning;

public abstract class AbsParent {
    protected String name;

    public AbsParent(String name) {
        this.name = name;
    }


    protected  void  sayHi(){};
    protected abstract void sayHello();

}
