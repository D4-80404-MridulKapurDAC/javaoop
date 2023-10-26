package defPkg;

import java.util.Scanner;

public class Cricketer extends Player implements Batter,Bowler{
	int runs;
	int wickets;
	double economy;
	double average;
	double strikeRate;
	@Override
	public int getWickets() {
		return wickets;
	}
	@Override
	public double getEconomy() {
		return economy;
	}
	@Override
	public int getRuns() {
		return runs;
	}
	@Override
	public double getAverage() {
		return average;
	}
	@Override
	public double getStrikeRate() {
		return strikeRate;
	}
	@Override
	public void accept() {
		super.accept();
		System.out.println("Enter game details");
		Scanner sc = new Scanner(System.in);
		runs = sc.nextInt();
		wickets = sc.nextInt();
		economy = sc.nextDouble();
		average = sc.nextDouble();
		strikeRate = sc.nextDouble();
	}
}
