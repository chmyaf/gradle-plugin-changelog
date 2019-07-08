/*
 * Copyright 2019 Andrey S Teplitskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chmyaf.gradle.plugin.changelog.history;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HistoryReleaseTest {

    @Test
    void testGetAdded() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> emptyList = new ArrayList<>();
        assertEquals(historyRelease.getAdded().size(), 0);
        assertEquals(historyRelease.getAdded(), emptyList);
    }

    @Test
    void testGetDate() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getDate());
    }

    @Test
    void testGetFixed() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> emptyList = new ArrayList<>();
        assertEquals(historyRelease.getFixed().size(), 0);
        assertEquals(historyRelease.getFixed(), emptyList);
    }

    @Test
    void testGetPublish() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> emptyList = new ArrayList<>();
        assertEquals(historyRelease.getPublish().size(), 0);
        assertEquals(historyRelease.getPublish(), emptyList);

    }

    @Test
    void testGetTag() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getTag());
        assertEquals(historyRelease.getTag(), "");
    }

    @Test
    void testGetTagPrev() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getTagPrev());
        assertEquals(historyRelease.getTagPrev(), "");
    }

    @Test
    void testGetVersion() {
        HistoryRelease historyRelease = new HistoryRelease();

        assertNotNull(historyRelease.getVersion());
        assertEquals(historyRelease.getVersion(), "");
    }

    @Test
    void testSetAdded() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> empty = new ArrayList<>();
        historyRelease.setAdded(empty);

        assertEquals(historyRelease.getAdded().size(), 0);
        assertEquals(historyRelease.getAdded(), empty);
    }

    @Test
    void testSetAddedEdited() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> edited = new ArrayList<>();
        edited.add("added description");
        historyRelease.setAdded(edited);

        assertEquals(historyRelease.getAdded().size(), 1);
        assertEquals(historyRelease.getAdded().get(0), "added description");
    }

    @Test
    void testSetDate() {
        HistoryRelease historyRelease = new HistoryRelease();

        Date checkDate = new Date();
        historyRelease.setDate(checkDate);

        assertEquals(historyRelease.getDate(), checkDate);
    }

    @Test
    void testSetFixed() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> empty = new ArrayList<>();
        historyRelease.setFixed(empty);

        assertEquals(historyRelease.getFixed().size(), 0);
        assertEquals(historyRelease.getFixed(), empty);
    }

    @Test
    void testSetFixedEdited() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> edited = new ArrayList<>();
        edited.add("fixed description");
        historyRelease.setFixed(edited);

        assertEquals(historyRelease.getFixed().size(), 1);
        assertEquals(historyRelease.getFixed().get(0), "fixed description");
    }

    @Test
    void testSetPublish() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> empty = new ArrayList<>();
        historyRelease.setPublish(empty);

        assertEquals(historyRelease.getPublish().size(), 0);
        assertEquals(historyRelease.getPublish(), empty);
    }

    @Test
    void testSetPublishEdited() {
        HistoryRelease historyRelease = new HistoryRelease();

        ArrayList<String> edited = new ArrayList<>();
        edited.add("publish to");
        historyRelease.setPublish(edited);

        assertEquals(historyRelease.getPublish().size(), 1);
        assertEquals(historyRelease.getPublish().get(0), "publish to");
    }

    @Test
    void testSetTag() {
        HistoryRelease historyRelease = new HistoryRelease();

        historyRelease.setTag("v1.0.1");
        assertEquals(historyRelease.getTag(), "v1.0.1");
    }

    @Test
    void testSetTagPrev() {
        HistoryRelease historyRelease = new HistoryRelease();

        historyRelease.setTagPrev("v1.0.0");
        assertEquals(historyRelease.getTagPrev(), "v1.0.0");
    }

    @Test
    void testSetVersion() {
        HistoryRelease historyRelease = new HistoryRelease();

        historyRelease.setVersion("1.0.1");
        assertEquals(historyRelease.getVersion(), "1.0.1");
    }
}