package com.otoil.ot_932_ago.client.thema.monitoring;


import com.google.gwt.core.client.GWT;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.resources.SolrTileMonitoringResources;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.resources.SolrTileMonitoringStyle;


public interface NornickelSolrTileMonitoringResources
        extends SolrTileMonitoringResources
{
    NornickelSolrTileMonitoringResources INSTANCE = GWT
        .create(NornickelSolrTileMonitoringResources.class);

    @Override
    @Source({
        "com/otoil/ot_040_5_0010/client/form/monitoring/solrtile/resources/SolrTileMonitoringStyle.css",
        "NornickelSolrTileMonitoringStyle.css"})
    SolrTileMonitoringStyle style();
}
