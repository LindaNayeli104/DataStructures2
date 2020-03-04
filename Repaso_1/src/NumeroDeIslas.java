
public class NumeroDeIslas {

	int res;
	
	public int islas(int[][] mapa) {
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa.length; j++) {
				if(mapa[i][j] == 1) {
					res += 1;
					busca(mapa, i,j);
				}
			}
		}
		return res;
	}
	
	private void busca(int[][] mapa, int i, int j) {
		if(i >= mapa.length || i < 0 || j >= mapa[0].length || j < 0 || mapa[i][j] == 0) {
			return;
		}
		mapa[i][j] = 0;
		busca(mapa,i, j+1);
		busca(mapa,i, j-1);
		busca(mapa,i+1, j);
		busca(mapa,i-1, j);	
		return;
	}
	
	
}
