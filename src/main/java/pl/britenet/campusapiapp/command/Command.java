package pl.britenet.campusapiapp.command;

public abstract class Command {

    private String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void execute();

    public String getName() {
        return name;
    }
}
