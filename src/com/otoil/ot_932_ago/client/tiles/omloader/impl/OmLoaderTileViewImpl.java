package com.otoil.ot_932_ago.client.tiles.omloader.impl;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.otoil.ot_932_ago.client.i18n.OreMainConstants;
import com.otoil.ot_932_ago.client.i18n.OreMainConstantsFactory;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTilePresenter.OmLoaderTileView;

import lombok.Getter;
import ru.ot.gwt.atoll.client.images.Images;
import ru.ot.wevelns.client.NSAcceptButton;
import ru.ot.wevelns.client.NSHorizontalPanel;
import ru.ot.wevelns.client.tile.DefaultTilePanel;


public class OmLoaderTileViewImpl extends DefaultTilePanel
        implements OmLoaderTileView
{
    private final OreMainConstants CONSTANTS = OreMainConstantsFactory
        .getInstance();

    @Getter
    private final NSAcceptButton openButton = new NSAcceptButton(
        CONSTANTS.omStartBtn());

    public OmLoaderTileViewImpl()
    {
        super();
        setCaption(CONSTANTS.omLoaderTitle());
        NSHorizontalPanel imagePanel = new NSHorizontalPanel(
            HasHorizontalAlignment.ALIGN_CENTER,
            HasVerticalAlignment.ALIGN_MIDDLE);
        imagePanel.setSize("100%", "125%");
        imagePanel.add(new Image(Images.getBundle().img1996_30x30()));

        NSHorizontalPanel btnPanel = new NSHorizontalPanel(
            HasHorizontalAlignment.ALIGN_CENTER);
        btnPanel.setSize("100%", "100%");
        btnPanel.add(openButton);

        DockLayoutPanel docPanel = new DockLayoutPanel(Unit.PCT);
        docPanel.setSize("100%", "100%");

        docPanel.addSouth(btnPanel, 25);
        docPanel.add(imagePanel);

        setContent(docPanel);
    }
}
