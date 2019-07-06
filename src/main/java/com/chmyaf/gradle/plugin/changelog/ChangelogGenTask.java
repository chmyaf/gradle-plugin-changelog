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

import com.chmyaf.gradle.plugin.changelog.config.Config;
import com.chmyaf.gradle.plugin.changelog.config.ConfigTemplate;
import com.chmyaf.gradle.plugin.changelog.history.History;
import com.chmyaf.gradle.plugin.changelog.history.HistoryRelease;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleScriptException;
import org.gradle.api.tasks.TaskAction;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class ChangelogGenTask extends DefaultTask {
    private ChangelogPluginExtension CLPE;
    private Config config;
    private History history;

    public ChangelogGenTask() {
        this.CLPE = this.getProject().getExtensions().
                findByType(ChangelogPluginExtension.class);
    }

    @TaskAction
    public void apply() {
        this.loadConfig();
        this.loadHistory();

        this.getConfig().getTemplates().forEach(this::genChangelog);
    }

    private void genChangelog(String name, ConfigTemplate configTemplate) {
        File outFile;

        StringWriter sw;
        FileWriter fw;
        TemplateEngine templateEngine;
        FileTemplateResolver templateResolver;
        Context ctx;

        outFile = new File(configTemplate.getOutput());

        templateEngine = new TemplateEngine();
        templateResolver = new FileTemplateResolver();

        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setPrefix(this.getInputDir().getAbsolutePath()
                + File.separator
        );
        templateEngine.setTemplateResolver(templateResolver);

        ctx = new Context();
        ctx.setVariable("config", configTemplate);
        ctx.setVariable("history", this.getHistory());

        sw = new StringWriter();
        templateEngine.process(configTemplate.getTemplate(), ctx, sw);

        try {
            fw = new FileWriter(outFile);
            fw.write(sw.toString());
            fw.close();
        } catch (IOException e) {
            throw new GradleScriptException("Can't write data to " +
                    outFile.getAbsolutePath(),
                    new IOException(e)
            );
        }
    }

    private ChangelogPluginExtension getCLPE() {
        return this.CLPE;
    }

    private Config getConfig() {
        return this.config;
    }

    private File getConfigFile() {
        return new File(this.getInputDir(), this.getCLPE().config);
    }

    private File getInputDir() {
        return new File(this.getCLPE().inputDir);
    }

    private History getHistory() {
        return this.history;
    }

    private File getHistoryFile() {
        return new File(this.getInputDir(), this.getCLPE().history);
    }

    private void loadHistory() {
        InputStream is = this.loadFileToInputStream(this.getHistoryFile());
        Yaml yaml = new Yaml(new Constructor(History.class));

        List<HistoryRelease> releases;
        HistoryRelease firstRelease;
        String prevTag;

        this.history = yaml.load(is);

        firstRelease = this.getHistory().getFirstRelease();
        releases = this.getHistory().getReleases();
        if (firstRelease.getTag().isEmpty()) {
            firstRelease.setTag(firstRelease.getVersion());
        }

        for (HistoryRelease rel : releases) {
            if (rel.getTag().isEmpty()) {
                rel.setTag(rel.getVersion());
            }
        }

        prevTag = firstRelease.getTag();
        Collections.reverse(releases);
        for (HistoryRelease rel : releases) {
            if (rel.getTagPrev().isEmpty()) {
                rel.setTagPrev(prevTag);
            }
            prevTag = rel.getTag();
        }
        Collections.reverse(releases);
    }

    private void loadConfig() {
        InputStream is = this.loadFileToInputStream(this.getConfigFile());
        Yaml yaml = new Yaml(new Constructor(Config.class));

        this.config = yaml.load(is);
    }

    private InputStream loadFileToInputStream(File file) {
        InputStream result;

        try {
            result = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new GradleScriptException("Can't read file: " +
                    this.getConfigFile().getAbsolutePath(),
                    new Exception(e)
            );
        }

        return result;
    }
}
