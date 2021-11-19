package com.otoil.ot_932_ago.client;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.LoginException;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import ru.ot.gtmdb.wets.places.client.WetsPlaceHistoryMapper;
import ru.ot.gwt.exception.client.ErrorHandler;
import ru.ot.gwt.exception.client.ErrorManager;
import ru.ot.gwt.utils.client.callback.Callbacks;
import ru.ot.gwt.utils.client.callback.DelegateErrorAsyncCallback;
import ru.ot.gwt.utils.client.rest.RestServiceAdapter;
import ru.ot.gwt.utils.client.watchexecution.WatchExecutionDispatcher;
import ru.ot.hpd.authorise.client.AccessManager;
import ru.ot.mvp.client.history.AsyncPlaceController;
import ru.ot.mvp.client.history.AsyncPresenterMapper;
import ru.ot.mvp.client.history.CompositePlaceHistoryMapper;
import ru.ot.wevelns.client.NSEntryPoint;
import ru.ot.wevelns.client.NSErrorDialog;
import ru.ot.wevelns.client.NSMessageDialog;
import ru.ot.wevelns.client.login.LoginMetaData;
import ru.ot.wevelns.client.main.AbstractMainFormPresenter;
import ru.ot.wevelns.client.main.MainFormClientFactory;
import ru.ot.wevelns.client.main.MainFormPresenter;
import ru.ot.wevelns.client.main.tray.TrayTileRegistry;

import com.otoil.issue.creator.client.IssueCreatorPresenter;
import com.otoil.issue.creator.client.dialog.FeedbackErrorDialog;
import com.otoil.issue.creator.client.tray.IssueCreatorTile;
import com.otoil.ot_040_1_0020.client.tray.NotificationTrayTile;
import com.otoil.ot_040_7_0010.client.login.LoginInvoker;
import com.otoil.ot_040_atoll.places.client.ProfilePlace;
import com.otoil.ot_131_main.client.HPDCommonPlaceHistoryMapper;
import com.otoil.ot_135_1_0010.client.GraphicalReportingsPlaceHistoryMapper;
import com.otoil.ot_135_1_0020.client.GraphicalReportingEditorPlaceHistoryMapper;
import com.otoil.ot_135_5_0020.client.base.InlineVisualiserPresenterMapper;
import com.otoil.ot_932.places.client.Carcas3DVisualiserPlace;
import com.otoil.ot_932_5_0020.client.helper.MicromineHelper;
import com.otoil.ot_932_5_0020.client.helper.MicromineHelper.NMineBlockMode;
import com.otoil.ot_932_5_0020.client.rounding.BuForRounding;
import com.otoil.ot_932_5_0020.client.rounding.RoundingRules;
import com.otoil.ot_932_5_0170.client.Carcas3DPlaceHistoryMapper;
import com.otoil.ot_932_5_0170.client.Carcas3DVisualiserPresenterFactory;
import com.otoil.ot_932_ago.client.impl.OT_932_ClientFactoryImpl;
import com.otoil.ot_932_ago.client.issue.OT_932_IssueCreatorClientFactoryImpl;
import com.otoil.ot_932_ago.client.secretdialog.SecretDialog;
import com.otoil.ot_932_ago.client.services.WarnShowServiceAsync;
import com.otoil.speedtest.client.dialog.SpeedTestPresenter;
import com.otoil.speedtest.client.dialog.impl.SpeedTestClientFactoryImpl;
import com.otoil.tiles.client.mapper.TilePresenterMapper;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.plugins.RxJavaPlugins;


public class OT_932_EntryPoint extends NSEntryPoint<OT_932_ClientFactory>
{
    private static final String FUNCTION_NAME_MM_ENABLE = "OT.932.APP.SF.9.001";

    private Logger logger = Logger.getLogger(OT_932_EntryPoint.class.getName());

    private IssueCreatorPresenter issueCreatorPresenter;
    private SpeedTestPresenter speedTestPresenter;
    private Place defaultPlace;
    private SecretDialog secretDialog;

