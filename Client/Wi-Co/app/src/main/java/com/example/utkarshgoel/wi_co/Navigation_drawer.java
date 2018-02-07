package com.example.utkarshgoel.wi_co;

/**
 * Created by Utkarsh Goel on 17-Nov-16.
 * ​Utkarsh Goel
 *ABV-Indian Institute of Information Technology & Management,
 *Gwalior-474 015, India
 */

/*Copyright Utkarsh Goel
*Copyright infringement is the use of works protected by copyright law
* without permission, infringing certain exclusive rights granted to the copyright holder,
* such as the right to reproduce, distribute, display or perform the protected work, or to make derivative works.
* It is a punishable offence under Copyright Act, 1957
 */


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Navigation_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean doubleBackToExitPressedOnce = false;
    //FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FragmentManager fragmentManager=getSupportFragmentManager();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_navigation_drawer, new mouse_fragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            /*
            super.onBackPressed();*/

            if (doubleBackToExitPressedOnce) {
                PrintWriter out = ConnectionSingleton.getPrintWriter();
                Socket socket=ConnectionSingleton.getSocket();

                try {
                    ConnectionSingleton.setSocket(null);
                    out.println("exit"); //tell server to exit
                    //close socket
                    socket.close();
                }
                catch (IOException e) {
                    Log.e("Wi-Co", "Error in closing socket", e);
                }

                System.exit(0);
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }
    /**
     * Created by Utkarsh Goel on 17-Nov-16.
     * ​Utkarsh Goel
     *ABV-Indian Institute of Information Technology & Management,
     *Gwalior-474 015, India
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager=getSupportFragmentManager();

        if (id == R.id.mouse) {
            mouse_fragment mouse_frag = new mouse_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_navigation_drawer,mouse_frag,mouse_frag.getTag()).commit();
        }

        else if (id == R.id.keyboard) {
            keyboard_fragment keyboard_fragment = new keyboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_navigation_drawer,keyboard_fragment,keyboard_fragment.getTag()).commit();
        }

        else if (id == R.id.vlc) {
            media_fragment media_fragment = new media_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_navigation_drawer,media_fragment,media_fragment.getTag()).commit();
        }

        else if (id == R.id.powerpoint) {
            powerpt_fragment powerpt_fragment = new powerpt_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_navigation_drawer,powerpt_fragment,powerpt_fragment.getTag()).commit();
        }

        else if (id == R.id.exit) {
            PrintWriter out = ConnectionSingleton.getPrintWriter();
            Socket socket=ConnectionSingleton.getSocket();

            try {
                ConnectionSingleton.setSocket(null);
                out.println("exit"); //tell server to exit
                //close socket
                socket.close();
            }
            catch (IOException e) {
                Log.e("Wi-Co", "Error in closing socket", e);
            }

            System.exit(0);
        }

        else if (id == R.id.logout) {
            PrintWriter out = ConnectionSingleton.getPrintWriter();
            Socket socket=ConnectionSingleton.getSocket();

            try {
                ConnectionSingleton.setSocket(null);
                out.println("exit"); //tell server to exit
                //close socket
                socket.close();
            }
            catch (IOException e) {
                Log.e("Wi-Co", "Error in closing socket", e);
            }

            startActivity(new Intent(Navigation_drawer.this,Connect.class));
            this.finish();
        }

 
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     * Created by Utkarsh Goel on 17-Nov-16.
     * ​Utkarsh Goel
     *ABV-Indian Institute of Information Technology & Management,
     *Gwalior-474 015, India
     */
}
