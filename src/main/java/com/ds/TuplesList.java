package com.ds;

public class TuplesList {
	int test;
	public static void main(String[] args) {
		TuplesList tl = new TuplesList();
		System.out.println(tl.test);
		//divisibleByFive();
	}
	public static void divisibleByFive() {
		String s = "361 636 277 129 434 577 796 596 727 566 " + 
				"156 109 714 716 546 979 366 766 137 243 " + 
				"331 999 922 304 657 314 634 303 677 597 " + 
				"363 174 431 193 361 677 403 926 279 692 " + 
				"749 401 346 202 763 314 333 244 796 697 " + 
				"674 651 517 349 337 667 617 464 379 793 " + 
				"542 464 962 146 946 199 302 699 606 126 " + 
				"519 203 137 517 146 724 696 699 747 663 " + 
				"126 247 469 953 396 502 562 647 364 214 " + 
				"346 646 331 426 763 291 557 764 939 656 " + 
				"753 561 797 224 537 361 263 493 196 162 " + 
				"362 102 629 936 663 279 966 241 907 677 " + 
				"945 416 122 563 667 394 654 592 977 177 " + 
				"666 199 463 561 954 924 991 363 754 754 " + 
				"199 451 796 566 629 651 517 167 704 749 " + 
				"622 299 466 559 973 243 639 276 603 753";
		String[] list = s.split(" ");
		int y = 0;
		for (int i = 0; i < list.length; i++) {
			y += Integer.valueOf(list[i]);
		}
		System.out.println(y);
	}
	public static void cantOverride() {
		
	}
	public static void cantOverride(int i) {
		
	}
}
