package com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhavishaymankani.imperativebusinessventuresmachinetest.databinding.BasicDetailsFragmentBinding;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.model.Data;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.base.BaseFragment;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.viewmodel.SharedViewModel;


public class BasicDetailsFragment extends BaseFragment {

    private SharedViewModel mViewModel;
    private BasicDetailsFragmentBinding binding;
    private Data data;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = BasicDetailsFragmentBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        observe();
    }


    @Override
    public void saveData() {

        Data data = this.data != null ? this.data : new Data();
        boolean isNameEmpty = binding.nameEt.getText().toString().isEmpty();
        boolean isMobNumberEmpty = binding.mobileNumberEt.getText().toString().isEmpty();
        boolean isEmailEmpty = binding.emailEt.getText().toString().isEmpty();

        if (!isNameEmpty || !isMobNumberEmpty || !isEmailEmpty) {
            String name = isNameEmpty ? null : binding.nameEt.getText().toString();
            String mobNumber = isMobNumberEmpty ? null : binding.mobileNumberEt.getText().toString();
            String email = isEmailEmpty ? null : binding.emailEt.getText().toString();

            data.setName(name);
            data.setMobileNumber(mobNumber);
            data.setEmail(email);

            mViewModel.setData(data);
        }
    }

    private void observe() {
        mViewModel.getLiveData().observe(requireActivity(), data -> {
            this.data = data;
            binding.nameEt.setText(data.getName());
            binding.mobileNumberEt.setText(data.getMobileNumber());
            binding.emailEt.setText(data.getEmail());
        });
    }

}