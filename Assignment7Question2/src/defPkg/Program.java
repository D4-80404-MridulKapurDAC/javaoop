package defPkg;

public class Program {
	public static void main(String[] args) {
		Player[] team = new Player[11];
		for(int i=0; i<team.length; i++) {
			team[i] = new Cricketer();
			team[i].accept();
		}
		
		for(Player p:team)
			System.out.println(p.toString());
		
		int totalRuns = Players.batterTotalRuns(team);
	}
}
