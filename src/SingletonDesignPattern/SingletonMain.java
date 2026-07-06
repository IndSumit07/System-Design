package SingletonDesignPattern;

public class SingletonMain {
    public static void main(String[] args) {

//        // Without Singleton
//        NoSingleton s1 = new NoSingleton();
//        NoSingleton s2 = new NoSingleton();
//        System.out.println(s1.equals(s2));

        // Simple Singleton
        SimpleSingleton s1 = SimpleSingleton.getInstance();
        SimpleSingleton s2 = SimpleSingleton.getInstance();
        System.out.println(s1.equals(s2));
    }
}
