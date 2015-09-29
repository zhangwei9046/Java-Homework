public class BirthdayKid {
	int age;
	
	void cutCake(Cake c, Knife k) {
		
	}
	void unpackGift() {
		
	}
	void blowKandle(){
		
	}
	void eatCake(Cake c) {
		
	}
	void playGames(Guest g, Partyroom p, Game game) {
		
	}
	
	public static void main(String[] args) {
		BirthdayKid bk = new BirthdayKid();
		Guest g = new Guest();
		KidParents kp = new KidParents();
		Partyroom p = new Partyroom();
		Cake c = new Cake();
		Kandle k = new Kandle();
		Knife kn = new Knife();
		g.enterPartyroom(p);
		kp.greetGuest(g);
		g.giveGift();
		g.wishBirthdayKid(bk);
		bk.unpackGift();
		kp.lightKandle(k);
		g.singBirthdaySong(bk);
		bk.cutCake(c, kn);
		g.eatCake(c);
		bk.eatCake(c);
		kp.eatCake(c);
		Game game = new Game();
		kp.hostGames(game);
		bk.playGames(g, p, game);
		g.leavePartyroom();
	}
}

class Guest {
	Gift p;
	void enterPartyroom(Partyroom p) {
		
	}
	void giveGift() {
		
	}
	void wishBirthdayKid(BirthdayKid bk) {
		
	}
	void singBirthdaySong(BirthdayKid bk) {
		
	}
	void eatCake(Cake c) {
		
	}
	void leavePartyroom() {
		
	}
}

class Partyroom {
	int size;
	Cake cake;
	Game game;
	KidParents kp;
	BirthdayKid bk;
}

class KidParents {
	void greetGuest(Guest g) {
		
	}
	void hostGames(Game g){
		
	}
	void lightKandle(Kandle k){
		
	}
	void eatCake(Cake c) {
		
	}
}

class Cake {
	int size;
	String color;
	Kandle kandle;
}
class Knife {
	
}

class Game {
	String game_type;
}
class Kandle{
	
}
class Gift{
	
}