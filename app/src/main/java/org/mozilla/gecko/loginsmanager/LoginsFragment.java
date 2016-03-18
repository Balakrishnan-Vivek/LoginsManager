/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.gecko.loginsmanager;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Fragment that displays logins details in a <code>ListView<code>.
 * <p>
 * Login details are retrieved from Fennec nightly build exposed through sharedUserID.
 */
public class LoginsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private ListView mList;
    private CursorAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logins_panel, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new LoginsCursorAdapter(getActivity());
        mList.setAdapter(mAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mList = (ListView) view.findViewById(R.id.list);
    }

    private static final class LoginsCursorAdapter extends CursorAdapter {
        LoginsCursorAdapter(Context context) {
            super(context, null, 0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.logins_item_row, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            if (cursor == null) {
                return;
            }

            final TextView hostnameView = (TextView) view.findViewById(R.id.login_hostname);
            final TextView usernameView = (TextView) view.findViewById(R.id.login_username);
            hostnameView.setText(cursor.getString(cursor.getColumnIndexOrThrow(LoginsContract.HOSTNAME)));
            usernameView.setText(cursor.getString(cursor.getColumnIndexOrThrow(LoginsContract.ENCRYPTED_USERNAME)));
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                                LoginsContract.LOGINS_URI,
                                null,
                                null,
                                null,
                                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
