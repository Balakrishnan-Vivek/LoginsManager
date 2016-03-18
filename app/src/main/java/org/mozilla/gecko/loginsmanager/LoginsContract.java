/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.gecko.loginsmanager;

import android.net.Uri;

// Contract class for Logins Content Provider.
public class LoginsContract {
    private static final Uri LOGINS_AUTHORITY_URI = Uri.parse("content://" + BuildConfig.TARGET_PACKAGE_NAME + ".db.logins");
    public static final Uri LOGINS_URI = Uri.withAppendedPath(LOGINS_AUTHORITY_URI, "logins");
    public static final String HOSTNAME = "hostname";
    public static final String HTTP_REALM = "httpRealm";
    public static final String FORM_SUBMIT_URL = "formSubmitURL";
    public static final String USERNAME_FIELD = "usernameField";
    public static final String PASSWORD_FIELD = "passwordField";
    public static final String ENCRYPTED_USERNAME = "encryptedUsername";
    public static final String ENCRYPTED_PASSWORD = "encryptedPassword";
    public static final String ENC_TYPE = "encType";
    public static final String TIME_CREATED = "timeCreated";
    public static final String TIME_LAST_USED = "timeLastUsed";
    public static final String TIME_PASSWORD_CHANGED = "timePasswordChanged";
    public static final String TIMES_USED = "timesUsed";
    public static final String GUID = "guid";
}
