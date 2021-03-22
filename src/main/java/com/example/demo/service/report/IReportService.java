package com.example.demo.service.report;

import com.example.demo.entity.Item;
import com.example.demo.entity.Payment;

import java.util.List;

public interface IReportService {
    List<Payment> findAll();

    List<Item> getItemsPurchasedByWomen(List<Payment> payments);

    List<Item> getAllPurchasedItems(List<Payment> payments);

    List<Item> getBestSellers(List<Payment> payments);

    List<Item> getCandidatesToRemove(List<Payment> payments);

    boolean saveBestSellersToFile(List<Payment> payments);

    boolean saveCandidatesToRemoveToFile(List<Payment> payments);
}
