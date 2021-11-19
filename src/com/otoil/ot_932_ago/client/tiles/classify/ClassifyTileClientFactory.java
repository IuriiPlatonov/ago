package com.otoil.ot_932_ago.client.tiles.classify;


import ru.ot.mvp.client.factory.ClientFactory;

import com.otoil.ot_932_2_0050.micromine.client.factory.IWizardFactory;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenter.ClassifyTileModel;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenter.ClassifyTileView;


public interface ClassifyTileClientFactory extends ClientFactory
{
    ClassifyTileModel getClassifyTileModel();

    ClassifyTileView getClassifyTileView();

    IWizardFactory getGgisLoaderWizardFactory();
}
