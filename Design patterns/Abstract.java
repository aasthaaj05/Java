interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Render a button in Windows style.");
    }
}

class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Render a button in MacOS style.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Render a checkbox in Windows style.");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Render a checkbox in MacOS style.");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}

public class Abstract {
    public static void main(String[] args) {
        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        windowsApp.render();

        GUIFactory macFactory = new MacOSFactory();
        Application macApp = new Application(macFactory);
        macApp.render();
    }
}