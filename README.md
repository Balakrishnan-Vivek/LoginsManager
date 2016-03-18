# LoginsManager

Native LoginsManager (about:logins) for Firefor for Android

This is an offshoot project for Mozilla fennec to quickly prototype a native Logins Manager which would hopefully replace about:logins. The work for this project is tracked in the [bug 1247999]. The native logins content provider support was added to fennec as part of [bug 946857]. This project would complement that with a androidy UI.

### Prerequisite

To work with this app please install [fennec nightly]. This application shares the userID with fennec and thus is able to retrieve logins data.

### Todos

This is a short gist of task that needs to be done not in any particular order. The [tasks description] and screenshot can be found in the referenced bug.
 * Implement Action bar
 * Mutli-select support
 * Context dialog for copy, edit etc
 * View a login item 
 * Styling
 
### Limitations

Fennec theme.xml, style.xml, TwoLinePageRow, FadedTextView are not exposed to this project. Thus, it would be more painful to get the visual stylings right. 

   [bug 1247999]: https://bugzilla.mozilla.org/show_bug.cgi?id=1247999
   [bug 946857]: https://bugzilla.mozilla.org/show_bug.cgi?id=946857
   [fennec nightly]: https://ftp.mozilla.org/pub/mobile/nightly/latest-mozilla-central-android-api-15/
   [tasks description]: https://bugzilla.mozilla.org/show_bug.cgi?id=1247999#c2




