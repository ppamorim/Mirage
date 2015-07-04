/*
 * Copyright (C) 2015 Jorge Castillo Pérez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jorgecastilloprz.mirage.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.jorgecastilloprz.mirage.NearPlacesListPresenter;
import com.jorgecastilloprz.mirage.R;
import com.jorgecastilloprz.mirage.model.Place;
import com.jorgecastilloprz.mirage.ui.activity.MainActivity;
import com.jorgecastilloprz.mirage.ui.adapter.NearPlacesListAdapter;
import com.jorgecastilloprz.mirage.ui.base.SwipeToRefreshFragment;
import com.jorgecastilloprz.mirage.ui.listener.EndlessRecyclerOnScrollListener;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Jorge Castillo Pérez
 */
public class NearPlacesListFragment extends SwipeToRefreshFragment
    implements NearPlacesListPresenter.View {

  private View rootView;
  private NearPlacesListAdapter adapter;

  @Inject NearPlacesListPresenter presenter;
  @InjectView(R.id.placesList) RecyclerView placesList;

  public static NearPlacesListFragment newInstance() {
    return new NearPlacesListFragment();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_near_places_list, container, false);
    return rootView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    injectDependencies();
    presenter.setView(this);
    presenter.initialize();
    setupPlacesList();
  }

  private void injectDependencies() {
    ((MainActivity) getActivity()).component().inject(this);
  }

  private void setupPlacesList() {
    placesList.setHasFixedSize(true);

    LinearLayoutManager mLayoutManager =
        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    placesList.setLayoutManager(mLayoutManager);

    adapter = new NearPlacesListAdapter(getActivity());
    placesList.setAdapter(adapter);
    placesList.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
      @Override public void onLoadMore(int current_page) {
        presenter.onLoadMoreScrollPositionReached();
      }
    });
  }

  @Override public void onResume() {
    super.onResume();
    presenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    presenter.pause();
  }

  @Override public void drawPlaces(List<Place> places) {
    adapter.setPlaces(places);
    adapter.notifyDataSetChanged();
    stopRefreshAnimation();
  }
}
