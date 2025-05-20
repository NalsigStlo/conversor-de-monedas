package records;

import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;

public record ConversionRates(String result, LinkedTreeMap<String, JsonElement> conversion_rates) {
}
