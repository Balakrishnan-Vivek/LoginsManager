# LoginsManager

Native LoginsManager (about:logins) for Firefor for Android

This is an offshoot project for Mozilla fennec to quickly prototype a native Logins Manager which would hopefully replace about:logins. The work for this project is tracked in the [bug 1247999]. The native logins content provider support was added to fennec as part of [bug 946857]. This project would complement that with a androidy UI.

### Prerequisite

To work with app,  you need fennec installed in your device. This application shares the userID with fennec and thus is able to retrieve logins data. For those lazy bones like me, please install this [debug signed nightly apk] file.

For those who are really curious, please compile and build following the [instructions]. You should also update the targetPackageName in gradle.properties to match with the compiled fennec installation.

### Todos

This is a short gist of task that needs to be done not in any particular order. The [tasks description] and screenshot can be found in the referenced bug.
 * Implement Action bar
 * Mutli-select support
 * Context dialog for copy, edit etc
 * View a login item 
 * Styling
 
### Limitations

Favicon is not exposed to this project. This is will updated while backporting this project to fennec codebase or as follow up bug. 

   [bug 1247999]: https://bugzilla.mozilla.org/show_bug.cgi?id=1247999
   [bug 946857]: https://bugzilla.mozilla.org/show_bug.cgi?id=946857
   [tasks description]: https://bugzilla.mozilla.org/show_bug.cgi?id=1247999#c2
   [debug signed nightly apk]: https://www.dropbox.com/s/14e7715ze7cxk8w/gecko.apk?dl=0
   [instructions] : https://developer.mozilla.org/en-US/docs/Mozilla/Developer_guide/Build_Instructions/Simple_Firefox_for_Android_build




