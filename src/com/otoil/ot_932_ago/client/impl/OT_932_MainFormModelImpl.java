package com.otoil.ot_932_ago.client.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.resources.client.ImageResource;

import ru.ot.gwt.atoll.client.images.Images;
import ru.ot.gwt.binding.client.tree.TreeListModel;
import ru.ot.gwt.sdo.client.SqlClauseBuilder;
import ru.ot.gwt.sdo.client.SqlClauseProvider;
import ru.ot.gwt.sdo.client.common.QueryProxy;
import ru.ot.wevelns.client.login.LoginMetaData;
import ru.ot.wevelns.client.main.DefaultMenuItem;
import ru.ot.wevelns.client.main.MenuItem;

import com.otoil.ot_040_7_0010.client.mainform.common.FormInfo;
import com.otoil.ot_040_7_0010.client.mainform.impl.AbstractMainFormModel;
import com.otoil.ot_932_5_0020.shared.MineProMainFormModel;


public class OT_932_MainFormModelImpl extends AbstractMainFormModel
        implements MineProMainFormModel
{
    private static final String ATOLL_PLATFORMA_IDENTIFIER = "OT.104";
    private static final String ATOLL_LIBRARY_IDENTIFIER = "OT.131";
    private static final String ORE_IDENTIFIER = "OT.932";
    private static final String SDK_IDENTIFIER = "OT.040";

    private HashMap<String, FormInfo> map;
    private Place defaultPlace;
    private PlaceHistoryMapper historyMapper;

    public OT_932_MainFormModelImpl(PlaceHistoryMapper historyMapper,
        Place defaultPlace)
    {
        super();
        this.historyMapper = historyMapper;
        this.defaultPlace = defaultPlace;
    }

    private void installAppIcons(List<MenuItem> applicationItems)
    {
        for (MenuItem appMenuItem : applicationItems)
        {
            String identifier = appMenuItem.getIdentifier();
            if (appMenuItem.getSmallImageUrl() == null)
            {
                ImageResource image = null;
                if (ATOLL_PLATFORMA_IDENTIFIER.equals(identifier))
                {
                    image = Images.getBundle().img1893_32x32();
                }
                else if (ATOLL_LIBRARY_IDENTIFIER.equals(identifier))
                {
                    image = Images.getBundle().img1899_32x32();
                }
                else if (ORE_IDENTIFIER.equals(identifier))
                {
                    image = Images.getBundle().img1891_32x32();
                }
                else if (SDK_IDENTIFIER.equals(identifier))
                {
                    image = Images.getBundle().img1989_32x32();
                }

                if (image != null)
                {
                    appMenuItem.setSmallImageUrl(image.getSafeUri().asString());
                }
            }
        }
    }

    @Override
    protected void buildMenu(TreeListModel menu,
        List<MenuItem> applicationItems, Map<String, List<MenuItem>> formsByApp,
        Map<String, List<MenuItem>> reportGroupsByApp,
        Map<String, List<MenuItem>> functionsByParent)
    {
        List<MenuItem> forms = removeItems(formsByApp, "OT.100.APP.SF.003",
            "OT.118.APP.SF.002");
        if (!forms.isEmpty())
        {
            MenuItem app = FluentIterable.from(applicationItems)
                .firstMatch(new Predicate<MenuItem>()
                {
                    @Override
                    public boolean apply(MenuItem menuItem)
                    {
                        return ATOLL_PLATFORMA_IDENTIFIER
                            .equalsIgnoreCase(menuItem.getIdentifier());
                    }
                }).orNull();

            if (app == null)
            {
                app = new DefaultMenuItem("-1", ATOLL_PLATFORMA_IDENTIFIER,
                    "Платформа АТОЛЛ", null, false, true);
                applicationItems.add(0, app);
                formsByApp.put(app.getId(), new ArrayList<MenuItem>());
            }
            formsByApp.get(app.getId()).addAll(forms);

            for (Iterator<MenuItem> iterator = applicationItems
                .iterator(); iterator.hasNext();)
            {
                String appId = iterator.next().getId();
                if (!formsByApp.containsKey(appId)
                    && !reportGroupsByApp.containsKey(appId))
                {
                    iterator.remove();
                }
            }
        }

        installAppIcons(applicationItems);

        super.buildMenu(menu, applicationItems, formsByApp, reportGroupsByApp,
            functionsByParent);
    }

    private List<MenuItem> removeItems(Map<String, List<MenuItem>> groupedForms,
        String... identifiers)
    {
        List<MenuItem> removedItems = new ArrayList<MenuItem>();

        List<String> leftIdentifiers = new ArrayList<String>(
            Arrays.asList(identifiers));

        Iterator<Entry<String, List<MenuItem>>> formsEntryIterator = groupedForms
            .entrySet().iterator();
        while (formsEntryIterator.hasNext() && !leftIdentifiers.isEmpty())
        {
            Entry<String, List<MenuItem>> formsEntry = formsEntryIterator
                .next();
            List<MenuItem> forms = formsEntry.getValue();
            Iterator<MenuItem> formsIterator = forms.iterator();
            while (formsIterator.hasNext() && !leftIdentifiers.isEmpty())
            {
                MenuItem menuItem = formsIterator.next();
                if (leftIdentifiers.remove(menuItem.getIdentifier()))
                {
                    removedItems.add(menuItem);
                    formsIterator.remove();
                }
            }
            if (forms.isEmpty())
            {
                formsEntryIterator.remove();
            }
        }

        return removedItems;
    }

    @Override
    public String getApplicationName()
    {
        return "";
    }

    public Place getDefaultPlace()
    {
        return defaultPlace;
    }

    @Override
    public String getDefaultToken()
    {
        return historyMapper.getToken(defaultPlace);
    }

    @Override
    public Map<String, FormInfo> getFormsInfoMap()
    {
        if (map == null)
        {
            map = new HashMap<String, FormInfo>();
            /*
             * Все данные о форме берутся из БД, здесь ни для каких форм не
             * переопределяем ничего
             */
        }

        return map;
    }

    @Override
    protected void tuneParams(QueryProxy queryParams)
    {
        queryParams.setWhereClauseProvider(
            new SqlClauseProvider(MineProGroupWhereClauseBuilder.class));
        queryParams.setWhereClauseParam("USER_NAME", LoginMetaData.userLogin);
    }

    private static class MineProGroupWhereClauseBuilder
            implements SqlClauseBuilder
    {
        @Override
        public String buildSqlClause(HashMap<String, String> params)
        {
            return MINE_PRO_FUNCTION_WHERE_CLAUSE;
        }
    }
}
