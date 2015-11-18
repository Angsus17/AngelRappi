package com.angelgonzalez.rappi.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angelgonzalez.rappi.R;
import com.angelgonzalez.rappi.adapters.TabsInfoAdapter;
import com.angelgonzalez.rappi.model.Aplicaciones;
import com.angelgonzalez.rappi.model.Entry;
import com.angelgonzalez.rappi.util.Util;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by angel.gonzalez on 11/11/2015.
 */
@EFragment(R.layout.fragment_grupo_items)
public class GrupoFragment extends Fragment {

    private static final String LISTA_DATOS  = "com.angelgonzalez.rappi.LISTA_DATOS";
    private static final String TIPO_TAB ="com.angelgonzalez.rappi.TIPO_TAB";
    private static final String IS_ARTIST ="com.angelgonzalez.rappi.IS_ARTIST";

    private List<Entry> items;
    private Aplicaciones aplicaciones;
    private String tipoTabs;
    private  boolean isArtist;
    private boolean isTablet;

    @ViewById
    RecyclerView reciclador;

    public GrupoFragment() {

    }

    public static GrupoFragment_ newInstance(Aplicaciones aplicaciones, String tipoTab, boolean isArtist) {
        GrupoFragment_ fragment = new GrupoFragment_();
        Bundle args = new Bundle();

        args.putSerializable(LISTA_DATOS,aplicaciones);
        args.putString(TIPO_TAB, tipoTab);
        args.putBoolean(IS_ARTIST, isArtist);
        fragment.setArguments(args);

        return fragment;
    }

    @AfterViews
    void onLoadView() {

        this.isTablet = Util.isTablet(this.getActivity().getApplicationContext());

        if(this.isTablet) {
            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            reciclador.setLayoutManager(layoutManager);
        }
        else {

            reciclador.setLayoutManager(new LinearLayoutManager(reciclador.getContext()));
        }

        aplicaciones = (Aplicaciones)getArguments().getSerializable(LISTA_DATOS);


        items=new ArrayList<>();

        tipoTabs = getArguments().getString(TIPO_TAB);
        isArtist =getArguments().getBoolean(IS_ARTIST);

        for (int i = 0; i < aplicaciones.getFeed().getEntry().size(); i++) {

            if(isArtist){
                if (aplicaciones.getFeed().getEntry().get(i).getImArtist().getLabel().equalsIgnoreCase(tipoTabs)){
                    items.add(aplicaciones.getFeed().getEntry().get(i));
                }
            }
            else {


                if (aplicaciones.getFeed().getEntry().get(i).getCategory().getAttributes().getTerm().equalsIgnoreCase(tipoTabs)) {

                    items.add(aplicaciones.getFeed().getEntry().get(i));

                }
            }

        }

        TabsInfoAdapter adaptador = new TabsInfoAdapter(items, this.isTablet);
        reciclador.setAdapter(adaptador);

    }


}