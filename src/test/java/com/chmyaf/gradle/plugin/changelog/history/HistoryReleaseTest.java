package com.chmyaf.gradle.plugin.changelog.history;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HistoryReleaseTest {

    @Test
    void getAdded() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> emptyList = new ArrayList<>();
        assertEquals(historyRelease.getAdded().size(), 0);
        assertEquals(historyRelease.getAdded(), emptyList);
    }

    @Test
    void getDate() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getDate());
    }

    @Test
    void getFixed() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> emptyList = new ArrayList<>();
        assertEquals(historyRelease.getFixed().size(), 0);
        assertEquals(historyRelease.getFixed(), emptyList);
    }

    @Test
    void getPublish() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> emptyList = new ArrayList<>();
        assertEquals(historyRelease.getPublish().size(), 0);
        assertEquals(historyRelease.getPublish(), emptyList);

    }

    @Test
    void getTag() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getTag());
        assertEquals(historyRelease.getTag(), "");
    }

    @Test
    void getTagPrev() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getTagPrev());
        assertEquals(historyRelease.getTagPrev(), "");
    }

    @Test
    void getVersion() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getVersion());
        assertEquals(historyRelease.getVersion(), "");
    }

    @Test
    void setAdded() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> empty = new ArrayList<>();
        historyRelease.setAdded(empty);

        assertEquals(historyRelease.getAdded().size(), 0);
        assertEquals(historyRelease.getAdded(), empty);
    }

    @Test
    void setAddedEdited() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> edited = new ArrayList<>();
        edited.add("added description");
        historyRelease.setAdded(edited);

        assertEquals(historyRelease.getAdded().size(), 1);
        assertEquals(historyRelease.getAdded().get(0), "added description");
    }

    @Test
    void setDate() {
        HistoryRelease historyRelease = new HistoryRelease();

        Date checkDate = new Date();
        historyRelease.setDate(checkDate);

        assertEquals(historyRelease.getDate(), checkDate);
    }

    @Test
    void setFixed() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> empty = new ArrayList<>();
        historyRelease.setFixed(empty);

        assertEquals(historyRelease.getFixed().size(), 0);
        assertEquals(historyRelease.getFixed(), empty);
    }

    @Test
    void setFixedEdited() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> edited = new ArrayList<>();
        edited.add("fixed description");
        historyRelease.setFixed(edited);

        assertEquals(historyRelease.getFixed().size(), 1);
        assertEquals(historyRelease.getFixed().get(0), "fixed description");
    }

    @Test
    void setPublish() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> empty = new ArrayList<>();
        historyRelease.setPublish(empty);

        assertEquals(historyRelease.getPublish().size(), 0);
        assertEquals(historyRelease.getPublish(), empty);
    }

    @Test
    void setPublishEdited() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> edited = new ArrayList<>();
        edited.add("publish to");
        historyRelease.setPublish(edited);

        assertEquals(historyRelease.getPublish().size(), 1);
        assertEquals(historyRelease.getPublish().get(0), "publish to");
    }

    @Test
    void setTag() {
        HistoryRelease historyRelease = new HistoryRelease();

        historyRelease.setTag("v1.0.1");
        assertEquals(historyRelease.getTag(), "v1.0.1");
    }

    @Test
    void setTagPrev() {
        HistoryRelease historyRelease = new HistoryRelease();

        historyRelease.setTagPrev("v1.0.0");
        assertEquals(historyRelease.getTagPrev(), "v1.0.0");
    }

    @Test
    void setVersion() {
        HistoryRelease historyRelease = new HistoryRelease();

        historyRelease.setVersion("1.0.1");
        assertEquals(historyRelease.getVersion(), "1.0.1");
    }
}