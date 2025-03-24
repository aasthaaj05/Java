public class Q2 {
    public static void main(String[] args) {
        try {
            System.out.println("\n🔢 Testing Arithmetic Exception...");
            int a = 10, b = 0;
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ ArithmeticException caught: " + e.getMessage());
        }

        System.out.println("\n----------------------------\n");

        try {
            System.out.println("\n📌 Testing Array Index Out of Bounds Exception...");
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        System.out.println("\n----------------------------\n");

        try {
            System.out.println("\n📝 Testing Null Pointer Exception...");
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("❌ NullPointerException caught: " + e.getMessage());
        }

        System.out.println("\n----------------------------\n");

        try {
            System.out.println("\n📂 Testing Class Not Found Exception...");
            Class.forName("com.nonexistent.MyClass");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ ClassNotFoundException caught: " + e.getMessage());
        }

        System.out.println("\n----------------------------\n");

        try {
            System.out.println("\n🔠 Testing String Index Out of Bounds Exception...");
            String text = "Java";
            System.out.println(text.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("❌ StringIndexOutOfBoundsException caught: " + e.getMessage());
        }

        System.out.println("\n✅ Program execution completed successfully.");
    }
}
