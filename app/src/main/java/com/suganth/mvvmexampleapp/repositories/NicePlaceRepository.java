package com.suganth.mvvmexampleapp.repositories;

import com.suganth.mvvmexampleapp.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class NicePlaceRepository {

    public static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<NicePlace>();

    public static NicePlaceRepository getInstance()
    {
        if (instance == null)
        {
            return new NicePlaceRepository();
        }
        return instance;
    }
    //get data from web service or online source
    public MutableLiveData<List<NicePlace>> getNicePlace()
    {
            setNicePlace();
            MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
            return data;
    }

    private void setNicePlace()
    {
        dataSet.add(
                new NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}
