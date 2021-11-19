package com.otoil.ot_932_ago.client.tiles.restorationgeo;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;

import ru.ot.mvp.client.presenters.Presenter;


public class RestorationgeoTilePresenterFactory
        implements TilePresenterFactory<RestorationgeoTile>
{
    private RestorationgeoTileClientFactory clientFactory;

    public RestorationgeoTilePresenterFactory(
        RestorationgeoTileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(RestorationgeoTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback
            .onSuccess(new RestorationgeoTilePresenter(clientFactory));
    }
}
