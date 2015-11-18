package com.angelgonzalez.rappi.presenters;

import com.angelgonzalez.rappi.interfaces.IResumenPresenter;
import com.angelgonzalez.rappi.interfaces.IResumenView;
import com.angelgonzalez.rappi.model.Entry;

/**
 * Created by angel.gonzalez on 17/11/2015.
 */
public class ResumenPresenter implements IResumenPresenter {

    private IResumenView view;
    private Entry entry;

    @Override
    public void onCreate(IResumenView view, Entry entry) {

        this.view = view;
        this.entry = entry;

        view.setImage(entry.getImImage().get(2).getLabel());
        view.setTitle(entry.getImName().getLabel());
        view.setResumen(entry.getSummary().getLabel());
    }
}
