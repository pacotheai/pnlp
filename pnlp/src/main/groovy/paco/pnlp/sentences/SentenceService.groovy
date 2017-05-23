package paco.pnlp.sentences

import opennlp.tools.sentdetect.SentenceDetectorME
import opennlp.tools.sentdetect.SentenceModel

import javax.inject.Inject

/**
 * Holds all functions dealing with sentence detection
 *
 * @since 0.1.0
 */
class SentenceService {

  /**
   * Preloaded {@link SentenceModel} to detect sentences
   *
   * @since 0.1.0
   */
  @Inject
  SentenceModel model

  /**
   * Returns an array of {@link String} sentences detected in the text
   * passed as an argument. The whitespace before, between and after the
   * input String is removed
   *
   * @param text The text the sentences are detected from
   * @return an arrayof type {@link Strign} containing found sentences
   * @since 0.1.0
   */
  String[] detectSentences(String text) {
    return new SentenceDetectorME(model).sentDetect(text)
  }
}
