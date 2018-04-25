package com.clock.zc.mydemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Zc on 2017/11/6.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class CalculatorAndroidTest {
    private UiDevice mDevice;
    private static final int LAUNCH_TIMEOUT = 500;
    private final String BASIC_SAMPLE_PACKAGE = "com.android.calculator2";
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
    public void calculatorTest() {//paged_folder_content
        mDevice.findObject(By.text("工具")).click();
        mDevice.wait(Until.hasObject(By.text("计算器")), LAUNCH_TIMEOUT);
        mDevice.findObject(By.text("计算器")).click();


        UiObject2 clear = mDevice.wait(Until.findObject(By.res("com.android.bbkcalculator", "clear")), 500);
        UiObject2 button7 = mDevice.wait(Until.findObject(By.res("com.android.bbkcalculator", "digit7")), 500);
        UiObject2 buttonX = mDevice.wait(Until.findObject(By.res("com.android.bbkcalculator", "mul")), 500);
        UiObject2 button6 = mDevice.wait(Until.findObject(By.res("com.android.bbkcalculator", "digit6")), 500);
        UiObject2 buttonEqual = mDevice.wait(Until.findObject(By.res("com.android.bbkcalculator", "equal")), 500);
        UiObject2 output = mDevice.wait(Until.findObject(By.res("com.android.bbkcalculator", "edit_result_text")), 500);
        clear.click();
        button7.click();
        buttonX.click();
        button6.click();
        buttonEqual.click();

        assertEquals(output.getText(), "42");

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
