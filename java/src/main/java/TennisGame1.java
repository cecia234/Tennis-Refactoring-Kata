
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    final String PLAYER1 = "player1";


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void pointAssigner(String playerName) {
        if (playerName.equals(PLAYER1))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String overallScore = "";
        if (player1Score == player2Score) {
            switch (player1Score) {
                case 0:
                    overallScore = "Love-All";
                    break;
                case 1:
                    overallScore = "Fifteen-All";
                    break;
                case 2:
                    overallScore = "Thirty-All";
                    break;
                default:
                    overallScore = "Deuce";
                    break;

            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int pointsDifference = player1Score - player2Score;
            if (pointsDifference == 1) overallScore = "Advantage player1";
            else if (pointsDifference == -1) overallScore = "Advantage player2";
            else if (pointsDifference >= 2) overallScore = "Win for player1";
            else overallScore = "Win for player2";
        } else {
            overallScore = scoreConstructor(player1Score,player2Score);
        }
        return overallScore;
    }

    private String scoreConstructor(int player1Score, int player2Score) {
        return convertScoreFromNumberToTennis(player1Score) + "-" + convertScoreFromNumberToTennis(player2Score);
    }

    String convertScoreFromNumberToTennis(int scoreAsNumber) {
        String scoreAsString="";
        switch (scoreAsNumber) {
            case 0:
                scoreAsString = "Love";
                break;
            case 1:
                scoreAsString = "Fifteen";
                break;
            case 2:
                scoreAsString = "Thirty";
                break;
            case 3:
                scoreAsString = "Forty";
                break;

        }
        return scoreAsString;
    }
}
