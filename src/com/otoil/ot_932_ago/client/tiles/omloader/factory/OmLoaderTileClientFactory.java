package com.otoil.ot_932_ago.client.tiles.omloader.factory;

import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTilePresenter.OmLoaderTileModel;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTilePresenter.OmLoaderTileView;
import com.otoil.ot_932_ago.client.tiles.omloader.impl.OmLoaderTileModelImpl;
import com.otoil.ot_932_ago.client.tiles.omloader.impl.OmLoaderTileViewImpl;

import ru.ot.mvp.client.factory.ClientFactory;


public interface OmLoaderTileClientFactory extends ClientFactory
{

    default OmLoaderTileModel getOmLoaderTileModel()
    {

        return new OmLoaderTileModelImpl();
    }

    default OmLoaderTileView getOmLoaderTileView()
    {
        return new OmLoaderTileViewImpl();
    }

}
