package com.useradgents.burgers.test.mvp.presenters;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
