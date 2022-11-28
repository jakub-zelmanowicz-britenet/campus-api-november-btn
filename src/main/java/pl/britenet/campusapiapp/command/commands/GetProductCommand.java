package pl.britenet.campusapiapp.command.commands;

import pl.britenet.campusapiapp.Constants;
import pl.britenet.campusapiapp.command.Command;
import pl.britenet.campusapiapp.model.Product;
import pl.britenet.campusapiapp.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class GetProductCommand extends Command {

    private final ProductService productService;

    public GetProductCommand(ProductService productService) {
        super(Constants.COMMAND_GET_PRODUCT);
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product ID to retrieve:");
        int productId = scanner.nextInt();

        Optional<Product> product = Optional.ofNullable(this.productService.getProduct(productId));

        if (product.isPresent()) {
            System.out.println(product.get());
        }
        else {
            System.out.println("Cannot find product.");
        }
    }
}
