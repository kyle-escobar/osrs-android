package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

public final class ConnectionErrorMessages {
    @GuardedBy(value="sCache") private static final SimpleArrayMap zaof;

    static {
        ConnectionErrorMessages.zaof = new SimpleArrayMap();
    }

    private ConnectionErrorMessages() {
        super();
    }

    public static String getAppName(Context arg2) {
        String v0 = arg2.getPackageName();
        try {
            return Wrappers.packageManager(arg2).getApplicationLabel(v0).toString();
        }
        catch(NullPointerException ) {
            String v2 = arg2.getApplicationInfo().name;
            if(TextUtils.isEmpty(((CharSequence)v2))) {
                return v0;
            }

            return v2;
        }
    }

    public static String getDefaultNotificationChannelName(Context arg1) {
        return arg1.getResources().getString(R$string.common_google_play_services_notification_channel_name);
    }

    @NonNull public static String getErrorDialogButtonMessage(Context arg0, int arg1) {
        Resources v0 = arg0.getResources();
        switch(arg1) {
            case 1: {
                goto label_11;
            }
            case 2: {
                goto label_8;
            }
            case 3: {
                goto label_5;
            }
        }

        return v0.getString(0x104000A);
    label_5:
        return v0.getString(R$string.common_google_play_services_enable_button);
    label_8:
        return v0.getString(R$string.common_google_play_services_update_button);
    label_11:
        return v0.getString(R$string.common_google_play_services_install_button);
    }

    @NonNull public static String getErrorMessage(Context arg5, int arg6) {
        Resources v0 = arg5.getResources();
        String v1 = ConnectionErrorMessages.getAppName(arg5);
        if(arg6 == 5) {
            goto label_61;
        }

        if(arg6 == 7) {
            goto label_58;
        }

        if(arg6 == 9) {
            goto label_53;
        }

        if(arg6 == 20) {
            goto label_50;
        }

        switch(arg6) {
            case 1: {
                goto label_45;
            }
            case 2: {
                goto label_35;
            }
            case 3: {
                goto label_30;
            }
        }

        switch(arg6) {
            case 16: {
                goto label_27;
            }
            case 17: {
                goto label_24;
            }
            case 18: {
                goto label_19;
            }
        }

        return v0.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue, new Object[]{v1});
    label_19:
        return v0.getString(R$string.common_google_play_services_updating_text, new Object[]{v1});
    label_24:
        return ConnectionErrorMessages.zaa(arg5, "common_google_play_services_sign_in_failed_text", v1);
    label_27:
        return ConnectionErrorMessages.zaa(arg5, "common_google_play_services_api_unavailable_text", v1);
    label_35:
        if(DeviceProperties.isWearableWithoutPlayStore(arg5)) {
            return v0.getString(R$string.common_google_play_services_wear_update_text);
        }

