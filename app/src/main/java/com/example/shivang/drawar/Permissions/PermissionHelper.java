package com.example.shivang.drawar.Permissions;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionHelper {
    private static final String CAMERA_PERMISSION = Manifest.permission.CAMERA;
    private static final int CAMERA_PERMISSION_CODE = 5;

    /**
     * Check to see we have the necessary permissions for this app.
     */
    public static boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, CAMERA_PERMISSION) ==
                PackageManager.PERMISSION_GRANTED;

    }

    /**
     * Check to see we have the necessary permissions for this app, and ask for them if we don't.
     */
    public static void requestCameraPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{CAMERA_PERMISSION},
                CAMERA_PERMISSION_CODE);
    }
}