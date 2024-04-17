public class Gibbet {

    private int curState = 0;
    private final String[] gibbetStates = {zero, first, second, third, fourth, fifth, sixth};
    private String curStateStr = gibbetStates[curState];
    private boolean isFinalState = false;
    private final int numStates = gibbetStates.length - 1;

    public static final String zero = """
            ______
            |    |
            |
            |
            |
            |_______""";
    public static final String first = """
            ______
            |    |
            |    о
            |
            |
            |_______""";
    public static final String second = """
            ______
            |    |
            |    о
            |    |
            |
            |_______""";
    public static final String third = """
            ______
            |    |
            |    о
            |   /|
            |
            |_______""";
    public static final String fourth = """
            ______
            |    |
            |    о
            |   /|\\
            |
            |_______""";
    public static final String fifth = """
            ______
            |    |
            |    о
            |   /|\\
            |   /
            |_______""";
    public static final String sixth = """
            ______
            |    |
            |    о
            |   /|\\
            |   / \\
            |_______""";

    public Gibbet() {
    }

    public void addState(){
        if (curState < gibbetStates.length - 1) {
            setCurState(getCurState() + 1);
            setCurStateStr();
        }
        if (curState == gibbetStates.length - 1){
             setFinalState(true);
        }

    }

    public int getCurState() {
        return curState;
    }

    public void setCurState(int curState) {
        this.curState = curState;
        this.setCurStateStr();
    }

    public String getCurStateStr() {
        return curStateStr;
    }

    public void setCurStateStr() {
        this.curStateStr = gibbetStates[curState];
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    private void setFinalState(boolean finalState) {
        isFinalState = finalState;
    }

    public int getNumStates() {
        return numStates;
    }
}
