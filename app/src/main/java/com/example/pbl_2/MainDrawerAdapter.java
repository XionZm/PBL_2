package com.example.pbl_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainDrawerAdapter extends RecyclerView.Adapter<MainDrawerAdapter.ViewHolder> {

    private final Activity activity;
    private final ArrayList<String> arrayList;
    private final ArrayList<Integer> image;

    // Constructor untuk adapter
    public MainDrawerAdapter(Activity activity, ArrayList<String> arrayList, ArrayList<Integer> image) {
        this.activity = activity;
        this.arrayList = arrayList;
        this.image = image;
    }

    @NonNull
    @Override
    public MainDrawerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout item drawer
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainDrawerAdapter.ViewHolder holder, int position) {
        // Set data untuk setiap item
        holder.logoutImage.setImageResource(image.get(position));
        holder.logoutText.setText(arrayList.get(position));

        // Tambahkan aksi klik untuk setiap item
        holder.logoutText.setOnClickListener(view -> {
            int posisi = holder.getAdapterPosition();

            // Handle berdasarkan posisi
            switch (posisi) {
                case 0: // Tombol Logout
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Logout");
                    builder.setMessage("Yakin ingin logout dari aplikasi?");
                    builder.setPositiveButton("Ya", (dialogInterface, i) -> {
                        // Logout pengguna dari Firebase
                        FirebaseAuth.getInstance().signOut();

                        // Logout pengguna dari Google Sign-In
                        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build();
                        GoogleSignIn.getClient(activity, gso).signOut().addOnCompleteListener(task -> {
                            // Intent ke LoginActivity
                            Intent intent = new Intent(activity, Login.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear back stack
                            activity.startActivity(intent);
                            activity.finish(); // Tutup aktivitas saat ini
                        });
                    });

                    builder.setNegativeButton("Tidak", null); // Tutup dialog jika pilih "Tidak"
                    builder.show();
                    break;

                // Tambahkan case lain jika ada item drawer lainnya
                default:
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // ViewHolder untuk item drawer
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView logoutText;
        private final ImageView logoutImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logoutImage = itemView.findViewById(R.id.logout); // Gambar
            logoutText = itemView.findViewById(R.id.Logout); // Teks
        }
    }
}
