package paco.pnlp.tokenizer

import paco.pnlp.common.ModelProvider
import opennlp.tools.tokenize.TokenizerModel

/**
 * @since 0.1.0
 */
class TokenizerModelProvider extends ModelProvider<TokenizerModel> {

  @Override
  TokenizerModel get() {
    new TokenizerModel(getModel(config.model.tokenizer))
  }
}
