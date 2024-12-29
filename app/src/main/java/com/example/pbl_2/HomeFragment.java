package com.example.pbl_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RelativeLayout relativeLayoutShoe1 = view.findViewById(R.id.relativeLayoutShoe1);
        RelativeLayout relativeLayoutShoe2 = view.findViewById(R.id.relativeLayoutShoe2);
        RelativeLayout relativeLayoutShoe3 = view.findViewById(R.id.relativeLayoutShoe3);
        RelativeLayout relativeLayoutShoe4 = view.findViewById(R.id.relativeLayoutShoe4);
        RelativeLayout relativeLayoutShoe5 = view.findViewById(R.id.relativeLayoutShoe5);
        RelativeLayout relativeLayoutShoe6 = view.findViewById(R.id.relativeLayoutShoe6);
        RelativeLayout relativeLayoutShoe7 = view.findViewById(R.id.relativeLayoutShoe7);
        RelativeLayout relativeLayoutShoe8 = view.findViewById(R.id.relativeLayoutShoe8);

        relativeLayoutShoe1.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe1);
            moveProductDetail.putExtra("Title", "Onitsuka Tiger Mexico 66™ \"Tai Chi Yellow / Black\"");
            moveProductDetail.putExtra("Color", "Yellow/Black");
            moveProductDetail.putExtra("Style", "1183A872750");
            moveProductDetail.putExtra("Material", "Calf Leather");
            moveProductDetail.putExtra("Price", "Rp 2,200k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe2.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe2);
            moveProductDetail.putExtra("Title", "Salomon XT-6 Gore-Tex \"Black/Silver\"");
            moveProductDetail.putExtra("Color", "Black");
            moveProductDetail.putExtra("Style", "L47450600");
            moveProductDetail.putExtra("Material", "Fabric, Gore-Tex");
            moveProductDetail.putExtra("Price", "Rp 2,900k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe3.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe3);
            moveProductDetail.putExtra("Title", "Adidas Samba OG \"Cloud White/Night Indigo/Gum\"");
            moveProductDetail.putExtra("Color", "White/Multicolour");
            moveProductDetail.putExtra("Style", "IF3814");
            moveProductDetail.putExtra("Material", "Suede, Leather");
            moveProductDetail.putExtra("Price", "Rp 1,200k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe4.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe4);
            moveProductDetail.putExtra("Title", "ASICS GEL-KAYANO 14 \"Simply Taupe/Oatmeal\"");
            moveProductDetail.putExtra("Color", "Beigi");
            moveProductDetail.putExtra("Style", "1201A161251");
            moveProductDetail.putExtra("Material", "Fabric, Leather");
            moveProductDetail.putExtra("Price", "Rp 2,600k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe5.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe5);
            moveProductDetail.putExtra("Title", "Jordan x Travis Scott Air Jordan 1 Low Golf");
            moveProductDetail.putExtra("Color", "Olive Green/White/Black");
            moveProductDetail.putExtra("Style", "FZ3124");
            moveProductDetail.putExtra("Material", "Calf Leather");
            moveProductDetail.putExtra("Price", "Rp 19,300k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe6.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe6);
            moveProductDetail.putExtra("Title", "Converse Chuck 70 Hi FW24");
            moveProductDetail.putExtra("Color", "Green");
            moveProductDetail.putExtra("Style", "A09467F");
            moveProductDetail.putExtra("Material", "Canvas");
            moveProductDetail.putExtra("Price", "Rp 1,000k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe7.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe7);
            moveProductDetail.putExtra("Title", "Vans Knu Skool Padded");
            moveProductDetail.putExtra("Color", "Black/White");
            moveProductDetail.putExtra("Style", "VN0009QC6BT");
            moveProductDetail.putExtra("Material", "Calf Leather");
            moveProductDetail.putExtra("Price", "Rp 1,200k");
            startActivity(moveProductDetail);
        });

        relativeLayoutShoe8.setOnClickListener(v -> {
            Intent moveProductDetail = new Intent(getActivity(), ProductDetail.class);
            moveProductDetail.putExtra("Image", R.drawable.shoe8);
            moveProductDetail.putExtra("Title", "New Balance 9060 \"Sea Salt\"");
            moveProductDetail.putExtra("Color", "White/Silver/Grey");
            moveProductDetail.putExtra("Style", "U9060ECA");
            moveProductDetail.putExtra("Material", "Calf Suede, Mesh");
            moveProductDetail.putExtra("Price", "Rp 2,200k");
            startActivity(moveProductDetail);
        });

        return view;
    }
}
