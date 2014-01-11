package com.bugsnag.model;

import java.util.HashMap;
import java.util.Map;

public class MetaDataVO {

    private Map<String, TabVO> nameToTab = new HashMap<String, TabVO>();

    public MetaDataVO addToTab(final String tabName, final String key, final Object value) {
        getAndEnsureTabExistence(tabName).add(key, value);
        return this;
    }

    private TabVO getAndEnsureTabExistence(final String tabName) {
        final TabVO tab = nameToTab.get(tabName);
        final boolean tabDoesNotExist = tab == null;
        if (tabDoesNotExist) {
            final TabVO newTab = new TabVO();
            nameToTab.put(tabName, newTab);
            return newTab;
        }

        return tab;
    }

    public Map<String, TabVO> getNameToTab() {
        return nameToTab;
    }
}