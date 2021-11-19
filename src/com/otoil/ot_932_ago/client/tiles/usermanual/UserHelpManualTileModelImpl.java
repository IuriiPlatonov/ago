package com.otoil.ot_932_ago.client.tiles.usermanual;


import com.google.gwt.user.client.rpc.AsyncCallback;

import com.otoil.ot_040_5_0010.client.tile.manual.ManualTilePresenter.ManualTileModel;
import com.otoil.ot_932_ago.client.i18n.OreMainConstantsFactory;


public class UserHelpManualTileModelImpl implements ManualTileModel
{
    @Override
    public void getManualUrl(AsyncCallback<String> callback)
    {
        callback.onSuccess(
            OreMainConstantsFactory.getInstance().userHelpManualUrl());
    }
}
