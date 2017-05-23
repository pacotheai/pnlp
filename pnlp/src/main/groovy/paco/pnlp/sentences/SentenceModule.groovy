package paco.pnlp.sentences

import com.google.inject.Scopes
import com.google.inject.Provides
import com.google.inject.Singleton
import com.google.inject.AbstractModule

import opennlp.tools.sentdetect.SentenceModel

/**
 * Loads required classes to deal with sentences
 *
 * @since 0.1.0
 */
class SentenceModule extends AbstractModule {

  @Override
  void configure() {
    bind(SentenceModel)
      .toProvider(SentenceModelProvider)
      .in(Scopes.SINGLETON)

    bind(SentenceService).in(Scopes.SINGLETON)
    bind(SentenceHandler).in(Scopes.SINGLETON)
  }
}
