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
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.jorgecastilloprz.mirage.R;
import com.jorgecastilloprz.mirage.model.Place;
import com.jorgecastilloprz.mirage.ui.components.picassotransform.ColorTransform;
import com.squareup.picasso.MemoryPolicy;
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
    if (this.places.size() > 0 && this.places.get(0).getName().equals(places.get(0).getName())) {
      this.places = places;
    } else {
      this.places.addAll(places);
    }
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
    setTip(holder.userComment, place);

    holder.distance.setText(place.getLocationInfo().getFormattedDistance());
    setupRating(holder.ratingBgCircle, holder.ratingText, place);
  }

  private void setTip(TextView userComment, Place place) {
    if (place.hasTips()) {
      userComment.setText(place.getTips().get(0).getText());
    }
  }

  private void loadPhoto(Place place, ImageView imageView) {
    String photoUrl = place.getPhotos() != null && place.getPhotos().size() > 0 ? place.getPhotos()
        .get(0)
        .getUrl() : "";

    if (!photoUrl.equals("")) {
      Picasso.with(context).load(photoUrl).into(imageView);
    }
  }

  private void setupRating(ImageView ratingBgCircle, TextView ratingText, Place place) {
    if (place.getRatingInfo() != null) {
      ratingBgCircle.setVisibility(View.VISIBLE);
      ratingText.setVisibility(View.VISIBLE);
      setRatingColor(ratingBgCircle, place.getRatingInfo().getRatingColor());
      ratingText.setText(place.getRatingInfo().getRating() + "");
    } else {
      ratingBgCircle.setVisibility(View.GONE);
      ratingText.setVisibility(View.GONE);
    }
  }

  private void setRatingColor(ImageView bgCircle, String color) {
    Picasso.with(context)
        .load(R.drawable.ic_menu)
        .transform(new ColorTransform(color))
        .memoryPolicy(MemoryPolicy.NO_CACHE)
        .error(android.R.color.darker_gray)
        .into(bgCircle);
  }

  @Override public int getItemCount() {
    return places.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.card) CardView card;
    @InjectView(R.id.image) ImageView image;
    @InjectView(R.id.title) TextView title;
    @InjectView(R.id.subtitle) TextView subtitle;
    @InjectView(R.id.userComment) TextView userComment;
    @InjectView(R.id.distance) TextView distance;
    @InjectView(R.id.ratingBgCircle) ImageView ratingBgCircle;
    @InjectView(R.id.ratingText) TextView ratingText;

    public ViewHolder(View v) {
      super(v);
      ButterKnife.inject(this, v);
    }
  }
}
