package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

public interface GoogleSignInOptionsExtension {
    @KeepForSdk public static final int FITNESS = 3;
    @KeepForSdk public static final int GAMES = 1;

    @KeepForSdk int getExtensionType();

    @Nullable @KeepForSdk List getImpliedScopes();

    Bundle toBundle();
}

