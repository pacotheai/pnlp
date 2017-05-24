package paco.pnlp.namefinder.model

import paco.pnlp.common.ModelProvider
import opennlp.tools.namefind.TokenNameFinderModel

/**
 * This class creates an instance of {@link NameFinderModel} which is
 * a holder for different instances of {@link TokenNameFinderModel} that
 * can be used to search for names
 *
 * @since 0.1.0
 */
class NameFinderModelProvider extends ModelProvider<NameFinderModel> {

  @Override
  NameFinderModel get() {
    URL personModelUrl = getModel(config.model.namefinder.person)
    URL locationModelUrl = getModel(config.model.namefinder.location)

    return [
      personModel:    new TokenNameFinderModel(personModelUrl),
      locationModel:  new TokenNameFinderModel(locationModelUrl),
    ] as NameFinderModel
  }
}
