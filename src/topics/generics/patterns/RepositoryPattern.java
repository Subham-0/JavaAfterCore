package topics.generics.patterns;

import java.util.Optional;

public class RepositoryPattern {
    static void main() {
        // User Repository
        System.out.println("=== User Repository Tests ===");
        Repository<User, Long> userRepo = new InMemoryRepository<>(User::getId);

        // Create users
        User user1 = new User(1L, "Alice Johnson", "alice@example.com");
        User user2 = new User(2L, "Bob Smith", "bob@example.com");
        User user3 = new User(3L, "Charlie Brown", "charlie@example.com");

        // Save users
        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);

        System.out.println("\nTotal users: " + userRepo.count());

        // Find user by ID
        System.out.println("\nFinding user with ID 2:");
        Optional<User> foundUser = userRepo.findById(2L);
        foundUser.ifPresent(System.out::println);

        // Find all users
        System.out.println("\nAll users:");
        userRepo.findAll().forEach(System.out::println);

        // Check existence
        System.out.println("\nUser with ID 2 exists: " + userRepo.exists(2L));
        System.out.println("User with ID 99 exists: " + userRepo.exists(99L));

        // Delete user
        System.out.println("\nDeleting user with ID 2:");
        userRepo.delete(2L);
        System.out.println("Total users after deletion: " + userRepo.count());

        // Product Repository
        System.out.println("\n\n=== Product Repository Tests ===");
        Repository<Product, Long> productRepo = new InMemoryRepository<>(Product::getId);

        // Create products
        Product product1 = new Product(101L, "Laptop", 999.99);
        Product product2 = new Product(102L, "Mouse", 29.99);
        Product product3 = new Product(103L, "Keyboard", 79.99);
        Product product4 = new Product(104L, "Monitor", 299.99);

        // Save products
        productRepo.save(product1);
        productRepo.save(product2);
        productRepo.save(product3);
        productRepo.save(product4);

        System.out.println("\nTotal products: " + productRepo.count());

        // Find all products
        System.out.println("\nAll products:");
        productRepo.findAll().forEach(System.out::println);

        // Find product by ID
        System.out.println("\nFinding product with ID 103:");
        Optional<Product> foundProduct = productRepo.findById(103L);
        foundProduct.ifPresent(System.out::println);

        // Update product price
        System.out.println("\nUpdating product price:");
        foundProduct.ifPresent(p -> {
            p.setPrice(69.99);
            productRepo.save(p);
        });

        // Delete products
        System.out.println("\nDeleting products:");
        productRepo.delete(102L);
        productRepo.delete(104L);

        System.out.println("\nRemaining products:");
        productRepo.findAll().forEach(System.out::println);
        System.out.println("Total products: " + productRepo.count());
    }
}
