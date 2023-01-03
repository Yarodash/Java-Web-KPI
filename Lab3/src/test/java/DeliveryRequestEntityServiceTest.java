import com.delivery.Dependencies;
import com.delivery.db.DeclineReasonEntity;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.ReceiptEntity;
import com.delivery.services.objects.DeclineReasonEntityService;
import com.delivery.services.objects.DeliveryRequestEntityService;
import com.delivery.services.objects.ReceiptEntityService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DeliveryRequestEntityServiceTest {

    @Test
    public void getWithoutReceiptAndDeclineTest() {

        DeliveryRequestEntityService deliveryRequestEntityService = mock(DeliveryRequestEntityService.class);

        ArrayList<DeliveryRequestEntity> deliveryRequestEntityList = new ArrayList<DeliveryRequestEntity>();

        DeliveryRequestEntity entity = new DeliveryRequestEntity();
        entity.setId(7);
        deliveryRequestEntityList.add(entity);

        DeliveryRequestEntity entity2 = new DeliveryRequestEntity();
        entity2.setId(11);
        deliveryRequestEntityList.add(entity2);

        DeliveryRequestEntity entity3 = new DeliveryRequestEntity();
        entity3.setId(13);
        deliveryRequestEntityList.add(entity3);

        DeliveryRequestEntity entity4 = new DeliveryRequestEntity();
        entity4.setId(17);
        deliveryRequestEntityList.add(entity4);

        when(deliveryRequestEntityService.getAllByTime()).thenReturn(deliveryRequestEntityList);

        ReceiptEntityService receiptEntityService = mock(ReceiptEntityService.class);
        DeclineReasonEntityService declineReasonEntityService = mock(DeclineReasonEntityService.class);

        ReceiptEntity receiptEntity = new ReceiptEntity();
        receiptEntity.setId(5);
        receiptEntity.setDeliveryRequestId(11);

        DeclineReasonEntity declineReasonEntity = new DeclineReasonEntity();
        declineReasonEntity.setId(3);
        declineReasonEntity.setDeliveryRequestId(13);

        when(receiptEntityService.getByDeliveryRequestId(anyInt())).thenAnswer(invocationOnMock -> {
            int argument = (int) invocationOnMock.getArguments()[0];
            if (argument == 11) {
                return receiptEntity;
            }
            return null;
        });

        when(declineReasonEntityService.getByDeliveryRequestId(anyInt())).thenAnswer(invocationOnMock -> {
            int argument = (int) invocationOnMock.getArguments()[0];
            if (argument == 13) {
                return declineReasonEntity;
            }
            return null;
        });

        Dependencies.receiptEntityService = receiptEntityService;
        Dependencies.declineReasonEntityService = declineReasonEntityService;
        Dependencies.deliveryRequestEntityService = deliveryRequestEntityService;

        when(deliveryRequestEntityService.getWithoutReceiptAndDecline()).thenCallRealMethod();

        ArrayList<DeliveryRequestEntity> expected = new ArrayList<>();
        expected.add(entity);
        expected.add(entity4);

        List<DeliveryRequestEntity> actual = deliveryRequestEntityService.getWithoutReceiptAndDecline();

        assert expected.size() == actual.size();
        for (int i = 0; i < expected.size(); i++)
            assert expected.get(i) == actual.get(i);
    }

}
