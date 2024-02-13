import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author 
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier()throws FileVideException{
		//TODO

		return (E) table[indiceTete];

		
	}


	public E defile() throws FileVideException{
		//TODO
		if (estVide() ) throw new FileVideException();
		taille--;
		E element = (E) table[indiceTete];
		if (indiceTete >= table.length -1){
			indiceTete = 0;
		}else indiceTete++;
		return element;
	}


	public void enfile(E element) {
		//TODO
		if (taille == table.length) {
			Object[] newTable = new Object[table.length * 2];
			for (int i = 0; i < taille; i++) {
				newTable[i] = table[(indiceTete + i) % table.length];
			}
			table = newTable;
			indiceTete = 0;
		}
		table[(indiceTete + taille) % table.length] = element;
		taille++;
	}
} 
