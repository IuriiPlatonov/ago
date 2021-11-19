package com.otoil.ot_932_ago.client.tiles.getreport;


import ru.ot.mvp.client.factory.AbstractClientFactory;
import ru.ot.mvp.client.history.AsyncPlaceController;

import com.otoil.ot_932_2_0050.micromine.client.factory.IWizardFactory;
import com.otoil.ot_932_2_0050.micromine.client.factory.impl.WizardFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenter.GetReportTileModel;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenter.GetReportTileView;


public class GetReportTileClientFactoryImpl extends AbstractClientFactory
        implements GetReportTileClientFactory
{
    public GetReportTileClientFactoryImpl(AsyncPlaceController placeController)
    {
        super(placeController);
    }

    @Override
    public GetReportTileModel getGetReportTileModel()
    {
        return new GetReportTileModelImpl();
    }

    @Override
    public GetReportTileView getGetReportTileView()
    {
        return new GetReportTileViewImpl();
    }

    @Override
    public IWizardFactory getGgisLoaderWizardFactory()
    {
        return new WizardFactoryImpl();
    }
}
