/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.gecko.loginsmanager;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

// This version of password row does not expose Favicon for updating image url.
// The current version always loads the default image for all hostname urls.
// This should be rectified in final version when merging back to the codebase.
// TODO: Implement Favicon and corresponding listeners.
public class LoginsListRow extends LinearLayout {

    private final TextView mHostName;
    private final TextView mUserName;

    public LoginsListRow(Context context) {
        this(context, null);
    }

    public LoginsListRow(Context context, AttributeSet attrs) {
        super(context, attrs);

        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater.from(context).inflate(R.layout.logins_list_row, this);
        // Merge layouts lose their padding, so set it dynamically.
        setPadding(0, 0, (int) getResources().getDimension(R.dimen.page_row_edge_padding), 0);

        mHostName = (TextView) findViewById(R.id.hostname);
        mUserName = (TextView) findViewById(R.id.username);
    }

    /**
     * Update the data displayed by this row.
     * <p>
     * This method must be invoked on the UI thread.
     *
     * @param cursor to extract data from.
     */
    public void updateFromCursor(Cursor cursor) {
        if (cursor == null) {
            return;
        }

        int hostNameIndex = cursor.getColumnIndexOrThrow(LoginsContract.HOSTNAME);
        mHostName.setText(cursor.getString(hostNameIndex));

        int userNameIndex = cursor.getColumnIndexOrThrow(LoginsContract.ENCRYPTED_USERNAME);
        mUserName.setText(cursor.getString(userNameIndex));
    }
}
