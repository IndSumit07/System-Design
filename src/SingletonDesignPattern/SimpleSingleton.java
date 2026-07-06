package SingletonDesignPattern;

public class SimpleSingleton {
    private static SimpleSingleton instance = null;

    private SimpleSingleton(){
        System.out.println("Simple Singleton Constructor Called.");
    }

    public static SimpleSingleton getInstance(){
        if(instance==null){
            instance = new SimpleSingleton();
        }
        return instance;
    }
}
