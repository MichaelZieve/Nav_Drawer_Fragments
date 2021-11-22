package com.zybooks.navdrawerfragments.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.zybooks.navdrawerfragments.R;
import com.zybooks.navdrawerfragments.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button button_1 = root.findViewById(R.id.gallery_item_1);
        Button button_2 = root.findViewById(R.id.gallery_item_2);
        Button button_3 = root.findViewById(R.id.gallery_item_3);

        //TODO: Sets the onClickListener for each button to the galleryItemButtonClick method with appropriate arguments
        button_1.setOnClickListener(
                view -> {
                    galleryItemButtonClick(view, 1);
                });

        button_2.setOnClickListener(
                view -> {
                    galleryItemButtonClick(view, 2);
                });

        button_3.setOnClickListener(
                view -> {
                    galleryItemButtonClick(view, 3);
                });

        return root;
    }

    public void galleryItemButtonClick(View view, int item) {
        HomeFragmentDirections.ActionNavHomeToNavGallery action = HomeFragmentDirections.actionNavHomeToNavGallery();
        //TODO: assign the appropriate item number value to the Destination Argument and navigate to the gallery page

        action.setGalleryItemId(item);
        Navigation.findNavController(view).navigate(action);

    }


}