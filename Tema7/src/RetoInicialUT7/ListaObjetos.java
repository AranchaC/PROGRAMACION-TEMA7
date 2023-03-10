package RetoInicialUT7;

public interface ListaObjetos {
	public boolean add(Object obj);
	public boolean add(int index, Object obj);
	public Object get (int index);
	public boolean set (int index, Object o);
	public boolean remove (int index);
	public boolean isEmpty();
	public int size();
}
