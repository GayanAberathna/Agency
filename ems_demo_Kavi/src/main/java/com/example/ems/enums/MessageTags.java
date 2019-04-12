package com.example.ems.enums;

public enum MessageTags implements EnumType {
    REGISTER_SUCCESS("Registration Success"),
    UPDATE_SUCCESS("updated successfully"),
    DELETE_SUCCESS("Successfully deleted");

    private String string;

    MessageTags(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return string;
    }
}
