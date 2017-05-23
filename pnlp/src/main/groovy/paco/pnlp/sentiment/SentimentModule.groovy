package paco.pnlp.sentiment

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import opennlp.tools.doccat.DoccatModel

/**
 * Loads required classes to deal with document
 * categorization
 *
 * @since 0.1.0
 */
class SentimentModule extends AbstractModule {

  @Override
  void configure() {
    bind(DoccatModel)
      .toProvider(SentimentModelProvider)
      .in(Scopes.SINGLETON)

    bind(SentimentService).in(Scopes.SINGLETON)
    bind(SentimentHandler).in(Scopes.SINGLETON)
  }
}
