package pl.britenet.campusapiapp.command;

import pl.britenet.campusapiapp.Constants;
import pl.britenet.campusapiapp.model.Category;
import pl.britenet.campusapiapp.model.builder.CategoryBuilder;

public class HelpCommand extends Command {

    private final CommandService commandService;

    public HelpCommand(CommandService commandService) {
        super(Constants.COMMAND_NAME_HELP);
        this.commandService = commandService;
    }

    @Override
    public void execute() {



    }
}
