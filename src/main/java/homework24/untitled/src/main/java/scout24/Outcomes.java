//public static int getScoreDifference(List<Integer> numSeq) {
//    int firstScore = 0;
//    int secondScore = 0;
//    boolean isFirstPlayerTurn = true;
//
//    while (!numSeq.isEmpty()){
//        int pick =numSeq.remove(0);
//        if (isFirstPlayerTurn){
//            firstScore +=pick;
//        }else{
//            secondScore +=pick;
//        }
//
//        if (pick%2==0){
//            Collections.reverse(numSeq);
//        }
//        isFirstPlayerTurn = !isFirstPlayerTurn;
//
//
//    }
//    return firstScore-secondScore;
//}
//
//}