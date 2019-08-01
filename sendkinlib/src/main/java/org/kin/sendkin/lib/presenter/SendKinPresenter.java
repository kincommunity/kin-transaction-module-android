package org.kin.sendkin.lib.presenter;

import org.kin.sendkin.core.base.BasePresenter;
import org.kin.sendkin.lib.view.SendKinView;

public interface SendKinPresenter extends BasePresenter<SendKinView> {
    void onResume();
    void onShowPublicAddressClicked();
}
