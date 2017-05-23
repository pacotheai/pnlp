package paco.pnlp.sentiment

import paco.pnlp.common.ModelProvider

import opennlp.tools.doccat.DoccatModel
import opennlp.tools.doccat.DocumentCategorizerME
import opennlp.tools.doccat.DocumentSampleStream
import opennlp.tools.util.ObjectStream
import opennlp.tools.util.PlainTextByLineStream
import opennlp.tools.util.InputStreamFactory
import groovy.transform.TupleConstructor
import opennlp.tools.util.TrainingParameters
import opennlp.tools.doccat.DoccatFactory

/**
 * Loads an instance of {@link DoccatModel}, a document categorizer model
 *
 * @since 0.1.0
 */
class SentimentModelProvider extends ModelProvider<DoccatModel> {

  @Override
  DoccatModel get() {
    URL sentimentModelUrl = getModel(config.model.sentiment.location)
    InputStream inputStream = sentimentModelUrl.openStream()
    InputStreamFactory inputStreamFactory = new CustomInputStreamFactory(inputStream)

    ObjectStream samples = new DocumentSampleStream(new PlainTextByLineStream(inputStreamFactory, "UTF-8"))
    TrainingParameters params = new TrainingParameters()

    params.put(TrainingParameters.ITERATIONS_PARAM, config.model.sentiment.iterations)
    params.put(TrainingParameters.CUTOFF_PARAM, config.model.sentiment.cutoff)

    def model =  DocumentCategorizerME.train("x-unspecified",
                                       samples,
                                       params,
                                       new DoccatFactory())
    inputStream.close()
    return model
  }

  @TupleConstructor
  static class CustomInputStreamFactory implements InputStreamFactory {
    InputStream inputStream
    InputStream createInputStream() {
      return inputStream
    }
  }
}
