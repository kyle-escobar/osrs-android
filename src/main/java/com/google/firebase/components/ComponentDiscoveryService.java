package com.google.firebase.components;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk public class ComponentDiscoveryService extends Service {
    public ComponentDiscoveryService() {
        super();
    }

    @Nullable public IBinder onBind(Intent arg1) {
        return null;
    }
}

