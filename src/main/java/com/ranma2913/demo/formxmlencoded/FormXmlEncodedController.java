package com.ranma2913.demo.formxmlencoded;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FormXmlEncodedController {
  /*

  curl -i http://localhost:8080/github-webhook/ \
  curl -i http://10.96.113.144:8080/github-webhook/ \
  curl -i http://LAMU0HRPX43HKQY.uhc.com:8080/github-webhook/ \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'emailId=abc%40example.com&comment=Sample%20Feedback'

  */
  @PostMapping(
      path = "/github-webhook/",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
  @ResponseStatus(code = HttpStatus.OK)
  public MultiValueMap<String, String> webhook(
      @RequestParam MultiValueMap<String, String> requestBody) {
    log.info("requestBody: {}", requestBody);
    return requestBody;
  }
}
