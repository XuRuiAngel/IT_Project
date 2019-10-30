package com.it.springbootdemo.service.service_impl;


import com.it.springbootdemo.mapper.BookLocationMapper;
import com.it.springbootdemo.model.BookCatagory;
import com.it.springbootdemo.model.BookLocation;
import com.it.springbootdemo.service.BookLocationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLocationServiceImpl implements BookLocationService {

    @Autowired
    BookLocationMapper bookLocationMapper;
    @Override
    public JSONObject getBookLocation() {
        List<BookLocation> bookLocations=null;
        bookLocations=bookLocationMapper.getBookLocation();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(BookLocation bookLocation:bookLocations)
        {
            JSONObject result=new JSONObject();
            result.put("locationID",bookLocation.getLocationID());
            result.put("FloorNo",bookLocation.getFloorNo());
            result.put("ShelfNo",bookLocation.getShelfNo());

            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);
        return jsonObject;
    }

    @Override
    public int addBookLocation(int FloorNo, int ShelfNo) {
        BookLocation test=bookLocationMapper.findBookLocation(FloorNo,ShelfNo);
        if(test!=null)
        {
            return 0;
        }
        else {
           bookLocationMapper.addBookLocation(FloorNo,ShelfNo);
            return 1;
        }

    }

    @Override
    public int deleteBookLocation(int ID) {
        bookLocationMapper.deleteBookLocation(ID);
        return 0;
    }
}
