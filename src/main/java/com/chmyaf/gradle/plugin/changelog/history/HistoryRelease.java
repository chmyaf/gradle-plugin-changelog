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

public class HistoryRelease {
    private List<String> added = new ArrayList<>();
    private Date date = new Date();
    private List<String> fixed = new ArrayList<>();
    private List<String> publish = new ArrayList<>();
    private String tag = "";
    private String tagPrev = "";
    private String version = "";

    public List<String> getAdded() {
        return this.added;
    }

    public Date getDate() {
        return this.date;
    }

    public List<String> getFixed() {
        return this.fixed;
    }

    public List<String> getPublish() {
        return this.publish;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTagPrev() {
        return this.tagPrev;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAdded(List<String> added) {
        this.added = added;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFixed(List<String> fixed) {
        this.fixed = fixed;
    }

    public void setPublish(List<String> publish) {
        this.publish = publish;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTagPrev(String tagPrev) {
        this.tagPrev = tagPrev;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
