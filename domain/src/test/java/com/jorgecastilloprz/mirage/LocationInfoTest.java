package com.jorgecastilloprz.mirage;

import com.jorgecastilloprz.mirage.model.LocationInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jorge
 * @since 26/07/15
 */
public class LocationInfoTest {

  @Test public void shouldHaveDefaultCrossStreet() throws Exception {
    LocationInfo location = new LocationInfo(null, 0.0, 0.0, 0.0, "", "", "", "", "", "");
    assertEquals("", location.getCrossStreet());
  }

  @Test public void shouldUseGivenCrossStreet() throws Exception {
    LocationInfo location =
        new LocationInfo("Given mock cross street", 0.0, 0.0, 0.0, "", "", "", "", "", "");
    assertEquals("Given mock cross street", location.getCrossStreet());
  }

  @Test public void shouldReturnDistanceInMetersIfGivenDistanceHasNotDecimals() throws Exception {
    LocationInfo location = new LocationInfo("", 0.0, 0.0, 750, "", "", "", "", "", "");
    assertEquals("750 m", location.getFormattedDistance());
  }

  @Test public void shouldReturnDistanceInKilometersIfGivenDistanceHasDecimals() throws Exception {
    LocationInfo location = new LocationInfo("", 0.0, 0.0, 23.6, "", "", "", "", "", "");
    assertEquals("23.6 km", location.getFormattedDistance());
  }
}