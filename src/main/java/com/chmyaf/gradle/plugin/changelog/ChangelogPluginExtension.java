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

package com.chmyaf.gradle.plugin.changelog;

/**
 * Changelog plugin parameters.
 *
 * Plugin options.
 */
public class ChangelogPluginExtension {
    /// Path to the configuration file.
    String config = "config.yml";
    /// Path to releases history.
    String history = "history.yml";
    /// Path to directory with parameters.
    String inputDir = ".chmyaf/changelogs";
}
