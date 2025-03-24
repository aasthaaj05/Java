interface USBKeyboard {
    void type();
}

class TypeCKeyboard {
    public void typeWithTypeC() {
        System.out.println("Typing with a Type-C keyboard.");
    }
}

class TypeCToUSBAdapter implements USBKeyboard {
    private TypeCKeyboard typeCKeyboard;

    public TypeCToUSBAdapter(TypeCKeyboard typeCKeyboard) {
        this.typeCKeyboard = typeCKeyboard;
    }

    @Override
    public void type() {
        typeCKeyboard.typeWithTypeC(); 
    }
}

public class Adapter{
    public static void main(String[] args) {
        TypeCKeyboard typeCKeyboard = new TypeCKeyboard();
        USBKeyboard usbKeyboard = new TypeCToUSBAdapter(typeCKeyboard);
        usbKeyboard.type();
    }
}