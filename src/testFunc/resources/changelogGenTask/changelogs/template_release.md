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