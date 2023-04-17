package Multimedia;

public class Película extends Multimedia implements Comparable<Película>{
	protected String actorPrincipal, actrizPrincipal;

	public Película(String título, String autor, double duración, Formato formato, String actorPrincipal,
			String actrizPrincipal) {
		super(título, autor, duración, formato);
		this.actorPrincipal = actorPrincipal;
		this.actrizPrincipal = actrizPrincipal;
	}

	public String getActorPrincipal() {
		return actorPrincipal;
	}

	public void setActorPrincipal(String actorPrincipal) {
		this.actorPrincipal = actorPrincipal;
	}

	public String getActrizPrincipal() {
		return actrizPrincipal;
	}

	public void setActrizPrincipal(String actrizPrincipal) {
		this.actrizPrincipal = actrizPrincipal;
	}

	@Override
	public String toString() {
		String actores = "";
		if (actorPrincipal != null) {
			actores += actorPrincipal;
			if (actrizPrincipal != null) {
			actores += " y "+actrizPrincipal;	
			}
		}
		else {
			if (actrizPrincipal != null) {
				actores += actrizPrincipal;
			}
		}
		if (actorPrincipal == null && actrizPrincipal == null) {
			actores = "ERROR: Escribe al menos uno";			
		}
		return super.toString()+ " Protagonistas: "+actores+"\n\n";
	}

	@Override
	public int compareTo(Película o) {
		if (this.autor != o.getAutor()) {
			return this.autor.compareToIgnoreCase(o.getAutor());
		}
		if (this.duración < o.getDuración()) {
			return -1;
		}//if
		else if (this.duración > o.getDuración()) {
			return 1;
		}//else
		return 0;		
	}
	

		//return (int) ((this.duración*1000) - (o.duración*1000));
}




