package pl.britenet.campusapiapp.command;

import pl.britenet.campusapiapp.Constants;

public class HelpCommand extends Command {

    public HelpCommand() {
        super(Constants.COMMAND_NAME_HELP);
    }

    @Override
    public void execute() {
        System.out.println("Helping...");
    }

}
