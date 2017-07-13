package com.tdd.tdddemo;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;

import static org.junit.Assert.*;

/**
 * Created by ankur.singh on 13/07/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {
    private MainActivity activity;
    private View fab;
    private TextView tv;
    private DrawerLayout drawerLayout;
    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.setupActivity( MainActivity.class );
        fab = activity.findViewById(R.id.fab);
        tv = (TextView) activity.findViewById(R.id.center_text);
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        assertEquals("Ankur",tv.getText().toString());
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void selectMenuItem() throws Exception
    {

        MenuItem item = new RoboMenuItem(R.id.nav_gallery);
        activity.onNavigationItemSelected(item);
        assertEquals("nav_gallery",tv.getText().toString());

        item = new RoboMenuItem(R.id.nav_camera);
        activity.onNavigationItemSelected(item);
        assertEquals("nav_camera",tv.getText().toString());

        item = new RoboMenuItem(R.id.nav_slideshow);
        activity.onNavigationItemSelected(item);
        assertEquals("nav_slideshow",tv.getText().toString());

        item = new RoboMenuItem(R.id.nav_manage);
        activity.onNavigationItemSelected(item);
        assertEquals("nav_manage",tv.getText().toString());

        item = new RoboMenuItem(R.id.nav_share);
        activity.onNavigationItemSelected(item);
        assertEquals("nav_share",tv.getText().toString());

        item = new RoboMenuItem(R.id.nav_send);
        activity.onNavigationItemSelected(item);
        assertEquals("nav_send",tv.getText().toString());
    }

    @Test
    public void onFabClick() throws Exception
    {
        fab.performClick();
        assertEquals("fab",tv.getText().toString());
    }

    @Test
    public void onBackPress(){
        drawerLayout.openDrawer(GravityCompat.START);
        activity.onBackPressed();
        assertTrue(activity.isFinishing());
    }
}