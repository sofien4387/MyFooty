package com.useradgents.burgers.test.mvp.views;

import com.useradgents.burgers.test.mvp.models.Competition;

import java.util.List;

/**
 * Created by Sofien on 25/09/2017.
 */

public interface CompetitionsBaseMvpView {

    void showCompetitions();

    void showMessage(int stringId);

    void onProgressIndicator(boolean visibility);
}
