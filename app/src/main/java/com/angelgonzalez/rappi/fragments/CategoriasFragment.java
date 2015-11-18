package com.angelgonzalez.rappi.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.angelgonzalez.rappi.R;
import com.angelgonzalez.rappi.adapters.TitlePagerAdapter;
import com.angelgonzalez.rappi.model.Aplicaciones;
import com.angelgonzalez.rappi.util.Util;
import com.google.gson.Gson;
import com.ajgc.volleyajgcrappi.GsonHelper;
import com.ajgc.volleyajgcrappi.HttpServiciosControllerVolley;
import com.ajgc.volleyajgcrappi.IListenerResult;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by angel.gonzalez on 11/11/2015.
 */

@EFragment(R.layout.fragment_main)
public class CategoriasFragment extends Fragment {

    private static final String IS_ARTIST ="com.angelgonzalez.rappi.IS_ARTIST";

    private TitlePagerAdapter adapter;
    private Aplicaciones aplicaciones;

    View view;

    @ViewById
    ViewPager viewpager;

    @ViewById
    TabLayout tabs;

    @ViewById
    ProgressBar progress;

    private Boolean isArtist;

    public static CategoriasFragment_ newInstance(boolean isArtist){
        CategoriasFragment_ fragment = new CategoriasFragment_();
        Bundle args = new Bundle();

        args.putBoolean(IS_ARTIST, isArtist);

        fragment.setArguments(args);
        return  fragment;
    }
    @AfterViews
    void onLoadView(){

        HttpServiciosControllerVolley httpService = new HttpServiciosControllerVolley(getActivity().getApplicationContext(), "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json");
        httpService.setListenerResult(new IListenerResult() {
            @Override
            public void onProcessFinish(Object responseService) {
                if (responseService != null && !responseService.equals("[]")) {

                   Gson gson = new GsonHelper().getGson();


                    String json = responseService.toString();

                    json = json.replace("im:id", "imid");
                    json = json.replace("im:image", "imImage");
                    json = json.replace("im:name", "imName");
                     json = json.replace("im:price", "imPrice");
                    json = json.replace("im:artist", "imArtist");
                    aplicaciones = gson.fromJson(json, Aplicaciones.class);


                    if (aplicaciones != null) {

                        //Util.guardarDatos(getActivity().getApplicationContext(), aplicaciones);

                        if (viewpager != null) {
                            setupViewPager();
                        }

                    }

                }
            }

            @Override
            public void onError(String p_MensajeError) {

                //aplicaciones = Util.obtieneAplicaciones(getActivity().getApplicationContext());

                Toast.makeText(getActivity().getApplicationContext(),p_MensajeError, Toast.LENGTH_SHORT).show();

                if (viewpager != null && aplicaciones !=null && aplicaciones.getFeed() != null && aplicaciones.getFeed().getEntry() != null) {
                    setupViewPager();
                }
            }
        });
       // progress.setVisibility(View.VISIBLE);
        httpService.callMethodoPost();


    }

    private void setupViewPager() {
        adapter = new TitlePagerAdapter(getFragmentManager());

        int sizeEnty = aplicaciones.getFeed().getEntry().size();

        List<String> listNameTabs = new ArrayList<>();

        boolean  isArtist =getArguments().getBoolean(IS_ARTIST);

        for (int i =0; i<sizeEnty;i++){



            String nameTabs;

            if(isArtist){
                nameTabs = aplicaciones.getFeed().getEntry().get(i).getImArtist().getLabel();
            }
            else {
                nameTabs = aplicaciones.getFeed().getEntry().get(i).getCategory().getAttributes().getTerm();
            }
            if(!listNameTabs.contains(nameTabs)){

                listNameTabs.add(nameTabs);
            }

        }
        int sizeTabs = listNameTabs.size();


        for (int j=0; j<sizeTabs;j++ ){

            adapter.addFragment(new GrupoFragment_().newInstance(aplicaciones, listNameTabs.get(j), isArtist), listNameTabs.get(j));
        }

        viewpager.setAdapter(adapter);

        tabs.setupWithViewPager(viewpager);

        progress.setVisibility(View.GONE);
    }

}
