package bowling.business.parser;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ValidationErrorCatalog {
    INVALID_FORMAT("Formato de tiro inválido"),
    INVALID_THROW("Tiro inválido");
    private String message;

    @Override
    public String toString() {
        return message+", por favor intente de nuevo.";
    }
}
