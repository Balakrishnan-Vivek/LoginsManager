/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.gecko.loginsmanager;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ContentValues createLogin(String hostname, String httpRealm, String formSubmitUrl,
                                      String usernameField, String passwordField, String encryptedUsername,
                                      String encryptedPassword) {
        final ContentValues values = new ContentValues();
        values.put(LoginsContract.HOSTNAME, hostname);
        values.put(LoginsContract.HTTP_REALM, httpRealm);
        values.put(LoginsContract.FORM_SUBMIT_URL, formSubmitUrl);
        values.put(LoginsContract.USERNAME_FIELD, usernameField);
        values.put(LoginsContract.PASSWORD_FIELD, passwordField);
        values.put(LoginsContract.ENCRYPTED_USERNAME, encryptedUsername);
        values.put(LoginsContract.ENCRYPTED_PASSWORD, encryptedPassword);
        return values;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.populate_dummy_login_menu_item) {
            final ArrayList<ContentProviderOperation> ops = new ArrayList<>();
            final int id = new Random().nextInt();
            final ContentValues values = createLogin("http://www.example.com", "http://www.example.com",
                    "http://www.example.com", "username", "password", "username" + id, "password" + id);
            ops.add(ContentProviderOperation.newInsert(LoginsContract.LOGINS_URI)
                    .withValues(values).build());
            try {
                getContentResolver().applyBatch(LoginsContract.LOGINS_URI.getAuthority(), ops);
            } catch (Exception e) {
                Toast.makeText(this, R.string.failed_to_insert, Toast.LENGTH_LONG).show();
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
