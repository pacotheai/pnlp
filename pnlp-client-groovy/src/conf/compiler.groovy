import groovy.transform.CompileStatic

/**
 * This compiler configuration
 *
 * @since 0.1.0
 */
withConfig(configuration) {

  def allButSpecs = { unit ->
    !unit.AST.classes.any { it.name.endsWith('Spec') }
  }

  source(unitValidator: allButSpecs) {
    ast(CompileStatic)
  }
}
