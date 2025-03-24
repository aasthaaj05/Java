public class Strings {
    public static void main(String[] args) {
    String str = "Aastha", str2 = "AASTHA",str3 = " trim ";
    System.out.println("Length of the string: " + str.length());
    System.out.println("Character at index 0: " + str.charAt(0));
    String str1 = str.concat(" Jajoo");
    System.out.println("After concatenation: " + str1);
    System.out.println("Index of first occurrence of 't': " + str.indexOf('t'));
    System.out.println("String in uppercase: " + str.toUpperCase());
    System.out.println("String in lowercase: " + str.toLowerCase());
    System.out.println("Is the string empty? " + str.isEmpty());
    System.out.println("Unicode code point at index 4: " + str.codePointAt(4));
    System.out.println("Unicode code point before index 4: " + str.codePointBefore(4));
    System.out.println("Code point count from index 0 to 2: " + str.codePointCount(0, 3));
    System.out.println("Lexicographic comparison with 'AASTHA' (case-sensitive): " +
    str.compareTo(str2));
    System.out.println("Lexicographic comparison with 'AASTHA' (case-insensitive): " +
    str.compareToIgnoreCase(str2));
    System.out.println("Does the string contain 'sth'? " + str.contains("sth"));
    System.out.println("Does the string end with 'a'? " + str.endsWith("a"));
    System.out.println("Last index of 'a': " + str.lastIndexOf('a'));
    System.out.println("Does the string start with 'A'? " + str.startsWith("A"));
    System.out.println("Converting integer 3 to string: " + String.valueOf(3));
    System.out.println("Replacing 'a' with 'x': " + str.replace('a', 'x'));
    System.out.println("Trimmed string: " + str3.trim());
    String[] splitStr = str3.trim().split(" ");
    for (String s : splitStr) {
    System.out.println("Split part: " + s);
    }
    char[] cts = str3.toCharArray();
    byte[] bytes = str.getBytes();
    System.out.print("Byte representation of the string: ");
    for (byte b : bytes) {
    System.out.print(b + " ");
    }
    System.out.println();
    System.out.println("Interned string: " + str.intern());
    System.out.println("Joined string: " + String.join("-", "Hello", "World"));
    System.out.println("Does the string match 'Aastha'? " + str.matches("Aastha"));
    System.out.println("Offset by code points (index 2, offset 2): " + str.offsetByCodePoints(2, 2));
    System.out.println("Region matches: " + str.regionMatches(0, str2, 0, 3));
    System.out.println("Replace all 'a' with 'o': " + str.replaceAll("a", "o"));
    System.out.println("Replace first 'a' with 'o': " + str.replaceFirst("a", "o"));
    System.out.println("To string: " + str.toString());
    System.out.println("Copy value of char array: " + String.copyValueOf(cts));
    System.out.println("Content equals 'Aastha': " + str.contentEquals("Aastha"));System.out.println("Formatted string: " + String.format("Hello, %s!", str));
    }
    }