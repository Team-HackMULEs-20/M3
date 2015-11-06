package GameConfig;

public enum LandType {
    RIVER, PLAIN, M1, M2, M3, TOWN;

    public static LandType[] standardMap() {
        return new LandType[]{PLAIN, PLAIN, M1,    PLAIN, RIVER, PLAIN, M3,    PLAIN, PLAIN,
                				PLAIN, M1,    PLAIN, PLAIN, RIVER, PLAIN, PLAIN, PLAIN, M3,
                				M3,    PLAIN, PLAIN, PLAIN, TOWN,  PLAIN, PLAIN, PLAIN, M1,
                				PLAIN, M2,    PLAIN, PLAIN, RIVER, PLAIN, M2,    PLAIN, PLAIN,
                				PLAIN, PLAIN, M2,    PLAIN, RIVER, PLAIN, PLAIN, PLAIN, M2};
    }
}