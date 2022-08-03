package com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.bhavishaymankani.imperativebusinessventuresmachinetest.databinding.FragmentOtherDetailBinding;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.model.Data;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.base.BaseFragment;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.viewmodel.SharedViewModel;


public class OtherDetailFragment extends BaseFragment implements AdapterView.OnItemSelectedListener {

    private FragmentOtherDetailBinding binding;
    private SharedViewModel mViewModel;
    private Data data;
    private String occupation;
    private int pos;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOtherDetailBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] occupations = new String[] {"Select Occupation", "Teacher", "Accountant", "Army Officer", "Engineer", "Doctor"};
        ArrayAdapter adapter = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                occupations
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.occupationSpinner.setAdapter(adapter);
        binding.occupationSpinner.setOnItemSelectedListener(this);

        observe();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        occupation = position != 0 ? adapterView.getItemAtPosition(position).toString() : "";
        pos = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void saveData() {
        Data data = this.data != null ? this.data : new Data();

        boolean isMothersNameEmpty = binding.motherNamrEt.getText().toString().isEmpty();
        boolean isFathersNameEmpty = binding.fatherNameEt.getText().toString().isEmpty();


        if (!isMothersNameEmpty || !isFathersNameEmpty || pos != 0) {
            String mothersName = isMothersNameEmpty ? null : binding.motherNamrEt.getText().toString();
            String fathersName = isFathersNameEmpty ? null : binding.fatherNameEt.getText().toString();

            data.setMotherName(mothersName);
            data.setFatherName(fathersName);
            data.setOccupation(occupation);
            data.setOccupationPosition(pos);

            mViewModel.setData(data);
        }
    }

    private void observe() {
        mViewModel.getLiveData().observe(requireActivity(), data -> {
            this.data = data;
            binding.motherNamrEt.setText(data.getMotherName());
            binding.fatherNameEt.setText(data.getFatherName());
            binding.occupationSpinner.setSelection(data.getOccupationPosition() != null ? data.getOccupationPosition() : 0);
        });
    }
}