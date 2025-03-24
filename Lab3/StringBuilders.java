public class StingBuilders {
    public static void main(String[] args) {
        String str = "aastha";
        StringBuilder sb = new StringBuilder(str);
        System.out.println("Original string: " + sb);
        sb.append(" jajoo");
        System.out.println("After appending ' jajoo': " + sb);
        sb.insert(3, "123");
        System.out.println("After inserting '123' at position 3: " + sb);
        sb.replace(3, 6, "XYZ");
        System.out.println("After replacing '123' with 'XYZ': " + sb);
        sb.delete(3, 6);
        System.out.println("After deleting from position 3 to 6: " + sb);
        sb.reverse();
        System.out.println("After reversing the string: " + sb);
        System.out.println("Length of the string: " + sb.length());
        sb.setCharAt(0, 'A');
        System.out.println("After setting 'A' at position 0: " + sb);
        sb.ensureCapacity(100);
        System.out.println("Capacity after ensuring 100: " + sb.capacity());
    }
}