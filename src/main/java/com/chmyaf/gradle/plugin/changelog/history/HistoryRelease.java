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
import java.util.Date;
import java.util.List;

/**
 * One of a releases parameters.
 */
public class HistoryRelease {
    /// Added features.
    private List<String> added = new ArrayList<>();
    /// Release date.
    private Date date = new Date();
    /// Fixed issues.
    private List<String> fixed = new ArrayList<>();
    /// Templates to publish for this release.
    private List<String> publish = new ArrayList<>();
    /// Release tag.
    private String tag = "";
    /// Previous release tag.
    private String tagPrev = "";
    /// Release version.
    private String version = "";

    /**
     * Added features getter.
     *
     * @return Features.
     */
    public List<String> getAdded() {
        return this.added;
    }

    /**
     * Release date getter.
     *
     * @return Release date.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Fixed issues getter.
     *
     * @return Issues.
     */
    public List<String> getFixed() {
        return this.fixed;
    }

    /**
     * Publish templates getter.
     *
     * @return Templates.
     */
    public List<String> getPublish() {
        return this.publish;
    }

    /**
     * Release tag getter.
     *
     * @return Tag.
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * Previous release tag getter.
     *
     * @return Tag.
     */
    public String getTagPrev() {
        return this.tagPrev;
    }

    /**
     * Version getter.
     *
     * @return Version.
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Added features setter.
     *
     * @param added Features.
     */
    public void setAdded(List<String> added) {
        this.added = added;
    }

    /**
     * Release date setter.
     *
     * @param date Release date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Fixed issues setter.
     *
     * @param fixed Issues.
     */
    public void setFixed(List<String> fixed) {
        this.fixed = fixed;
    }

    /**
     * Publish templates setter.
     *
     * @param publish Templates.
     */
    public void setPublish(List<String> publish) {
        this.publish = publish;
    }

    /**
     * Release tag setter.
     *
     * @param tag Tag of the release.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Previous release tag setter.
     *
     * @param tagPrev Tag of the previous release.
     */
    public void setTagPrev(String tagPrev) {
        this.tagPrev = tagPrev;
    }

    /**
     * Version setter.
     *
     * @param version Release version.
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
