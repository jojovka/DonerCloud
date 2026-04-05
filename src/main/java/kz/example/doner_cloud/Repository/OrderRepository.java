package kz.example.doner_cloud.Repository;

import kz.example.doner_cloud.Model.DonerOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<DonerOrder, Long> {

    //find/read/get synonims
    List<DonerOrder> findByDeliveryZip(String deliveryZip);

    List<DonerOrder> readDonerOrderByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
}
