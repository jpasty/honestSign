package honest.sign.document.validator.controller;

import honest.sign.document.validator.vo.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
public class DocumentController {
    @PostMapping("/documentAcceptor")
    public ResponseEntity<?> acceptDocument(@RequestBody @Valid Document document,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());

            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }
}
