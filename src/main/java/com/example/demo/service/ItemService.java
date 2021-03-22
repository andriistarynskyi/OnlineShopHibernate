package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.utils.Constant;
import com.example.demo.utils.DateParser;
import com.example.demo.utils.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> parseItemsFromFile() {
        List<String> itemsDataList = FileReader.read(Constant.ITEMS_FILE_PATH);
        List<Item> items = new ArrayList<>();

        for (String str : itemsDataList) {
            String[] tempArray = str.split(";");
            Item item = new Item();
            item.setTitle(tempArray[1]);
            item.setCode(Integer.parseInt(tempArray[2]));
            item.setProducer(tempArray[3]);
            item.setDateOfLastUpdate(DateParser.parse(tempArray[4], Constant.DATE_OF_LAST_UPDATE_PATTERN));
            items.add(item);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id);
    }
}