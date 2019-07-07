# BitBucket example

[# th:each="release : ${history.unreleased}"]
[# th:insert="template_release.md" /][/][# th:each="release : ${history.releases}"]
[# th:insert="template_release.md" /][/][# th:each="release : ${history.firstRelease}"]
[# th:insert="template_release.md" /][/]
[Unreleased]: https://bitbucket.org/chmyaf/gradle-plugin-doxygen/branches/compare/dev..master#compare-commits[# th:each="release : ${history.releases}"]
[[# th:utext="${release.version}" /]]: [(${config.repo})]branches/compare/[(${release.tag})]..[(${release.tagPrev})]#compare-commits
[/][[# th:utext="${history.firstRelease.version}" /]]: [(${config.repo})]src/[(${history.firstRelease.version})]/
