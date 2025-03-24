public class StringBuffers {
    public static void main(String[] args) {
        String str = "Aastha";
        StringBuffer s = new StringBuffer(str)
        System.out.println("Original string: " + s);
        System.out.println("After appending ' Jajoo': " + s.append(" Jajoo"));
        System.out.println("After inserting '1' at position 1: " + s.insert(1, "1"));
        s.replace(0, 6, "Aastha1");
        System.out.println("After replacing 'Aastha' with 'Aastha1': " + s);
        System.out.println("After deleting character at position 0: " + s.deleteCharAt(0));
        System.out.println("After reversing the string: " + s.reverse());System.out.println("Length of the string: " + s.length());
        System.out.println("Capacity of the StringBuffer: " + s.capacity());
        s.setCharAt(1, 'X');
        System.out.println("After setting 'X' at position 1: " + s);
        s.ensureCapacity(50);
        System.out.println("Capacity after ensuring 50: " + s.capacity());
    }
}