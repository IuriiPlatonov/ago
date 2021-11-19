package com.otoil.ot_932_ago.client.tiles.classify;


import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.ot.mvp.client.presenters.Presenter;

import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;


public class ClassifyTilePresenterFactory
        implements TilePresenterFactory<ClassifyTile>
{
    private ClassifyTileClientFactory clientFactory;

    public ClassifyTilePresenterFactory(ClassifyTileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(ClassifyTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(new ClassifyTilePresenter(clientFactory));
    }
}
