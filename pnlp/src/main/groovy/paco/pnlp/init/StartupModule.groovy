package paco.pnlp.init

import com.google.inject.AbstractModule
import ratpack.service.Service

class StartupModule extends AbstractModule {
  @Override
  void configure() {
    bind(Service).to(StartupService)
  }
}
