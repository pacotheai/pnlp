package paco.pnlp.namefinder

import paco.pnlp.sentences.SentenceService
import paco.pnlp.tokenizer.TokenizerService
import paco.pnlp.namefinder.model.NameFinderModel

import rx.functions.Func1
import javax.inject.Inject
import java.util.stream.Stream
import groovy.transform.TupleConstructor
import org.codehaus.groovy.runtime.DefaultGroovyMethods

import opennlp.tools.util.Span
import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel

import groovy.transform.stc.*
/**
 * Service to search names
 *
 * @since 0.1.0
 */
class NameFinderService {

  @Inject
  SentenceService sentenceService

  @Inject
  TokenizerService tokenizerService

  @Inject
  NameFinderModel nameFinderModel

  /**
   * Finds names of the type passed as parameter in the tokens of a
   * given text
   *
   * @param type the type of span
   * @param text we analyzed text to get the names from
   * @return a list of tuples containing a string with the name
   * of the person and a map containing the type of span and
   * the score of the term as a person name
   * @since 0.1.0
   */
  List<Map> findNames(String type, String text) {
    NameFinderME finder = new NameFinderME(findModelByType(type))
    String[] textTokens = tokenizerService.tokenize(text)
    List<Map> nameList = finder
      .find(textTokens)
      .collect()
      .findAll()
      .collectMany { span ->
        [fromSpanToMap(textTokens, span as Span, text)]
      }

    return nameList
  }

  Map fromSpanToMap(String[] tokens, Span span, String text) {
    Boolean isJustOneWord = (span.end - span.start) == 1

    String name = isJustOneWord ?
      "${tokens[span.start]}".toString() :
      "${tokens[span.start]} ${tokens[span.end - 1]}".toString()

    Integer nameStartsAt = text.indexOf(name)
    Integer nameEndsAt = nameStartsAt + name.size()

    return [
      name: name,
      probability: span.prob,
      start: nameStartsAt,
      end: nameEndsAt
    ]
  }

  private TokenNameFinderModel findModelByType(String type) {
    switch(type) {
      case 'person':    return nameFinderModel.personModel
      case 'location':  return nameFinderModel.locationModel

      default:
      return nameFinderModel.locationModel
    }
  }
}
