package pl.put.poznan.transformer.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TextTransformerController {
    @RequestMapping(value = "/{transformation:.+}", method = RequestMethod.POST)
    public ResponseEntity<Response> post(@PathVariable String transformation, @RequestBody Request request) {
        Text newText = new PlainText(request.text);
        String[] transformations = transformation.split(" ");

        for (String singleTransformation : transformations) {
            switch (singleTransformation) {
                case "capitalize":
                    newText = new Capitalize(new ToLower(newText));
                    break;
                case "uppercase":
                    newText = new ToUpper(newText);
                    break;
                case "lowercase":
                    newText = new ToLower(newText);
                    break;
                case "expand-abbreviation":
                    newText = new ExpandAbbreviations(newText);
                    break;
                case "latex":
                    newText = new LatexFormat(newText);
                    break;
                case "eliminate-duplicates":
                    newText = new DuplicatesElimination(newText);
                    break;
                case "inverse":
                    newText = new Inverse(newText);
                    break;
                case "words-to-abbreviations":
                    newText = new WordsToAbbreviations(newText);
                    break;
                default:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return ResponseEntity.ok(new Response(newText.get()));
    }
}


