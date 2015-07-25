package com.github.jorgecastilloprz.mirage;

import com.github.jorgecastilloprz.mirage.di.DaggerTestRepositoryComponent;
import com.github.jorgecastilloprz.mirage.di.TestApiModule;
import com.github.jorgecastilloprz.mirage.di.TestRepositoryComponent;
import com.jorgecastilloprz.mirage.di.RepositoryModule;
import com.jorgecastilloprz.mirage.interactor.exceptions.ObtainPlacesException;
import com.jorgecastilloprz.mirage.repository.PlacesRepository;
import com.squareup.okhttp.mockwebserver.MockResponse;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jorge
 * @since 24/07/15
 */
public class PlacesRepositoryTest {

  private TestApiModule apiModule;

  @Inject PlacesRepository placesRepository;

  @Before public void setup() {
    apiModule = new TestApiModule();
    TestRepositoryComponent component = DaggerTestRepositoryComponent.builder()
        .repositoryModule(new RepositoryModule())
        .testApiModule(apiModule)
        .build();

    component.inject(this);
  }

  @Test public void repositoryShouldBeInjected() {
    try {
      MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody("{\n"
          + "meta: {\n" + "code: 200\n" + "}\n" + "notifications: [\n" + "{\n"
          + "type: \"notificationTray\"\n" + "item: {\n" + "unreadCount: 0\n" + "}\n" + "}\n"
          + "]\n" + "response: {\n" + "suggestedFilters: {\n" + "header: \"Tap to show:\"\n"
          + "filters: [\n" + "{\n" + "name: \"Open now\"\n" + "key: \"openNow\"\n" + "}\n" + "]\n"
          + "}\n" + "warning: {\n"
          + "text: \"There aren't a lot of results near you. Try something more general, reset your filters, or expand the search area.\"\n"
          + "}\n" + "suggestedRadius: 1305\n" + "headerLocation: \"La Flota\"\n"
          + "headerFullLocation: \"La Flota, Murcia\"\n"
          + "headerLocationGranularity: \"neighborhood\"\n" + "query: \"outdoors recreation\"\n"
          + "totalResults: 39\n" + "suggestedBounds: {\n" + "ne: {\n" + "lat: 37.99273026877379\n"
          + "lng: -1.12827449621866\n" + "}\n" + "sw: {\n" + "lat: 37.983563163391715\n"
          + "lng: -1.1310909856491158\n" + "}\n" + "}\n" + "groups: [\n" + "{\n"
          + "type: \"Recommended Places\"\n" + "name: \"recommended\"\n" + "items: [\n" + "{\n"
          + "reasons: {\n" + "count: 0\n" + "items: [\n" + "{\n"
          + "summary: \"This spot is popular\"\n" + "type: \"general\"\n"
          + "reasonName: \"globalInteractionReason\"\n" + "}\n" + "]\n" + "}\n" + "venue: {\n"
          + "id: \"4be99811a9900f4794811540\"\n" + "name: \"Plaza Santo Domingo\"\n"
          + "contact: { }\n" + "location: {\n" + "address: \"Pl. Santo Domingo\"\n"
          + "lat: 37.987240467714194\n" + "lng: -1.1291674581487767\n" + "distance: 884\n"
          + "postalCode: \"30001\"\n" + "cc: \"ES\"\n" + "city: \"Murcia\"\n"
          + "state: \"Murcia\"\n" + "country: \"Spain\"\n" + "formattedAddress: [\n"
          + "\"Pl. Santo Domingo\"\n" + "\"30001 Murcia Murcia\"\n" + "\"Spain\"\n" + "]\n" + "}\n"
          + "categories: [\n" + "{\n" + "id: \"4bf58dd8d48988d164941735\"\n" + "name: \"Plaza\"\n"
          + "pluralName: \"Plazas\"\n" + "shortName: \"Plaza\"\n" + "icon: {\n"
          + "prefix: \"https://ss3.4sqi.net/img/categories_v2/parks_outdoors/plaza_\"\n"
          + "suffix: \".png\"\n" + "}\n" + "primary: true\n" + "}\n" + "]\n" + "verified: false\n"
          + "stats: {\n" + "checkinsCount: 3260\n" + "usersCount: 956\n" + "tipCount: 20\n" + "}\n"
          + "url: \"http://es.wikipedia.org/wiki/Plaza_de_Santo_Domingo_(Murcia)\"\n"
          + "like: false\n" + "specials: {\n" + "count: 0\n" + "items: [ ]\n" + "}\n"
          + "photos: {\n" + "count: 168\n" + "groups: [ ]\n" + "}\n" + "hereNow: {\n" + "count: 0\n"
          + "summary: \"Nobody here\"\n" + "groups: [ ]\n" + "}\n" + "}\n" + "tips: [\n" + "{\n"
          + "id: \"4e5cfcc51495d25a3a02f87e\"\n" + "createdAt: 1314716869\n"
          + "text: \"Hace un siglo era la plaza del mercado, hoy es un habitual punto de encuentro y quedada para los Murcianos. El ficus tiene más de 100 años. Muchos sitios con terracita para un café o cenita\"\n"
          + "type: \"user\"\n"
          + "canonicalUrl: \"https://foursquare.com/item/4e5cfcc51495d25a3a02f87e\"\n"
          + "photo: {\n" + "id: \"4e5cfcccfa76a4cf148cb0fe\"\n" + "createdAt: 1314716876\n"
          + "source: {\n" + "name: \"Foursquare for iOS\"\n"
          + "url: \"https://foursquare.com/download/#/iphone\"\n" + "}\n"
          + "prefix: \"https://irs0.4sqi.net/img/general/\"\n"
          + "suffix: \"/W4R0TN42WGDOAEZTQNB2LVJLXYFHILGFKCDEOFLBHUZY22S0.jpg\"\n" + "width: 720\n"
          + "height: 537\n" + "}\n"
          + "photourl: \"https://irs0.4sqi.net/img/general/original/W4R0TN42WGDOAEZTQNB2LVJLXYFHILGFKCDEOFLBHUZY22S0.jpg\"\n"
          + "likes: {\n" + "count: 9\n" + "groups: [ ]\n" + "summary: \"9 likes\"\n" + "}\n"
          + "logView: true\n" + "todo: {\n" + "count: 1\n" + "}\n" + "user: {\n"
          + "id: \"12446050\"\n" + "firstName: \"Leles\"\n" + "gender: \"female\"\n" + "photo: {\n"
          + "prefix: \"https://irs2.4sqi.net/img/user/\"\n" + "suffix: \"/3Z5BTEJR3NLWCBDU.jpg\"\n"
          + "}\n" + "}\n" + "}\n" + "]\n" + "referralId: \"e-0-4be99811a9900f4794811540-0\"\n"
          + "}\n" + "{\n" + "reasons: {\n" + "count: 0\n" + "items: [\n" + "{\n"
          + "summary: \"This spot is popular\"\n" + "type: \"general\"\n"
          + "reasonName: \"globalInteractionReason\"\n" + "}\n" + "]\n" + "}\n" + "venue: {\n"
          + "id: \"4d257cbad713b1f7a6abdf53\"\n" + "name: \"Plaza Circular\"\n" + "contact: { }\n"
          + "location: {\n" + "lat: 37.99231358216551\n" + "lng: -1.130198023718999\n"
          + "distance: 766\n" + "cc: \"ES\"\n" + "city: \"Murcia\"\n" + "state: \"Murcia\"\n"
          + "country: \"Spain\"\n" + "formattedAddress: [\n" + "\"Murcia Murcia\"\n" + "\"Spain\"\n"
          + "]\n" + "}\n" + "categories: [\n" + "{\n" + "id: \"4bf58dd8d48988d164941735\"\n"
          + "name: \"Plaza\"\n" + "pluralName: \"Plazas\"\n" + "shortName: \"Plaza\"\n"
          + "icon: {\n"
          + "prefix: \"https://ss3.4sqi.net/img/categories_v2/parks_outdoors/plaza_\"\n"
          + "suffix: \".png\"\n" + "}\n" + "primary: true\n" + "}\n" + "]\n" + "verified: false\n"
          + "stats: {\n" + "checkinsCount: 1945\n" + "usersCount: 383\n" + "tipCount: 10\n" + "}\n"
          + "like: false\n" + "specials: {\n" + "count: 0\n" + "items: [ ]\n" + "}\n"
          + "photos: {\n" + "count: 65\n" + "groups: [ ]\n" + "}\n" + "hereNow: {\n" + "count: 0\n"
          + "summary: \"Nobody here\"\n" + "groups: [ ]\n" + "}\n" + "}\n" + "tips: [\n" + "{\n"
          + "id: \"50b90fc4e4b0c22ba8fe8121\"\n" + "createdAt: 1354305476\n"
          + "text: \"El kiosko que han colocado para tomarte unas tapitas definitivamente invita a disfrutar la plaza.\"\n"
          + "type: \"user\"\n"
          + "canonicalUrl: \"https://foursquare.com/item/50b90fc4e4b0c22ba8fe8121\"\n"
          + "likes: {\n" + "count: 8\n" + "groups: [ ]\n" + "summary: \"8 likes\"\n" + "}\n"
          + "logView: true\n" + "todo: {\n" + "count: 0\n" + "}\n" + "user: {\n"
          + "id: \"13087295\"\n" + "firstName: \"@sitiocreaCtivo\"\n" + "gender: \"male\"\n"
          + "photo: {\n" + "prefix: \"https://irs0.4sqi.net/img/user/\"\n"
          + "suffix: \"/MOABKYP3MK150JKT.jpg\"\n" + "}\n" + "}\n" + "}\n" + "]\n"
          + "referralId: \"e-0-4d257cbad713b1f7a6abdf53-1\"\n" + "}\n" + "{\n" + "reasons: {\n"
          + "count: 0\n" + "items: [\n" + "{\n" + "summary: \"This spot is popular\"\n"
          + "type: \"general\"\n" + "reasonName: \"globalInteractionReason\"\n" + "}\n" + "]\n"
          + "}\n" + "venue: {\n" + "id: \"4d8e261d5091a1cd9cba8801\"\n"
          + "name: \"Plaza de la Catedral\"\n" + "contact: { }\n" + "location: {\n"
          + "address: \"Pl.Cardenal Belluga, s/n\"\n" + "lat: 37.98397985\n" + "lng: -1.129537\n"
          + "distance: 1171\n" + "postalCode: \"30001\"\n" + "cc: \"ES\"\n" + "city: \"Murcia\"\n"
          + "state: \"Murcia\"\n" + "country: \"Spain\"\n" + "formattedAddress: [\n"
          + "\"Pl.Cardenal Belluga, s/n\"\n" + "\"30001 Murcia Murcia\"\n" + "\"Spain\"\n" + "]\n"
          + "}\n" + "categories: [\n" + "{\n" + "id: \"4bf58dd8d48988d164941735\"\n"
          + "name: \"Plaza\"\n" + "pluralName: \"Plazas\"\n" + "shortName: \"Plaza\"\n"
          + "icon: {\n"
          + "prefix: \"https://ss3.4sqi.net/img/categories_v2/parks_outdoors/plaza_\"\n"
          + "suffix: \".png\"\n" + "}\n" + "primary: true\n" + "}\n" + "]\n" + "verified: false\n"
          + "stats: {\n" + "checkinsCount: 1835\n" + "usersCount: 891\n" + "tipCount: 19\n" + "}\n"
          + "like: false\n" + "specials: {\n" + "count: 0\n" + "items: [ ]\n" + "}\n"
          + "photos: {\n" + "count: 307\n" + "groups: [ ]\n" + "}\n" + "hereNow: {\n" + "count: 1\n"
          + "summary: \"One other person is here\"\n" + "groups: [\n" + "{\n" + "type: \"others\"\n"
          + "name: \"Other people here\"\n" + "count: 1\n" + "items: [ ]\n" + "}\n" + "]\n" + "}\n"
          + "}\n" + "tips: [\n" + "{\n" + "id: \"4e79a6d88998654c74d6f173\"\n"
          + "createdAt: 1316595416\n" + "text: \"Un café y la catedral, mejor vista...\"\n"
          + "type: \"user\"\n"
          + "canonicalUrl: \"https://foursquare.com/item/4e79a6d88998654c74d6f173\"\n"
          + "likes: {\n" + "count: 9\n" + "groups: [ ]\n" + "summary: \"9 likes\"\n" + "}\n"
          + "logView: true\n" + "todo: {\n" + "count: 0\n" + "}\n" + "user: {\n"
          + "id: \"7086309\"\n" + "firstName: \"Anna\"\n" + "lastName: \"C. Pereira\"\n"
          + "gender: \"female\"\n" + "photo: {\n" + "prefix: \"https://irs1.4sqi.net/img/user/\"\n"
          + "suffix: \"/MVFEU20EBNLN2DYU.jpg\"\n" + "}\n" + "}\n" + "}\n" + "]\n"
          + "referralId: \"e-0-4d8e261d5091a1cd9cba8801-2\"\n" + "}\n" + "]\n" + "}\n" + "]\n"
          + "}\n" + "}");

      apiModule.getMockWebServer().enqueue(mockResponse);

      placesRepository.obtainPlacesAround(0, 37.992360, -1.121461, 200, 100000);
    } catch (ObtainPlacesException e) {
      e.printStackTrace();
    }
  }
}
