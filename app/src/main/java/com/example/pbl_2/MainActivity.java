package com.example.pbl_2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private BottomNavigationView taskbarMenu;
    private DrawerLayout drawerLayout;
    private RecyclerView rvMenu;
    private ImageView ivGoogleProfile;
    private TextView tvGoogleName;
    private ImageView ivMenu;
    static ArrayList<String> arrayList = new ArrayList<>();
    static ArrayList<Integer> image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi views
        taskbarMenu = findViewById(R.id.taskbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        rvMenu = findViewById(R.id.rvMenu);
        ivGoogleProfile = findViewById(R.id.ivGoogleProfile);
        tvGoogleName = findViewById(R.id.tvGoogleName);
        ivMenu = findViewById(R.id.ivMenu);

        // Setup menu button
        setupMenuButton();

        // Inisialisasi Firebase User
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Setup profil Google
        setupGoogleProfile();

        // Menampilkan pesan selamat datang dengan custom Toast
        if (firebaseUser != null) {
            String displayName = firebaseUser.getDisplayName();
            if (displayName != null && !displayName.isEmpty()) {
                showCustomToast("Welcome, " + displayName + "!");
            } else {
                showCustomToast("Welcome!");
            }
        } else {
            showCustomToast("Login failed!");
        }

        // Menampilkan fragment default (HomeFragment)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        // Listener untuk Bottom Navigation
        taskbarMenu.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.checkout) {
                selectedFragment = new CheckoutFragment();
            } else if (itemId == R.id.location) {
                selectedFragment = new LocationFragment();
            } else if (itemId == R.id.about_us) {
                selectedFragment = new AboutUsFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            } else {
                return false;
            }
        });

        // Menyiapkan data untuk menu drawer
        setupDrawerMenu();
    }

    // Fungsi untuk setup tombol menu
    private void setupMenuButton() {
        ivMenu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    // Fungsi untuk setup profil Google
    private void setupGoogleProfile() {
        if (firebaseUser != null) {
            // Set nama profil
            String displayName = firebaseUser.getDisplayName();
            if (displayName != null && !displayName.isEmpty()) {
                tvGoogleName.setText(displayName);
            } else {
                tvGoogleName.setText("Guest");
            }

            // Set foto profil
            if (firebaseUser.getPhotoUrl() != null) {
                Glide.with(this)
                        .load(firebaseUser.getPhotoUrl())
                        .circleCrop()
                        .into(ivGoogleProfile);
            } else {
                // Set default icon jika foto profil tidak tersedia
                ivGoogleProfile.setImageResource(R.drawable.ic_person); // Ubah `ic_person` ke nama ikon default Anda
            }
        } else {
            // Jika tidak ada user, set default nama dan ikon
            tvGoogleName.setText("Guest");
            ivGoogleProfile.setImageResource(R.drawable.ic_person); // Ubah `ic_person` ke nama ikon default Anda
        }
    }

    private void setupDrawerMenu() {
        arrayList.clear();
        arrayList.add("LOGOUT"); // Tambahkan menu logout ke drawer

        image.clear();
        image.add(R.drawable.baseline_logout_24); // Tambahkan ikon logout

        // Set adapter untuk RecyclerView di drawer
        MainDrawerAdapter adapter = new MainDrawerAdapter(this, arrayList, image);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setAdapter(adapter);
    }

    // Fungsi untuk menampilkan custom Toast
    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_root));

        ImageView icon = layout.findViewById(R.id.toast_icon);
        TextView text = layout.findViewById(R.id.toast_message);

        icon.setImageResource(R.mipmap.ic_launcher); // Gunakan ikon aplikasi Anda
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        // Atur posisi toast agar berada di sekitar area yang ditandai
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 400); // Nilai yOffset diatur lebih besar
        toast.show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
