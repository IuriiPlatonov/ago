package com.otoil.ot_932_ago.client.thema;


import com.otoil.ot_040_1_0050.client.resources.ProfileGridsterResources;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.resources.SolrTileMonitoringResources;
import com.otoil.ot_932_ago.client.thema.main.NornickelDownScrollButtonResources;
import com.otoil.ot_932_ago.client.thema.main.NornickelFormButtonBackgroundResources;
import com.otoil.ot_932_ago.client.thema.main.NornickelMainFormResources;
import com.otoil.ot_932_ago.client.thema.main.NornickelMainMenuCellTreeResources;
import com.otoil.ot_932_ago.client.thema.main.NornickelUpScrollButtonResources;
import com.otoil.ot_932_ago.client.thema.main.NornickelUserButtonBackgroundResources;
import com.otoil.ot_932_ago.client.thema.monitoring.NornickelSolrTileMonitoringResources;
import com.otoil.ot_932_ago.client.thema.profile.NornickelProfileGridsterResources;

import ru.ot.wevelns.client.main.resources.DownScrollButtonResources;
import ru.ot.wevelns.client.main.resources.FormButtonBackgroundResources;
import ru.ot.wevelns.client.main.resources.MainFormResources;
import ru.ot.wevelns.client.main.resources.MainMenuCellTreeResources;
import ru.ot.wevelns.client.main.resources.UpScrollButtonResources;
import ru.ot.wevelns.client.main.resources.UserButtonBackgroundResources;
import ru.ot.wevelns.client.themes.Thema;


public class NornickelThema extends Thema
{
    {
        registerUserResource(ProfileGridsterResources.class,
            NornickelProfileGridsterResources.INSTANCE);
        registerUserResource(SolrTileMonitoringResources.class,
            NornickelSolrTileMonitoringResources.INSTANCE);
    }

    @Override
    public MainFormResources mainFormResources()
    {
        return NornickelMainFormResources.INSTANCE;
    }

    @Override
    public UserButtonBackgroundResources userButtonBackgroundResources()
    {
        return NornickelUserButtonBackgroundResources.INSTANCE;
    }

    @Override
    public MainMenuCellTreeResources mainMenuCellTreeResources()
    {
        return NornickelMainMenuCellTreeResources.INSTANCE;
    }

    @Override
    public FormButtonBackgroundResources formButtonBackgroundResources()
    {
        return NornickelFormButtonBackgroundResources.INSTANCE;
    }

    @Override
    public UpScrollButtonResources upScrollButtonResources()
    {
        return NornickelUpScrollButtonResources.INSTANCE;
    }

    @Override
    public DownScrollButtonResources downScrollButtonResources()
    {
        return NornickelDownScrollButtonResources.INSTANCE;
    }
}