package co.edu.icesi.pf.domain.model.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EntityStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted");

    private final String status;

}
