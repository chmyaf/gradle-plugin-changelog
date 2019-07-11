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

package com.chmyaf.gradle.plugin.changelog.config;

/**
 * One of a templates parameters.
 */
public class ConfigTemplate {
    /// Path to output generated data.
    private String output = "";
    /// Project repository url.
    private String repo = "";
    /// Path to template file.
    private String template = "";

    /**
     * Output path getter.
     *
     * @return Output path.
     */
    public String getOutput() {
        return output;
    }

    /**
     * Repository url getter.
     *
     * @return Repository url.
     */
    public String getRepo() {
        return repo;
    }

    /**
     * Template path getter.
     *
     * @return Path to template.
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Output path setter.
     *
     * @param output Output path.
     */
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     * Repository url setter.
     *
     * @param repo Repository url.
     */
    public void setRepo(String repo) {
        this.repo = repo;
    }

    /**
     * Template path setter.
     *
     * @param template Path to template.
     */
    public void setTemplate(String template) {
        this.template = template;
    }
}
