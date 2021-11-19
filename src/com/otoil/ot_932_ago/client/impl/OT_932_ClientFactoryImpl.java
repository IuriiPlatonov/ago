package com.otoil.ot_932_ago.client.impl;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.otoil.issue.creator.client.tray.IssueCreatorTileClientFactory;
import com.otoil.issue.creator.client.tray.IssueCreatorTileClientFactoryImpl;
import com.otoil.ot_040_1_0020.client.form.NotificationClientFactory;
import com.otoil.ot_040_1_0020.client.form.NotificationClientFactoryImpl;
import com.otoil.ot_040_1_0050.client.ProfileClientFactory;
import com.otoil.ot_040_1_0050.client.impl.ProfileClientFactoryImpl;
import com.otoil.ot_040_1_0080.client.common.QuartzManagerClientFactory;
import com.otoil.ot_040_1_0080.client.common.QuartzManagerClientFactoryImpl;
import com.otoil.ot_040_1_0100.client.form.RationingTablesClientFactory;
import com.otoil.ot_040_1_0100.client.form.impl.RationingTablesClientFactoryImpl;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.tile.presenter.SolrTileClientFactory;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.tile.presenter.SolrTileClientFactoryImpl;
import com.otoil.ot_040_7_0010.client.mainform.AbstractMainFormClientFactory;

import com.otoil.ot_131_1_0140.client.TemplateMonitoringClientFactory;
import com.otoil.ot_131_1_0140.client.TemplateMonitoringFormFactory;
import com.otoil.ot_131_1_0140.client.main.impl.TemplateMonitoringFormClientFactoryImpl;
import com.otoil.ot_131_main.client.HPDCommonClientFactory;
import com.otoil.ot_131_main.client.HPDCommonClientFactoryImpl;
import com.otoil.ot_135_1_0010.client.GraphicalReportingClientFactory;
import com.otoil.ot_135_1_0010.client.customization.CustomizationButtonManager;
import com.otoil.ot_135_1_0010.client.customization.CustomizationButtonManagerImpl;
import com.otoil.ot_135_1_0010.client.customization.CustomizationManager;
import com.otoil.ot_135_1_0010.client.customization.GOTileRegistratorFactory;
import com.otoil.ot_135_1_0010.client.impl.GraphicalReportingClientFactoryImpl;
import com.otoil.ot_135_1_0020.client.GraphicalReportingEditorClientFactory;
import com.otoil.ot_135_1_0020.client.impl.GraphicalReportingEditorClientFactoryImpl;
import com.otoil.ot_135_2_0020.client.testviewer.TestVisPresenterFactory;
import com.otoil.ot_932_1_0090.client.MiningWorksDesignClientFactory;
import com.otoil.ot_932_1_0090.client.MiningWorksDesignClientFactoryImpl;
import com.otoil.ot_932_1_0190.client.ExplorationWellsClientFactory;
import com.otoil.ot_932_1_0190.client.impl.ExplorationWellsClientFactoryImpl;
import com.otoil.ot_932_5_0160.client.GOCustomizationManager;
import com.otoil.ot_932_ago.client.OT_932_ClientFactory;
import com.otoil.ot_932_ago.client.OT_932_TilePlacer;
import com.otoil.ot_932_ago.client.tiles.OT_932_TileClientFactory;
import com.otoil.ot_932_ago.client.tiles.OT_932_TileClientFactoryImpl;
import com.otoil.tiles.client.TilePlacer;
import com.otoil.tiles.client.TileRegistry;

import ru.ot.gtmdb.wets.main.client.ReportManagerClientFactory;
import ru.ot.gtmdb.wets.main.client.ReportManagerClientFactoryImpl;
import ru.ot.mvp.client.history.AsyncPlaceController;
import ru.ot.ot_131_5_0050.client.customalgorithm.TileRegistratorFactory;
import ru.ot.wevelns.client.Point;
import ru.ot.wevelns.client.banner.user.UserDialogClientFactory;
import ru.ot.wevelns.client.banner.user.UserDialogClientFactoryImpl;
import ru.ot.wevelns.client.main.MainFormPresenter.MainFormModel;
import ru.ot.wevelns.client.main.resources.MainFormResources;

