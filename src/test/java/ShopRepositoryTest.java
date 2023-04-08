import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "Молоко", 100);
    Product item2 = new Product(2, "Хлеб", 50);
    Product item3 = new Product(3, "Яйца", 80);
    Product item4 = new Product(4, "Сыр", 250);

    @Test
    public void shouldCatchException() {
        ShopRepository shop = new ShopRepository();

        shop.add(item1);
        shop.add(item2);
        shop.add(item3);
        shop.add(item4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(5);
        });

    }

    @Test
    public void shouldRemoveById() {
        ShopRepository shop = new ShopRepository();

        shop.add(item1);
        shop.add(item2);
        shop.add(item3);
        shop.add(item4);

        shop.removeById(2);

        Product[] expected = {item1, item3, item4};
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
