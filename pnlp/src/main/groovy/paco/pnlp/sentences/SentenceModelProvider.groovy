package paco.pnlp.sentences

import paco.pnlp.common.ModelProvider
import opennlp.tools.sentdetect.SentenceModel

/**
 * Loads an instance of {@link SentenceModel} for the language
 * configured for the application instance.
 *
 * @since 0.1.0
 */
class SentenceModelProvider extends ModelProvider<SentenceModel> {

  @Override
  SentenceModel get() {
    return new SentenceModel(getModel(config.model.sentences))
  }
}
