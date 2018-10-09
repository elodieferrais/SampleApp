package com.elodieferrais.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.textview) TextView textView;
    MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.loadPeople();
    }

    @Override public void showCount(DummyObject dummyObject) {
        textView.setText(String.valueOf(dummyObject.count));
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        mainPresenter.destroy();
    }
}
