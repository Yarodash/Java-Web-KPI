import com.delivery.Dependencies;
import com.delivery.db.ReceiptEntity;
import com.delivery.services.PayOrder;
import com.delivery.services.objects.ReceiptEntityService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PayOrderTest {

    @Test
    public void pay_successfully() {

        ReceiptEntityService receiptEntityService = mock(ReceiptEntityService.class);
        when(receiptEntityService.save(any(ReceiptEntity.class))).thenReturn(true);

        ReceiptEntity receiptEntity = mock(ReceiptEntity.class);
        when(receiptEntity.getIsPayed()).thenReturn((byte) 0);

        Dependencies.receiptEntityService = receiptEntityService;

        assert PayOrder.pay(receiptEntity);

        verify(receiptEntity, times(1)).setIsPayed((byte) 1);
    }

    @Test
    public void payed_already() {

        ReceiptEntityService receiptEntityService = mock(ReceiptEntityService.class);
        when(receiptEntityService.save(any(ReceiptEntity.class))).thenReturn(true);

        ReceiptEntity receiptEntity = mock(ReceiptEntity.class);
        when(receiptEntity.getIsPayed()).thenReturn((byte) 1);

        Dependencies.receiptEntityService = receiptEntityService;

        assert PayOrder.pay(receiptEntity);

        verify(receiptEntity, never()).setIsPayed(anyByte());
        verify(receiptEntityService, never()).save(any(ReceiptEntity.class));
    }

}
