package com.otoil.ot_932_ago.client.tiles.paramsbm;


import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.ot.mvp.client.presenters.Presenter;

import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;


public class ParamsBMTilePresenterFactory
        implements TilePresenterFactory<ParamsBMTile>
{
    private ParamsBMTileClientFactory clientFactory;

    public ParamsBMTilePresenterFactory(ParamsBMTileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(ParamsBMTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(new ParamsBMTilePresenter(clientFactory));
    }
}
