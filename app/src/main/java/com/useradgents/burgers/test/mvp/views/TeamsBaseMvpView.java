package com.useradgents.burgers.test.mvp.views;

import com.useradgents.burgers.test.mvp.models.Competition;
import com.useradgents.burgers.test.mvp.models.Teams;

import java.util.List;

/**
 * Created by Sofien on 25/09/2017.
 */

public interface TeamsBaseMvpView {

    void showTeams();

    void showMessage(int stringId);

    void onProgressIndicator(boolean visibility);
}
