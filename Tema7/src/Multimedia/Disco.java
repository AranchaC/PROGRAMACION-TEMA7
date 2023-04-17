package Multimedia;

public class Disco extends Multimedia {
	protected Género género;

	public Disco(String título, String autor, double duración, Formato formato, Género género) {
		super(título, autor, duración, formato);
		this.género = género;
	}

	public Género getGénero() {
		return género;
	}

	public void setGénero(Género género) {
		this.género = género;
	}

	@Override
	public String toString() {
		return super.toString() +  "Género del disco: " + género + "\n\n";
	}
	
	
	

}
