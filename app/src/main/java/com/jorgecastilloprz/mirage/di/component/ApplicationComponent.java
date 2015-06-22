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
package com.jorgecastilloprz.mirage.di.component;

import android.app.Application;
import com.jorgecastilloprz.mirage.MirageApp;
import com.jorgecastilloprz.mirage.di.modules.ApplicationModule;
import com.jorgecastilloprz.mirage.executor.InteractorExecutor;
import com.jorgecastilloprz.mirage.executor.MainThread;
import dagger.Component;
import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 *
 * @author Jorge Castillo Pérez
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class) public interface ApplicationComponent {

  void inject(MirageApp application);

  // Exported for child-components.
  Application application();

  InteractorExecutor threadExecutor();

  MainThread mainThread();
}
