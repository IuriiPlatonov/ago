package com.otoil.ot_932_ago.client.tiles.scenarioresource;


import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.ot.mvp.client.presenters.Presenter;

import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;


public class ScenarioResourceTilePresenterFactory
        implements TilePresenterFactory<ScenarioResourceTile>
{
    private ScenarioResourceTileClientFactory clientFactory;

    public ScenarioResourceTilePresenterFactory(ScenarioResourceTileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(ScenarioResourceTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(new ScenarioResourceTilePresenter(clientFactory));
    }
}
