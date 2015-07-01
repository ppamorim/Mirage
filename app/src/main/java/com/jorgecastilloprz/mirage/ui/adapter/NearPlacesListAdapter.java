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
package com.jorgecastilloprz.mirage.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jorgecastilloprz.mirage.R;
import com.jorgecastilloprz.mirage.model.Place;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Castillo Pérez
 */
public class NearPlacesListAdapter extends RecyclerView.Adapter<NearPlacesListAdapter.ViewHolder> {

  private List<Place> places;
  private Context context;

  public NearPlacesListAdapter(Context context) {
    this.context = context;
    places = new ArrayList<>();
  }

  public void setPlaces(List<Place> places) {
    this.places = places;
  }

  @Override
  public NearPlacesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_list, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Place place = places.get(position);
    loadPhoto(place, holder.image);
    holder.title.setText(place.getName());
    holder.subtitle.setText(place.getLocationInfo().getCity());
    holder.userComment.setText(place.getTips().get(0).getText());
  }

  private void loadPhoto(Place place, ImageView imageView) {
    String photoUrl = place.getPhotos() != null && place.getPhotos().size() > 0 ? place.getPhotos()
        .get(0)
        .getUrl() : "";

    if (!photoUrl.equals("")) {
      Picasso.with(context).load(photoUrl).into(imageView);
    }
  }

  @Override public int getItemCount() {
    return places.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public CardView card;
    public ImageView image;
    public TextView title;
    public TextView subtitle;
    public TextView userComment;

    public ViewHolder(View v) {
      super(v);
      card = (CardView) v.findViewById(R.id.card);
      image = (ImageView) v.findViewById(R.id.image);
      title = (TextView) v.findViewById(R.id.title);
      subtitle = (TextView) v.findViewById(R.id.subtitle);
      userComment = (TextView) v.findViewById(R.id.userComment);
    }
  }
}
