package paco.pnlp.tokenizer

import com.google.inject.Scopes
import com.google.inject.Provides
import com.google.inject.Singleton
import com.google.inject.AbstractModule

import opennlp.tools.tokenize.TokenizerModel

/**
 * Loads required classes to deal with tokens
 * from strings
 *
 * @since 0.1.0
 */
class TokenizerModule extends AbstractModule {

  @Override
  void configure() {
    bind(TokenizerModel)
      .toProvider(TokenizerModelProvider)
      .in(Scopes.SINGLETON)

    bind(TokenizerService).in(Scopes.SINGLETON)
    bind(TokenizerHandler).in(Scopes.SINGLETON)
  }
}
