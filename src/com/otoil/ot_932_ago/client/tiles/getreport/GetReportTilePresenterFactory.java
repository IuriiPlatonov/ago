package com.otoil.ot_932_ago.client.tiles.getreport;


import com.google.gwt.user.client.rpc.AsyncCallback;

import ru.ot.mvp.client.presenters.Presenter;

import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper.TilePresenterFactory;


public class GetReportTilePresenterFactory
        implements TilePresenterFactory<GetReportTile>
{
    private GetReportTileClientFactory clientFactory;

    public GetReportTilePresenterFactory(GetReportTileClientFactory clientFactory)
    {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public void getPresenter(GetReportTile tile,
        AsyncCallback<Presenter> presenterCallback)
    {
        presenterCallback.onSuccess(new GetReportTilePresenter(clientFactory));
    }
}
