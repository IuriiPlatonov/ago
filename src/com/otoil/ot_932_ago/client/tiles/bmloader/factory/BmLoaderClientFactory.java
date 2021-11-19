package com.otoil.ot_932_ago.client.tiles.bmloader.factory;

import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTilePresenter.BMTileLoaderModel;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTilePresenter.BmLoaderTileView;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.BmOmDialogLoaderClientFactory;
import com.otoil.ot_932_ago.client.tiles.bmloader.impl.BMTileLoaderModelImpl;
import com.otoil.ot_932_ago.client.tiles.bmloader.impl.BmLoaderTileViewImpl;

import ru.ot.mvp.client.factory.ClientFactory;


public interface BmLoaderClientFactory extends ClientFactory
{
    default BMTileLoaderModel getBMTileLoaderModel()
    {
        return new BMTileLoaderModelImpl();
    }

    default BmLoaderTileView getBmLoaderTileView()
    {
        return new BmLoaderTileViewImpl();
    }

    default BmOmDialogLoaderClientFactory getBmLoaderClientFactory()
    {
        return new BmOmDialogLoaderClientFactory()
        {
        };
    }
}
