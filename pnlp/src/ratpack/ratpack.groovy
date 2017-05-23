import static ratpack.groovy.Groovy.ratpack
import static paco.pnlp.common.SystemResources.classpath

ratpack {
  include classpath('handlers.groovy')
  include classpath('bindings.groovy')
}
