package com.angelgonzalez.rappi.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.angelgonzalez.rappi.R;
import com.angelgonzalez.rappi.activitys.ResumenActivity;
import com.angelgonzalez.rappi.activitys.ResumenActivity_;
import com.angelgonzalez.rappi.model.Entry;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by angel.gonzalez on 11/11/2015.
 */
public class TabsInfoAdapter extends RecyclerView.Adapter<TabsInfoAdapter.ViewHolder>  {

    private List<Entry> items;
    private boolean isTablet;
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView precio;
        public ImageView imagen;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombre = (TextView) view.findViewById(R.id.nombre);
            precio = (TextView) view.findViewById(R.id.precio);
            imagen = (ImageView) view.findViewById(R.id.imagen_miniatura);
        }
    }

    public TabsInfoAdapter(List<Entry> items, boolean isTablet) {
        this.items = items;
        this.isTablet = isTablet;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(isTablet ? R.layout.item_grid_lista_categorias : R.layout.item_lista_categorias, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
       final Entry item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getImImage().get(2).getLabel())
                //.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.nombre.setText(item.getImName().getLabel());
        viewHolder.precio.setText("$" + item.getImPrice().getAttributes().getAmount());


        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ResumenActivity_.class);
                intent.putExtra(ResumenActivity.EXTRA_ENTRY, item);
                //context.startActivity(intent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ActivityOptionsCompat activityOptions =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    (Activity) context,
                                    new Pair<View, String>(v.findViewById(R.id.imagen_miniatura),
                                            ResumenActivity.VIEW_NAME_HEADER_IMAGE)
                            );

                    ActivityCompat.startActivity((Activity) context, intent, activityOptions.toBundle());
                } else
                    context.startActivity(intent);

            }
        });
    }
}