    public OT_932_EntryPoint()
    {
        Defaults.setDispatcher(new WatchExecutionDispatcher());

        setLoginInvoker(new LoginInvoker()
        {
            @Override
            protected LoginMetaDataAsyncCallback getLoginMetaDataAsyncCallback(
                AsyncCallback<HashMap<String, String>> callback)
            {
                LoginMetaDataAsyncCallback loginMetaDataAsyncCallback = new LoginMetaDataAsyncCallback(
                    new DelegateErrorAsyncCallback<HashMap<String, String>>(
                        callback)
                    {
                        @Override
                        protected void safeOnSuccess(
                            HashMap<String, String> params) throws Exception
                        {
                            /*
                             * Свойства, которые не загружатся явно в
                             * LoginMetaData.load()
                             */
                            for (String key : params.keySet())
                            {
                                LoginMetaData.setProperty(key, params.get(key));
                            }
                            RoundingRules.get().init();
                            BuForRounding.get().init();
                            ru.ot.gwt.authorise.client.access.AccessManager
                                .ifGranted(FUNCTION_NAME_MM_ENABLE)
                                .then(isGranted -> {
                                    NMineBlockMode mode = isGranted
                                        ? NMineBlockMode.NORMAL
                                        : NMineBlockMode.BLOCKED;
                                    MicromineHelper.setInterfaceEnable(mode)
                                        .subscribe(s -> {
                                            logger.log(Level.INFO,
                                                "Success setInterfaceEnable for N-Mine to "
                                                    + mode);
                                        }, e -> {
                                            logger.log(Level.WARNING,
                                                "Can't setInterfaceEnable for N-Mine",
                                                e);
                                        });
                                });
                            AccessManager.INSTANCE.resetAccessManager(
                                new DelegateErrorAsyncCallback<Void>(callback)
                                {
                                    @Override
                                    protected void safeOnSuccess(
                                        Void nullResult) throws Exception
                                    {
                                        callback.onSuccess(params);
                                    }
                                });
                        }
                    });

                return loginMetaDataAsyncCallback;
            }
        });

        issueCreatorPresenter = new IssueCreatorPresenter(
            new OT_932_IssueCreatorClientFactoryImpl());
        speedTestPresenter = new SpeedTestPresenter(
            new SpeedTestClientFactoryImpl());

        LoginMetaData.logoffAlwaysEnabled = true;
    }

    @Override
    public void onModuleLoad()
    {
        RootLayoutPanel.get().addStyleName("rootPanel");

        super.onModuleLoad();

        ErrorManager.getInstance().setErrorDialog(LoginException.class,
            new NSErrorDialog());
        FeedbackErrorDialog errorDialog = new FeedbackErrorDialog();
        ErrorManager.getInstance().setErrorDialog(errorDialog);
        RxJavaPlugins.setErrorHandler(error -> {
            Throwable cause = error;
            while (cause instanceof OnErrorNotImplementedException)
            {
                cause = cause.getCause();
            }
            ErrorHandler.handleException(cause);
        });

        speedTestPresenter.start(null, null);
        issueCreatorPresenter.start(null, null);
        TrayTileRegistry.getInstance().registerTiles(new IssueCreatorTile(),
            new NotificationTrayTile());
    }

    @Override
    public OT_932_ClientFactory getClientFactory(
        AsyncPlaceController placeController)
    {
        return new OT_932_ClientFactoryImpl(placeController,
            getPlaceHistoryMapper(), getDefaultPlace());
    }

    @Override
    public MainFormClientFactory getMainFormClientFactory(
        AsyncPlaceController placeController, HashMap<String, String> params)
    {
        return new OT_932_ClientFactoryImpl(placeController,
            getPlaceHistoryMapper(), getDefaultPlace());
    }

