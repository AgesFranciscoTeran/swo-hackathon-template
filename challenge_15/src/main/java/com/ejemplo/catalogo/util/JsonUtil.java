package com.ejemplo.catalogo.util;

import com.ejemplo.catalogo.dto.ProductoResponse;
import javax.json.*;
import java.util.List;

/**
 * Clase utilitaria para convertir objetos y listas a JSON.
 */
public class JsonUtil {
    public static String productoListToJson(List<ProductoResponse> productos) {
        JsonArrayBuilder arr = Json.createArrayBuilder();
        for (ProductoResponse p : productos) {
            arr.add(productoToJson(p));
        }
        return arr.build().toString();
    }

    public static JsonObject productoToJson(ProductoResponse p) {
        JsonObjectBuilder builder = Json.createObjectBuilder()
            .add("id", p.getId())
            .add("nombre", p.getNombre())
            .add("categoria", p.getCategoria())
            .add("precio", p.getPrecio())
            .add("disponible", p.isDisponible());
        if (p.getTags() != null) {
            JsonArrayBuilder tagsArr = Json.createArrayBuilder();
            for (String tag : p.getTags()) {
                tagsArr.add(tag);
            }
            builder.add("tags", tagsArr);
        }
        return builder.build();
    }
}
