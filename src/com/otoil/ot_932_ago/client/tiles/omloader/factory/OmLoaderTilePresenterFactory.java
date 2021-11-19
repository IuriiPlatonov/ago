package com.otoil.ot_932_ago.client.tiles.omloader.factory;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTile;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTilePresenter;
import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;

import ru.ot.mvp.client.presenters.Presenter;


public class OmLoaderTilePresenterFactory
        implements TilePresenterFactory<OmLoaderTile>
{
    private final OmLoaderTileClientFactory clientFactory;

    public OmLoaderTilePresenterFactory(
        final OmLoaderTileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(OmLoaderTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(new OmLoaderTilePresenter(clientFactory));
    }

}
