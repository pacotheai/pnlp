package paco.pnlp.init

import com.google.inject.Scopes
import com.google.inject.Provides
import com.google.inject.Singleton
import com.google.inject.AbstractModule

import ratpack.server.Service

class StartupModule extends AbstractModule {
  @Override
  void configure() {
    bind(Service).to(StartupService)
  }
}
