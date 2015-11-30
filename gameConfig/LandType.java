package gameConfig;

public enum LandType {
	RIVER, PLAIN, M1, M2, M3, TOWN;

	public static LandType[] standardMap() {
		return new LandType[]{
				PLAIN, PLAIN, M3,    PLAIN, PLAIN,//0-4
				PLAIN, M1,    PLAIN, M2,    PLAIN,//5-9
				M1,    PLAIN, PLAIN, PLAIN, M2,   //10-14
				PLAIN, PLAIN, PLAIN, PLAIN, PLAIN,//15-19
				RIVER, RIVER, TOWN,  RIVER, RIVER,//20-24
				PLAIN, PLAIN, PLAIN, PLAIN, PLAIN,//25-29
				M3,    PLAIN, PLAIN, M2,    PLAIN,//30-34
				PLAIN, PLAIN, PLAIN, PLAIN, PLAIN,//35-39
				PLAIN, M3,    M1,    PLAIN, M2};  //40-44
	}
}