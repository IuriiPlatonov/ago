package com.otoil.ot_932_ago.client.tiles.bmloader.factory;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTile;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTilePresenter;
import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;

import ru.ot.mvp.client.presenters.Presenter;


public class BmLoaderPresenterFactory
        implements TilePresenterFactory<BmLoaderTile>
{
    private final BmLoaderClientFactory clientFactory;

    public BmLoaderPresenterFactory(final BmLoaderClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(BmLoaderTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(new BmLoaderTilePresenter(clientFactory));
    }

}
