package com.github.jorgecastilloprz.mirage.di;

import com.github.jorgecastilloprz.mirage.PlacesRepositoryTest;
import com.jorgecastilloprz.mirage.di.RepositoryModule;
import com.jorgecastilloprz.mirage.di.annotations.PerActivity;
import dagger.Component;

/**
 * @author jorge
 * @since 24/07/15
 */
@PerActivity @Component(modules = { RepositoryModule.class, TestApiModule.class })
public interface TestRepositoryComponent {

  void inject(PlacesRepositoryTest placesRepositoryTest);
}
