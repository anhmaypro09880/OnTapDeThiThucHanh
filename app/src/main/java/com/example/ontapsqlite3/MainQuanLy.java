package com.example.ontapsqlite3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainQuanLy extends AppCompatActivity {
    ThuChiAdapter adt;
    Button btnThem;
    EditText edtThu,edtChi;
    ListView lv;
    FirebaseDatabase test =FirebaseDatabase.getInstance();
    DatabaseReference data =test.getReference("QuanLy");
    List<QuanLyThuChi> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quan_ly);
        khaiBao();

        adt = new ThuChiAdapter(this, R.layout.listview_quanly, list, new ThuChiAdapter.IClickListener() {
            @Override
            public void onCLickUpdate(QuanLyThuChi acc) {
                String thu = edtThu.getText().toString();
                int thu2 = Integer.parseInt(thu);
                String chi = edtChi.getText().toString();
                int chi2 = Integer.parseInt(chi);
                QuanLyThuChi q = new QuanLyThuChi(thu2,chi2);
                data.child(String.valueOf(acc.getKhoanChi())).setValue(q);

            }

            @Override
            public void onCLickDelete(QuanLyThuChi acc) {

            }
        });
        lv.setAdapter(adt);
        getAllList();
        addThuChi();

    }

    private void khaiBao() {
        lv=findViewById(R.id.lvThuChi);
        edtChi = findViewById(R.id.edtChi);
        edtThu = findViewById(R.id.edtThu);
        btnThem = findViewById(R.id.btnThem);

    }
    private void getAllList(){
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot s : snapshot.getChildren()){
                    QuanLyThuChi acc = s.getValue(QuanLyThuChi.class);
                    list.add(acc);
                }
                adt.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainQuanLy.this,"get fail",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void addThuChi(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thu = edtChi.getText().toString();
                int thu2 = Integer.parseInt(thu);

                String chi = edtThu.getText().toString();
                int chi2 = Integer.parseInt(chi);
                QuanLyThuChi q = new QuanLyThuChi(thu2,chi2);
                String pathObject = String.valueOf(q.getKhoanChi());
                data.child(pathObject).setValue(q);

            }
        });
    }

}