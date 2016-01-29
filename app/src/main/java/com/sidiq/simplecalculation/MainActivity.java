package com.sidiq.simplecalculation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.edt_panjang)
    EditText edtPanjang;
    @Bind(R.id.edt_lebar)
    EditText edtLebar;
    @Bind(R.id.btn_hitung)
    Button btnHitung;
    @Bind(R.id.txt_hasil)
    TextView txtHasil;

    private String KEY_HASIL = "hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_hitung)
    public void hitung(){
        double panjang = Double.parseDouble(edtPanjang.getText().toString().trim());
        double lebar = Double.parseDouble(edtLebar.getText().toString().trim());

        double luas = panjang * lebar;

        txtHasil.setText(String.valueOf(luas));
    }

    //Method ini akan menyimpan value hasil yang ada di txtHasil kedalam object Bundle 
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_HASIL, txtHasil.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }

    //Method ini akan restore value yang disimpan sebelumnya dari Bundle
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            txtHasil.setText(savedInstanceState.getString(KEY_HASIL));
        }
    }
}
