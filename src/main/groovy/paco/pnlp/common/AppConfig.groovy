package paco.pnlp.common

/**
 * Application's config
 *
 * @since 0.1.0
 */
class AppConfig {
  String version
  Models model

  static class Models {
    NameFinder namefinder
    String sentences
    String tokenizer
    Sentiment sentiment
  }

  static class NameFinder {
    String person
    String location
  }

  static class Sentiment {
    String location
    Integer cutoff
    Integer iterations
  }
}
