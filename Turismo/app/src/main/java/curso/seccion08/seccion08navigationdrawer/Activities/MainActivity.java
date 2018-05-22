package curso.seccion08.seccion08navigationdrawer.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import curso.seccion08.seccion08navigationdrawer.Fragments.MuseoFragment;
import curso.seccion08.seccion08navigationdrawer.Fragments.ComerFragment;
import curso.seccion08.seccion08navigationdrawer.Fragments.HotelFragment;
import curso.seccion08.seccion08navigationdrawer.R;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menu_restaurant:
                        fragment = new ComerFragment();
                        fragmentTransaction = true;
                        break;

                    case R.id.menu_museo:
                        fragment = new MuseoFragment();
                        fragmentTransaction = true;
                        break;

                    case R.id.menu_hotel:
                        fragment = new HotelFragment();
                        fragmentTransaction = true;
                        break;
                }

                if (fragmentTransaction){
                    changeFragment(fragment, item);
                    drawerLayout.closeDrawers();
                }

                return false;
            }
        });
    }

    private void setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment(new ComerFragment(),navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                //Abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

