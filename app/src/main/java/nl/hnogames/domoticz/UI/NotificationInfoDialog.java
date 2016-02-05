/*
 * Copyright (C) 2015 Domoticz
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package nl.hnogames.domoticz.UI;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import nl.hnogames.domoticz.Adapters.NotificationsAdapter;
import nl.hnogames.domoticz.Containers.NotificationInfo;
import nl.hnogames.domoticz.R;

public class NotificationInfoDialog {

    private final MaterialDialog.Builder mdb;
    private ArrayList<NotificationInfo> info;
    private Context mContext;

    public NotificationInfoDialog(Context c,
                                  ArrayList<NotificationInfo> _info) {
        this.info = _info;
        this.mContext = c;

        mdb = new MaterialDialog.Builder(mContext);
        mdb.customView(R.layout.dialog_switch_timer, true)
                .positiveText(android.R.string.ok);
    }

    public void show() {
        mdb.title(R.string.category_notification);
        MaterialDialog md = mdb.build();
        View view = md.getCustomView();
        ListView listView = (ListView) view.findViewById(R.id.list);
        NotificationsAdapter adapter = new NotificationsAdapter(mContext, info);
        listView.setAdapter(adapter);

        md.show();
    }
}
