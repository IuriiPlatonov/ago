package com.otoil.ot_932_ago.client.tiles.getreport;


import ru.ot.mvp.client.factory.ClientFactory;

import com.otoil.ot_932_2_0050.micromine.client.factory.IWizardFactory;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenter.GetReportTileModel;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenter.GetReportTileView;


public interface GetReportTileClientFactory extends ClientFactory
{
    GetReportTileModel getGetReportTileModel();

    GetReportTileView getGetReportTileView();

    IWizardFactory getGgisLoaderWizardFactory();
}
