package com.elodieferrais.myapplication;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void loadPeople() {
        DummyService service = new DummyService();
        service.getPeople()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<DummyObject>() {
                   @Override public void accept(DummyObject dummyObject) throws Exception {
                       if (view != null) {
                           view.showCount(dummyObject);
                       }
                   }
               });
    }

    public void destroy() {
        view = null;
    }
}
