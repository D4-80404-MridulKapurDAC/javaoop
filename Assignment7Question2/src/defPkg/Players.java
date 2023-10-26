package defPkg;

public class Players {
	public static int batterTotalRuns(Player[] arr) {
		int total = 0;
		for(Player p:arr) {
			if(p instanceof Batter) {
				Batter b = (Batter)p;
				total += b.getRuns();
			}
		}
		return total;
	}
	public static int bowlerTotalWickets(Player[] arr){
		int total = 0;
		for(Player p:arr) {
			if(p instanceof Bowler) {
				Bowler b = (Bowler)p;
				total += b.getWickets();
			}
		}
		return total;
	}
	public static int countBowler(Player[] arr){
		int total = 0;
		for(Player p:arr) {
			if(p instanceof Bowler) {
				total++;
			}
		}
		return total;
	}
	public static int countBatters(Player[] arr){
		int total = 0;
		for(Player p:arr) {
			if(p instanceof Batter) {
				total++;
			}
		}
		return total;
	}
	public static Player maxRunBatter(Player[] arr) {
		int mx = 0;
		Player ans = null;
		for(Player p:arr) {
			if(p instanceof Batter && ((Batter)p).getRuns() > mx) {
				ans = p;
				mx = ((Batter)p).getRuns();
			}
		}
		return ans;
	}
	
	public static Player maxWicketBowler(Player[] arr) {
		int mx = 0;
		Player ans = null;
		for(Player p:arr) {
			if(p instanceof Bowler && ((Bowler)p).getWickets() > mx) {
				ans = p;
				mx = ((Bowler)p).getWickets();
			}
		}
		return ans;
	}
}
