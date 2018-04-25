package com.clock.zc.mydemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Zc on 2017/11/13.
 */
@RunWith(AndroidJUnit4.class)
public class MainActTest {
    private UiDevice mDevice;
    private static final int LAUNCH_TIMEOUT = 500;
    private final String BASIC_SAMPLE_PACKAGE = "com.clock.zc.mydemo";
    @Before
    public void setUp(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);
    }
    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }

    @Test
    public void mainTest() {
        mDevice.wait(Until.hasObject(By.text("MyDemo")), LAUNCH_TIMEOUT);
        mDevice.findObject(By.text("MyDemo")).click();

//        UiObject2 drawerToggle = mDevice.wait(Until.findObject(By.clazz("android.widget.ImageButton")), 500);
//        drawerToggle.click();
        UiObject2 qq_view_bubble = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "qq_view_bubble")), 500);
        UiObject2 qq_point = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "qq_point")), 500);
        qq_point.drag(new Point(),50);

    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
