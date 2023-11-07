package org.project.backapi.enums;

public enum VoteStatus {
    TRUE(1),
    FALSE(0);

    private final int value;

    VoteStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VoteStatus fromInt(VoteStatus value) {
        for (VoteStatus status : VoteStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value : " + value);
    }

}
