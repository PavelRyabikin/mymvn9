import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();

        Product p1 = new Product(1, "Книга", 100);
        Product p2 = new Product(2, "Телефон", 200);
        Product p3 = new Product(3, "Ноутбук", 300);

        repo.add(p1);
        repo.add(p2);
        repo.add(p3);

        repo.removeById(2);

        Product[] expected = {p1, p3};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldThrowNotFoundException() {
        ShopRepository repo = new ShopRepository();

        Product p1 = new Product(1, "Книга", 100);
        repo.add(p1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(500);
        });
    }

    @Test
    public void shouldAddProduct() {
        ShopRepository repo = new ShopRepository();

        Product p1 = new Product(1, "Книга", 100);
        Product p2 = new Product(2, "Телефон", 200);

        repo.add(p1);
        repo.add(p2);

        Product[] expected = {p1, p2};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldThrowAlreadyExistsException() {
        ShopRepository repo = new ShopRepository();

        Product p1 = new Product(1, "Книга", 100);
        Product p2 = new Product(1, "Телефон", 200);

        repo.add(p1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(p2);
        });
    }
}