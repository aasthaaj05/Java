interface Command {
    void execute();
}

class Television {
    public void turnOn() { System.out.println("TV is ON"); }
    public void turnOff() { System.out.println("TV is OFF"); }
}

class TurnOnCommand implements Command {
    private Television tv;
    public TurnOnCommand(Television tv) { this.tv = tv; }
    public void execute() { tv.turnOn(); }
}

class TurnOffCommand implements Command {
    private Television tv;
    public TurnOffCommand(Television tv) { this.tv = tv; }
    public void execute() { tv.turnOff(); }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); }
}

public class CommandP{
    public static void main(String[] args) {
        Television tv = new Television();
        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(new TurnOnCommand(tv));
        remote.pressButton();
        
        remote.setCommand(new TurnOffCommand(tv));
        remote.pressButton();
    }
}
