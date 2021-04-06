package com.suganth.mvvmexampleapp.viewmodels;

import android.os.AsyncTask;

import com.suganth.mvvmexampleapp.models.NicePlace;
import com.suganth.mvvmexampleapp.repositories.NicePlaceRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository mRepo;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void init() {
        if (mNicePlaces == null) {
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNicePlaces = mRepo.getNicePlace();
    }

    public LiveData<List<NicePlace>> getNicePlace() {
        return mNicePlaces;
    }

    public void addNewValue(final NicePlace nicePlace) {
        isUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlace = mNicePlaces.getValue();
                currentPlace.add(nicePlace);
                mNicePlaces.postValue(currentPlace);
                isUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> isUpdating()
    {
        return isUpdating;
    }

}
