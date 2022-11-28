package pl.britenet.campusapiapp;

import pl.britenet.campusapiapp.command.Command;
import pl.britenet.campusapiapp.command.CommandService;
import pl.britenet.campusapiapp.command.HelpCommand;
import pl.britenet.campusapiapp.command.commands.GetProductCommand;
import pl.britenet.campusapiapp.database.DatabaseService;
import pl.britenet.campusapiapp.service.CategoryService;
import pl.britenet.campusapiapp.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static boolean isRunning = true;

    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        ProductService productService = new ProductService(databaseService);
        CommandService commandService = new CommandService();
        commandService.registerCommand(new HelpCommand(commandService));
        commandService.registerCommand(new GetProductCommand(productService));

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            String commandName = scanner.nextLine();
            Optional<Command> optionalCommand = commandService.findCommandByName(commandName);

            if (optionalCommand.isPresent()) {
                optionalCommand.get().execute();
            }
            else {
                System.out.println("Command does not exist.");
            }
        }
    }
}