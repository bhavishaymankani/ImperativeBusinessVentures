package com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.base;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {


    @Override
    public void onStop() {
        super.onStop();
        saveData();
    }

    public abstract void saveData();
}