        return v0.getString(R$string.common_google_play_services_update_text, new Object[]{v1});
    label_45:
        return v0.getString(R$string.common_google_play_services_install_text, new Object[]{v1});
    label_30:
        return v0.getString(R$string.common_google_play_services_enable_text, new Object[]{v1});
    label_50:
        return ConnectionErrorMessages.zaa(arg5, "common_google_play_services_restricted_profile_text", v1);
    label_53:
        return v0.getString(R$string.common_google_play_services_unsupported_text, new Object[]{v1});
    label_58:
        return ConnectionErrorMessages.zaa(arg5, "common_google_play_services_network_error_text", v1);
    label_61:
        return ConnectionErrorMessages.zaa(arg5, "common_google_play_services_invalid_account_text", v1);
    }

    @NonNull public static String getErrorNotificationMessage(Context arg1, int arg2) {
        if(arg2 == 6) {
            return ConnectionErrorMessages.zaa(arg1, "common_google_play_services_resolution_required_text", ConnectionErrorMessages.getAppName(arg1));
        }

        return ConnectionErrorMessages.getErrorMessage(arg1, arg2);
    }

    @NonNull public static String getErrorNotificationTitle(Context arg1, int arg2) {
        String v2 = arg2 == 6 ? ConnectionErrorMessages.zaa(arg1, "common_google_play_services_resolution_required_title") : ConnectionErrorMessages.getErrorTitle(arg1, arg2);
        if(v2 == null) {
            v2 = arg1.getResources().getString(R$string.common_google_play_services_notification_ticker);
        }

        return v2;
    }

    @Nullable public static String getErrorTitle(Context arg3, int arg4) {
        Resources v0 = arg3.getResources();
        if(arg4 == 20) {
            goto label_64;
        }

        String v1 = null;
        switch(arg4) {
            case 1: {
                goto label_61;
            }
            case 2: {
                goto label_58;
            }
            case 3: {
                goto label_55;
            }
            case 5: {
                goto label_48;
            }
            case 4: 
            case 6: {
                return v1;
            }
            case 7: {
                goto label_42;
            }
            case 8: {
                goto label_38;
            }
            case 9: {
                goto label_34;
            }
            case 10: {
                goto label_30;
            }
            case 11: {
                goto label_26;
            }
        }

        switch(arg4) {
            case 16: {
                goto label_22;
            }
            case 17: {
                goto label_16;
            }
            case 18: {
                return v1;
            }
        }

        StringBuilder v2 = new StringBuilder(33);
        v2.append("Unexpected error code ");
        v2.append(arg4);
        Log.e("GoogleApiAvailability", v2.toString());
        return v1;
    label_22:
        Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
        return v1;
    label_16:
        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
        return ConnectionErrorMessages.zaa(arg3, "common_google_play_services_sign_in_failed_title");
    label_34:
        Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
        return v1;
    label_38:
        Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
        return v1;
    label_55:
        return v0.getString(R$string.common_google_play_services_enable_title);
    label_58:
        return v0.getString(R$string.common_google_play_services_update_title);
    label_42:
        Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
        return ConnectionErrorMessages.zaa(arg3, "common_google_play_services_network_error_title");
    label_26:
        Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
        return v1;
    label_61:
        return v0.getString(R$string.common_google_play_services_install_title);
    label_30:
        Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
        return v1;
    label_48:
        Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
        return ConnectionErrorMessages.zaa(arg3, "common_google_play_services_invalid_account_title");
    label_64:
        Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
        return ConnectionErrorMessages.zaa(arg3, "common_google_play_services_restricted_profile_title");
    }

    private static String zaa(Context arg2, String arg3, String arg4) {
        Resources v0 = arg2.getResources();
        String v2 = ConnectionErrorMessages.zaa(arg2, arg3);
        if(v2 == null) {
            v2 = v0.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue);
        }

        return String.format(v0.getConfiguration().locale, v2, arg4);
    }

    @Nullable private static String zaa(Context arg4, String arg5) {
        String v2_1;
        String v4_2;
        SimpleArrayMap v0 = ConnectionErrorMessages.zaof;
        __monitor_enter(v0);
        try {
            Object v1 = ConnectionErrorMessages.zaof.get(arg5);
            if(v1 != null) {
                __monitor_exit(v0);
                return ((String)v1);
            }

            Resources v4_1 = GooglePlayServicesUtil.getRemoteResource(arg4);
            String v1_1 = null;
            if(v4_1 == null) {
                __monitor_exit(v0);
                return v1_1;
            }

            int v2 = v4_1.getIdentifier(arg5, "string", "com.google.android.gms");
            if(v2 == 0) {
                v4_2 = "GoogleApiAvailability";
                v2_1 = "Missing resource: ";
                arg5 = String.valueOf(arg5);
                arg5 = arg5.length() != 0 ? v2_1.concat(arg5) : new String(v2_1);
                Log.w(v4_2, arg5);
                __monitor_exit(v0);
                return v1_1;
            }

            v4_2 = v4_1.getString(v2);
            if(TextUtils.isEmpty(((CharSequence)v4_2))) {
                v4_2 = "GoogleApiAvailability";
                v2_1 = "Got empty resource: ";
                arg5 = String.valueOf(arg5);
                arg5 = arg5.length() != 0 ? v2_1.concat(arg5) : new String(v2_1);
                Log.w(v4_2, arg5);
                __monitor_exit(v0);
                return v1_1;
            }

            ConnectionErrorMessages.zaof.put(arg5, v4_2);
            __monitor_exit(v0);
            return v4_2;
        label_48:
            __monitor_exit(v0);
        }
        catch(Throwable v4) {
            goto label_48;
        }

        throw v4;
    }
}

