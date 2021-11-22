package com.zybooks.thebanddatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import java.util.List;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        LinearLayout layout = (LinearLayout) rootView;

        // Create the buttons using the band names and ids from BandRepository
        List<Band> bandList = BandRepository.getInstance(requireContext()).getBands();

        //Create Settings Button First
        Button settings_button = new Button(getContext());
        LinearLayout.LayoutParams settings_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        settings_layoutParams.setMargins(0, 0, 0, 10);   // 10px bottom margin
        settings_button.setLayoutParams(settings_layoutParams);

        // Display Settings on the Settings button
        settings_button.setText("Settings");
        settings_button.setTag(0);

        // Navigate to Settings screen when clicked
        settings_button.setOnClickListener(buttonView -> {
            // Create fragment arguments containing the selected button ID
            int settings_selectedBandId = (int) buttonView.getTag();
            Bundle settings_args = new Bundle();
            settings_args.putInt(DetailFragment.ARG_BAND_ID, settings_selectedBandId);

            Navigation.findNavController(buttonView).navigate(R.id.settings_fragment, settings_args);
        });

        // Add settings button to layout
        layout.addView(settings_button);


        for (Band band : bandList) {
            Button button = new Button(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 0, 10);   // 10px bottom margin
            button.setLayoutParams(layoutParams);

            // Display band's name on button
            button.setText(band.getName());
            button.setTag(band.getId());

            // Navigate to detail screen when clicked
            button.setOnClickListener(buttonView -> {
                // Create fragment arguments containing the selected band ID
                int selectedBandId = (int) buttonView.getTag();
                Bundle args = new Bundle();
                args.putInt(DetailFragment.ARG_BAND_ID, selectedBandId);


                // Send band ID to DetailFragment
                Navigation.findNavController(buttonView).navigate(R.id.show_item_detail, args);
            });

            // Add button to the LinearLayout
            layout.addView(button);
        }

        return rootView;
            }
}

