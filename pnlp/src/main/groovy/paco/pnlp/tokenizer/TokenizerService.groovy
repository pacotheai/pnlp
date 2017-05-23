package paco.pnlp.tokenizer

import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel

import javax.inject.Inject

/**
 * Functions to segment a string into its tokens
 *
 * @since 0.1.0
 */
class TokenizerService {

  @Inject
  TokenizerModel model

  /**
   * Segment a string into its tokens following the model loaded by
   * the application
   *
   * @param text the text we want the tokens fromn
   * @return an array of token strings
   * @since 0.1.0
   */
  String[] tokenize(String text) {
    return new TokenizerME(model).tokenize(text)
  }
}
