package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zzf;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class zzad implements ServiceConnection {
    @GuardedBy(value="this") int state;
    final Messenger zzcb;
    zzai zzcc;
    @GuardedBy(value="this") final Queue zzcd;
    @GuardedBy(value="this") final SparseArray zzce;

    zzad(zzab arg1, zzac arg2) {
        this(arg1);
    }

    private zzad(zzab arg4) {
        this.zzcf = arg4;
        super();
        this.state = 0;
        this.zzcb = new Messenger(new zzf(Looper.getMainLooper(), new zzae(this)));
        this.zzcd = new ArrayDeque();
        this.zzce = new SparseArray();
    }

    public final void onServiceConnected(ComponentName arg3, IBinder arg4) {
        int v0;
        __monitor_enter(this);
        try {
            v0 = 2;
            if(Log.isLoggable("MessengerIpcClient", v0)) {
                Log.v("MessengerIpcClient", "Service connected");
            }

            if(arg4 != null) {
                goto label_14;
            }

            this.zza(0, "Null service connection");
        }
        catch(Throwable v3) {
            goto label_27;
        }

        __monitor_exit(this);
        return;
        try {
        label_14:
            this.zzcc = new zzai(arg4);
            goto label_17;
        }
        catch(Throwable v3) {
        }
        catch(RemoteException v4) {
            try {
                this.zza(0, v4.getMessage());
            }
            catch(Throwable v3) {
                goto label_27;
            }

            __monitor_exit(this);
            return;
            try {
            label_17:
                this.state = v0;
                this.zzy();
            }
            catch(Throwable v3) {
            label_27:
                __monitor_exit(this);
                throw v3;
            }
        }

        __monitor_exit(this);
    }

    public final void onServiceDisconnected(ComponentName arg3) {
        __monitor_enter(this);
        try {
            int v0 = 2;
            if(Log.isLoggable("MessengerIpcClient", v0)) {
                Log.v("MessengerIpcClient", "Service disconnected");
            }

            this.zza(v0, "Service disconnected");
        }
        catch(Throwable v3) {
            __monitor_exit(this);
            throw v3;
        }

        __monitor_exit(this);
    }

    final void zza(int arg5, String arg6) {
        int v1_1;
        __monitor_enter(this);
        try {
            if(Log.isLoggable("MessengerIpcClient", 3)) {
                String v0 = "MessengerIpcClient";
                String v1 = "Disconnected: ";
                String v2 = String.valueOf(arg6);
                v1 = v2.length() != 0 ? v1.concat(v2) : new String(v1);
                Log.d(v0, v1);
            }

            v1_1 = 4;
            switch(this.state) {
                case 0: {
                    goto label_62;
                }
                case 1: 
                case 2: {
                    goto label_26;
                }
                case 3: {
                    goto label_23;
                }
                case 4: {
                    goto label_21;
                }
            }

            int v6 = this.state;
            StringBuilder v1_2 = new StringBuilder(26);
            v1_2.append("Unknown state: ");
            v1_2.append(v6);
            throw new IllegalStateException(v1_2.toString());
        }
        catch(Throwable v5) {
            goto label_76;
        }

    label_21:
        __monitor_exit(this);
        return;
        try {
        label_23:
            this.state = v1_1;
        }
        catch(Throwable v5) {
            goto label_76;
        }

        __monitor_exit(this);
        return;
        try {
        label_26:
            if(Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }

            this.state = v1_1;
            ConnectionTracker.getInstance().unbindService(zzab.zza(this.zzcf), ((ServiceConnection)this));
            zzal v0_1 = new zzal(arg5, arg6);
            Iterator v5_1 = this.zzcd.iterator();
            while(v5_1.hasNext()) {
                v5_1.next().zza(v0_1);
            }

            this.zzcd.clear();
            for(arg5 = 0; arg5 < this.zzce.size(); ++arg5) {
                this.zzce.valueAt(arg5).zza(v0_1);
            }

            this.zzce.clear();
        }
        catch(Throwable v5) {
            goto label_76;
        }

        __monitor_exit(this);
        return;
        try {
        label_62:
            throw new IllegalStateException();
        }
        catch(Throwable v5) {
        label_76:
            __monitor_exit(this);
            throw v5;
        }
    }

    final void zza(int arg5) {
        __monitor_enter(this);
        try {
            Object v0 = this.zzce.get(arg5);
            if(v0 != null) {
                StringBuilder v3 = new StringBuilder(0x1F);
                v3.append("Timing out request: ");
                v3.append(arg5);
                Log.w("MessengerIpcClient", v3.toString());
                this.zzce.remove(arg5);
                ((zzak)v0).zza(new zzal(3, "Timed out waiting for response"));
                this.zzz();
            }
        }
        catch(Throwable v5) {
            __monitor_exit(this);
            throw v5;
        }

        __monitor_exit(this);
    }

    final boolean zza(Message arg5) {
        Object v1;
        StringBuilder v3;
        int v0 = arg5.arg1;
        if(Log.isLoggable("MessengerIpcClient", 3)) {
            v3 = new StringBuilder(41);
            v3.append("Received response to request: ");
            v3.append(v0);
            Log.d("MessengerIpcClient", v3.toString());
        }

        __monitor_enter(this);
        try {
            v1 = this.zzce.get(v0);
            if(v1 == null) {
                v3 = new StringBuilder(50);
                v3.append("Received response for unknown request: ");
                v3.append(v0);
                Log.w("MessengerIpcClient", v3.toString());
                __monitor_exit(this);
                return 1;
            }

            this.zzce.remove(v0);
            this.zzz();
            __monitor_exit(this);
        }
        catch(Throwable v5) {
            try {
            label_48:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_48;
            }

            throw v5;
        }

        Bundle v5_1 = arg5.getData();
        if(v5_1.getBoolean("unsupported", false)) {
            ((zzak)v1).zza(new zzal(4, "Not supported by GmsCore"));
        }
        else {
            ((zzak)v1).zzb(v5_1);
        }

        return 1;
    }

    final void zzaa() {
        __monitor_enter(this);
        try {
            if(this.state == 1) {
                this.zza(1, "Timed out while binding");
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }

    final boolean zzb(zzak arg6) {
        __monitor_enter(this);
        try {
            switch(this.state) {
                case 0: {
                    goto label_18;
                }
                case 1: {
                    goto label_14;
                }
                case 2: {
                    goto label_9;
                }
                case 3: 
                case 4: {
                    goto label_7;
                }
            }

            int v0 = this.state;
            StringBuilder v2 = new StringBuilder(26);
            v2.append("Unknown state: ");
            v2.append(v0);
            throw new IllegalStateException(v2.toString());
        label_18:
            this.zzcd.add(arg6);
            boolean v6_1 = this.state == 0 ? true : false;
            Preconditions.checkState(v6_1);
            if(Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }

            this.state = 1;
            Intent v6_2 = new Intent("com.google.android.c2dm.intent.REGISTER");
            v6_2.setPackage("com.google.android.gms");
            if(!ConnectionTracker.getInstance().bindService(zzab.zza(this.zzcf), v6_2, ((ServiceConnection)this), 1)) {
                this.zza(0, "Unable to bind to service");
            }
            else {
                zzab.zzb(this.zzcf).schedule(new zzaf(this), 30, TimeUnit.SECONDS);
            }
        }
        catch(Throwable v6) {
            goto label_67;
        }

        __monitor_exit(this);
        return 1;
    label_7:
        __monitor_exit(this);
        return 0;
        try {
        label_9:
            this.zzcd.add(arg6);
            this.zzy();
        }
        catch(Throwable v6) {
            goto label_67;
        }

        __monitor_exit(this);
        return 1;
        try {
        label_14:
            this.zzcd.add(arg6);
        }
        catch(Throwable v6) {
        label_67:
            __monitor_exit(this);
            throw v6;
        }

        __monitor_exit(this);
        return 1;
    }

    private final void zzy() {
        zzab.zzb(this.zzcf).execute(new zzag(this));
    }

    final void zzz() {
        __monitor_enter(this);
        try {
            int v1 = 2;
            if(this.state == v1 && (this.zzcd.isEmpty()) && this.zzce.size() == 0) {
                if(Log.isLoggable("MessengerIpcClient", v1)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }

                this.state = 3;
                ConnectionTracker.getInstance().unbindService(zzab.zza(this.zzcf), ((ServiceConnection)this));
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }
}

