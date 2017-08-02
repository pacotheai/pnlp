package pnlp.api

import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import static org.springframework.restdocs.snippet.Attributes.key
import static org.springframework.restdocs.snippet.Attributes.attributes

import pnlp.test.ApiDocumentationSpec
import com.jayway.restassured.RestAssured
import com.jayway.restassured.response.Response
import org.springframework.restdocs.restassured.RestDocumentationFilter

class NameFinderSpec extends ApiDocumentationSpec {

  void 'get a new token sucessfully'() {
    when: 'asking for a new token'
    Response response = RestAssured
      .given(baseRequestSpec)
      .filter(specFor(200))
      .body('{"text":"This is a sentence. This is another sentence."}')
      .contentType('application/json')
      .accept('application/json')
      .when()
      .post("${app.address}api/v1/sentences/me")

    then: 'the status code should be accepted'
    response.statusCode == 200
  }

  RestDocumentationFilter specFor(Integer code) {
    return document("sentences-$code",
      requestPreprocessors,
      responsePreprocessors,
      requestFields(
        attributes(key("title").value("Request fields")),
        fieldWithPath("text")
          .description("Text extracting sentences from")
        .attributes(key('constraints').value('required'))))
  }
}
