package com.example.gabrielmoro.baking_app.ui.main_screen.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.example.gabrielmoro.baking_app.R;
import com.example.gabrielmoro.baking_app.ui.base.GeneralBaseAdapter;

import java.util.List;

public class RecipeAdapterList extends GeneralBaseAdapter<RecipeItemViewModel> {

    public RecipeAdapterList(@NonNull List<RecipeItemViewModel> aLstElements, LayoutInflater aInflater) {
        super(aLstElements, aInflater);
    }

    @Override
    protected int getLayoutResourceAccordingViewType() {
        return R.layout.layout_recipe_item;
    }
}