package kz.example.doner_cloud.Repository;

import kz.example.doner_cloud.Model.DonerOrder;

public interface OrderRepository {
    DonerOrder save(DonerOrder order);
}
