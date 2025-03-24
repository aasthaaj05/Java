interface TextEditor {
    void write(String text);
}

class BasicTextEditor implements TextEditor {
    @Override
    public void write(String text) {
        System.out.println("Writing text: " + text);
    }
}

abstract class TextEditorDecorator implements TextEditor {
    protected TextEditor textEditor;

    public TextEditorDecorator(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void write(String text) {
        textEditor.write(text);
    }
}

class SpellCheckDecorator extends TextEditorDecorator {
    public SpellCheckDecorator(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void write(String text) {
        super.write(text);
        checkSpelling(text);
    }

    private void checkSpelling(String text) {
        System.out.println("Spell-checking: " + text);
    }
}

class GrammarCheckDecorator extends TextEditorDecorator {
    public GrammarCheckDecorator(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void write(String text) {
        super.write(text);
        checkGrammar(text);
    }

    private void checkGrammar(String text) {
        System.out.println("Grammar-checking: " + text);
    }
}

public class Decorator{
    public static void main(String[] args) {
        TextEditor editor = new BasicTextEditor();
        editor = new SpellCheckDecorator(editor);
        editor = new GrammarCheckDecorator(editor);
        editor.write("Hello, World!");
    }
}