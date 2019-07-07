# GitHub example

Without unreleased changes.

[# th:each="release : ${history.releases}"]
[# th:insert="template_release.md" /][/][# th:each="release : ${history.firstRelease}"]
[# th:insert="template_release.md" /][/]
[# th:each="release : ${history.releases}"][[# th:utext="${release.version}" /]]: [(${config.repo})]compare/[(${release.tagPrev})]...[(${release.tag})]
[/][[# th:utext="${history.firstRelease.version}" /]]: [(${config.repo})]releases/tag/[(${history.firstRelease.version})]
