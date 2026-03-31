package kz.example.doner_cloud.Repository;

import kz.example.doner_cloud.Model.DonerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<DonerOrder, Long> {
}
