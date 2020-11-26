
public class test{

	public static void main(String[] args){
		test(3);

	}
	public static int test(int n) {
    if (n==0)
        return n;
    int sequenceTerm = 2;
    int sequence = 0;
    while(sequence < 60) {
        sequence = (sequenceTerm * n) + (sequenceTerm * test(n - 1));
        System.out.println(sequence);
        if (sequence > 60)
            return sequence;
    }
    return sequence;
}


}