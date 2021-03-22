package com.example.demo.service.report;

import com.example.demo.entity.Gender;
import com.example.demo.entity.Item;
import com.example.demo.entity.Payment;
import com.example.demo.service.IItemService;
import com.example.demo.service.IPaymentService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.ItemSorter;
import com.example.demo.utils.ReportSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private IPaymentService paymentService;
    @Autowired
    private IItemService itemService;

    @Override
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @Override
    public List<Item> getBestSellers(List<Payment> payments) {
        List<Item> items = getAllPurchasedItems(payments);
        return ItemSorter.getItemsSortedByNumberOfSales(items).subList(0, 3);
    }

    @Override
    public List<Item> getAllPurchasedItems(List<Payment> payments) {
        List<Item> items = new ArrayList<>();
        payments.forEach(p -> items.addAll(p.getItems()));
        return items;
    }

    @Override
    public List<Item> getCandidatesToRemove(List<Payment> payments) {
        List<Item> items = getAllPurchasedItems(payments);
        List<Item> sortedBySalesItems = ItemSorter.getItemsSortedByNumberOfSales(items);
        return sortedBySalesItems.subList(sortedBySalesItems.size() - 3, sortedBySalesItems.size());
    }

    @Override
    public List<Item> getItemsPurchasedByWomen(List<Payment> payments) {
        List<Item> items = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getCustomer().getGender().equals(Gender.FEMALE)) {
                items.addAll(p.getItems());
            }
        }
        return ItemSorter.getItemsSortedByNumberOfSales(items);
    }

    //    save best selling items to file
    @Override
    public boolean saveBestSellersToFile(List<Payment> payments) {
        List<Item> items = getBestSellers(payments);
        items.forEach(i -> itemService.updatePrimaryItem(i));
        ReportSaver.save(items, Constant.BEST_SELLERS_REPORT);
        return true;
    }

    //    save items which are candidates to remove from store inventory due to poor sales level
    @Override
    public boolean saveCandidatesToRemoveToFile(List<Payment> payments) {
        List<Item> items = getCandidatesToRemove(payments);
        items.forEach(i -> itemService.updateCandidateToRemove(i));
        ReportSaver.save(items, Constant.CANDIDATES_TO_REMOVE);
        return true;
    }
}
