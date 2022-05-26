package com.example.ontapsqlite3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ThuChiAdapter extends BaseAdapter {
    Context ctx;
    int layout;
    List<QuanLyThuChi> list;
    private IClickListener iClickListener;
    public interface IClickListener{
        void onCLickUpdate(QuanLyThuChi acc);
        void onCLickDelete(QuanLyThuChi acc);
    }

    public ThuChiAdapter(Context ctx, int layout, List<QuanLyThuChi> list, IClickListener iClickListener) {
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;
        this.iClickListener = iClickListener;
    }

    public ThuChiAdapter(Context ctx, int layout, List<QuanLyThuChi> list) {
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(ctx).inflate(layout,viewGroup,false);
        QuanLyThuChi acc = list.get(i);
        TextView txtChi = view.findViewById(R.id.txtChi);
        TextView txtThu = view.findViewById(R.id.txtThu);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        Button btnDelete = view.findViewById(R.id.btnDelete);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickListener.onCLickUpdate(acc);
            }
        });

        txtChi.setText(""+list.get(i).getKhoanChi());
        txtThu.setText(""+list.get(i).getKhoanThu());
        return view;
    }
}
