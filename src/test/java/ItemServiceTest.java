import com.example.endpointexample.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.example.endpointexample.model.Item;
import com.example.endpointexample.repository.ItemRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testInsertDiscountByCategory() {
        // Arrange
        Item item = new Item();
        item.setCategory("Electronic");

        // Act
        itemService.insertDiscountByCategory(item);

        // Assert
        assertEquals(10, item.getDiscount());
        verify(itemRepository).save(item);
    }
    @Test
    public void testInsertDiscountForHomeCategory() {
        // Arrange
        Item item = new Item();
        item.setCategory("Home");

        // Act
        itemService.insertDiscountByCategory(item);

        // Assert
        assertEquals(20, item.getDiscount());
        verify(itemRepository).save(item);
    }

        @Test
        public void testInsertDiscountForClothesCategory() {
            // Arrange
            Item item = new Item();
            item.setCategory("Clothes");

            // Act
            itemService.insertDiscountByCategory(item);

            // Assert
            assertEquals(30, item.getDiscount());
            verify(itemRepository).save(item);
        }
        @Test
        public void testInsertDiscountForShoesCategory() {
        Item item = new Item();
        item.setCategory("Shoes");

        itemService.insertDiscountByCategory(item);

        assertEquals(40, item.getDiscount());
        verify(itemRepository).save(item);
        }

    @Test
    public void testInsertDiscountByCategoryUnknownCategory() {
        // Arrange
        Item item = new Item();
        item.setCategory("Unknown");

        // Act
        itemService.insertDiscountByCategory(item);

        // Assert
        assertEquals(0, item.getDiscount()); // No discount should be applied
        verify(itemRepository).save(item);
    }
}