package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
	Map<Integer, Room> hotelMap;
	Scanner scan;
	
	// 호텔 정보가 저장될 파일명 설정
	private String fileName = "d:/D_other/hotel.dat";
	
	// 데이터가 변경되었는지 여부를 나타내는 변수 선언 ==> 데이터가 변경되면 true가 된다.
	private boolean dataChange;
	
	// 생성자
	public Hotel() {
		//hotelMap = new HashMap<Integer, Room>();
		hotelMap = load();
		System.out.println("hotelMap : " + hotelMap);
		
		
		if(hotelMap == null) {
			System.out.println("객실 생성");
			hotelMap = new HashMap<Integer, Room>();
			// 객실 생성
			//hotelMap.put(201, new Room(201, "싱글룸"));
			for(int i=2; i<=4; i++) {
				String roomType = null;
				switch(i) {
					case 2: roomType = "싱글룸"; break;
					case 3: roomType = "더블룸"; break;
					case 4: roomType = "스위트룸"; break;
				}
				
				for(int j=1; j<=9; j++) {
					int roomNum = i * 100 + j;
					Room room = new Room(roomNum, roomType);
					System.out.println("roomNum : "+roomNum);
					System.out.println("room : "+room);
					hotelMap.put(roomNum, room);
				}
			}
		}
		scan = new Scanner(System.in);
	} 
	

	public static void main(String[] args) {
		new Hotel().hotelStart();
	}
	
	
	public HashMap<Integer, Room> load() {
		HashMap<Integer, Room> hMap = null;	// 읽어온 데이터가 저장될 변수
		
		File file = new File(fileName);
		
		// 저장된 파일이 없으면...
		if(!file.exists()) {
			System.out.println("저장된 파일이 없습니다.");
			return null;
		}
		
		// 저장된 파일이 있으면
		ObjectInputStream ois = null;
		
		try {
			
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(fileName)));
			hMap = (HashMap<Integer, Room>) ois.readObject();
			
			return hMap;
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(ois!=null) try {	ois.close(); }catch(IOException e) {}
		}
		
	}
	
	// 호텔 정보를 파일에 저장하는 메서드
	public void save() {
		
		ObjectOutputStream oos = null;
		try {
			// 객체 출력하기 위한 출력용 스트림 객체 생성
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fileName)));
			// Map객체를 파일로 저장
			oos.writeObject(hotelMap);
			System.out.println("hotelMap 저장 완료");
			dataChange = false; 
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos!=null) try { oos.close(); } catch(IOException e) {}
		}
		
	}
	
	
	private void hotelStart() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("      호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :   // 체크인
					checkIn();
					break;
				case 2 :   // 체크아웃
					checkOut();
					break;
				case 3 :   // 객실상태
					showRoom();
					break;
				case 4 :   // 정보 저장
					save();
					break;
				case 0 :   // 업무종료
					if(dataChange==true) {
						System.out.println("변경된 내용을 저장합니다.");
						save();
					}
					System.out.println("*********************************************");
					System.out.println("       호텔문을 닫았습니다.");
					System.out.println("*********************************************");
					return;
				default : 
					System.out.println("작업번호를 잘못 입력했습니다. 다시 선택하세요.");
			}
		}
		
	}
	
	// 체크인을 처리하는 메서드
	private void checkIn() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("    체크인 작업");
		System.out.println("------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("------------------------------------");
		System.out.print(" 방 번호 입력 >> ");
		int roomNum = scan.nextInt();
		
		// 입력한 방번호가 있는지 검사(키값으로 입력한 방번호가 있는지 검사)
		if(!hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			//return;
		}else if(hotelMap.get(roomNum).getGuestName()!=null) {  // 해당 객실에 손님이 있는지 검사
			System.out.println(roomNum + "호 객실에는 이미 손님이 있습니다.");
			//return;
		}else {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 >> ");
			String name = scan.next();
			
			// 입력받은 객실의 투숙객 명단에 입력받은 이름을 저장한다.
			hotelMap.get(roomNum).setGuestName(name);
			
			System.out.println(name + "씨가 " + roomNum + "호 객실에 체크인 되었습니다.");
			
		}
		
	}
	
	// 체크아웃을 처리하는 메서드
	private void checkOut() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("    체크아웃 작업");
		System.out.println("------------------------------------");
		System.out.println("체크 아웃할 방 번호를 입력하세요.");
		System.out.print(" 방 번호 입력 >> ");
		int roomNum = scan.nextInt();
		
		// 입력한 방번호가 있는지 검사(키값으로 입력한 방번호가 있는지 검사)
		if(!hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실에 손님이 없는지 검사
		if(hotelMap.get(roomNum).getGuestName()==null) {  
			System.out.println(roomNum + "호 객실에는 체크아웃할 손님이 없습니다.");
			return;
		}
		
		// 체크 아웃 작업은 해당 객실의 손님의 이름을 null로 변경하는 것을 말한다.
		String name = hotelMap.get(roomNum).getGuestName(); // 현재 손님이름을 구한다.
		hotelMap.get(roomNum).setGuestName(null);  // 손님이름을 null로 설정
		
		System.out.println(roomNum + "호 객실의 " + name + "님의 체크아웃을 완료했습니다.");
	}
	
	// 객실 상태를 출력하는 메서드
	private void showRoom() {
		System.out.println();
		
		// 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣어서 정렬하여 사용한다.
		ArrayList<Integer> roomNumList = new ArrayList<>();
		for(int num : hotelMap.keySet()) {  // Map의 key값을 List에 추가하기
			roomNumList.add(num);
		}
		
		Collections.sort(roomNumList);  // 방번호를 오름차순으로 정렬하기
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("        현재 객실 상태");
		System.out.println("-----------------------------");
		System.out.println("방번호\t 방종류\t 투숙객 이름");
		System.out.println("-----------------------------");
		
		// List에서 방번호를 하나씩 꺼내와 Map에서 해당 방번호에 해당하는 Room객체를 구해서 출력한다.
		for(int i=0; i<roomNumList.size(); i++) {
			Room r = hotelMap.get( roomNumList.get(i)  );
			System.out.print(r.getRoomNum() + "\t " + r.getRoomType() + "\t ");
			String name = " -";
			if(r.getGuestName()!=null) { // 방에 손님이 있으면...
				name = r.getGuestName();
			}
			System.out.println(name);			
		}
		
		System.out.println("-----------------------------");
		System.out.println();
		
	}
	
	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 저장    0. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print(" 선택>> ");
		int num = scan.nextInt();
		return num;
	}

}


class Room implements Serializable{
	private int roomNum;
	private String roomType;
	private String guestName;
	
	public Room(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

}













