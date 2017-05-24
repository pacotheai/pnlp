package paco.pnlp.namefinder

import com.google.inject.Scopes
import com.google.inject.AbstractModule

import paco.pnlp.namefinder.model.NameFinderModel
import paco.pnlp.namefinder.model.NameFinderModelProvider

class NameFinderModule extends AbstractModule {
  @Override
  void configure() {
    bind(NameFinderModel)
      .toProvider(NameFinderModelProvider)
      .in(Scopes.SINGLETON)

    bind(NameFinderService).in(Scopes.SINGLETON)
    bind(PersonHandler).in(Scopes.SINGLETON)
    bind(LocationHandler).in(Scopes.SINGLETON)
  }
}
