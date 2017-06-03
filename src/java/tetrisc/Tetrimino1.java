
package tetrisc;

/**
 *
 * @author ChristianP
 */
public class Tetrimino1 {
    private static String T[][] = new String[0][0];

    /**
     * Constructor, inicializa la matriz    
     */
    public Tetrimino1() {

	T = new String[3][3];

    }

    /**
     *	Trae la matriz del tetramino
     * @return T (Tetramino)
     */
    public String[][] getT() {
	return T;
    }

    /**
     *	Actualiza la matriz de tetramino
     * @param T
     */
    public static void setT(String[][] T) {
	Tetrimino1.T = T;
    }

    /**
     * Carga las posiciones en la matriz
     */
    public void iniciarFicha() {

	int cont = 0;
	for (int i = 0; i < T.length; i++) {
	    for (int j = 0; j < T[0].length; j++, cont++) {

		T[i][j] = cont + ",4,21";

	    }
	}

    }
    
        /**
     * Realiza la acción de girar a la izquierda
     */
 public void girarIzquierda() {

	String mino1 = "", mino2 = "", mino3 = "", mino4 = "";

        //matriz 3x3 inicia desde la pocision 0,0
//	mino1 = T[0][0];
//	mino2 = T[0][1];
//	mino3 = T[0][2];
//	mino4 = T[1][1];
//
//	T[0][1] = mino2;
//	T[-1][1] = mino3;
//	T[0][2] = mino4;
//	T[1][1] = mino1;
        //matriz 3x3 inicia desde la pocision 1,0
        mino1 = T[1][0];
	mino2 = T[1][1];
	mino3 = T[1][2];
	mino4 = T[2][1];

	T[2][1] = mino1;
        T[1][1] = mino2;
	T[0][1] = mino3;
	T[1][2] = mino4;
	
System.out.print("matriz" +T);
    }

    /**
     * Realiza la acción de girar a la derecha
     */
    public void girarDerecha() {

	String mino1 = "", mino2 = "", mino3 = "", mino4 = "";

//	mino1 = T[0][0];
//	mino2 = T[0][1];
//	mino3 = T[0][2];
//	mino4 = T[1][1];
//
//	T[0][0] = mino4;
//	T[-1][1] = mino1;
//	T[0][1] = mino2;
//	T[1][1] = mino3;
         //matriz 3x3 inicia desde la pocision 1,0
        mino1 = T[1][0];
	mino2 = T[1][1];
	mino3 = T[1][2];
	mino4 = T[2][1];

	T[0][1] = mino1;
        T[1][1] = mino2;
	T[2][1] = mino3;
	T[1][0] = mino4;

    }

  
    /**
     * Realiza la acción de bajar todo
     */
    public void bajar() {

	String mino1 = "", mino2 = "", mino3 = "", mino4 = "", dat = "";

	mino1 = T[1][0];
	mino2 = T[1][1];
	mino3 = T[1][2];
	mino4 = T[2][1];
        
//      mino1 = T[0][0];
//	mino2 = T[0][1];
//	mino3 = T[0][2];
//	mino4 = T[1][1];

	String[] dato1 = mino1.split(",");
	dat = dato1[1];

	dat = (Integer.parseInt(dat) - 1) + "";
	T[0][0] = dato1[0] + "," + dat + "," + dato1[2];

	String[] dato2 = mino2.split(",");
	T[0][1] = dato2[0] + "," + dat + "," + dato2[2];

	String[] dato3 = mino3.split(",");
	T[1][1] = dato3[0] + "," + dat + "," + dato3[2];

	String[] dato4 = mino4.split(",");
	T[1][0] = dato4[0] + "," + dat + "," + dato4[2];

	
    }
    
    /**
     * Imprime la matriz
     * @return Matriz tetramino
     */
    public String imprimirFicha() {

	String aux = "";
	for (int i = 0; i < T.length; i++) {
	    for (int j = 0; j < T[0].length; j++) {

		aux = aux + "|" + T[i][j];
	    }
	    aux = aux + "|\n";
	}

	return aux;
        
    }

  
    
  
}
