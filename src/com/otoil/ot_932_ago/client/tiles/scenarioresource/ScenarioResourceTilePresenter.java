package com.otoil.ot_932_ago.client.tiles.scenarioresource;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;
import com.otoil.ot_932_2_0780.client.events.OpenScenarioResourceEvent;
import com.otoil.ot_932_2_0780.client.form.ScenarioResourcePresenter;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenter.ScenarioResourceModelTileModel;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenter.ScenarioResourceModelTileView;

import io.reactivex.disposables.CompositeDisposable;
import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;


public class ScenarioResourceTilePresenter extends
        AbstractPresenter<ScenarioResourceModelTileModel, ScenarioResourceModelTileView>
{
   
    public interface ScenarioResourceModelTileView extends IsWidget
    {

        Action openBlockModelParameters();

        HasClickHandlers close();

    }
    public interface ScenarioResourceModelTileModel extends Model
    {

    }
    private CompositeDisposable subscription = new CompositeDisposable();
    private ScenarioResourceTileClientFactory clientFactory;
    private ScenarioResourcePresenter scenarioResourcePresenter;

    public ScenarioResourceTilePresenter(
        ScenarioResourceTileClientFactory clientFactory)
    {
        super(clientFactory.getScenarioResourceModelTileModel(),
            clientFactory.getScenarioResourceModelTileView());
        this.clientFactory = clientFactory;
    }

    public ScenarioResourcePresenter ensureBlockModelParametersPresenter()
    {
        if (scenarioResourcePresenter != null)
        {
            scenarioResourcePresenter.onStop();
        }
        scenarioResourcePresenter = new ScenarioResourcePresenter(
            clientFactory.getScenarioResourceClientFactory());
        scenarioResourcePresenter.start(null, eventBus);
        return scenarioResourcePresenter;
    }

    @Override
    public void bind()
    {
        subscription.add(RxHandlers.click(view.openBlockModelParameters())
            .subscribe(event -> {
                ensureBlockModelParametersPresenter();
                eventBus.fireEvent(new OpenScenarioResourceEvent());
            }));

        subscription.add(RxHandlers.click(view.close()).subscribe(event -> {
            onStop();
        }));
    }

    @Override
    public void onStop()
    {
        subscription.clear();
        if (scenarioResourcePresenter != null)
        {
            scenarioResourcePresenter.onStop();
            scenarioResourcePresenter = null;
        }
        super.onStop();
    }
}
