package com.otoil.ot_932_ago.client.issue;


import com.otoil.issue.creator.client.IssueCreatorClientFactory;
import com.otoil.issue.creator.client.IssueCreatorPresenter.IssueCreatorModel;
import com.otoil.issue.creator.client.IssueCreatorPresenter.IssueCreatorView;
import com.otoil.issue.creator.client.impl.view.IssueCreatorViewImpl;
import com.otoil.ot_040_5_0010.client.issue.AtollIssueCreatorModelImpl;


public class OT_932_IssueCreatorClientFactoryImpl
        implements IssueCreatorClientFactory
{
    @Override
    public IssueCreatorModel getIssueCreatorModel()
    {
        return new AtollIssueCreatorModelImpl();
    }

    @Override
    public IssueCreatorView getIssueCreatorView()
    {
        return new IssueCreatorViewImpl();
    }
}
