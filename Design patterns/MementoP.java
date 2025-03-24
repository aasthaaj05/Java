import java.util.Stack;

class Memento {
    private String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}

class TextEditor {
    private String content;
    public void setContent(String content) { this.content = content; }
    public String getContent() { return content; }
    public Memento save() { return new Memento(content); }
    public void restore(Memento memento) { content = memento.getState(); }
}

class History {
    private Stack<Memento> history = new Stack<>();
    public void saveState(TextEditor editor) { history.push(editor.save()); }
    public void undo(TextEditor editor) {
        if (!history.isEmpty()) editor.restore(history.pop());
    }
}

public class MementoP{
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();
        
        editor.setContent("Version 1");
        history.saveState(editor);
        
        editor.setContent("Version 2");
        history.saveState(editor);
        
        editor.setContent("Version 3");
        System.out.println("Current Content: " + editor.getContent());
        
        history.undo(editor);
        System.out.println("After Undo: " + editor.getContent());
        
        history.undo(editor);
        System.out.println("After Undo: " + editor.getContent());
    }
}
