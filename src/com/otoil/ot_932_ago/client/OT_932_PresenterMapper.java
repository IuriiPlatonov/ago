package com.otoil.ot_932_ago.client;


import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.ot.gtmdb.wets.main.client.ReportManagerPresenterMapper;
import ru.ot.mvp.client.history.DefaultPresenterMapper;
import ru.ot.mvp.client.presenters.Presenter;

import ru.ot.ot_132.places.client.formplaces.GraphicalReportingEditorPlace;
import ru.ot.ot_132.places.client.formplaces.GraphicalReportingPlace;
import ru.ot.ot_132.places.client.formplaces.MonitoringTemplateFilterPlace;

import com.otoil.ot_040_1_0050.client.ProfilePresenterFactory;
import com.otoil.ot_040_1_0080.client.common.QuartzManagerFormFactory;
import com.otoil.ot_040_1_0080.client.common.QuartzManagerPlace;
import com.otoil.ot_040_1_0100.client.form.RationingTablesPresenterFactory;
import com.otoil.ot_040_5_0010.client.form.UnderConstructionFormPresenterFactory;
import com.otoil.ot_040_atoll.places.client.ProfilePlace;
import com.otoil.ot_040_atoll.places.client.RationingTablesPlace;

import com.otoil.ot_131_main.client.HPDCommonPresenterMapper;
import com.otoil.ot_135_1_0010.client.GraphicalReportingFormFactory;
import com.otoil.ot_135_1_0020.client.GraphicalReportingEditorFormFactory;

import com.otoil.ot_932.places.client.ExplorationWellsPlace;

import com.otoil.ot_932.places.client.MiningWorksDesignPlace;


import com.otoil.ot_932_1_0090.client.MiningWorksDesignFormFactory;

import com.otoil.ot_932_1_0190.client.ExplorationWellsFormFactory;



public class OT_932_PresenterMapper
        extends DefaultPresenterMapper<OT_932_ClientFactory>
{
    public OT_932_PresenterMapper(OT_932_ClientFactory clientFactory)
    {
        super(clientFactory);

        /*
         * Формы Библиотеки
         */
        addPresenterMapper(new HPDCommonPresenterMapper(
            clientFactory.getHPDCommonClientFactory()));
        /*
         * Форма Мониторинга Книг(не входит в HPDCommonPresenterMapper т.к в в
         * некоторых ИТ решениях ее нет)
         */
        addPresenterFactory(MonitoringTemplateFilterPlace.class,
            clientFactory.getMonitoringFormFactory());

        addPresenterFactory(ProfilePlace.class, new ProfilePresenterFactory(
            clientFactory.getProfileClientFactory()));

      

        addPresenterMapper(new ReportManagerPresenterMapper(
            clientFactory.getReportManagerClientFactory()));

      

        // Проектирование горных работ
        addPresenterFactory(MiningWorksDesignPlace.class,
            new MiningWorksDesignFormFactory(
                clientFactory.getMiningWorksDesignClientFactory()));

      

        addPresenterFactory(RationingTablesPlace.class,
            new RationingTablesPresenterFactory(
                clientFactory.getRationingTablesClientFactory()));

      
        // Мониторинг скважин
        addPresenterFactory(ExplorationWellsPlace.class,
            new ExplorationWellsFormFactory(
                clientFactory.getExplorationWellsClientFactory()));

     


    


      
        // Графические отчеты
        addPresenterFactory(GraphicalReportingPlace.class,
            new GraphicalReportingFormFactory(
                clientFactory.getGraphicalReportingClientFactory(),
                clientFactory.getPlaceHistoryMapper()));

        addPresenterFactory(GraphicalReportingEditorPlace.class,
            new GraphicalReportingEditorFormFactory(
                clientFactory.getGraphicalReportingEditorFormFactory()));

        // Управление quartz задачами
        addPresenterFactory(QuartzManagerPlace.class,
            new QuartzManagerFormFactory(
                clientFactory.getQuartzManagerClientFactory()));
      
    }

    @Override
    public void getPresenter(Place place,
        AsyncCallback<Presenter> presenterCallback)
    {
        if (place instanceof UnderConstructionPlace)
        {
            String formId = ((UnderConstructionPlace) place).getFormId();

            new UnderConstructionFormPresenterFactory(formId)
                .getPresenter(place, presenterCallback);
        }
        else
        {
            super.getPresenter(place, presenterCallback);
        }
    }

    @Override
    public boolean isSamePlace(Place oldPlace, Place newPlace)
    {
        if (oldPlace instanceof UnderConstructionPlace
            && newPlace instanceof UnderConstructionPlace)
        {
            return oldPlace.equals(newPlace);
        }
        else
        {
            return super.isSamePlace(oldPlace, newPlace);
        }
    }
}
