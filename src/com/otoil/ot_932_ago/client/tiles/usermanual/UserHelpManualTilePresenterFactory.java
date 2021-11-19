package com.otoil.ot_932_ago.client.tiles.usermanual;


import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.ot.mvp.client.presenters.Presenter;

import com.otoil.ot_040_5_0010.client.tile.manual.ManualTilePresenter;
import com.otoil.ot_932_ago.client.tiles.OT_932_TileClientFactory;
import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;


public class UserHelpManualTilePresenterFactory
        implements TilePresenterFactory<UserHelpManualTile>
{
    private OT_932_TileClientFactory clientFactory;

    public UserHelpManualTilePresenterFactory(
        OT_932_TileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(UserHelpManualTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(
            new ManualTilePresenter(clientFactory.getUserHelpManualTileModel(),
                clientFactory.getUserHelpManualView()));
    }
}
