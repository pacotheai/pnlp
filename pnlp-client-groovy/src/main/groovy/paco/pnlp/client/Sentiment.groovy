package paco.pnlp.client

import groovy.transform.Canonical

/**
 * Represents the evaluation of a simple positive/negative sentiment
 * over a given text
 *
 * @since 0.1.0
 */
@Canonical
class Sentiment {

  /**
   * Probability of positiveness or negativeness
   *
   * @since 0.1.0
   */
  List<Double> outcomes

  /**
   * True if the sentiment was positive, false otherwise
   *
   * @since 0.1.0
   */
  Boolean result
}
