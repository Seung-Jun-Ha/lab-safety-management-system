package com.safety.model;

import java.time.LocalDate;

/**
 * @deprecated Use {@link WasteInfoRegisterDto}. Kept for compatibility with the original scaffold name.
 */
@Deprecated
public class WasteRegisterDto extends WasteInfoRegisterDto {

    public WasteRegisterDto() {
    }

    public WasteRegisterDto(String typeId, String labId, Double quantity, String unit, LocalDate generatedDate) {
        super(typeId, labId, quantity, unit, generatedDate);
    }
}
