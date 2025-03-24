class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); 
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class Single {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        singleton.showMessage();

        Singleton anotherSingleton = Singleton.getInstance();
        System.out.println("Are both instances the same? " + (singleton == anotherSingleton));
    }
}