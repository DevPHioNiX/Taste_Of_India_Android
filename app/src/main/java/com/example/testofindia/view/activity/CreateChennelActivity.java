package com.example.testofindia.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.testofindia.R;
import com.example.testofindia.databinding.ActivityCreateChennelBinding;
import com.example.testofindia.databinding.ActivityHomeBinding;
import com.example.testofindia.utils.ProgressDialogCustom;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class CreateChennelActivity extends Base_Activity {

    private ActivityCreateChennelBinding mBinding;
    private ProgressDialogCustom progressDialog = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(activity, R.layout.activity_create_chennel);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        onCreateMethod();
    }

    private void onCreateMethod() {
        onClickListner();
    }

    private void onClickListner() {
        mBinding.tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,AddChennelDataActivity.class);
                intent.putExtra("FirstName",mBinding.editFirstName.getText().toString().trim());
                intent.putExtra("LastName",mBinding.editLastName.getText().toString().trim());
                intent.putExtra("Email",mBinding.editEmail.getText().toString().trim());
                intent.putExtra("City",mBinding.editCity.getText().toString().trim());
                intent.putExtra("State",mBinding.editState.getText().toString().trim());
                intent.putExtra("Address",mBinding.editAddress.getText().toString().trim());
                intent.putExtra("DateOfBirth",mBinding.tvBirthdate.getText().toString().trim());
                startActivity(intent);
            }
        });
        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
        mBinding.tvBirthdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                    }
                });

        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        mBinding.tvBirthdate.setText(materialDatePicker.getHeaderText());
                    }
                });
    }
}