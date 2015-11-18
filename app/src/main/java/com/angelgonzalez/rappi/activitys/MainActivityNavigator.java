package com.angelgonzalez.rappi.activitys;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.angelgonzalez.rappi.R;
import com.angelgonzalez.rappi.fragments.CategoriasFragment_;
import com.angelgonzalez.rappi.util.Util;

/**
 * Created by angel.gonzalez on 11/11/2015.
 */
public class MainActivityNavigator extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    NavigationView navigationView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_navigator);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        navigationView = (NavigationView) findViewById(R.id.navigationView);

        context = this;

        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        Util.setRequestedOrientation(this);


        openFragment(new CategoriasFragment_().newInstance(Util.isArtist()));


    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        Fragment fragmento = null;


                        try {
                           switch (menuItem.getItemId()) {

                                case R.id.item_navigation_drawer_categoria:
                                    Util.setIsArtist(false);
                                    fragmento = new CategoriasFragment_().newInstance(false);

                                    break;

                               case R.id.item_navigation_drawer_developers:
                                   Util.setIsArtist(true);
                                   fragmento = new CategoriasFragment_().newInstance(true);

                                   break;
                            }


                        } catch (Exception ex) {

                            Log.e("AJGC", "Error en MainActivityNavigator metodo onNavigationItemSelected. Mensaje de error: " + ex.getMessage());
                            throw ex;
                        }

                        menuItem.setChecked(true);

                        openFragment(fragmento);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void openFragment(Fragment fragment){

        try {

            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_contenedor, fragment);
            fragmentTransaction.commit();

        } catch (Exception ex) {

            Log.e("RelacionCruce", "Error en MainActivityNavigator metodo openFragment. Mensaje de error: " + ex.getMessage());
            throw ex;
        }

    }
}
