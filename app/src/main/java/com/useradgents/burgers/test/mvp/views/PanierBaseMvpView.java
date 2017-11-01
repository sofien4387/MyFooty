package com.useradgents.burgers.test.mvp.views;


public interface PanierBaseMvpView extends BaseMvpView {

    void onClickPay();

    void onEmptyMessageVisibility(int idVisibility);

    void onPriceCalculationListener(float price);
}
