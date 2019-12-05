//Disa Röed Sahlström, disa7213

public class DoubleHashingProbingHashTable<T> extends ProbingHashTable<T> {

	/*
	 * Denna metod ska skrivas klart. Den ska använda bokens förslag på andra
	 * hashalgoritm.
	 * 
	 * TODO: algoritmen måste finnas med här för dem som inte har boken.
	 */
	@Override
	protected int findPos(T x) {
		int currentPos = myhash(x);
		while(continueProbing(currentPos, x)) {
			int currentPos2 = myhash2(x);
			currentPos += currentPos2;
			currentPos %= capacity();
		}
		return currentPos;
	}

	/*
	 * Denna metod ger ett primtal mindre än tabellens storlek. Detta primtal ska
	 * användas i metoden ovan.
	 */
	protected int smallerPrimeThanCapacity() {
		int n = capacity() - 2;
		while (!isPrime(n)) {
			n -= 2;
		}
		return n;
	}
	
	protected int myhash2(T x) {
		int prime = smallerPrimeThanCapacity();
		int hashVal = x.hashCode();
		return prime - (hashVal % prime);
	}

}
