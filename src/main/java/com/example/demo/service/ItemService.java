package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.utils.Constant;
import com.example.demo.utils.DateParser;
import com.example.demo.utils.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> parseItemsFromFile() {
        List<Item> items = new ArrayList<>();
        List<String> itemsDataList = FileReader.read(Constant.ITEMS_FILE_PATH);

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
}