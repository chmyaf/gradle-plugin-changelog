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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    void testGetFirstRelease() {
        History history = new History();

        assertNotNull(history.getFirstRelease());
    }

    @Test
    void testGetReleases() {
        History history = new History();

        assertNotNull(history.getReleases());
    }

    @Test
    void testGetUnreleased() {
        History history = new History();

        assertNotNull(history.getUnreleased());
    }

    @Test
    void testSetFirstRelease() {
        History history = new History();
        HistoryRelease release = new HistoryRelease();

        history.setFirstRelease(release);

        assertEquals(history.getFirstRelease(), release);
    }

    @Test
    void testSetReleases() {
        History history = new History();
        List<HistoryRelease> releases = new ArrayList<>();
        HistoryRelease release = new HistoryRelease();

        releases.add(release);
        history.setReleases(releases);

        assertEquals(history.getReleases(), releases);
    }

    @Test
    void testSetUnreleased() {
        History history = new History();
        HistoryRelease release = new HistoryRelease();

        history.setUnreleased(release);

        assertEquals(history.getUnreleased(), release);
    }
}