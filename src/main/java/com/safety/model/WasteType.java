package com.safety.model;

import java.util.Arrays;
import java.util.Optional;

public enum WasteType {
    W01("W01", "일반 폐기물"),
    W02("W02", "화학 폐기물"),
    W03("W03", "생물 폐기물");

    private final String typeId;
    private final String typeName;

    WasteType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public static Optional<WasteType> findByTypeId(String typeId) {
        return Arrays.stream(values())
            .filter(type -> type.typeId.equals(typeId))
            .findFirst();
    }
}
