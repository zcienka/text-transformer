package pl.put.poznan.transformer.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;


@RestController
@RequestMapping("/api")
public class TextTransformerController {
    @RequestMapping(value = "/{transformation:.+}", method = RequestMethod.POST)
    public ResponseEntity<Response> post(@PathVariable String transformation, @RequestBody Request request) {
        Text newText;

        switch (transformation) {
            case "capitalize":
                newText = new Capitalize(new ToLower(new PlainText(request.text)));
                break;
            case "uppercase":
                newText = new ToUpper(new PlainText(request.text));
                break;
            case "lowercase":
                newText = new ToLower(new PlainText(request.text));
                break;
            case "expand-abbreviation":
                newText = new ExpandAbbreviations(new PlainText(request.text));
                break;
            case "latex":
                newText = new LatexFormat(new PlainText(request.text));
                break;
            case "eliminate-duplicates":
                newText = new DuplicatesElimination(new PlainText(request.text));
                break;
            case "words-to-abbreviations":
                newText = new WordsToAbbreviations(new PlainText(request.text));
                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new Response(newText.get()));
    }
}


