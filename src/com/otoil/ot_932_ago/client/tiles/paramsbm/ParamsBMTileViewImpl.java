package com.otoil.ot_932_ago.client.tiles.paramsbm;


import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;

import ru.ot.gwt.atoll.client.images.Images;
import ru.ot.gwt.atoll.client.images.ImagesBundle;
import ru.ot.wevelns.client.NSAcceptButton;
import ru.ot.wevelns.client.NSHorizontalPanel;
import ru.ot.wevelns.client.action.Action;
import ru.ot.wevelns.client.tile.DefaultTilePanel;

import com.otoil.ot_932_ago.client.i18n.OreMainConstants;
import com.otoil.ot_932_ago.client.i18n.OreMainConstantsFactory;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileView;


public class ParamsBMTileViewImpl extends DefaultTilePanel
        implements ParamsBMTileView
{
    private NSAcceptButton openBlockModelParametersButton = new NSAcceptButton(
        "Выгрузить");

    private static final ImagesBundle IMAGES = Images.getBundle();
    private Image image = new Image(IMAGES.img1996_30x30());

    OreMainConstants resources = OreMainConstantsFactory.getInstance();

    public ParamsBMTileViewImpl()
    {
        super();
        setCaption(resources.paramsBMName());

        NSHorizontalPanel imagePanel = new NSHorizontalPanel(
            HasHorizontalAlignment.ALIGN_CENTER,
            HasVerticalAlignment.ALIGN_MIDDLE);
        imagePanel.setSize("100%", "125%");
        imagePanel.add(image);

        NSHorizontalPanel btnPanel = new NSHorizontalPanel(
            HasHorizontalAlignment.ALIGN_CENTER);
        btnPanel.setSize("100%", "100%");
        btnPanel.add(openBlockModelParametersButton);

        DockLayoutPanel docPanel = new DockLayoutPanel(Unit.PCT);
        docPanel.setSize("100%", "100%");

        docPanel.addSouth(btnPanel, 25);
        docPanel.add(imagePanel);

        setContent(docPanel);
    }

    @Override
    public Action openBlockModelParameters()
    {
        return openBlockModelParametersButton;
    }
}
