package com.otoil.ot_932_ago.client;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


import com.otoil.ot_040_1_0080.client.common.QuartzManagerPlace;
import com.otoil.ot_040_atoll.places.client.ProfilePlace;
import com.otoil.ot_040_atoll.places.client.RationingTablesPlace;
import com.otoil.ot_932.places.client.AreasMonitoringPlace;
import com.otoil.ot_932.places.client.BlastingOperationsDetailPlace;
import com.otoil.ot_932.places.client.BlastingOperationsMonitoringPlace;
import com.otoil.ot_932.places.client.BlastingWellMonitoringPlace;
import com.otoil.ot_932.places.client.CalendarPlanPeoPlace;
import com.otoil.ot_932.places.client.CoreMonitoringPlace;
import com.otoil.ot_932.places.client.EtalonObjectsPlace;
import com.otoil.ot_932.places.client.ExcavationDetailPlace;
import com.otoil.ot_932.places.client.ExplorationWellDetailPlace;
import com.otoil.ot_932.places.client.ExplorationWellPlanningPlace;
import com.otoil.ot_932.places.client.ExplorationWellSummarizingPlace;
import com.otoil.ot_932.places.client.ExplorationWellsPlace;
import com.otoil.ot_932.places.client.ExportDocumentsMonitoringPlace;
import com.otoil.ot_932.places.client.FieldSegmentMonitoringPlace;
import com.otoil.ot_932.places.client.GrrProjectPlace;
import com.otoil.ot_932.places.client.JournalsCalcCoordsPlace;
import com.otoil.ot_932.places.client.LayingWorksActExtPlace;
import com.otoil.ot_932.places.client.LayingWorksActPlace;
import com.otoil.ot_932.places.client.LocalProjectMonitoringPlace;
import com.otoil.ot_932.places.client.LocalProjectPassportPlace;
import com.otoil.ot_932.places.client.MineWorkingsPlace;
import com.otoil.ot_932.places.client.MiningSummarizingPlace;
import com.otoil.ot_932.places.client.MiningWorksDesignPlace;
import com.otoil.ot_932.places.client.MiningWorksPlanningPlace;
import com.otoil.ot_932.places.client.MonitoringGrrPlace;
import com.otoil.ot_932.places.client.MonitoringWorkDataPlace;
import com.otoil.ot_932.places.client.ObservationPointsResearchPlace;
import com.otoil.ot_932.places.client.OreReferencesPlace;
import com.otoil.ot_932.places.client.OreSamplingsMonitoringPlace;
import com.otoil.ot_932.places.client.ProductionAccountingPlace;
import com.otoil.ot_932.places.client.ResearchesQAMonitoringPlace;
import com.otoil.ot_932.places.client.RockAccountingWarehousesPlace;
import com.otoil.ot_932.places.client.SamplingRequestMonitoringPlace;
import com.otoil.ot_932.places.client.SamplingResultMonitoringPlace;
import com.otoil.ot_932.places.client.StockByCategoryPlace;
import com.otoil.ot_932.places.client.StockByReadinessPlace;
import com.otoil.ot_932.places.client.StocksPlace;
import com.otoil.ot_932.places.client.StrengthCalculationPlace;
import com.otoil.ot_932.places.client.StowageWorkPlace;
import com.otoil.ot_932.places.client.SurveyorAccountingPlace;
import com.otoil.ot_932.places.client.SurveyorPointsPlace;
import com.otoil.ot_932.places.client.TestLogRegisterPlace;
import com.otoil.ot_932.places.client.TransportModelDetailPlace;
import com.otoil.ot_932.places.client.TransportModelsPlace;
import com.otoil.ot_932.places.client.UchetGRRPlace;
import com.otoil.ot_932.places.client.WaysMonitoringPlace;


@WithTokenizers({ProfilePlace.Tokenizer.class,
    SurveyorAccountingPlace.Tokenizer.class,
    MiningWorksDesignPlace.Tokenizer.class,
    MiningWorksPlanningPlace.Tokenizer.class,
    ExplorationWellPlanningPlace.Tokenizer.class,
    ExplorationWellSummarizingPlace.Tokenizer.class,
    ProductionAccountingPlace.Tokenizer.class,
    LayingWorksActPlace.Tokenizer.class, LayingWorksActExtPlace.Tokenizer.class,

    LocalProjectPassportPlace.Tokenizer.class,
    LocalProjectMonitoringPlace.Tokenizer.class,
    RationingTablesPlace.Tokenizer.class, MineWorkingsPlace.Tokenizer.class,
    ExcavationDetailPlace.Tokenizer.class,
    ExplorationWellDetailPlace.Tokenizer.class,
    AreasMonitoringPlace.Tokenizer.class,
    BlastingWellMonitoringPlace.Tokenizer.class,
    BlastingOperationsMonitoringPlace.Tokenizer.class,
    BlastingOperationsDetailPlace.Tokenizer.class,
    FieldSegmentMonitoringPlace.Tokenizer.class,
    SamplingResultMonitoringPlace.Tokenizer.class,
    SamplingRequestMonitoringPlace.Tokenizer.class,
    ResearchesQAMonitoringPlace.Tokenizer.class,
    ExplorationWellsPlace.Tokenizer.class, CoreMonitoringPlace.Tokenizer.class,
    ExportDocumentsMonitoringPlace.Tokenizer.class,
    OreSamplingsMonitoringPlace.Tokenizer.class,
    EtalonObjectsPlace.Tokenizer.class, OreReferencesPlace.Tokenizer.class,
    ObservationPointsResearchPlace.Tokenizer.class,
    GrrProjectPlace.Tokenizer.class, MonitoringGrrPlace.Tokenizer.class,
    UchetGRRPlace.Tokenizer.class, StocksPlace.Tokenizer.class,
    SurveyorPointsPlace.Tokenizer.class,
    JournalsCalcCoordsPlace.Tokenizer.class,
    WaysMonitoringPlace.Tokenizer.class,
    RockAccountingWarehousesPlace.Tokenizer.class,
    StockByCategoryPlace.Tokenizer.class, StockByReadinessPlace.Tokenizer.class,
    TransportModelsPlace.Tokenizer.class,
    MonitoringWorkDataPlace.Tokenizer.class,
    TransportModelDetailPlace.Tokenizer.class,
    StrengthCalculationPlace.Tokenizer.class,
    MiningSummarizingPlace.Tokenizer.class, QuartzManagerPlace.Tokenizer.class,
    TestLogRegisterPlace.Tokenizer.class,
    StowageWorkPlace.Tokenizer.class,
    CalendarPlanPeoPlace.Tokenizer.class})
public interface OT_932_PlaceHistoryMapper extends PlaceHistoryMapper
{
    OT_932_PlaceHistoryMapper INSTANCE = GWT
        .create(OT_932_PlaceHistoryMapper.class);
}
