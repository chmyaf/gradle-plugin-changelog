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

import java.util.ArrayList;
import java.util.List;

public class History {
    private HistoryRelease firstRelease = new HistoryRelease();
    private List<HistoryRelease> releases = new ArrayList<>();
    private HistoryRelease unreleased = new HistoryRelease();

    public HistoryRelease getFirstRelease() {
        return firstRelease;
    }

    public List<HistoryRelease> getReleases() {
        return releases;
    }

    public HistoryRelease getUnreleased() {
        return unreleased;
    }

    public void setFirstRelease(HistoryRelease firstRelease) {
        this.firstRelease = firstRelease;
    }

    public void setReleases(List<HistoryRelease> releases) {
        this.releases = releases;
    }

    public void setUnreleased(HistoryRelease unreleased) {
        this.unreleased = unreleased;
    }
}
