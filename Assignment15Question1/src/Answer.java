import java.util.Scanner;

enum MENU{
	ADD,UPDATE,DELETE,FIND_ID,FIND_ALL,FIND_PARTY,PARTY_VOTES,EXIT;
}

public class Answer {
	public static Candidate acceptCandidate(Scanner sc) {
		System.out.print("Enter Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Name: ");
		String name = sc.next();
		System.out.print("Enter Party: ");
		String party = sc.next();
		System.out.print("Enter Votes: ");
		int votes = sc.nextInt();
		Candidate c = new Candidate(id, name, party, votes);	
		return c;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hello");
		try(CandidateDao cDao = new CandidateDao()){
			MENU ch;
			do {
				System.out.println("1add,2update,3delete,4id,5all,6partycan,7partyvotes,8exit");
				ch = MENU.values()[sc.nextInt()-1];
				switch(ch) {
					case ADD:
						Candidate temp = acceptCandidate(sc);
						System.out.println("Added Row : " + cDao.save(temp));
						break;
					case UPDATE:
						Candidate upd = acceptCandidate(sc);
						System.out.println("Updated Rows : " + cDao.update(upd));
						break;
					case DELETE:
						System.out.println("Enter id to delete");
						System.out.println("Deleted rows : " + cDao.deleteById(sc.nextInt()));						
						break;
					case FIND_ID:
						System.out.println("Enter id to find");
						System.out.println(cDao.findById(sc.nextInt()));
						break;
					case FIND_ALL:
						System.out.println(cDao.findAll());
						break;
					case FIND_PARTY:
						System.out.println("Enter party : ");
						System.out.println(cDao.findByParty(sc.next()));
						break;
					case PARTY_VOTES:
						System.out.println(cDao.partyVotes());
						break;
					default:
						break;
				}	
			}while(ch != MENU.EXIT);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}











