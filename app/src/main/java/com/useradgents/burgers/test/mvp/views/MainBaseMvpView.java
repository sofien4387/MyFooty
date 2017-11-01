package com.useradgents.burgers.test.mvp.views;

import com.useradgents.burgers.test.mvp.models.Posts;


public interface MainBaseMvpView extends BaseMvpView {

    void showRepositories(Posts posts);

    void showMessage(int stringId);

    void onProgressIndicator(boolean visibility);

}
