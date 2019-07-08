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

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

public class ChangelogGenTaskFunctionalTest {
    @TempDir
    public File testProjectDir;

    private void copyExampleProject() throws IOException {
        this.copyExampleProjectFile("build.gradle");
        new File(this.testProjectDir.getAbsolutePath(), "changelogs").mkdirs();
        this.copyExampleProjectFile("changelogs/config.yml");
        this.copyExampleProjectFile("changelogs/history.yml");
        this.copyExampleProjectFile("changelogs/example.md");
        this.copyExampleProjectFile("changelogs/exampleSecond.md");
        this.copyExampleProjectFile("changelogs/template_release.md");
    }

    private void copyExampleProjectFile(String fname) throws IOException {
        Path src;
        Path dst;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("changelogGenTask/" + fname);
        if (resource == null) {
            throw new FileNotFoundException("Can't get " + fname);
        }

        src = new File(resource.getFile()).toPath();
        dst = new File(this.testProjectDir, fname).toPath();

        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void testApply() throws IOException {
        this.copyExampleProject();

        BuildResult result = GradleRunner.create()
                .withProjectDir(this.testProjectDir)
                .withPluginClasspath()
                .withArguments("changelogGen")
                .build();

        assertEquals("SUCCESS", result.task(":changelogGen").getOutcome().toString());
    }
}
