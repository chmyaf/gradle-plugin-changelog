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

/**
 * History of a releases.
 */
public class History {
    /// First release.
    private HistoryRelease firstRelease = new HistoryRelease();
    /// Releases.
    private List<HistoryRelease> releases = new ArrayList<>();
    /// Unreleased.
    private HistoryRelease unreleased = new HistoryRelease();

    /**
     * First release getter.
     *
     * @return First release.
     */
    public HistoryRelease getFirstRelease() {
        return firstRelease;
    }

    /**
     * Releases getter.
     *
     * @return Releases.
     */
    public List<HistoryRelease> getReleases() {
        return releases;
    }

    /**
     * Unreleased getter.
     *
     * @return Unreleased.
     */
    public HistoryRelease getUnreleased() {
        return unreleased;
    }

    /**
     * First release setter.
     *
     * @param firstRelease First release.
     */
    public void setFirstRelease(HistoryRelease firstRelease) {
        this.firstRelease = firstRelease;
    }

    /**
     * Releases setter.
     *
     * @param releases Releases.
     */
    public void setReleases(List<HistoryRelease> releases) {
        this.releases = releases;
    }

    /**
     * Unreleased setter.
     *
     * @param unreleased Unreleased.
     */
    public void setUnreleased(HistoryRelease unreleased) {
        this.unreleased = unreleased;
    }
}
