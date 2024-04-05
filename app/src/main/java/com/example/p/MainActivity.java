package com.example.p;

import static android.view.View.OnKeyListener;

import static com.example.p.R.id.*;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    private Fragment fragment;

    public MainActivity(Fragment fragment) {
        this.fragment = fragment;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);
        View drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, (DrawerLayout) drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.setOnKeyListener((OnKeyListener) toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            replaceFragment(new HomeFragment());
            navigationView.setCheckedItem(R.id.nav_home);
        }

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

        fab.setOnClickListener(view -> showBottomDialog());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout uploadLayout = dialog.findViewById(R.id.upload_poetry);
        LinearLayout createLayout = dialog.findViewById(R.id.create_poetry);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        uploadLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "Upload a Poetry", Toast.LENGTH_SHORT).show();
        });

        createLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "Create a Poetry", Toast.LENGTH_SHORT).show();
        });

        cancelButton.setOnClickListener(view -> dialog.dismiss());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @SuppressLint("NonConstantResourceId")
    private boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.feed:
                replaceFragment(new FeedFragment());
                break;
            case R.id.notifications:
                replaceFragment(new NotificationFragment());
                break;
            case R.id.profile:
                replaceFragment(new ProfileFragment());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        private void replaceFragment = (Fragment fragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_layout, fragment);
            fragmentTransaction.commit();
        }

        private void showBottomDialog() {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.bottomsheetlayout);

            LinearLayout uploadLayout = dialog.findViewById(R.id.upload_poetry);
            LinearLayout createLayout = dialog.findViewById(R.id.create_poetry);
            ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

            uploadLayout.setOnClickListener(v -> {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Upload a Poetry", Toast.LENGTH_SHORT).show();
            });

            createLayout.setOnClickListener(v -> {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Create a Poetry", Toast.LENGTH_SHORT).show();
            });

            cancelButton.setOnClickListener(view -> dialog.dismiss());

            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setGravity(Gravity.BOTTOM);
        }

    }
}
