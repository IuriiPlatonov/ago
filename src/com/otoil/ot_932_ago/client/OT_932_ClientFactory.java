package com.otoil.ot_932_ago.client;


import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.otoil.issue.creator.client.tray.IssueCreatorTileClientFactory;
import com.otoil.ot_040_1_0020.client.form.NotificationClientFactory;
import com.otoil.ot_040_1_0050.client.ProfileClientFactory;
import com.otoil.ot_040_1_0080.client.common.QuartzManagerClientFactory;
import com.otoil.ot_040_1_0100.client.form.RationingTablesClientFactory;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.tile.presenter.SolrTileClientFactory;

import com.otoil.ot_131_1_0140.client.TemplateMonitoringFormFactory;
import com.otoil.ot_131_main.client.HPDCommonClientFactory;
import com.otoil.ot_135_1_0010.client.GraphicalReportingClientFactory;
import com.otoil.ot_135_1_0020.client.GraphicalReportingEditorClientFactory;
import com.otoil.ot_135_2_0020.client.testviewer.TestVisPresenterFactory;

import com.otoil.ot_932_1_0090.client.MiningWorksDesignClientFactory;

import com.otoil.ot_932_1_0190.client.ExplorationWellsClientFactory;

import com.otoil.ot_932_ago.client.tiles.OT_932_TileClientFactory;

import ru.ot.gtmdb.wets.main.client.ReportManagerClientFactory;
import ru.ot.mvp.client.factory.ClientFactory;



public interface OT_932_ClientFactory extends ClientFactory
{
    PlaceHistoryMapper getPlaceHistoryMapper();

    IssueCreatorTileClientFactory getIssueCreatorTilePresenterFactory();

    ProfileClientFactory getProfileClientFactory();

    SolrTileClientFactory getSolrTileClientFactory();

    OT_932_TileClientFactory getOT_932_TileClientFactory();



    MiningWorksDesignClientFactory getMiningWorksDesignClientFactory();

  

    ReportManagerClientFactory getReportManagerClientFactory();

    RationingTablesClientFactory getRationingTablesClientFactory();

    HPDCommonClientFactory getHPDCommonClientFactory();

    TemplateMonitoringFormFactory getMonitoringFormFactory();

    

    NotificationClientFactory getNotificationClientFactory();

    ExplorationWellsClientFactory getExplorationWellsClientFactory();

    GraphicalReportingEditorClientFactory getGraphicalReportingEditorFormFactory();

    GraphicalReportingClientFactory getGraphicalReportingClientFactory();

    QuartzManagerClientFactory getQuartzManagerClientFactory();

  

}
