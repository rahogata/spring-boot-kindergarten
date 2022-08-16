/**
 * 
 */
package in.co.rahogata.memoryuse.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * @author Rahogatha
 *
 */
@RestController
public class IndependenceController {

	@GetMapping("/fighters")
	public JsonNode freedomFighers() {
		ArrayNode fighters = JsonNodeFactory.instance.arrayNode();
		fighters.add("savarkar").add("subhash");
		return fighters;
	}
}
