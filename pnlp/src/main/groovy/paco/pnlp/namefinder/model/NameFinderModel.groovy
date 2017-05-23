package paco.pnlp.namefinder.model

import groovy.transform.Immutable
import opennlp.tools.namefind.TokenNameFinderModel

/**
 * This class holds singleton instances of type {@link
 * TokenNameFinderModel}
 *
 * @since 0.1.0
 */
@Immutable(knownImmutableClasses = [TokenNameFinderModel])
class NameFinderModel {

  /**
   * Model for search for people's names
   *
   * @since 0.1.0
   */
  TokenNameFinderModel personModel

  /**
   * Model for search for locations
   *
   * @since 0.1.0
   */
  TokenNameFinderModel locationModel
}
