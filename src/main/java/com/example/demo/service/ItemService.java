package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.utils.Constant;
import com.example.demo.utils.DateParser;
import com.example.demo.utils.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public boolean parseItemsFromFile() {
        List<String> itemsDataList = FileReader.read(Constant.ITEMS_FILE_PATH);

        for (String str : itemsDataList) {
            String[] tempArray = str.split(";");
            Item item = new Item();
            item.setTitle(tempArray[1]);
            item.setCode(Integer.parseInt(tempArray[2]));
            item.setProducer(tempArray[3]);
            item.setDateOfLastUpdate(DateParser.parse(tempArray[4], Constant.DATE_OF_LAST_UPDATE_PATTERN));
            save(item);
        }
        System.out.println("Items from file were added to DB");
        return true;
    }
}