public class OT_932_ClientFactoryImpl extends AbstractMainFormClientFactory implements OT_932_ClientFactory {
	private PlaceHistoryMapper placeHistoryMapper;
	/*
	 * Личный кабинет
	 */
	private ProfileClientFactoryImpl profileClientFactory;
	private TilePlacer<Point> profileTilePlacer;

	private final Place defaultPlace;
	private TemplateMonitoringClientFactory hpdMonitoringClientFactory;

	public OT_932_ClientFactoryImpl(AsyncPlaceController placeController, PlaceHistoryMapper placeHistoryMapper,
			Place defaultPlace) {
		super(placeController);
		this.placeHistoryMapper = placeHistoryMapper;
		this.defaultPlace = defaultPlace;
		registerTiles();
	}

	private void registerTiles() {
		TileRegistry register = new TileRegistry();
		profileTilePlacer = new OT_932_TilePlacer(register);

		/*
		 * TileRegistratorFactory из Библиотеки. Необходима при старте Рабочего стола
		 */
		TileRegistratorFactory.getTileRegistrator().registerTiles();
		GOTileRegistratorFactory.getTileRegistrator().registerTiles();

	}

	@Override
	public MainFormModel getMainFormModel() {
		formModel = new OT_932_MainFormModelImpl(placeHistoryMapper, defaultPlace);
		return formModel;
	}

	@Override
	public PlaceHistoryMapper getPlaceHistoryMapper() {
		return placeHistoryMapper;
	}

	@Override
	public UserDialogClientFactory getUserDialogClientFactory() {
		return new UserDialogClientFactoryImpl(placeController);
	}

	@Override
	public IssueCreatorTileClientFactory getIssueCreatorTilePresenterFactory() {
		return new IssueCreatorTileClientFactoryImpl(placeController);
	}

	@Override
	public ProfileClientFactory getProfileClientFactory() {
		if (profileClientFactory == null) {
			profileClientFactory = new ProfileClientFactoryImpl(getPlaceController(), profileTilePlacer);
		}
		return profileClientFactory;
	}

	@Override
	public SolrTileClientFactory getSolrTileClientFactory() {
		return new SolrTileClientFactoryImpl(getPlaceController());
	}

	@Override
	public OT_932_TileClientFactory getOT_932_TileClientFactory() {
		return new OT_932_TileClientFactoryImpl(placeController);
	}

	@Override
	public ReportManagerClientFactory getReportManagerClientFactory() {
		return new ReportManagerClientFactoryImpl(getPlaceController());
	}

	@Override
	public RationingTablesClientFactory getRationingTablesClientFactory() {
		return new RationingTablesClientFactoryImpl(getPlaceController());
	}

	@Override
	public HPDCommonClientFactory getHPDCommonClientFactory() {
		return new HPDCommonClientFactoryImpl(placeController, placeHistoryMapper, defaultPlace, true);
	}

	private TemplateMonitoringClientFactory getHpdMonitoringClientFactory() {
		if (hpdMonitoringClientFactory == null) {
			String solrCoreName;
			try {
				solrCoreName = (String) ru.ot.wevelns.client.login.LoginMetaData
						.getProperty("solr-monitoring.solr-core");
			} catch (Exception e) {
				solrCoreName = null;
			}
			hpdMonitoringClientFactory = new TemplateMonitoringFormClientFactoryImpl(placeController, solrCoreName);
		}
		return hpdMonitoringClientFactory;
	}

	@Override
	public TemplateMonitoringFormFactory getMonitoringFormFactory() {
		return new TemplateMonitoringFormFactory(getHpdMonitoringClientFactory(), placeHistoryMapper);
	}

	@Override
	public NotificationClientFactory getNotificationClientFactory() {
		return new NotificationClientFactoryImpl(getPlaceController());
	}

	@Override
	public GraphicalReportingEditorClientFactory getGraphicalReportingEditorFormFactory() {
		return new GraphicalReportingEditorClientFactoryImpl(placeController);
	}

	@Override
	public QuartzManagerClientFactory getQuartzManagerClientFactory() {
		return new QuartzManagerClientFactoryImpl(placeController);
	}

	@Override
	public MiningWorksDesignClientFactory getMiningWorksDesignClientFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExplorationWellsClientFactory getExplorationWellsClientFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphicalReportingClientFactory getGraphicalReportingClientFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
