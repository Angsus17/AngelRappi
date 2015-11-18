package com.angelgonzalez.rappi.activitys;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.angelgonzalez.rappi.R;
import com.angelgonzalez.rappi.interfaces.IResumenPresenter;
import com.angelgonzalez.rappi.interfaces.IResumenView;
import com.angelgonzalez.rappi.model.Entry;
import com.angelgonzalez.rappi.presenters.ResumenPresenter;
import com.angelgonzalez.rappi.util.Util;
import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by angel.gonzalez on 17/11/2015.
 */
@EActivity(R.layout.activity_summary)
public class ResumenActivity extends AppCompatActivity implements IResumenView {

    public static final String EXTRA_ENTRY  = "com.angelgonzalez.rappi.EXTRA_ENTRY";
    public static final String VIEW_NAME_HEADER_IMAGE = "com.angelgonzalez.rappi.NAME_HEADER_IMAGE";
    @ViewById
    Toolbar toolbar;

    @ViewById
    TextView lblResumen;

    @ViewById
    CollapsingToolbarLayout collapsing_toolbar;

    @ViewById
    ImageView imagenResumen;

    IResumenPresenter presenter;




    @AfterViews
    void onLoadView(){
        try {

            Util.setRequestedOrientation(this);

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            presenter = new ResumenPresenter();
            presenter.onCreate(this, this.getEntryFromIntent(getIntent()));


            collapsing_toolbar.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });

        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public void setImage(String url) {

        Glide.with(this).load(url).centerCrop().into(imagenResumen);
    }

    @Override
    public void setTitle(String text) {
        collapsing_toolbar.setTitle(text);
    }

    @Override
    public void setResumen(String text) {
        lblResumen.setText(text);
    }

    private Entry getEntryFromIntent(Intent intent) {
        return (Entry)intent.getSerializableExtra(EXTRA_ENTRY);
    }


}