    @Override
    public PlaceHistoryMapper getPlaceHistoryMapper()
    {
        Map<String, String> unimplementedForms = new HashMap<>();

        // "Детализация склада"
        unimplementedForms.put("warehouse-detail:", "OT_932_1_0130");
        // "Визуализация данных литологии"
        unimplementedForms.put("OT_932_8_0030", "OT_932_8_0030");
        // "Паспорт борозды"
        unimplementedForms.put("furrow-detail:", "OT_932_1_0180");
        // "Мониторинг ГТК"
        unimplementedForms.put("samplings-of-ore-mapping:", "OT_932_1_0260");
        // // "Учет горной массы на складах"
        // unimplementedForms.put("rock-accounting-at-warehouses:",
        // "OT_932_1_0290");

        return new CompositePlaceHistoryMapper(
            new UnderConstructionPlaceHistoryMapper(unimplementedForms),
            OT_932_PlaceHistoryMapper.INSTANCE,
            WetsPlaceHistoryMapper.INSTANCE,
            HPDCommonPlaceHistoryMapper.INSTANCE,
            GraphicalReportingsPlaceHistoryMapper.INSTANCE,
            GraphicalReportingEditorPlaceHistoryMapper.INSTANCE);
    }

    @Override
    public AsyncPresenterMapper getPresenterMapper(
        OT_932_ClientFactory clientFactory)
    {
        registerInlineVisualisers(clientFactory);
        return new OT_932_PresenterMapper(clientFactory);
    }

    @Override
    public TilePresenterMapper getTilePresenterMapper(
        OT_932_ClientFactory clientFactory)
    {
        return new OT_932_TilePresenterMapper(clientFactory);
    }

    private Place getDefaultPlace()
    {
        if (defaultPlace == null)
        {
            defaultPlace = new ProfilePlace();
        }
        return defaultPlace;
    }

    @Override
    protected AbstractMainFormPresenter<?, ?> getMainFormPresenter(
        AsyncPlaceController placeController,
        AsyncPresenterMapper presenterMapper,
        PlaceHistoryMapper placeHistoryMapper,
        TilePresenterMapper tilePresenterMapper, HashMap<String, String> params)
    {
        MainFormPresenter mainPresenter = new MainFormPresenter(
            getMainFormClientFactory(placeController, params), presenterMapper,
            placeHistoryMapper, tilePresenterMapper)
        {
            RestServiceAdapter<WarnShowServiceAsync> service = RestServiceAdapter
                .get(GWT.create(WarnShowServiceAsync.class));
            Runnable tokenGrantedRequest;

            private void runTokenGrantedRequest()
            {
                if (tokenGrantedRequest != null)
                {
                    tokenGrantedRequest.run();
                    tokenGrantedRequest = null;
                }
            }

            @Override
            protected void isTokenGranted(String token, String function,
                AsyncCallback<Boolean> callback)
            {
                // Запоминаем последний запрос, поскольку только на него мы
                // должны ответить
                tokenGrantedRequest = () -> super.isTokenGranted(token,
                    function, callback);

                service.toSingle(WarnShowServiceAsync::getToShowWarn)
                    .subscribe(toShowWarn -> {
                        if (toShowWarn)
                        {
                            // показываем диалог только один раз
                            if (secretDialog == null)
                            {
                                secretDialog = new SecretDialog();
                                Callbacks.toSingle(secretDialog::showCenter)
                                    .subscribe(modalResult -> {
                                        secretDialog = null;
                                        if (modalResult == NSMessageDialog.MR_OK)
                                        {
                                            service
                                                .toSingle(
                                                    s -> s.setToShowWarn(false))
                                                .subscribe(
                                                    newToShowWarn -> runTokenGrantedRequest());
                                        }
                                        else
                                        {
                                            logoff();
                                        }
                                    });
                            }
                        }
                        else
                        {
                            runTokenGrantedRequest();
                        }
                    });
            }
        };

        return mainPresenter;
    }

    private void registerInlineVisualisers(OT_932_ClientFactory clientFactory)
    {
        /*
         * Визуализатор сечений и проекций на основании каркасов
         */
        InlineVisualiserPresenterMapper.INSTANCE
            .addPlaceMapper(Carcas3DPlaceHistoryMapper.INSTANCE);
        InlineVisualiserPresenterMapper.INSTANCE.addPresenterFactory(
            Carcas3DVisualiserPlace.class,
            new Carcas3DVisualiserPresenterFactory(
                clientFactory.getPlaceController()));
    }
}
