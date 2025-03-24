import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails(); 
        }
    }
}

public class Composite{
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        Folder folder1 = new Folder("Folder 1");
        folder1.addComponent(file1);
        folder1.addComponent(file2);
        Folder rootFolder = new Folder("Root Folder");
        rootFolder.addComponent(folder1);
        rootFolder.showDetails();
    }
}