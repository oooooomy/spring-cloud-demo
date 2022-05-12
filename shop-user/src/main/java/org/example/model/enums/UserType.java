package org.example.model.enums;

/**
 * @author Gao Yuan Ming
 */
public enum UserType {

    /**
     * 超级管理员
     */
    SUPER_ADMIN(0),

    /**
     * 普通管理员
     */
    SIMPLE_ADMIN(1);

    private final Integer value;

    UserType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
