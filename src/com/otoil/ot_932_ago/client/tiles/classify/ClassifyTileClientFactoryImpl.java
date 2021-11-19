package com.otoil.ot_932_ago.client.tiles.classify;


import ru.ot.mvp.client.factory.AbstractClientFactory;
import ru.ot.mvp.client.history.AsyncPlaceController;

import com.otoil.ot_932_2_0050.micromine.client.factory.IWizardFactory;
import com.otoil.ot_932_2_0050.micromine.client.factory.impl.WizardFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenter.ClassifyTileModel;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenter.ClassifyTileView;


public class ClassifyTileClientFactoryImpl extends AbstractClientFactory
        implements ClassifyTileClientFactory
{
    public ClassifyTileClientFactoryImpl(AsyncPlaceController placeController)
    {
        super(placeController);
    }

    @Override
    public ClassifyTileModel getClassifyTileModel()
    {
        return new ClassifyTileModelImpl();
    }

    @Override
    public ClassifyTileView getClassifyTileView()
    {
        return new ClassifyTileViewImpl();
    }

    @Override
    public IWizardFactory getGgisLoaderWizardFactory()
    {
        return new WizardFactoryImpl();
    }
}
