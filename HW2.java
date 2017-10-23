import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0544220 蔡明蒼
 * @param  nDeck 總共有幾副牌
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO:
 * first for loop : 幾副牌
 * second for loop :卡牌花色
 * third for loop:卡牌大小值
 * @param suit 花色
 * @param rank 牌的大小
 */
class Deck{
	private ArrayList<Card> cards;
	private Object card;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		int suit , rank ;
		for(int x = 0 ; x < nDeck ; x ++)
		{
			for(suit = 1 ; suit < 5 ; suit++)
			{
				for(rank = 1 ; rank < 14 ; rank ++)
				{
					Card card=new Card(suit,rank);
					cards.add(card);
				}
			}
		}
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		for(int count = 0 ; count < cards.size() ; count ++)
		{
			Card card = cards.get(count);
			card.printCard(card);
		}
		
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO:
 * Card function 給這張牌大小
 * printCard function 先用字串陣列分別寫出花色,大小 ,再依卡片花色,大小值給予名稱,最後給玩家看卡牌內容 
 * getSuit function    傳回卡牌花色
 * getRank function    傳回卡牌大小值
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	public static char[] card(Card number) {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(Card card){
		String kind[]={"Clubs" , "Diamonds", "Hearts", "Spades"};
		String number[] = {"Ace" , "TWO" , "THREE" , "FOUR" , "FIVE" , "SIX" ,
				"SEVEN" , "EIGHT" , "NINE" , "TEN" , "J" , "Q" , "K"};
		System.out.println("(" + suit +  "," + rank + ") \t = (" + kind[suit-1] + "," + number[rank-1] + ")");
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
