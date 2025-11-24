import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;


public class InventoryItemTest{

    @Test
    public void quantityNoDebeSerNegativo(){
        InventoryItem i = new InventoryItem("juan", 1, 1000); 
        assertTrue(i.getQuantity()>0);
        InventoryItem i1 = new InventoryItem("juan", 5, 1000); 
        assertTrue(i.getQuantity()>0);
        InventoryItem i2 = new InventoryItem("juan", 0, 1000); 
        assertTrue(i.getQuantity()>0);
    }

    @Test
    public void priceNoDebeSerNegativo(){
        InventoryItem i = new InventoryItem("juan", 1, 1000); 
        assertTrue(i.getQuantity()>0);
        InventoryItem i1 = new InventoryItem("juan", 5, 1); 
        assertTrue(i.getQuantity()>0);
        InventoryItem i2 = new InventoryItem("juan", 0, 2000); 
        assertTrue(i.getQuantity()>0);
    }

    @Test
    public void probarTotalValue(){
        InventoryItem i = new InventoryItem("juan", 1, 1000); 
        assertEquals(1000, i.totalValue(), 0.00001);
        InventoryItem i1 = new InventoryItem("juan", 2, 1000); 
        assertEquals(2000, i1.totalValue(), 0.00001);
        InventoryItem i2 = new InventoryItem("juan", 3, 50); 
        assertEquals(150, i2.totalValue(), 0.00001);
    }

    @Test 
    public void probarAddStock(){
        InventoryItem i = new InventoryItem("juan", 0, 0); 
        i.addStock(100);
        assertEquals(100, i.getQuantity());
    }

    @Test 
    public void validarSell(){
        InventoryItem i = new InventoryItem("juan", 50, 1); 
        i.sell(25);
        assertEquals(25, i.getQuantity());
    }

    @Test
    public void quantityNoNegativa(){
        assertThrows(IllegalArgumentException.class, ()-> new InventoryItem("juan", -50, 1));
    }

    @Test
    public void priceNoNegativo(){
        assertThrows(IllegalArgumentException.class, ()-> new InventoryItem("juan", 1, -50));
    }

    @Test
    public void addStockNoNegativo(){
        InventoryItem i = new InventoryItem("juan", 50, 1); 
        assertThrows(IllegalArgumentException.class, ()-> i.addStock(-3));
    }

    @Test
    public void SellNoNegativo(){
        InventoryItem i = new InventoryItem("juan", 50, 1); 
        assertThrows(IllegalArgumentException.class, ()-> i.sell(-3));
    }
    @Test
    public void sellNoDebeSerMayorQueStock(){
        InventoryItem i = new InventoryItem("juan", 10, 1); 
        assertThrows(IllegalStateException.class, ()-> i.sell(51));
    }
}
