# Changelog plugin for Gradle

A changelogs file generator.

## Description

This is a Gradle plugin for generating a changelog files.

You can generate one, two or more changelog files and publish their to difference repos.
For example, You can publish one file only to the BitBucket, and publish second file only to the GitHub.

## Third party:

Plugin uses the Thymeleaf template engine. 

## Usage

### Include plugin

#### Using the pluginsDSL

```groovy
plugins {
  id "com.chmyaf.gradle.plugin.doxygen" version "X.Y.Z"
}
```

#### Using legacy plugin application

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.chmyaf.gradle.plugin:doxygen:+'
    }
}
apply plugin: 'com.chmyaf.gradle.plugin.doxygen'

```

### Plugin configuration

Default configuration:

```groovy
changelog {
    inputDir = "changelogs"
    config = "config.yml"
    history = "history.yml"
}
```

### Changelogs configuration

Templates configuration: ```changelogs/config.yml```
```yaml
templates:
  example:
    template: example.md
    output: generated.md
    repo: https://github.com/chmyaf/gradle-plugin-changelog/
  exampleSecond:
    template: exampleSecond.md
    output: generatedSecond.md
    repo: https://github.com/chmyaf/gradle-plugin-changelog/
```

Releases history: ```changelogs/history.yml```
```yaml
unreleased:
  version: Unreleased
  date: null
  added:
    - Added new feature
  fixed:
    - Fixed old bug
releases:
  - version: 0.0.4
    tag: v0.0.4
    date: 2019-07-04
    added:
      - Example added #2
      - Example added #3
    fixed:
      - Example fixed #2
      - Example fixed #3
  - version: 0.0.3
    tag: v0.0.3
    date: 2019-07-03
    fixed:
      - Example fixed #1
  - version: 0.0.2
    tag: v0.0.2
    date: 2019-07-02
    added:
      - Examlpe added #1
firstRelease:
  version: 0.0.1
  tag: v0.0.1
  date: 2019-07-01
  added:
    - Init project

```

First template: ```changelog/example.md```
```markdown
# BitBucket example

[# th:each="release : ${history.unreleased}"]
[# th:insert="template_release.md" /][/][# th:each="release : ${history.releases}"]
[# th:insert="template_release.md" /][/][# th:each="release : ${history.firstRelease}"]
[# th:insert="template_release.md" /][/]
[Unreleased]: https://bitbucket.org/chmyaf/gradle-plugin-doxygen/branches/compare/dev..master#compare-commits[# th:each="release : ${history.releases}"]
[[# th:utext="${release.version}" /]]: [(${config.repo})]branches/compare/[(${release.tag})]..[(${release.tagPrev})]#compare-commits
[/][[# th:utext="${history.firstRelease.version}" /]]: [(${config.repo})]src/[(${history.firstRelease.version})]/
```

Second template: ```changelog/exampleSecond.md```

```markdown
# GitHub example

Without unreleased changes.

[# th:each="release : ${history.releases}"]
[# th:insert="template_release.md" /][/][# th:each="release : ${history.firstRelease}"]
[# th:insert="template_release.md" /][/]
[# th:each="release : ${history.releases}"][[# th:utext="${release.version}" /]]: [(${config.repo})]compare/[(${release.tagPrev})]...[(${release.tag})]
[/][[# th:utext="${history.firstRelease.version}" /]]: [(${config.repo})]releases/tag/[(${history.firstRelease.version})]
```

Common template used in both of the above: ```changelog/template_release.md```

```markdown
## [[# th:utext="${release.version}" /]][# th:if="${release.date} != null"] - [(${#dates.format(release.date, 'YYYY-MM-dd')})][/]
[# th:if="${release.added.size} != 0"]
### Added
[# th:each="note : ${release.added}"]
- [(${note})]
[/][/][# th:if="${release.fixed.size} != 0"]
### Fixed
[# th:each="note : ${release.fixed}"]
- [(${note})]
[/][/]
```

Result of the ```changelogGen``` task:

```generated.md```:

```markdown
# BitBucket example


## [Unreleased]

### Added

- Added new feature

### Fixed

- Fixed old bug

## [0.0.4] - 2019-07-04

### Added

- Example added
- Example added

### Fixed

- Example fixed
- Example fixed

## [0.0.3] - 2019-07-03

### Fixed

- Example fixed

## [0.0.2] - 2019-07-02

### Added

- Examlpe added

## [0.0.1] - 2019-07-01

### Added

- Init project

[Unreleased]: https://bitbucket.org/chmyaf/gradle-plugin-doxygen/branches/compare/dev..master#compare-commits
[0.0.4]: https://github.com/chmyaf/gradle-plugin-changelog/branches/compare/v0.0.4..v0.0.3#compare-commits
[0.0.3]: https://github.com/chmyaf/gradle-plugin-changelog/branches/compare/v0.0.3..v0.0.2#compare-commits
[0.0.2]: https://github.com/chmyaf/gradle-plugin-changelog/branches/compare/v0.0.2..v0.0.1#compare-commits
```

and second file:

```generatedSecond.md```

```markdown
# GitHub example

Without unreleased changes.


## [0.0.4] - 2019-07-04

### Added

- Example added
- Example added

### Fixed

- Example fixed
- Example fixed

## [0.0.3] - 2019-07-03

### Fixed

- Example fixed

## [0.0.2] - 2019-07-02

### Added

- Examlpe added

## [0.0.1] - 2019-07-01

### Added

- Init project

[0.0.4]: https://github.com/chmyaf/gradle-plugin-changelog/compare/v0.0.3...v0.0.4
[0.0.3]: https://github.com/chmyaf/gradle-plugin-changelog/compare/v0.0.2...v0.0.3
[0.0.2]: https://github.com/chmyaf/gradle-plugin-changelog/compare/v0.0.1...v0.0.2
[0.0.1]: https://github.com/chmyaf/gradle-plugin-changelog/releases/tag/0.0.1
```

Now You can add the first file to main repo and second file to shared repo.

Other examples can be found in the [src/testFunc/resources](src/testFunc/resources) directory.

## License

This is Open Source software released under [Apache 2.0 license](./LICENSE).

## Links

* [Apache Linense, Version 2.0](https://apache.org/licenses/LICENSE-2.0)
* [Gradle](https://gradle.org/)
* [Thymeleaf](https://www.thymeleaf.org/)
