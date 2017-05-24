package paco.pnlp.sentiment

import groovy.util.logging.Slf4j
import opennlp.tools.doccat.DoccatModel
import opennlp.tools.doccat.DocumentCategorizerME
import paco.pnlp.tokenizer.TokenizerService

import javax.inject.Inject

/**
 * Service responsible to apply sentiment analysis to text
 *
 * @since 0.1.0
 */
@Slf4j
class SentimentService {

  /**
   * Default document categorizer loaded at bootstrap
   *
   * @since 0.1.0
   */
  @Inject
  DoccatModel model

  /**
   * Default text tokenizer loaded at bootstrap
   *
   * @since 0.1.0
   */
  @Inject
  TokenizerService tokenizer

  /**
   * Evaluates the text passed as argument as "positive" (true) or
   * "negative" (false). It depends on the configured sentiment
   * analysis model loaded at bootstrap.
   * <br/>
   * The text is decomposed to get a list of tokens that eventually
   * will be transform in a tuple of weights that will decide wether
   * the whole text is positive or negative.
   * <br/>
   * "I had a bad day"->[pos, neg]->[0.2, 0.6]->So it's more likely to
   * be a negative sentence than a positive one.
   *
   * @param text the text we would like to evaluate
   * @return true if the text is evaluated as "positive" or "false" otherwise
   * @since 0.1.0
   */
  Map isPositive(String text) {
    DocumentCategorizerME categorizer = new DocumentCategorizerME(model)
    double[] outcomes = categorizer.categorize(tokenizer.tokenize(text))
    String category = categorizer.getBestCategory(outcomes)

    log.debug "outcomes for \"$text\": $outcomes"

    return [
      result: getResult(category),
      outcomes: outcomes,
    ]
  }

  Boolean getResult(String category) {
    switch (category) {
      case "1": return true
      case "0": return false

      default: 'if we dont know then it should be :('
        return false
    }
  }
}
