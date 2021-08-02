import box.ParcelSize;
import box.PurchasedItem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ParcelTest {

    @Test
    public void testA() {
        PurchasedItem purchasedItem = new PurchasedItem(500,80,200,22,new BigDecimal("13.99"));

        try {
            ParcelSize parcelSize = purchasedItem.findCheapestParcel();
            Assert.assertEquals(ParcelSize.SMALLBOX, parcelSize);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
