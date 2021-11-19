package com.otoil.ot_932_ago.client.secretdialog;

import com.otoil.ot_932_ago.client.i18n.OreMainConstantsFactory;

import ru.ot.wevelns.client.NSButton;
import ru.ot.wevelns.client.NSMessageDialog;
import ru.ot.wevelns.client.dialog.MessageType;
import ru.ot.wevelns.client.dialog.OptionType;

public class SecretDialog  extends NSMessageDialog{
	
    public SecretDialog()
    {
        super(false, OptionType.YES_NO_OPTION, MessageType.WARNING_TYPE);
        
        setMessage("<b>" + OreMainConstantsFactory.getInstance().secretWarning() + "</b>");
        setGlassEnabled(true);

        NSButton okButton = (NSButton) getButtons()[0];
        okButton.setCaption(OreMainConstantsFactory.getInstance().agree());
        okButton.setFocus(true);
        
        NSButton noButton = (NSButton) getButtons()[1];
        noButton.setCaption(OreMainConstantsFactory.getInstance().disagree());

        setWidth("500px");
    }
}
